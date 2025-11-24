package com.example.umc9thMission.domain.mission.service.query;

import com.example.umc9thMission.domain.mission.entity.MemberMission;
import com.example.umc9thMission.domain.mission.enums.MissionStatus;
import com.example.umc9thMission.domain.mission.repository.MemberMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.umc9thMission.domain.mission.service.query.MemberMissionQueryService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public List<MemberMission> getMemberMissions(Long memberId){
        MissionStatus status = MissionStatus.IN_PROGRESS; //도전 중인 미션만 가져오기
        return memberMissionRepository.findMemberMissions(memberId,status);
    }

}

