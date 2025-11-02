package com.gestion.stock.controller;


import com.gestion.stock.dto.request.FournisseurCreateDTO;
import com.gestion.stock.dto.response.FournisseurResponseDTO;
import com.gestion.stock.entity.Fournisseur;
import com.gestion.stock.mapper.FournisseurMapper;
import com.gestion.stock.service.FournisseurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/fournisseurs")
@RequiredArgsConstructor
public class FournisseurController {


    private final FournisseurService fournisseurService;

    private final FournisseurMapper mapper;





    @PostMapping
    public ResponseEntity<FournisseurResponseDTO> createFournisseur(@Valid @RequestBody FournisseurCreateDTO fournisseurCreateDTO){
        Fournisseur  newFournisseur = mapper.toEntity(fournisseurCreateDTO);
        Fournisseur newFournisseurSaved = fournisseurService.createFournisseur(newFournisseur);

        return ResponseEntity.ok(mapper.toResponseDTO(newFournisseurSaved));

    }




}
