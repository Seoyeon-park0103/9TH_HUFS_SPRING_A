package com.example.umc9thMission.domain.mission.converter;

import com.example.umc9thMission.domain.mission.dto.res.MemberMissionResDTO;
import com.example.umc9thMission.domain.mission.entity.MemberMission;
import com.example.umc9thMission.domain.test.dto.res.TestResDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public class MemberMissionConverter {
    //객체 -> DTO
    public static TestResDTO.Testing toTestingDTO(String testing){
        return TestResDTO.Testing.builder()
                .testString(testing)
                .build();
    }

    //객체 -> DTO
    public static TestResDTO.Exception toExceptionDTO(String testing){
        return TestResDTO.Exception.builder()
                .testString(testing)
                .build();
    }

    public static MemberMissionResDTO.CreateDTO toDTO(MemberMission memberMission){
        return MemberMissionResDTO.CreateDTO.builder()
                .memberMissionId(memberMission.getId())
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .isCompleted(memberMission.isCompleted())
                .earnedPoint(memberMission.getEarnedPoint())
                .status(memberMission.getStatus().toString())
                .build();
    }

    public static MemberMissionResDTO.ProgressListDTO toProgressListDTO(Page<MemberMission> missionPage) {

        List<MemberMissionResDTO.ProgressDTO> list = missionPage.getContent().stream()
                .map(mm -> MemberMissionResDTO.ProgressDTO.builder()
                        .missionId(mm.getMission().getId())
                        .description(mm.getMission().getDescription())
                        .point(mm.getMission().getPoint())
                        .status(mm.getStatus().toString())
                        .build()
                ).toList();

        return MemberMissionResDTO.ProgressListDTO.builder()
                .missionList(list)
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .first(missionPage.isFirst())
                .last(missionPage.isLast())
                .build();
    }
}
