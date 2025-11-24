package com.example.umc9thMission.domain.member.service.query;

import com.example.umc9thMission.domain.member.entity.Member;
import com.example.umc9thMission.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {
    private final MemberRepository memberRepository;

    @Override
    public Member getMyPage(Long memberId){
        return memberRepository.findById(memberId)
                .orElseThrow(()-> new IllegalArgumentException("해당 회원이 존재하지 않습니다."));

    }

}

