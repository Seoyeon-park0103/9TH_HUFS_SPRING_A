package com.example.umc9thMission.domain.member.service.query;

import com.example.umc9thMission.domain.member.entity.Member;

public interface MemberQueryService {
    Member getMyPage(Long memberId);
}
