package com.example.umc9thMission.domain.review.enums;

import com.example.umc9thMission.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ReviewCreateSuccessCode implements BaseSuccessCode {
    REVIEW_CREATE(HttpStatus.CREATED,"REVIEW_201","리뷰가 성공적으로 생성되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
