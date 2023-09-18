package com.example.LogisticsWarehouse.dto;

import com.example.LogisticsWarehouse.entity.Record;
import com.example.LogisticsWarehouse.entity.User;
import com.example.LogisticsWarehouse.entity.UserRole;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class UserResponse {

    private Long id;
    private String email;
    private String password;
    private String userName;
    private UserRole role;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public static UserResponse toDTO(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .userName(user.getUserName())
                .role(user.getRole())
                .createdDate(user.getCreatedDate())
                .modifiedDate(user.getModifiedDate())
                .build();
    }
}
