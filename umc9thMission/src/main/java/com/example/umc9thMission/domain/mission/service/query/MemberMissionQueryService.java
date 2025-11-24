package com.example.umc9thMission.domain.mission.service.query;

import com.example.umc9thMission.domain.mission.entity.MemberMission;

import java.util.List;

public interface MemberMissionQueryService {
    List<MemberMission> getMemberMissions(Long memnerId);
}
