package edu.platform.domains.learner.model.request;

import lombok.Data;

@Data
public class LearnerAuthRequest {
    private String account;
    private String password;
}
