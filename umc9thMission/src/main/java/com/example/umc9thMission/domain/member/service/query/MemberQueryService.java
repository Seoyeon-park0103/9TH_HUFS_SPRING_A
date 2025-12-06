package com.example.umc9thMission.domain.member.service.query;

import com.example.umc9thMission.domain.member.dto.req.MemberReqDTO;
import com.example.umc9thMission.domain.member.dto.res.MemberResDTO;
import com.example.umc9thMission.domain.member.entity.Member;
import jakarta.validation.Valid;

public interface MemberQueryService {
    Member getMyPage(Long memberId);

    //MemberResDTO.LoginDTO login(MemberReqDTO.@Valid LoginDTO dto);
    MemberResDTO.LoginDTO login(@Valid MemberReqDTO.LoginDTO dto);
}
