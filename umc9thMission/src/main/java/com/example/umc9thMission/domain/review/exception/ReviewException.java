package com.example.umc9thMission.domain.review.exception;

import com.example.umc9thMission.global.apiPayload.code.BaseErrorCode;
import com.example.umc9thMission.global.apiPayload.exception.GeneralException;

public class ReviewException extends GeneralException {
    public ReviewException(BaseErrorCode code){
        super(code);
    }
}
