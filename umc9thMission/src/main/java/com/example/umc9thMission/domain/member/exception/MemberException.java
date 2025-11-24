package com.example.umc9thMission.domain.member.exception;
import com.example.umc9thMission.global.apiPayload.exception.GeneralException;
import com.example.umc9thMission.global.apiPayload.code.BaseErrorCode;

public class MemberException extends GeneralException {
    public MemberException(BaseErrorCode code) {
        super(code);
    }
}
