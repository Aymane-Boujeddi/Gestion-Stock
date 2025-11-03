package com.gestion.stock.controller;

import com.gestion.stock.dto.request.ProduitRequestDTO;
import com.gestion.stock.entity.Produit;
import com.gestion.stock.mapper.ProduitMapper;
import com.gestion.stock.service.ProduitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<Produit> createProduit(@Valid @RequestBody ProduitRequestDTO produitRequestDTO){

      return ResponseEntity.ok(produitService.saveProduit(mapper.toEntity(produitRequestDTO)));

    }

    @GetMapping
    public ResponseEntity<List<Produit>> getAllProduits(){
        return ResponseEntity.ok(produitService.allProduits());
    }




}
