package com.example.umc9thMission.domain.review.controller;

// import com.example.umc9thMission.domain.review.entity.QReview;
import com.example.umc9thMission.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9thMission.domain.review.dto.res.ReviewResDTO;
import com.example.umc9thMission.domain.review.entity.Review;
import com.example.umc9thMission.domain.review.enums.Rating;
import com.example.umc9thMission.domain.review.service.command.ReviewCommandService;
import com.example.umc9thMission.domain.review.service.query.ReviewQueryService;
import com.example.umc9thMission.global.apiPayload.ApiResponse;
import com.example.umc9thMission.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.umc9thMission.domain.review.enums.ReviewSuccessCode;
import java.util.List;

import static com.example.umc9thMission.domain.review.entity.QReview.review;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;

    @GetMapping("/my")
    public ApiResponse<List<Review>> getMyReviews(
        @RequestParam(required = false)Long memberId,
        @RequestParam(required=false) String restaurantName,
        @RequestParam(required=false) Rating rating
    ){
        List<Review> reviews = reviewQueryService.getMyReviews(memberId,restaurantName,rating);

        GeneralSuccessCode code = GeneralSuccessCode.SUCCESS;

        return ApiResponse.onSuccess(code,reviews);
    }

    @PostMapping("")
    public ApiResponse<ReviewResDTO.CreateDTO> createReview(
            @RequestBody ReviewReqDTO.CreateDTO dto
    ){
        return ApiResponse.onSuccess(
                ReviewSuccessCode.REVIEW_CREATE,
          reviewCommandService.createReview(dto)
        );
    }

}
