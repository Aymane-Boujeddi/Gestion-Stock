package com.gestion.stock.dto.request;

public class ProduitRequestDTO {
    private Long id;
    private String reference;
    private String nom;
    private String description;
    private double prixUnitaire;
    private String categorie;
    private int stockActuel;
    private int pointCommande;
    private String UniteMesure;

    public ProduitRequestDTO(Long id, String reference, String nom, String description, double prixUnitaire, String categorie, int stockActuel, int pointCommande, String uniteMesure) {
        this.id = id;
        this.reference = reference;
        this.nom = nom;
        this.description = description;
        this.prixUnitaire = prixUnitaire;
        this.categorie = categorie;
        this.stockActuel = stockActuel;
        this.pointCommande = pointCommande;
        UniteMesure = uniteMesure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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
