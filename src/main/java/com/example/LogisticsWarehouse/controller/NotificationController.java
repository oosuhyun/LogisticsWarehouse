package com.example.LogisticsWarehouse.controller;

import com.example.LogisticsWarehouse.dto.NotificationRequest;
import com.example.LogisticsWarehouse.dto.NotificationResponse;
import com.example.LogisticsWarehouse.dto.RecordRequest;
import com.example.LogisticsWarehouse.entity.Notification;
import com.example.LogisticsWarehouse.entity.User;
import com.example.LogisticsWarehouse.repository.NotificationRepository;
import com.example.LogisticsWarehouse.service.NotificationService;
import com.example.LogisticsWarehouse.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notice")
@CrossOrigin(origins = "http://localhost:3000")
public class NotificationController {

    private final NotificationService notificationService;
    private final NotificationRepository notificationRepository;

    private final UserService userService;

    //알림 생성
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody NotificationRequest req){
        notificationService.create(req);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    //알림 단일 조회
    @GetMapping("/{id}")
    public ResponseEntity<NotificationResponse> getById(@PathVariable Long id){
        return ResponseEntity
                .ok(notificationService.findById(id));
    }

    //내가 받은 알림 전체 조회
    @GetMapping("/get_list")
    public ResponseEntity<Page<Notification>> getByGetUserId(
            Authentication auth,
            @PageableDefault(size = 5, sort = {"createdDate"}, direction = Sort.Direction.DESC)
            Pageable pageable
    ){
        User loginUser = userService.getLoginUserByEmail(auth.getName());
        String name = loginUser.getUserName();
        return ResponseEntity
                .ok(notificationService.findByGetUser(name, pageable));
    }

    //내가 받은 알림 조회(타입별)
    @GetMapping("/get_list/type")
    public ResponseEntity<Page<Notification>> getByGetUserIdAndNoticeType(
            Authentication auth,
            String type,
            @PageableDefault(size = 5, sort = {"createdDate"}, direction = Sort.Direction.DESC)
            Pageable pageable
    ){
        User loginUser = userService.getLoginUserByEmail(auth.getName());
        String name = loginUser.getUserName();
        return ResponseEntity
                .ok(notificationService.findByGetUserAndNoticeType(name, type, pageable));
    }

    //알림 단일 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        notificationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //알림 전체 삭제
    @DeleteMapping
    public ResponseEntity<?> deleteAll(){
        notificationService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
