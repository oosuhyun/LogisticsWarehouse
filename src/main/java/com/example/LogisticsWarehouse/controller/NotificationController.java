package com.example.LogisticsWarehouse.controller;

import com.example.LogisticsWarehouse.dto.NotificationRequest;
import com.example.LogisticsWarehouse.dto.NotificationResponse;
import com.example.LogisticsWarehouse.dto.RecordRequest;
import com.example.LogisticsWarehouse.entity.Notification;
import com.example.LogisticsWarehouse.repository.NotificationRepository;
import com.example.LogisticsWarehouse.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notice")
public class NotificationController {

    private final NotificationService notificationService;
    private final NotificationRepository notificationRepository;

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
            Long id,
            @PageableDefault(size = 5, sort = {"createdDate"}, direction = Sort.Direction.DESC)
            Pageable pageable
    ){
        return ResponseEntity
                .ok(notificationService.findByGetUserId(id, pageable));
    }


}
