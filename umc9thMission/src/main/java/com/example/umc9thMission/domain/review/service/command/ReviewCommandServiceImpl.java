package com.example.umc9thMission.domain.review.service.command;

import com.example.umc9thMission.domain.member.entity.Member;
import com.example.umc9thMission.domain.member.repository.MemberRepository;
import com.example.umc9thMission.domain.restaurant.entity.Restaurant;
import com.example.umc9thMission.domain.restaurant.repository.RestaurantRepository;
import com.example.umc9thMission.domain.review.converter.ReviewConverter;
import com.example.umc9thMission.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9thMission.domain.review.dto.res.ReviewResDTO;
import com.example.umc9thMission.domain.review.entity.Review;
import com.example.umc9thMission.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public ReviewResDTO.CreateDTO createReview(ReviewReqDTO.CreateDTO dto) {

        Member member = memberRepository.findById(dto.memberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        Restaurant restaurant = restaurantRepository.findById(dto.restaurantId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게입니다."));

        Review review = ReviewConverter.toReview(dto, member, restaurant);

        reviewRepository.save(review);

        return ReviewConverter.toCreateDTO(review);
    }
}

