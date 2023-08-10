package com.example.LogisticsWarehouse.service;

import com.example.LogisticsWarehouse.dto.JoinRequest;
import com.example.LogisticsWarehouse.dto.LoginRequest;
import com.example.LogisticsWarehouse.entity.User;
import com.example.LogisticsWarehouse.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder encoder;

    /**
     * email 중복 체크
     * 회원가입 기능 구현 시 사용
     * 중복되면 true return
     */
    public boolean checkEmailDuplicate(String email) {
        return userRepository.existsByEmail(email);
    }

    /**
     * userName 중복 체크
     * 회원가입 기능 구현 시 사용
     * 중복되면 true return
     */
    public boolean checkUserNameDuplicate(String userName) {
        return userRepository.existsByUserName(userName);
    }

    /**
     * 회원가입 기능 1
     * 화면에서 JoinRequest(email, password, userName)을 입력받아 User로 변환 후 저장
     * email, userName 중복 체크는 Controller에서 진행 => 에러 메세지 출력을 위해
     */
    public void join(JoinRequest req) {
        userRepository.save(req.toEntity());
    }


    /**
     *  로그인 기능
     *  화면에서 LoginRequest(email, password)을 입력받아 email와 password가 일치하면 User return
     *  email가 존재하지 않거나 password가 일치하지 않으면 null return
     */
    public User login(LoginRequest req) {
        Optional<User> optionalUser = userRepository.findByEmail(req.getEmail());

        // email와 일치하는 User가 없으면 null return
        if(optionalUser.isEmpty()) {
            return null;
        }

        User user = optionalUser.get();

        // 찾아온 User의 password와 입력된 password가 다르면 null return
        if(!user.getPassword().equals(req.getPassword())) {
            return null;
        }

        return user;
    }

    /**
     * userId(Long)를 입력받아 User을 return 해주는 기능
     * 인증, 인가 시 사용
     * userId가 null이거나(로그인 X) userId로 찾아온 User가 없으면 null return
     * userId로 찾아온 User가 존재하면 User return
     */
    public User getLoginUserById(Long userId) {
        if(userId == null) return null;

        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()) return null;

        return optionalUser.get();
    }

    /**
     * email(String)를 입력받아 User을 return 해주는 기능
     * 인증, 인가 시 사용
     * email가 null이거나(로그인 X) userId로 찾아온 User가 없으면 null return
     * email로 찾아온 User가 존재하면 User return
     */
    public User getLoginUserByEmail(String email) {
        if(email == null) return null;

        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty()) return null;

        return optionalUser.get();
    }
}