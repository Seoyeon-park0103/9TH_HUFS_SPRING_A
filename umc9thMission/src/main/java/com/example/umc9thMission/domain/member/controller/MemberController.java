package com.example.umc9thMission.domain.member.controller;

import com.example.umc9thMission.domain.member.dto.req.MemberReqDTO;
import com.example.umc9thMission.domain.member.dto.res.MemberResDTO;
import com.example.umc9thMission.domain.member.exception.code.MemberSuccessCode;
import com.example.umc9thMission.domain.member.service.command.MemberCommandService;
import com.example.umc9thMission.domain.test.converter.TestConverter;
import com.example.umc9thMission.domain.test.dto.res.TestResDTO;
import com.example.umc9thMission.domain.test.service.query.TestQueryService;
import com.example.umc9thMission.global.apiPayload.ApiResponse;
import com.example.umc9thMission.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final TestQueryService testQueryService;
    private final MemberCommandService memberCommandService;

    @GetMapping("/{memberId}")
    public ApiResponse<TestResDTO.Testing> test() throws Exception{
        //응답 코드 정의
        GeneralSuccessCode code = GeneralSuccessCode.SUCCESS;
        return ApiResponse.onSuccess(
                code,
                TestConverter.toTestingDTO("This is Member Test!")
        );
    }

    //예외 상황
    @GetMapping("/exception")
    public ApiResponse<TestResDTO.Exception> exception(
            @RequestParam Long flag
    ){
        testQueryService.checkFlag(flag);

        //응답 코드 정의
        GeneralSuccessCode code = GeneralSuccessCode.SUCCESS;
        return ApiResponse.onSuccess(code, TestConverter.toExceptionDTO("This is Test!"));
    }

    @PostMapping("/sign-up")
    public ApiResponse<MemberResDTO.JoinDTO> signUp(
            @RequestBody MemberReqDTO.JoinDTO dto
    ){
        return ApiResponse.onSuccess(MemberSuccessCode.FOUND, memberCommandService.signup(dto));
    }

}
