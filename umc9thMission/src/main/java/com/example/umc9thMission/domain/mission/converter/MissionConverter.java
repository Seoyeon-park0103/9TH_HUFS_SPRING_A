package com.example.umc9thMission.domain.mission.converter;

import com.example.umc9thMission.domain.mission.dto.res.MissionResDTO;
import com.example.umc9thMission.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;

import java.util.List;

public class MissionConverter {
    public static MissionResDTO.MissionPreviewListDTO toMissionPreviewListDTO(Page<Mission> missionPage){
        List<MissionResDTO.MissionPreviewDTO> list = missionPage.getContent().stream()
                .map(m -> MissionResDTO.MissionPreviewDTO.builder()
                        .missionId(m.getId())
                        .description(m.getDescription())
                        .build()
                ).toList();

        return MissionResDTO.MissionPreviewListDTO.builder()
                .missionList(list)
                .listSize(list.size())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .isFirst(missionPage.isFirst())
                .isLast(missionPage.isLast())
                .build();

    }
}
