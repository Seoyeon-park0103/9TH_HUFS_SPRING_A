package com.example.umc9thMission.domain.mission.exception;

import com.example.umc9thMission.global.apiPayload.code.BaseErrorCode;
import com.example.umc9thMission.global.apiPayload.exception.GeneralException;

public class MissionException extends GeneralException {
    public MissionException(BaseErrorCode code){
        super(code);
    }
}
