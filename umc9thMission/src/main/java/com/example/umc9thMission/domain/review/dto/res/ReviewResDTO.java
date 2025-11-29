package com.example.umc9thMission.domain.review.dto.res;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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


    @Builder
    public record ReviewPreViewListDTO(
            List<ReviewPreViewDTO> reviewList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record ReviewPreViewDTO(
            String ownerNickname,
            Integer score,
            String body,
            LocalDate createdAt
    ){}

    @Builder
    @Getter
    public static class MyReviewPreviewDTO{
        private String ownerNickname;
        private int score;
        private String body;
        private String createdAt;

    }

    @Builder
    @Getter
    public static class MyReviewPreviewListDTO{
        private List<MyReviewPreviewDTO> reviewList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;


    }
}
