package com.example.LogisticsWarehouse.controller;

import com.example.LogisticsWarehouse.dto.RecordRequest;
import com.example.LogisticsWarehouse.entity.RaspberryPi;
import com.example.LogisticsWarehouse.entity.Record;
import com.example.LogisticsWarehouse.service.RaspberryPiService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ras")
@CrossOrigin(origins = "http://localhost:3000")
public class RaspberryPiController {

    private final RaspberryPiService raspberryPiService;

//    @PostMapping
//    public ResponseEntity<Void> create(){
//        raspberryPiService.createItem();
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .build();
//    }

    @GetMapping
    public RaspberryPi find(){
        return raspberryPiService.findItem();
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .build();
    }

    @GetMapping("/all")
    public List<RaspberryPi> findAll(){
        return raspberryPiService.findAllItem();
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .build();
    }

    @GetMapping("/last")
    public RaspberryPi finaLast(){
        return raspberryPiService.finaLastItem();
    }

}
