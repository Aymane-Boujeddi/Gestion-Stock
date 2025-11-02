package com.gestion.stock.dto.response;

public class ProduitResponseDTO {
    private Long id;
    private String nom;
    private String description;
    private double prixUnitaire;
    private String categorie;
    private int stockActuel;
    private int pointCommande;
    private String UniteMesure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getStockActuel() {
        return stockActuel;
    }

    public void setStockActuel(int stockActuel) {
        this.stockActuel = stockActuel;
    }

    public int getPointCommande() {
        return pointCommande;
    }

    public void setPointCommande(int pointCommande) {
        this.pointCommande = pointCommande;
    }

    public String getUniteMesure() {
        return UniteMesure;
    }

    public void setUniteMesure(String uniteMesure) {
        UniteMesure = uniteMesure;
    }
}
