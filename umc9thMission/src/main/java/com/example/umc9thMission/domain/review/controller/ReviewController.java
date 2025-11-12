package com.example.umc9thMission.domain.review.controller;

// import com.example.umc9thMission.domain.review.entity.QReview;
import com.example.umc9thMission.domain.review.entity.Review;
import com.example.umc9thMission.domain.review.enums.Rating;
import com.example.umc9thMission.domain.review.service.ReviewService;
import com.example.umc9thMission.global.apiPayload.ApiResponse;
import com.example.umc9thMission.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.umc9thMission.domain.review.entity.QReview.review;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/my")
    public ApiResponse<List<Review>> getMyReviews(
        @RequestParam(required = false)Long memberId,
        @RequestParam(required=false) String restaurantName,
        @RequestParam(required=false) Rating rating
    ){
        List<Review> reviews = reviewService.getMyReviews(memberId,restaurantName,rating);

        GeneralSuccessCode code = GeneralSuccessCode.SUCCESS;

        return ApiResponse.onSuccess(code,reviews);
    }

}
