package edu.platform.domains.learner.model.request;

import lombok.Data;

@Data
public class LearnerConfirmMappingRequest {
    private Long id;
    private String adultAccountEmail;
    private String mappingCode;
}
