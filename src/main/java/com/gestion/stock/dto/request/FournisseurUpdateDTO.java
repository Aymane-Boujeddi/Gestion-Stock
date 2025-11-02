package com.gestion.stock.dto.request;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FournisseurUpdateDTO {

    @Size(min = 2, max = 50, message = "Nom must be between 2 and 50 characters")
    private String nom;

    @Size(max = 100, message = "Adresse cannot exceed 100 characters")
    private String adresse;

    private String personneContact;

    @Email(message = "Invalid email format")
    private String email;

    private String telephone;

    private String ville;

    private String raisonSociale;

    @Size(min = 15, max = 15, message = "ICE must be 15 characters")
    @JsonProperty("ICE")
    private String ICE;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPersonneContact() {
        return personneContact;
    }

    public void setPersonneContact(String personneContact) {
        this.personneContact = personneContact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getICE() {
        return ICE;
    }

    public void setICE(String ICE) {
        this.ICE = ICE;
    }
}
