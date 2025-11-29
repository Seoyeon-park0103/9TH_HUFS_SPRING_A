package com.example.umc9thMission.domain.restaurant.exception;

import com.example.umc9thMission.global.apiPayload.code.BaseErrorCode;
import com.example.umc9thMission.global.apiPayload.exception.GeneralException;

public class RestaurantException extends GeneralException{
    public RestaurantException(BaseErrorCode code){
        super(code);
    }
}