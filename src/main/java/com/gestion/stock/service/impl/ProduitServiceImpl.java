package com.gestion.stock.service.impl;

import com.gestion.stock.entity.Produit;
import com.gestion.stock.repository.ProduitRepository;
import com.gestion.stock.service.ProduitService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;

    @Override
    public Produit saveProduit(Produit produit) {

        return  produitRepository.save(produit);
    }

    @Override
    public List<Produit> allProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit oneProduitById(Long id) {
        return produitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produit Not Found with ID " + id));
    }
}
