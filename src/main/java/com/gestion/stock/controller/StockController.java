package com.gestion.stock.controller;


import com.gestion.stock.dto.response.StockResponseDTO;
import com.gestion.stock.entity.Stock;
import com.gestion.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;


    @GetMapping
    public ResponseEntity<List<StockResponseDTO>> getAllTheStock(){
        return ResponseEntity.ok(stockService.allStock());
    }

}
