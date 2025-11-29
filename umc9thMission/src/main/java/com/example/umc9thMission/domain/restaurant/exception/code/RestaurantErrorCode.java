package com.example.umc9thMission.domain.restaurant.exception.code;

import com.example.umc9thMission.global.apiPayload.code.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum RestaurantErrorCode implements BaseErrorCode {

    NOT_FOUND(HttpStatus.NOT_FOUND,"REVIEW404_1","가게 리뷰 목록 조회 실패");
    private final HttpStatus status;
    private final String code;
    private final String message;
}
