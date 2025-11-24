package com.example.umc9thMission.domain.mission.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter
public class MemberMissionReqDTO {

    @Getter
    @Setter
    public static class CreateDTO {
        private Long memberId;
        private Long missionId;
    }
}
