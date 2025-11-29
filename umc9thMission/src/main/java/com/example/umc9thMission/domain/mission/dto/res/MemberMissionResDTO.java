package com.example.umc9thMission.domain.mission.dto.res;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class MemberMissionResDTO {
    @Builder
    @Getter
    public static class Testing{
        private String testString;
    }

    @Builder
    @Getter
    public static class Exception{
        private String testString;
    }

    @Getter
    @Builder
    public static class CreateDTO {
        private Long memberMissionId;
        private Long memberId;
        private Long missionId;
        private boolean isCompleted;
        private int earnedPoint;
        private String status;

    }

    @Getter
    @Builder
    public static class ProgressDTO {
        private Long missionId;
        private String description;
        private int point;
        private String status;
    }

    @Getter
    @Builder
    public static class ProgressListDTO {
        private List<ProgressDTO> missionList;
        private int totalPage;
        private long totalElements;
        private boolean first;
        private boolean last;
    }

}
