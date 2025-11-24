package com.example.umc9thMission.domain.review.service.query;
import com.example.umc9thMission.domain.review.entity.Review;
import com.example.umc9thMission.domain.review.enums.Rating;
import com.example.umc9thMission.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService{
    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> getMyReviews(Long memberId, String restaurantName, Rating rating){
        return reviewRepository.findMyReviews(memberId,restaurantName,rating);
    }
}