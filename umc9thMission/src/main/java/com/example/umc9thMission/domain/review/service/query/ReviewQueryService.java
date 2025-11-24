package com.example.umc9thMission.domain.review.service.query;

import com.example.umc9thMission.domain.review.entity.Review;
import com.example.umc9thMission.domain.review.enums.Rating;

import java.util.List;

public interface ReviewQueryService {
    List<Review> getMyReviews(Long memberId, String restaurantName, Rating rating);
}
