package com.example.umc9thMission.domain.review.controller;

import com.example.umc9thMission.domain.review.dto.res.ReviewResDTO;
import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
import com.example.umc9thMission.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;

public interface ReviewControllerDocs {
    // 가게의 리뷰 목록 조회
    @Operation(
            summary = "가게의 리뷰 목록 조회 API By 마크 (개발 중)",
            description = "특정 가게의 리뷰를 모두 조회합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })

    ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getReviews(
            String restaurantName,
            Integer page
    );
}
