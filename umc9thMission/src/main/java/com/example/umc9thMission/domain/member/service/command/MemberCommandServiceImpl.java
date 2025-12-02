package com.example.umc9thMission.domain.member.service.command;

import com.example.umc9thMission.domain.member.converter.MemberConverter;
import com.example.umc9thMission.domain.member.dto.req.MemberReqDTO;
import com.example.umc9thMission.domain.member.dto.res.MemberResDTO;
import com.example.umc9thMission.domain.member.entity.Member;
import com.example.umc9thMission.domain.member.enums.Role;
import com.example.umc9thMission.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    //Password Encoder
    private final PasswordEncoder passwordEncoder;

    //회원 가입
    @Override
    @Transactional
    public MemberResDTO.JoinDTO signup(
            MemberReqDTO.JoinDTO dto
    ){
        //솔트된 비밀번호 생성
        String salt = passwordEncoder.encode(dto.password());

        //사용자 생성 : 유정 / 관리자는 따로 API 만들어서 관리
        Member member = MemberConverter.toMember(dto,salt, Role.ROLE_USER);
        // DB 적용
        memberRepository.save(member);

        // 응답 DTO 생성
        return MemberConverter.toJoinDTO(member);

    }
}
