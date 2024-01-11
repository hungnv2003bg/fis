package edu.platform.domains.learner.model.response;

import lombok.Data;

import java.util.List;

@Data
public class LearnerGetListResponse {
    private Long total;
    private List<LearnerResponse> list;
}
