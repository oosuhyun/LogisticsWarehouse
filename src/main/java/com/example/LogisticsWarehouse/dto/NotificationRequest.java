package com.example.LogisticsWarehouse.dto;

import com.example.LogisticsWarehouse.entity.Notification;
import com.example.LogisticsWarehouse.entity.Record;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class NotificationRequest {

    private Long getUserId;   //알림 받는 사람
    private Long sendUserId;  //알림 보내는 사람
    private String noticeType;  //알림 종류
    private String content;     //알림 내용
    private String noticeURL;   //알림 클릭시 이동할 주소

    public Notification toEntity() {
        return Notification.builder()
                .getUserId(this.getUserId)
                .sendUserId(this.sendUserId)
                .noticeType(this.noticeType)
                .content(this.content)
                .noticeURL(this.noticeURL)
                .build();
    }

}
