package com.example.LogisticsWarehouse.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MailRequest {
    private String address;
    private String title;
    private String content;
}
