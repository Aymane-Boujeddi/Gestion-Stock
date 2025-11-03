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

    private final FournisseurRepository fournisseurRepository;

    private final ProduitRepository produitRepository;

    private final CommandeMapper mapper;
    private final DetailsCommandeMapper detailsCommandeMapper;


    @Override
    public CommandeResponseDTO saveCommande(CommandeRequestDTO commandeRequestDTO) {
        Commande commande = mapper.toEntity(commandeRequestDTO);

        commande.setFournisseur(fournisseurByID(commandeRequestDTO.getFournisseurId()));
        commande.setDateCommnande(LocalDateTime.now());
        commande.setStatutCommande(StatutCommande.EN_ATTENTE);

        double montant = 0.0;

        List<DetailsCommande> detailsCommandeList = commandeRequestDTO.getDetailsCommande().stream()
                .map(dto -> {
                    DetailsCommande detailsCommande = detailsCommandeMapper.toEntity(dto);
                    detailsCommande.setCommande(commande);
                    detailsCommande.setProduit(produitRepository.findById(dto.getProduitId()).get());
                    return detailsCommande;

        }).toList();

        montant = detailsCommandeList.stream().mapToDouble(details -> details.getPrix() * details.getQuantite()).sum();
        commande.setDetailsCommandes(detailsCommandeList);
        commande.setMontanTotale(montant);


        return mapToResponseDto(commandeRepository.save(commande));


    }

    private Fournisseur fournisseurByID(Long id){
        return fournisseurRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The Fournisseur with the ID : " + id + " is not found"));
    }

    private Produit produitByID(Long id){
        return produitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The Produit with the ID : " + id + " is not found"));
    }

    private CommandeResponseDTO mapToResponseDto(Commande commande){
        CommandeResponseDTO response = mapper.toResponseDto(commande);
        response.setDateCommande(commande.getDateCommnande());
        response.setFournisseurNom(commande.getFournisseur().getNom());
        response.setMontantTotale(commande.getMontanTotale());
        List<CommandeResponseDTO.DetailsCommandeResponseDTO> detailsCommandeResponseDTOList = commande.getDetailsCommandes().stream().map(details -> {
            CommandeResponseDTO.DetailsCommandeResponseDTO detailsCommandeResponseDTO = detailsCommandeMapper.toResponseDTO(details);
            detailsCommandeResponseDTO.setProduitNom(details.getProduit().getNom());
            return detailsCommandeResponseDTO;
        }).toList();

        response.setDetailsCommandes(detailsCommandeResponseDTOList);

        return response;

    }
}


