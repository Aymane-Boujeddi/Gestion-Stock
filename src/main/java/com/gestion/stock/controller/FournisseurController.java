package com.gestion.stock.controller;


import com.gestion.stock.dto.request.FournisseurCreateDTO;
import com.gestion.stock.dto.request.FournisseurUpdateDTO;
import com.gestion.stock.dto.response.FournisseurResponseDTO;
import com.gestion.stock.entity.Fournisseur;
import com.gestion.stock.mapper.FournisseurMapper;
import com.gestion.stock.service.FournisseurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;

    @Autowired
    private FournisseurMapper mapper;





    @PostMapping(produces = "*/*")
    public ResponseEntity<FournisseurResponseDTO> createFournisseur(@Valid @RequestBody FournisseurCreateDTO fournisseurCreateDTO){
        Fournisseur  newFournisseur = mapper.toEntity(fournisseurCreateDTO);
        Fournisseur newFournisseurSaved = fournisseurService.createFournisseur(newFournisseur);

        return ResponseEntity.ok(mapper.toResponseDTO(newFournisseurSaved));

    }
    @PutMapping(value = "/{id}", produces = "*/*")
    public ResponseEntity<FournisseurResponseDTO> updateFournisseur(
            @PathVariable Long id,
            @Valid @RequestBody FournisseurUpdateDTO fournisseurUpdateDTO) {

        Fournisseur fournisseurToUpdate = mapper.toEntity(fournisseurUpdateDTO);
        Fournisseur updatedFournisseur = fournisseurService.updateFournisseur(id, fournisseurToUpdate);
        return ResponseEntity.ok(mapper.toResponseDTO(updatedFournisseur));
    }

    @GetMapping
    public ResponseEntity<List<FournisseurResponseDTO>> getAllFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurService.getAllFournisseurs();

        List<FournisseurResponseDTO> responseDTOs = fournisseurs.stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseDTOs);
    }

}
