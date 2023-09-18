package com.example.LogisticsWarehouse.service;

import com.example.LogisticsWarehouse.dto.NotificationRequest;
import com.example.LogisticsWarehouse.dto.NotificationResponse;
import com.example.LogisticsWarehouse.dto.RecordRequest;
import com.example.LogisticsWarehouse.entity.Notification;
import com.example.LogisticsWarehouse.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityExistsException;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    //알림 생성
    public void create(NotificationRequest req){
        notificationRepository.save(req.toEntity());
    }

    //알림 단일 조회
    public NotificationResponse findById(Long id){
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
        return NotificationResponse.toDTO(notification);
    }

    //내가 받은 알림 전체 조회
    public Page<Notification> findByGetUser(String name, Pageable pageable){
        return notificationRepository.findByGetUser(name, pageable);
    }


}
