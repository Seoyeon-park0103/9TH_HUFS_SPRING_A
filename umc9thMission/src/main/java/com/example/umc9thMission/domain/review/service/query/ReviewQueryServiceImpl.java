package com.example.umc9thMission.domain.review.service.query;
import com.example.umc9thMission.domain.restaurant.entity.Restaurant;
import com.example.umc9thMission.domain.restaurant.exception.RestaurantException;
import com.example.umc9thMission.domain.restaurant.exception.code.RestaurantErrorCode;
import com.example.umc9thMission.domain.review.converter.ReviewConverter;
import com.example.umc9thMission.domain.review.dto.res.ReviewResDTO;
import com.example.umc9thMission.domain.review.entity.Review;
import com.example.umc9thMission.domain.review.enums.Rating;
import com.example.umc9thMission.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.umc9thMission.domain.restaurant.repository.RestaurantRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService{
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public List<Review> getMyReviews(Long memberId, String restaurantName, Rating rating){
        return reviewRepository.findMyReviews(memberId,restaurantName,rating);
    }

    @Override
    public ReviewResDTO.ReviewPreViewListDTO findReview(
            String restaurantName,
            Integer page
    ){
        //음수 검사
        if (page < 0) {
            throw new IllegalArgumentException("페이지는 0 이상이어야 합니다.");
        }

        // - 가게를 가져온다 (가게 존재 여부 검증)
        Restaurant restaurant = restaurantRepository.findByName(restaurantName)
                //    - 없으면 예외 터뜨린다
                .orElseThrow(() -> new RestaurantException(RestaurantErrorCode.NOT_FOUND));

        //- 가게에 맞는 리뷰를 가져온다 (Offset 페이징)
        PageRequest pageRequest = PageRequest.of(page, 5);
        Page<Review> result = reviewRepository.findAllByRestaurant(restaurant, pageRequest);

        //- 결과를 응답 DTO로 변환한다 (컨버터 이용)
        return ReviewConverter.toReviewPreviewListDTO(result);
    }

    @Override
    public List<Review> searchReview(String filter, String type) {
        // 일단 비워두고 사용 안 하면 삭제해도 됨
        return List.of();
    }

    @Override
    public ReviewResDTO.MyReviewPreviewListDTO findMyReviews(Long memberId, Integer page){
        PageRequest pageRequest = PageRequest.of(page,10);
        Page<Review> reviewPage = reviewRepository.findAllByMemberId(memberId,pageRequest);

        return ReviewConverter.toMyReviewPreviewListDTO(reviewPage);
    }


}