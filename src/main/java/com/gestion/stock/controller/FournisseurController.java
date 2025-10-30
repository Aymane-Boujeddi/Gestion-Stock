package com.gestion.stock.controller;


import com.gestion.stock.dto.request.FournisseurCreateDTO;
import com.gestion.stock.mapper.FournisseurMapper;
import com.gestion.stock.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;

    @Autowired
    private FournisseurMapper mapper;





    @PostMapping
    public void createFournisseur(@RequestBody FournisseurCreateDTO fournisseurCreateDTO){


    }




}
