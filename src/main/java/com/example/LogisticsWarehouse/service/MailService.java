package com.example.LogisticsWarehouse.service;

import com.example.LogisticsWarehouse.dto.MailRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

@Service
@AllArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    public void sendSimpleMessage(MailRequest mailRequest){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ptngusimg@gmail.com");
        message.setTo(mailRequest.getAddress());
        message.setSubject(mailRequest.getTitle());
        message.setText(mailRequest.getContent());
        javaMailSender.send(message);
    }

}
