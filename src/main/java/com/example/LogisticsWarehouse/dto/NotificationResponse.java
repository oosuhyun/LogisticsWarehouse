package com.example.LogisticsWarehouse.dto;

import com.example.LogisticsWarehouse.entity.Notification;
import com.example.LogisticsWarehouse.entity.Record;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class NotificationResponse {

    private Long noticeId;
    private Long getUserId;   //알림 받는 사람
    private Long sendUserId;  //알림 보내는 사람
    private String noticeType;  //알림 종류
    private String content;     //알림 내용
    private String noticeURL;   //알림 클릭시 이동할 주소
    private LocalDateTime createdDate; //생성 날짜
    private LocalDateTime modifiedDate; //마지막 수정 날짜

    public static NotificationResponse toDTO(Notification notification) {
        return NotificationResponse.builder()
                .noticeId(notification.getNoticeId())
                .getUserId(notification.getGetUserId())
                .sendUserId(notification.getSendUserId())
                .noticeType(notification.getNoticeType())
                .content(notification.getContent())
                .noticeURL(notification.getNoticeURL())
                .createdDate(notification.getCreatedDate())
                .modifiedDate(notification.getModifiedDate())
                .build();
    }

}
