package com.example.LogisticsWarehouse.repository;

import com.example.LogisticsWarehouse.dto.RecordResponse;
import com.example.LogisticsWarehouse.entity.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {

    //전체 조회(페이지네이션)
    Page<Record> findAll(Pageable pageable);
    Page<Record> findByUserNameContaining(String keyword, Pageable pageable);

}
