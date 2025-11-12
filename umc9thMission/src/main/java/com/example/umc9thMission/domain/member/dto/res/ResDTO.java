package com.example.umc9thMission.domain.member.dto.res;

import lombok.Builder;
import lombok.Getter;

public class ResDTO {
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
}
