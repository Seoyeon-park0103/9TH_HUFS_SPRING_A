package com.example.umc9thMission.domain.review.converter;

import com.example.umc9thMission.domain.member.entity.Member;
import com.example.umc9thMission.domain.restaurant.entity.Restaurant;
import com.example.umc9thMission.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9thMission.domain.review.dto.res.ReviewResDTO;
import com.example.umc9thMission.domain.review.entity.Review;
import com.example.umc9thMission.domain.review.enums.Rating;
import com.example.umc9thMission.domain.test.dto.res.TestResDTO;

public class ReviewConverter {
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

    public static Review toReview(
            ReviewReqDTO.CreateDTO dto,
            Member member,
            Restaurant restaurant
    ){
        return Review.builder()
                .member(member)
                .restaurant(restaurant)
                .rating(Rating.valueOf(dto.rating()))
                .body(dto.body())
                .build();
    }

    public static ReviewResDTO.CreateDTO toCreateDTO(Review review){
        return ReviewResDTO.CreateDTO.builder()
                .reviewId(review.getId())
                .memberId(review.getMember().getId())
                .restaurantId(review.getRestaurant().getId())
                .rating(review.getBody())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
