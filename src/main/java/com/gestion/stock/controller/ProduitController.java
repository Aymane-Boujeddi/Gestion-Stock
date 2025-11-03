package com.gestion.stock.controller;

import com.gestion.stock.dto.request.ProduitRequestDTO;
import com.gestion.stock.entity.Produit;
import com.gestion.stock.mapper.ProduitMapper;
import com.gestion.stock.service.ProduitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
