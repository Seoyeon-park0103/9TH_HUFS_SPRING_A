package com.example.umc9thMission.domain.mission.service.command;


import com.example.umc9thMission.domain.member.entity.Member;
import com.example.umc9thMission.domain.member.repository.MemberRepository;
import com.example.umc9thMission.domain.mission.converter.MemberMissionConverter;
import com.example.umc9thMission.domain.mission.dto.req.MemberMissionReqDTO;
import com.example.umc9thMission.domain.mission.dto.res.MemberMissionResDTO;
import com.example.umc9thMission.domain.mission.entity.MemberMission;
import com.example.umc9thMission.domain.mission.entity.Mission;
import com.example.umc9thMission.domain.mission.enums.MissionStatus;
import com.example.umc9thMission.domain.mission.repository.MemberMissionRepository;
import com.example.umc9thMission.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService{
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMissionResDTO.CreateDTO createMemberMission(MemberMissionReqDTO.CreateDTO dto){
        Member member = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        Mission mission = missionRepository.findById(dto.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 미션입니다."));

        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .isCompleted(false)
                .earnedPoint(0)
                .status(MissionStatus.IN_PROGRESS)
                .build();

        memberMissionRepository.save(memberMission);

        return MemberMissionConverter.toDTO(memberMission);
    }
}
