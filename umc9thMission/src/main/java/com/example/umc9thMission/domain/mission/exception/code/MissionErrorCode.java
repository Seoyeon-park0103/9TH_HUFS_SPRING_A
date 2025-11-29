package com.example.umc9thMission.domain.mission.exception.code;

import com.example.umc9thMission.global.apiPayload.code.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MissionErrorCode implements BaseErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION404_1","가게 미션 목록 조회 실패"),
    INVALID_PAGE(HttpStatus.BAD_REQUEST, "MISSION400_1", "페이지 번호는 0 이상이어야 합니다.");
    private final HttpStatus status;
    private final String code;
    private final String message;
}
