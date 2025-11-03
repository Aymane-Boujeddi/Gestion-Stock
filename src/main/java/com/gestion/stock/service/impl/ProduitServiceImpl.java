package com.gestion.stock.service.impl;

import com.gestion.stock.entity.Produit;
import com.gestion.stock.repository.ProduitRepository;
import com.gestion.stock.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;

    @Override
    public Produit saveProduit(Produit produit) {

        return  produitRepository.save(produit);
    }
}
