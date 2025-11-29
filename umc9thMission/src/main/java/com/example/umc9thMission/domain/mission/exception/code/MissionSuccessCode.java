package com.example.umc9thMission.domain.mission.exception.code;

import com.example.umc9thMission.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MissionSuccessCode implements BaseSuccessCode {
    FOUND(HttpStatus.OK, "MISSION2001","가게 미션 목록 조회 성공");

    private final HttpStatus status;
    private final String code;
    private final String message;

}
