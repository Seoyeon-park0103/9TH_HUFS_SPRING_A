package com.example.umc9thMission.domain.member.service.command;

import com.example.umc9thMission.domain.member.dto.req.MemberReqDTO;
import com.example.umc9thMission.domain.member.dto.res.MemberResDTO;

public interface MemberCommandService {
    //회원 가입
    MemberResDTO.JoinDTO signup(
            MemberReqDTO.JoinDTO dto
    );
}
