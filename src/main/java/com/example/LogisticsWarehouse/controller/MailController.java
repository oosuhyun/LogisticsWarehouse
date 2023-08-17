package com.example.LogisticsWarehouse.controller;

import com.example.LogisticsWarehouse.dto.MailRequest;
import com.example.LogisticsWarehouse.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mail")
public class MailController {

    private final MailService mailService;

    @PostMapping("/send")
    public String sendMail(@RequestBody MailRequest mailRequest){
        System.out.println(mailRequest.getAddress());
        System.out.println(mailRequest.getTitle());
        System.out.println(mailRequest.getContent());
        mailService.sendSimpleMessage(mailRequest);
        return "메일 전송 완료";
    }

}
