package com.example.umc9thMission.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseSuccessCode{
    SUCCESS(HttpStatus.OK,"SUCCESS_200","요청이 성공적으로 처리되었습니다."),
    CREATED(HttpStatus.CREATED,"SUCCESS_201","리소스가 성공적으로 생성되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
