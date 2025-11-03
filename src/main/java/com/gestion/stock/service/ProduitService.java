package com.gestion.stock.service;

import com.gestion.stock.entity.Produit;

import java.util.List;

public interface ProduitService {
    public Produit saveProduit(Produit produit);
    public List<Produit> allProduits();
    public Produit oneProduitById(Long id);
}
