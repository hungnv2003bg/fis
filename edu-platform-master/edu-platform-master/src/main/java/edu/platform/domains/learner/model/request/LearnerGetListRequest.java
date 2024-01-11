package edu.platform.domains.learner.model.request;

import lombok.Data;

@Data
public class LearnerGetListRequest {
    private int page;
    private int size;
}
