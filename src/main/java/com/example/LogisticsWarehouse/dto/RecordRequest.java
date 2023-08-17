package com.example.LogisticsWarehouse.dto;

import com.example.LogisticsWarehouse.entity.Record;
import com.example.LogisticsWarehouse.entity.User;
import com.example.LogisticsWarehouse.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class RecordRequest {

    private String userName;
    private Integer railNum;
    private String content;

    public Record toEntity() {
        return Record.builder()
                .userName(this.userName)
                .railNum(this.railNum)
                .content(this.content)
                .createDate(LocalDateTime.now(ZoneId.of("Asia/Seoul")))
                .build();
    }

}
