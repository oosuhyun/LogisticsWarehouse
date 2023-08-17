package com.example.LogisticsWarehouse.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@AllArgsConstructor
public class Record {

    @Id
    @GeneratedValue
    private Long recordId;
    private String userName;
    private LocalDateTime createDate;
    private Integer railNum;
    private String content;


}