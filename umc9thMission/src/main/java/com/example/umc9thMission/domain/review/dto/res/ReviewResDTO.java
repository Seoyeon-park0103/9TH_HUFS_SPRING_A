package com.example.umc9thMission.domain.review.dto.res;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class ReviewResDTO {
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

    @Builder
    public record CreateDTO(
            Long reviewId,
        Long restaurantId,
        Long memberId,
        String rating,
        String body,
        LocalDateTime createdAt
    ){}

}
