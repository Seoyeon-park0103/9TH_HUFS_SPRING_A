package com.example.umc9thMission.domain.review.repository;

import com.example.umc9thMission.domain.restaurant.entity.Restaurant;
import com.example.umc9thMission.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long>,ReviewRepositoryCustom{
    Page<Review> findAllByRestaurant(Restaurant restaurant, Pageable pageable);
    Page<Review> findAllByMemberId(Long memberId, Pageable pageable);

}
