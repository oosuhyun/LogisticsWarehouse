package com.example.LogisticsWarehouse.dto;

import com.example.LogisticsWarehouse.entity.Record;
import com.example.LogisticsWarehouse.entity.User;
import com.example.LogisticsWarehouse.entity.UserRole;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class RecordResponse {

    private Long recordId;
    private String userName;
    private LocalDateTime createDate;
    private Integer railNum;
    private String content;

    public static RecordResponse toDTO(Record record) {
        return RecordResponse.builder()
                .recordId(record.getRecordId())
                .userName(record.getUserName())
                .createDate(record.getCreateDate())
                .railNum(record.getRailNum())
                .content(record.getContent())
                .build();
    }
}
