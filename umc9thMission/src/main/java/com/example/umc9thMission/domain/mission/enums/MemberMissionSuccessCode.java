package com.example.umc9thMission.domain.mission.enums;

import com.example.umc9thMission.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MemberMissionSuccessCode implements BaseSuccessCode {
    MISSION_CHALLENGE_CREATE(HttpStatus.CREATED ,"MISSION_201", "미션 도전이 시작되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

}
