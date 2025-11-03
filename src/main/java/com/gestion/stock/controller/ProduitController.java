package com.gestion.stock.controller;

import com.gestion.stock.dto.request.ProduitRequestDTO;
import com.gestion.stock.dto.response.ProduitResponseDTO;
import com.gestion.stock.entity.Produit;
import com.gestion.stock.mapper.ProduitMapper;
import com.gestion.stock.service.ProduitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService produitService;
    private final ProduitMapper mapper;


    @PostMapping
    public ResponseEntity<ProduitResponseDTO> createProduit(@Valid @RequestBody ProduitRequestDTO produitRequestDTO){

      return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDto(produitService.saveProduit(mapper.toEntity(produitRequestDTO))));

    }

    @GetMapping
    public ResponseEntity<List<ProduitResponseDTO>> getAllProduits(){
        List<ProduitResponseDTO> responseProduitsList = produitService.allProduits().stream().map(produit -> mapper.toResponseDto(produit)).toList();
        return ResponseEntity.ok(responseProduitsList);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<ProduitResponseDTO> getOneProduit(@PathVariable Long Id){
        return ResponseEntity.ok(mapper.toResponseDto(produitService.oneProduitById(Id)));
    }






}
