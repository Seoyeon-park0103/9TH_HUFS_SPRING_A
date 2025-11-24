package com.example.umc9thMission.domain.mission.service.command;

import com.example.umc9thMission.domain.mission.dto.req.MemberMissionReqDTO;
import com.example.umc9thMission.domain.mission.dto.res.MemberMissionResDTO;

public interface MemberMissionCommandService {
    MemberMissionResDTO.CreateDTO createMemberMission(MemberMissionReqDTO.CreateDTO dto);

}
