package com.example.umc9thMission.domain.mission.dto.res;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class MissionResDTO {
    @Builder
    @Getter
    public static class MissionPreviewDTO{
        private Long missionId;
        private String description;
        private Boolean isCompleted;
    }

    @Builder
    @Getter
    public static class MissionPreviewListDTO{
        private List<MissionPreviewDTO> missionList;
        private int listSize;
        private int totalPage;
        private long totalElements;
        private boolean isFirst;
        private boolean isLast;

    }
}
