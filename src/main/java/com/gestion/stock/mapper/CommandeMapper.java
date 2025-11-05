package com.gestion.stock.mapper;


import com.gestion.stock.dto.request.CommandeRequestDTO;
import com.gestion.stock.dto.response.CommandeResponseDTO;
import com.gestion.stock.entity.Commande;
import com.gestion.stock.entity.Fournisseur;
import com.gestion.stock.repository.FournisseurRepository;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring",uses = {DetailsCommandeMapper.class})
public abstract class  CommandeMapper {

    @Autowired
    protected FournisseurRepository fournisseurRepository;


    @Mapping(target = "fournisseur",source = "fournisseurId",qualifiedByName = "idToFournisseur")
    @Mapping(target = "detailsCommandes",source = "detailsCommande")
    @Mapping(target = "montantTotale",ignore = true)
    @Mapping(target = "statutCommande",ignore = true)
    public abstract  Commande toEntity(CommandeRequestDTO commandeRequestDTO);

    @Mapping(target = "dateCommande" , source = "dateCommande")
    @Mapping(target = "montantTotale" , source = "montantTotale")
    @Mapping(target = "fournisseurNom" , source = "fournisseur.nom")
    public abstract CommandeResponseDTO toResponseDto(Commande commande);


    @Named("idToFournisseur")
    protected Fournisseur mapToFournisseur(Long fournisseurId){
        return fournisseurRepository.findById(fournisseurId).orElseThrow(() -> new EntityNotFoundException("Fournisseur not found : " + fournisseurId));
    }

}
