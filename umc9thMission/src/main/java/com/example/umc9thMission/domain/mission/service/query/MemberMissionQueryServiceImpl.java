package com.example.umc9thMission.domain.mission.service.query;

import com.example.umc9thMission.domain.member.entity.Member;
import com.example.umc9thMission.domain.member.repository.MemberRepository;
import com.example.umc9thMission.domain.mission.converter.MemberMissionConverter;
import com.example.umc9thMission.domain.mission.dto.res.MemberMissionResDTO;
import com.example.umc9thMission.domain.mission.entity.MemberMission;
import com.example.umc9thMission.domain.mission.enums.MissionStatus;
import com.example.umc9thMission.domain.mission.repository.MemberMissionRepository;
import com.example.umc9thMission.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.umc9thMission.domain.mission.service.query.MemberMissionQueryService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<MemberMission> getMemberMissions(Long memberId){
        MissionStatus status = MissionStatus.IN_PROGRESS; //도전 중인 미션만 가져오기
        return memberMissionRepository.findMemberMissions(memberId,status);
    }

    @Override
    public MemberMissionResDTO.ProgressListDTO findMyProgressMissions(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        PageRequest pageRequest = PageRequest.of(page, 10);

        Page<MemberMission> missionPage =
                memberMissionRepository.findAllByMemberAndStatus(
                        member,
                        MissionStatus.IN_PROGRESS,
                        pageRequest
                );

        return MemberMissionConverter.toProgressListDTO(missionPage);
    }
}

