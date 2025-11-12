package com.example.umc9thMission.domain.member.converter;

import com.example.umc9thMission.domain.test.dto.res.TestResDTO;

public class Converter {
    //객체 -> DTO
    public static TestResDTO.Testing toTestingDTO(String testing){
        return TestResDTO.Testing.builder()
                .testString(testing)
                .build();
    }

    //객체 -> DTO
    public static TestResDTO.Exception toExceptionDTO(String testing){
        return TestResDTO.Exception.builder()
                .testString(testing)
                .build();
    }
}
