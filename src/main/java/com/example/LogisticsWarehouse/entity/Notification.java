package com.example.LogisticsWarehouse.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@AllArgsConstructor
public class Notification extends BaseTimeEntity{

    @Id
    @GeneratedValue
    private Long noticeId;
    private Long getUserId;   //알림 받는 사람
    private Long sendUserId;  //알림 보내는 사람
    private String noticeType;  //알림 종류
    private String content;     //알림 내용
    private String noticeURL;   //알림 클릭시 이동할 주소



}
