package edu.platform.application.service;

import edu.platform.application.model.request.SendGoogleMailRequest;
import org.springframework.mail.MailException;

public interface MailService {

    void sendGoogleMail(SendGoogleMailRequest request) throws MailException;
}
