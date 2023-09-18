package com.example.LogisticsWarehouse.controller;

import com.example.LogisticsWarehouse.dto.MailRequest;
import com.example.LogisticsWarehouse.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mail")
@CrossOrigin(origins = "http://localhost:3000")
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
