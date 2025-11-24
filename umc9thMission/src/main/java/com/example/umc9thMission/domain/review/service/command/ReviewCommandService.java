package com.example.umc9thMission.domain.review.service.command;

import com.example.umc9thMission.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9thMission.domain.review.dto.res.ReviewResDTO;

public interface ReviewCommandService {
    ReviewResDTO.CreateDTO createReview(ReviewReqDTO.CreateDTO dto);
}
