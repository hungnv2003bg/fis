package edu.platform.application.service.impl;

import edu.platform.application.model.request.SendGoogleMailRequest;
import edu.platform.application.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService {
    private JavaMailSender javaMailSender;

    @Override
    public void sendGoogleMail(SendGoogleMailRequest request) throws MailException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(request.getFrom());
        message.setTo(request.getTo());
        message.setSubject(request.getSubject());
        message.setText(request.getContent());

        javaMailSender.send(message);
    }
}
