package com.example.LogisticsWarehouse.controller;

import com.example.LogisticsWarehouse.dto.RecordRequest;
import com.example.LogisticsWarehouse.dto.RecordResponse;
import com.example.LogisticsWarehouse.entity.Record;
import com.example.LogisticsWarehouse.entity.User;
import com.example.LogisticsWarehouse.repository.RecordRepository;
import com.example.LogisticsWarehouse.service.RecordService;
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

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/record")
@CrossOrigin(origins = "http://localhost:3000")
public class RecordController {

    private final RecordService recordService;
    private final RecordRepository recordRepository;
    private final UserService userService;


    //기록 생성
    @PostMapping
    public ResponseEntity<Void> create(Authentication auth, @RequestBody RecordRequest req){
        recordService.create(req);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    //기록 단일 조회
    @GetMapping("/{id}")
    public ResponseEntity<RecordResponse> getById(@PathVariable Long id){
        return ResponseEntity
                .ok(recordService.findById(id));
    }

//    //기록 목록 조회(오름차순)
//    @GetMapping("/ASC")
//    public ResponseEntity<List<RecordResponse>> getAllASC(){
//        return ResponseEntity
//                .ok(recordService.findAllASC());
//    }

    //기록 목록 조회(오름차순, 페이지네이션)
    @GetMapping("/ASC")
    public ResponseEntity<Page<Record>> getAllASCPage(
            @PageableDefault(size = 5, sort = {"createdDate"}, direction = Sort.Direction.ASC)
            Pageable pageable
    ){
        return ResponseEntity
                .ok(recordService.findAllASCPage(pageable));
    }

    //기록 목록 조회(내림차순, 페이지네이션)
    @GetMapping("/DESC")
    public ResponseEntity<Page<Record>> getAllDESCPage(
            @PageableDefault(size = 5, sort = {"createdDate"}, direction = Sort.Direction.DESC)
            Pageable pageable
    ){
        return ResponseEntity
                .ok(recordService.findAllDESCPage(pageable));
    }

    //기록 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(Authentication auth, @PathVariable Long id){
        RecordResponse record = recordService.findById(id);
        User loginUser = userService.getLoginUserByEmail(auth.getName());

        if(!record.getUserName().equals(loginUser.getUserName()) ){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        recordService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //유저이름으로 검색
    @GetMapping("/search")
    public ResponseEntity<Page<Record>> getByUserNameContaining(
            String keyword,
            @PageableDefault(size = 5, sort = {"createdDate"}, direction = Sort.Direction.DESC)
            Pageable pageable
    ){
        System.out.println("test1");
        return ResponseEntity
                .ok(recordService.findByUserNameContaining(keyword, pageable));
    }

}
