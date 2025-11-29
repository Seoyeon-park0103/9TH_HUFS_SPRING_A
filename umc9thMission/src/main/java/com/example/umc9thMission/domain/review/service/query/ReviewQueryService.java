package com.example.umc9thMission.domain.review.service.query;

import com.example.umc9thMission.domain.review.dto.res.ReviewResDTO;
import com.example.umc9thMission.domain.review.entity.Review;
import com.example.umc9thMission.domain.review.enums.Rating;

import java.util.List;

public interface ReviewQueryService {
    List<Review> getMyReviews(Long memberId, String restaurantName, Rating rating);

    List<Review> searchReview(
            String filter, String type
    ) throws Exception ;

    ReviewResDTO.ReviewPreViewListDTO findReview(String restaurantName, Integer page);

    ReviewResDTO.MyReviewPreviewListDTO findMyReviews(Long memberId, Integer page);
}
