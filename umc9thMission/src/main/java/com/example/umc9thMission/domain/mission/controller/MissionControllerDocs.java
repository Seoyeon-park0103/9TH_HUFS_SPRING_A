package com.example.umc9thMission.domain.mission.controller;

import com.example.umc9thMission.domain.mission.dto.res.MissionResDTO;
import com.example.umc9thMission.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestParam;

public interface MissionControllerDocs {

    @Operation(
            summary = "특정 가게의 미션 목록 조회 API",
            description = "restaurantId에 해당하는 가게의 미션을 페이지네이션하여 조회합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400")
    })

    ApiResponse<MissionResDTO.MissionPreviewListDTO> getRestaurantMissions(
            Long restaurantId,
            Integer page
    );

}
