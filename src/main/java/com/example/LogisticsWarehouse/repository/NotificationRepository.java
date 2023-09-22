package com.example.LogisticsWarehouse.repository;

import com.example.LogisticsWarehouse.dto.NotificationResponse;
import com.example.LogisticsWarehouse.entity.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    //내가 받은 알림 전체 조회
    Page<Notification> findByGetUser(String name, Pageable pageable);

    Page<Notification> findByGetUserAndNoticeType(String name, String type, Pageable pageable);


}
