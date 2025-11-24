package com.example.umc9thMission.domain.mission.converter;

import com.example.umc9thMission.domain.mission.dto.res.MemberMissionResDTO;
import com.example.umc9thMission.domain.mission.entity.MemberMission;
import com.example.umc9thMission.domain.test.dto.res.TestResDTO;

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
}
