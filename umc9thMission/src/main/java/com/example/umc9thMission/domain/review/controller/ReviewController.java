package com.example.umc9thMission.domain.review.controller;

// import com.example.umc9thMission.domain.review.entity.QReview;
import com.example.umc9thMission.domain.restaurant.exception.RestaurantException;
import com.example.umc9thMission.domain.restaurant.repository.RestaurantRepository;
import com.example.umc9thMission.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9thMission.domain.review.dto.res.ReviewResDTO;
import com.example.umc9thMission.domain.review.entity.Review;
import com.example.umc9thMission.domain.review.enums.Rating;
import com.example.umc9thMission.domain.review.service.command.ReviewCommandService;
import com.example.umc9thMission.domain.review.service.query.ReviewQueryService;
import com.example.umc9thMission.global.apiPayload.ApiResponse;
import com.example.umc9thMission.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import com.example.umc9thMission.global.apiPayload.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.umc9thMission.domain.review.enums.ReviewCreateSuccessCode;
import com.example.umc9thMission.domain.review.exception.code.ReviewSuccessCode;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController implements ReviewControllerDocs{
    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;
    //private final RestaurantRepository restaurantRepository;

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
                ReviewCreateSuccessCode.REVIEW_CREATE,
          reviewCommandService.createReview(dto)
        );
    }


    @GetMapping("/reviews/search")
    public List<Review> searchReview(
            @RequestParam String filter,
            @RequestParam String type
    ) throws Exception{
        //서비스에게 요청
        List<Review> result = reviewQueryService.searchReview(filter, type);
        return result;
    }

    //가게의 리뷰 목록 조회
    @GetMapping("/reviews")
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getReviews(
            @RequestParam String restaurantName,
            @RequestParam(defaultValue = "1") Integer page
    ){
        ReviewSuccessCode code = ReviewSuccessCode.FOUND;
        return ApiResponse.onSuccess(code,reviewQueryService.findReview(restaurantName,page));

    }

    @GetMapping("/myReviews")
    public ApiResponse<ReviewResDTO.MyReviewPreviewListDTO> getMyReviews(
            @RequestParam Long memberId,
            @RequestParam Integer page
    ){
        ReviewSuccessCode code = ReviewSuccessCode.FOUND;
        return ApiResponse.onSuccess(
                code,
                reviewQueryService.findMyReviews(memberId, page)
        );
    }



}
