package com.gestion.stock.controller;


import com.gestion.stock.dto.request.FournisseurCreateDTO;
import com.gestion.stock.dto.response.FournisseurResponseDTO;
import com.gestion.stock.entity.Fournisseur;
import com.gestion.stock.mapper.FournisseurMapper;
import com.gestion.stock.service.FournisseurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;

    @Autowired
    private FournisseurMapper mapper;





    @PostMapping
    public ResponseEntity<FournisseurResponseDTO> createFournisseur(@Valid @RequestBody FournisseurCreateDTO fournisseurCreateDTO){
        Fournisseur  newFournisseur = mapper.toEntity(fournisseurCreateDTO);
        Fournisseur newFournisseurSaved = fournisseurService.createFournisseur(newFournisseur);

        return ResponseEntity.ok(mapper.toResponseDTO(newFournisseurSaved));

    }




}
