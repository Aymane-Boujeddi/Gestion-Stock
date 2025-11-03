package com.gestion.stock.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProduitRequestDTO {

    @NotBlank(message = "Reference can not be blank")
    private String reference;

    @NotBlank(message = "Nom can not be blank")
    private String nom;

    @NotBlank(message = "Description can not be blank")
    private String description;

    @NotBlank(message = "Prix unitaire can not be blank")
    @Positive(message = "Prix unitaire must be positive")
    private double prixUnitaire;

    @NotBlank(message = "Categorie can not be blank")
    private String categorie;

    @NotBlank(message = "Stock actuel can not be blank")
    @Positive(message = "Stock actuel must be positive")
    private int stockActuel;

    @NotBlank(message = "Stock minimum can not be blank")
    @Positive(message = "Stock minimum must be positive")
    private int pointCommande;

    @NotBlank(message = "Unite mesure can not be blank")
    @Positive(message = "Unite mesure must be positive")
    private String UniteMesure;



}
