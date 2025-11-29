package com.example.umc9thMission.domain.review.converter;

import com.example.umc9thMission.domain.member.entity.Member;
import com.example.umc9thMission.domain.restaurant.entity.Restaurant;
import com.example.umc9thMission.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9thMission.domain.review.dto.res.ReviewResDTO;
import com.example.umc9thMission.domain.review.entity.Review;
import com.example.umc9thMission.domain.review.enums.Rating;
import com.example.umc9thMission.domain.test.dto.res.TestResDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
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

    //result -> DTO
    public static ReviewResDTO.ReviewPreViewListDTO toReviewPreviewListDTO(
            Page<Review> result
    ){
        return ReviewResDTO.ReviewPreViewListDTO.builder()
                .reviewList(result.getContent().stream()
                        .map(ReviewConverter::toReviewPreviewDTO)
                        .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static ReviewResDTO.ReviewPreViewDTO toReviewPreviewDTO(
            Review review
    ){
        return ReviewResDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getRating().getScore())
                .body(review.getBody())
                .createdAt(LocalDate.from(review.getCreatedAt()))
                .build();
    }

    public static ReviewResDTO.MyReviewPreviewListDTO toMyReviewPreviewListDTO(
            Page<Review> reviewPage
    ){
        List<ReviewResDTO.MyReviewPreviewDTO> list = reviewPage.getContent().stream()
                .map(review -> ReviewResDTO.MyReviewPreviewDTO.builder()
                        .ownerNickname(review.getMember().getName())
                        .score(review.getRating().getScore()) // Enum -> 점수
                        .body(review.getBody())
                        .createdAt(review.getCreatedAt().toLocalDate().toString())
                        .build()
                ).toList();

        return ReviewResDTO.MyReviewPreviewListDTO.builder()
                .reviewList(list)
                .listSize(list.size())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .isFirst(reviewPage.isFirst())
                .isLast(reviewPage.isLast())
                .build();

    }


}

