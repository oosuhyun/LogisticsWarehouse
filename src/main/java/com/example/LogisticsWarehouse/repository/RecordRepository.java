package com.example.LogisticsWarehouse.repository;

import com.example.LogisticsWarehouse.entity.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {

    Page<Record> findAll(Pageable pageable);
    List<Record> findByUserNameContaining(String keyword);

}
