package com.example.umc9thMission.domain.member.dto.req;

import com.example.umc9thMission.domain.member.enums.Gender;
import com.example.umc9thMission.domain.mission.entity.MemberMission;
import com.example.umc9thMission.domain.review.entity.Review;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDTO {
    public record JoinDTO(
        @NotBlank
        String name,
        @NotNull
        Gender gender,
        @Email
        String email,
        @NotNull
        LocalDate birth,
        @NotNull
        String phoneNum,
        @NotBlank
        String password
        //List<Long> reviewList,
        //List<Long> memberMissionList

        ){}

    // 로그인
    public record LoginDTO(
            @NotBlank
            String email,
            @NotBlank
            String password
    ){}

}
