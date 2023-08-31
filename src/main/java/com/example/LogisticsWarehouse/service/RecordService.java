package com.example.LogisticsWarehouse.service;

import com.example.LogisticsWarehouse.dto.RecordRequest;
import com.example.LogisticsWarehouse.dto.RecordResponse;
import com.example.LogisticsWarehouse.entity.Record;
import com.example.LogisticsWarehouse.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final RecordRequest recordRequest;
    private final RecordRepository recordRepository;

    //기록 생성
    public void create(RecordRequest req){
        recordRepository.save(req.toEntity());
    }

    //기록 단일 조회
    public RecordResponse findById(Long id){
        Record record = recordRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
        return RecordResponse.toDTO(record);
    }

//    //기록 목록 조회(오름차순)
//    public List<RecordResponse> findAllASC(){
//        return recordRepository.findAll(Sort.by(Sort.Direction.ASC,"createDate"))
//                .stream()
//                .map(RecordResponse::toDTO)
//                .collect(Collectors.toList());
//    }

    //기록 목록 조회(오름차순, 페이지네이션)
    public Page<Record> findAllASCPage(Pageable pageable){
        return recordRepository.findAll(pageable);
    }

    //기록 목록 조회(내림차순, 페이지네이션)
    public Page<Record> findAllDESCPage(Pageable pageable){
        return recordRepository.findAll(pageable);
    }

    //기록 삭제
    public void deleteById(Long id){
        recordRepository.deleteById(id);
    }

    //유저이름으로 검색
    public Page<Record> findByUserNameContaining(String keyword, Pageable pageable){
        return recordRepository.findByUserNameContaining(keyword, pageable);
    }

}
