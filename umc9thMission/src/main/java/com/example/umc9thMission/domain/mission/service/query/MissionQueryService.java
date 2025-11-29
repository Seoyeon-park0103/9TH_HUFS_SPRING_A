package com.example.umc9thMission.domain.mission.service.query;

import com.example.umc9thMission.domain.mission.dto.res.MissionResDTO;
import com.example.umc9thMission.domain.mission.entity.Mission;
import com.example.umc9thMission.domain.review.dto.res.ReviewResDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MissionQueryService {
    MissionResDTO.MissionPreviewListDTO findMissionByRestaurant(Long restaurantId, Integer page);

    List<Mission> getAvailableMissions(Long memberId);

}
