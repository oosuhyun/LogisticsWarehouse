package com.example.LogisticsWarehouse.jwt;

import com.example.LogisticsWarehouse.dto.JoinRequest;
import com.example.LogisticsWarehouse.dto.LoginRequest;
import com.example.LogisticsWarehouse.dto.UserResponse;
import com.example.LogisticsWarehouse.entity.User;
import com.example.LogisticsWarehouse.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jwt")
@CrossOrigin(origins = "http://localhost:3000")
public class JwtLoginApiController {

    private final UserService userService;

    @PostMapping("/join")
    public String join(@Valid @RequestBody JoinRequest joinRequest) {

        // email 중복 체크
        if(userService.checkEmailDuplicate(joinRequest.getEmail())) {
            return "이메일이 중복됩니다.";
        }
        // 닉네임 중복 체크
        if(userService.checkUserNameDuplicate(joinRequest.getUserName())) {
            return "닉네임이 중복됩니다.";
        }
        // password와 passwordCheck가 같은지 체크
        if(!joinRequest.getPassword().equals(joinRequest.getPasswordCheck())) {
            return"바밀번호가 일치하지 않습니다.";
        }

        userService.join(joinRequest);
        return "회원가입 성공";
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest loginRequest) {

        User user = userService.login(loginRequest);

        // 로그인 아이디나 비밀번호가 틀린 경우 global error return
        if(user == null) {
            return"로그인 아이디 또는 비밀번호가 틀렸습니다.";
        }

        // 로그인 성공 => Jwt Token 발급

        String secretKey = "my-secret-key-123123";
        long expireTimeMs = 1000 * 60 * 60;     // Token 유효 시간 = 60분

        return JwtTokenUtil.createToken(user.getEmail(), secretKey, expireTimeMs);
    }

    @GetMapping("/info")
    public UserResponse userInfo(Authentication auth) {
        User loginUser = userService.getLoginUserByEmail(auth.getName());

//        return String.format("email : %s\nuserName : %s\nrole : %s",
//                loginUser.getEmail(), loginUser.getUserName(), loginUser.getRole().name());

        return UserResponse.toDTO(loginUser);
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "관리자 페이지 접근 성공";
    }

    @GetMapping("/test")
    public String create(){
        return "test";
//        recordService.create(req);
//        System.out.println(req.getContent() + req.getUserName() + req.getUserName());
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .build();
    }
}