package com.gestion.stock.service.impl;

import com.gestion.stock.dto.request.CommandeRequestDTO;
import com.gestion.stock.dto.response.CommandeResponseDTO;
import com.gestion.stock.dto.response.DetailsCommandeResponseDTO;
import com.gestion.stock.entity.Commande;
import com.gestion.stock.entity.DetailsCommande;
import com.gestion.stock.entity.Fournisseur;
import com.gestion.stock.entity.Produit;
import com.gestion.stock.enums.StatutCommande;
import com.gestion.stock.mapper.CommandeMapper;
import com.gestion.stock.mapper.DetailsCommandeMapper;
import com.gestion.stock.repository.CommandeRepository;
import com.gestion.stock.repository.FournisseurRepository;
import com.gestion.stock.repository.ProduitRepository;
import com.gestion.stock.service.CommandeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommandeServiceImpl implements CommandeService {

    private final CommandeRepository commandeRepository;


    private final CommandeMapper mapper;

    @Override
    public CommandeResponseDTO saveCommande(CommandeRequestDTO commandeRequestDTO) {
        Commande newCommande = mapper.toEntity(commandeRequestDTO);
        newCommande.setStatutCommande(StatutCommande.EN_ATTENTE);
        newCommande.setDateCommande(LocalDateTime.now());
        Double montant = newCommande.getDetailsCommandes().stream().mapToDouble(commande -> commande.getPrix() * commande.getQuantite()).sum();
        newCommande.getDetailsCommandes().forEach(detailsCommande -> detailsCommande.setCommande(newCommande));
        newCommande.setMontantTotale(montant);
        return mapper.toResponseDto(commandeRepository.save(newCommande));
    }

    @Override
    public List<CommandeResponseDTO> allCommandes() {
        List<Commande> commandes = commandeRepository.findAll();
        return commandes.stream().map(mapper::toResponseDto).toList();

    }

    @Override
    public CommandeResponseDTO commandeByID(Long id) {
        Commande searchedCommande = commandeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Commande not found : " + id));
        return mapper.toResponseDto(searchedCommande);
    }




}


