package com.example.umc9thMission.domain.member.converter;

import com.example.umc9thMission.domain.member.dto.req.MemberReqDTO;
import com.example.umc9thMission.domain.member.dto.res.MemberResDTO;
import com.example.umc9thMission.domain.member.entity.Member;
import com.example.umc9thMission.domain.member.enums.Gender;
import com.example.umc9thMission.domain.member.enums.Role;
import com.example.umc9thMission.domain.test.dto.res.TestResDTO;
import com.example.umc9thMission.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Component
public class MemberConverter {
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

    //Entity -> DTO
    public static MemberResDTO.JoinDTO toJoinDTO(
            Member member
            ){
        return MemberResDTO.JoinDTO.builder()
                .memberId(member.getId())
                .createAt(member.getCreatedAt())
                .build();
    }

    //DTO -> Entitiy
    public static Member toMember(
            MemberReqDTO.JoinDTO dto,
            String password,
            Role role
    ){
        return Member.builder()
                .name(dto.name())
                .birth(dto.birth())
                .email(dto.email())
                .password(password)
                .role(role)
                .phoneNum(dto.phoneNum())
                .gender(dto.gender())
                .build();

    }

    //회원 가입
    @PostMapping("/sign-up")
    public ApiResponse<MemberResDTO.JoinDTO> signUp(
            @RequestBody MemberReqDTO.JoinDTO dto
    ){
        return null;
    }

    // DTO 변환
    public static MemberResDTO.LoginDTO toLoginDTO(Member member, String accessToken) {
        return MemberResDTO.LoginDTO.builder()
                .memberId(member.getId())
                .accessToken(accessToken)
                .build();
    }

}
