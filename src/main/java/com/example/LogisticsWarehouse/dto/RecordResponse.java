package com.example.LogisticsWarehouse.dto;

import com.example.LogisticsWarehouse.entity.Record;
import com.example.LogisticsWarehouse.entity.User;
import com.example.LogisticsWarehouse.entity.UserRole;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
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
    private Integer railNum;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public static RecordResponse toDTO(Record record) {
        return RecordResponse.builder()
                .recordId(record.getRecordId())
                .userName(record.getUserName())
                .railNum(record.getRailNum())
                .content(record.getContent())
                .createdDate(record.getCreatedDate())
                .modifiedDate(record.getModifiedDate())
                .build();
    }
}
