package com.example.LogisticsWarehouse.dto;

import com.example.LogisticsWarehouse.entity.User;
import com.example.LogisticsWarehouse.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JoinRequest {


    @NotBlank(message = "로그인 아이디가 비어있습니다.")
    @Email
    private String email;

    @NotBlank(message = "password empty")
    private String password;
    private String passwordCheck;

    @NotBlank(message = "닉네임이 비어있습니다.")
    @Size(min = 1, max = 10, message = "1~10")
    private String userName;

    // 비밀번호 암호화 X
    public User toEntity() {
        return User.builder()
                .email(this.email)
                .password(this.password)
                .userName(this.userName)
                .role(UserRole.USER)
                .build();
    }
}