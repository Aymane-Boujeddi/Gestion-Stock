package com.gestion.stock.service;

import com.gestion.stock.dto.request.FournisseurCreateDTO;
import com.gestion.stock.entity.Fournisseur;

import java.util.List;

public interface FournisseurService {


    public Fournisseur createFournisseur(Fournisseur fournisseur);
    public Fournisseur updateFournisseur(Long id, Fournisseur fournisseur);


}
