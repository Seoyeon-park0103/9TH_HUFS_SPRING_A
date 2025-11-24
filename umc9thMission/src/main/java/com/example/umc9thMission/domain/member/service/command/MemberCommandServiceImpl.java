package com.example.umc9thMission.domain.member.service.command;

import com.example.umc9thMission.domain.member.converter.MemberConverter;
import com.example.umc9thMission.domain.member.dto.req.MemberReqDTO;
import com.example.umc9thMission.domain.member.dto.res.MemberResDTO;
import com.example.umc9thMission.domain.member.entity.Member;
import com.example.umc9thMission.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    //회원 가입
    @Override
    @Transactional
    public MemberResDTO.JoinDTO signup(
            MemberReqDTO.JoinDTO dto
    ){
        // 사용자 생성
        Member member = MemberConverter.toMember(dto);
        // DB 적용
        memberRepository.save(member);

        // 응답 DTO 생성
        return MemberConverter.toJoinDTO(member);

    }
}
