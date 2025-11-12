package com.example.umc9thMission.domain.test.exception;

import com.example.umc9thMission.global.apiPayload.code.BaseErrorCode;
import com.example.umc9thMission.global.apiPayload.exception.GeneralException;

public class TestException extends GeneralException {
    public TestException(BaseErrorCode code){
        super(code);
    }
}
