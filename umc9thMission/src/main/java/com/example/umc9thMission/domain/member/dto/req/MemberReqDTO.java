package com.example.umc9thMission.domain.member.dto.req;

import com.example.umc9thMission.domain.member.enums.Gender;
import com.example.umc9thMission.domain.mission.entity.MemberMission;
import com.example.umc9thMission.domain.review.entity.Review;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDTO {
    public record JoinDTO(
        String name,
        Gender gender,
        String email,
        LocalDate birth,
        String phoneNum,
        List<Long> reviewList,
        List<Long> memberMissionList

        ){}
}
