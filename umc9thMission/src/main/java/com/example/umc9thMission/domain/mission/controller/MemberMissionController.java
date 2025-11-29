package com.example.umc9thMission.domain.mission.controller;

import com.example.umc9thMission.domain.mission.dto.req.MemberMissionReqDTO;
import com.example.umc9thMission.domain.mission.dto.res.MemberMissionResDTO;
import com.example.umc9thMission.domain.mission.entity.MemberMission;
import com.example.umc9thMission.domain.mission.enums.MemberMissionSuccessCode;
import com.example.umc9thMission.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc9thMission.domain.mission.service.command.MemberMissionCommandService;
import com.example.umc9thMission.domain.mission.service.query.MemberMissionQueryService;
import com.example.umc9thMission.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/member-missions")
public class MemberMissionController {
    private final MemberMissionCommandService memberMissionCommandService;
    private final MemberMissionQueryService memberMissionQueryService;

    @PostMapping("")
    public ApiResponse<MemberMissionResDTO.CreateDTO> challengeMission(
            @RequestBody MemberMissionReqDTO.CreateDTO dto
    ){
        return ApiResponse.onSuccess(
                MemberMissionSuccessCode.MISSION_CHALLENGE_CREATE,
                memberMissionCommandService.createMemberMission(dto)
        );
    }

    @GetMapping("/progress")
    public ApiResponse<MemberMissionResDTO.ProgressListDTO> getMyProgressMissions(
            @RequestParam Long memberId,
            @RequestParam Integer page
    ){
        MissionSuccessCode code = MissionSuccessCode.FOUND;

        return ApiResponse.onSuccess(
                code,
                memberMissionQueryService.findMyProgressMissions(memberId, page)
        );
    }


}
