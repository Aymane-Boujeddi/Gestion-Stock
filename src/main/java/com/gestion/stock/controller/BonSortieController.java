package com.gestion.stock.controller;
import com.gestion.stock.dto.request.BonSortieRequestDto;
import com.gestion.stock.dto.response.BonSortieResponseDTO;
import com.gestion.stock.dto.response.CommandeResponseDTO;
import com.gestion.stock.service.BonSortieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/bonsSortie")
@RequiredArgsConstructor
public class BonSortieController {

    private final BonSortieService bonSortieService;

    @PostMapping
    public ResponseEntity<BonSortieResponseDTO> createBonSortie(@Valid @RequestBody BonSortieRequestDto bonSortieRequestDto){
        return ResponseEntity.ok(bonSortieService.createBonSortie(bonSortieRequestDto));
    }
    @GetMapping
    public ResponseEntity<List<BonSortieResponseDTO>> getAllBonsSortie() {
        return ResponseEntity.ok(bonSortieService.getAllBonsSortie());
    }

}
