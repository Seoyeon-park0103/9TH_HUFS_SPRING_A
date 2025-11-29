package com.example.umc9thMission.domain.restaurant.exception.code;

import com.example.umc9thMission.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum RestaurantSuccessCode implements BaseSuccessCode {

    FOUND(HttpStatus.OK, "RESTAURANT2001","가게 리뷰 목록 조회 성공");

    private final HttpStatus status;
    private final String code;
    private final String message;
}



