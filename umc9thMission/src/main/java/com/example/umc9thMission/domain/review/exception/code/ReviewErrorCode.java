package com.example.umc9thMission.domain.review.exception.code;

import com.example.umc9thMission.global.apiPayload.code.BaseErrorCode;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ReviewErrorCode implements BaseErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND,"REVIEW404_1", "해당 리뷰를 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

}
