package com.example.umc9thMission.domain.mission.service.query;

import com.example.umc9thMission.domain.mission.converter.MissionConverter;
import com.example.umc9thMission.domain.mission.dto.res.MissionResDTO;
import com.example.umc9thMission.domain.mission.entity.Mission;
import com.example.umc9thMission.domain.mission.exception.MissionException;
import com.example.umc9thMission.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9thMission.domain.mission.repository.MissionRepository;
import com.example.umc9thMission.domain.restaurant.entity.Restaurant;
import com.example.umc9thMission.domain.restaurant.exception.RestaurantException;
import com.example.umc9thMission.domain.restaurant.exception.code.RestaurantErrorCode;
import com.example.umc9thMission.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{
    private final RestaurantRepository restaurantRepository;
    private final MissionRepository missionRepository;

    @Override
    public MissionResDTO.MissionPreviewListDTO findMissionByRestaurant(Long restaurantId, Integer page){
        if(page<0) throw new MissionException(MissionErrorCode.INVALID_PAGE);

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(()->new RestaurantException(RestaurantErrorCode.NOT_FOUND));

        PageRequest pageRequest = PageRequest.of(page,10);
        Page<Mission> missionPage = missionRepository.findAllByRestaurant(restaurant, pageRequest);

        return MissionConverter.toMissionPreviewListDTO(missionPage);

    }

    @Override
    public List<Mission> getAvailableMissions(Long memberId){
        return missionRepository.findAvailableMissionsByMember(memberId);
    }
}
