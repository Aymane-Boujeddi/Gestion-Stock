package com.gestion.stock.service.impl;

import com.gestion.stock.entity.Fournisseur;
import com.gestion.stock.repository.FournisseurRepository;
import com.gestion.stock.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    public Fournisseur getFournisseurById(Long Id)   {
        return fournisseurRepository.findById(Id).orElseThrow(()-> new IllegalArgumentException("There is no Fournisseur with this Id"));
    }




}
