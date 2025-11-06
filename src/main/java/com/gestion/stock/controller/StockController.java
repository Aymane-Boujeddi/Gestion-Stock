package com.gestion.stock.controller;


import com.gestion.stock.dto.response.StockResponseDTO;
import com.gestion.stock.entity.Stock;
import com.gestion.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;


    @GetMapping
    public ResponseEntity<List<StockResponseDTO>> getAllTheStock(){
        return ResponseEntity.ok(stockService.allStock());
    }

    @GetMapping("/produit/{id}")
    public ResponseEntity<Map<String , List<StockResponseDTO>>> getStocksByProductSortedFifo(@PathVariable Long id){
        return ResponseEntity.ok(stockService.stocksForProductSortedFifo(id));
    }

}
