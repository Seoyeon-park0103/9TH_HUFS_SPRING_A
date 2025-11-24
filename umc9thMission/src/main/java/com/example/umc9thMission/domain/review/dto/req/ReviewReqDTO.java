package com.example.umc9thMission.domain.review.dto.req;

import com.example.umc9thMission.domain.review.enums.Rating;

public class ReviewReqDTO {
    public record CreateDTO(
        Long memberId,
        Long restaurantId,
        String rating,
        String body
    ){}
}
