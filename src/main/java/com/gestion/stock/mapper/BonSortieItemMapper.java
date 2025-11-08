package com.gestion.stock.mapper;


import com.gestion.stock.dto.request.BonSortieItemRequestDTO;
import com.gestion.stock.entity.BonSortieItem;
import com.gestion.stock.entity.Produit;
import com.gestion.stock.repository.ProduitRepository;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class BonSortieItemMapper {

    @Autowired
    protected ProduitRepository produitRepository;

    @Mapping(target = "produit",source = "produitId",qualifiedByName = "idToProduit")
    @Mapping(target = "quantite", source = "quantite")
   abstract BonSortieItem toEntity(BonSortieItemRequestDTO bonSortieItemRequestDTO);


    @Named("idToProduit")
    protected Produit idToProduit(Long produitId){
        return produitRepository.findById(produitId).orElseThrow(
                () -> new EntityNotFoundException("Produit not found : " + produitId));
    }

}
