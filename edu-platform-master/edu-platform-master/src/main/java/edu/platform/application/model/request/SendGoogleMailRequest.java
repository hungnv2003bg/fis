package edu.platform.application.model.request;

import lombok.Data;

@Data
public class SendGoogleMailRequest {
    private String from;
    private String to;
    private String subject;
    private String content;
}
