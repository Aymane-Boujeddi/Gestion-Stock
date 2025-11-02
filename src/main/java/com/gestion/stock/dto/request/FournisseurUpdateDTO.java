package com.gestion.stock.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FournisseurUpdateDTO {
    @Size(min = 2, max = 50, message = "Name must between 2 and 50 characters")
    private String nom;

    @Size(max = 100, message = "Adresse cannot be over 100 characters")
    private String adresse;

    private String personneContact;

    @Email(message = "Email format should be valid")
    private String email;

    private String telephone;

    private String ville;

    private String raisonSociale;

    @Size(min = 15, max = 15, message = "ICE must be 15 characters")
    @JsonProperty("ICE")
    private String ICE;



}
