package com.example.umc9thMission.domain.review.exception.code;


import com.example.umc9thMission.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ReviewSuccessCode implements BaseSuccessCode {

    FOUND(HttpStatus.OK, "REVIEW2001", "리뷰 목록 조회 성공");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
