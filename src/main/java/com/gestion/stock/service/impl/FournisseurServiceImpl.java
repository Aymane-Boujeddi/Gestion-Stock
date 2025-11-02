package com.gestion.stock.service.impl;

import com.gestion.stock.dto.request.FournisseurCreateDTO;
import com.gestion.stock.entity.Fournisseur;
import com.gestion.stock.repository.FournisseurRepository;
import com.gestion.stock.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FournisseurServiceImpl implements FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;



    @Override
    public Fournisseur createFournisseur(Fournisseur fournisseur) {


        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Fournisseur updateFournisseur(Long id, Fournisseur fournisseurDetails) {
        Fournisseur existingFournisseur = fournisseurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Fournisseur avec ID " + id + " non trouvé"));

        if (fournisseurDetails.getNom() != null) existingFournisseur.setNom(fournisseurDetails.getNom());
        if (fournisseurDetails.getAdresse() != null) existingFournisseur.setAdresse(fournisseurDetails.getAdresse());
        if (fournisseurDetails.getPersonneContact() != null) existingFournisseur.setPersonneContact(fournisseurDetails.getPersonneContact());
        if (fournisseurDetails.getEmail() != null) existingFournisseur.setEmail(fournisseurDetails.getEmail());
        if (fournisseurDetails.getTelephone() != null) existingFournisseur.setTelephone(fournisseurDetails.getTelephone());
        if (fournisseurDetails.getVille() != null) existingFournisseur.setVille(fournisseurDetails.getVille());
        if (fournisseurDetails.getRaisonSociale() != null) existingFournisseur.setRaisonSociale(fournisseurDetails.getRaisonSociale());
        if (fournisseurDetails.getICE() != null) existingFournisseur.setICE(fournisseurDetails.getICE());

        return fournisseurRepository.save(existingFournisseur);
    }

    @Override
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }

}
