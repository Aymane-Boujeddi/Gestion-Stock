package com.gestion.stock.mapper;


import com.gestion.stock.dto.request.ProduitRequestDTO;
import com.gestion.stock.entity.Produit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProduitMapper {

    Produit toEntity(ProduitRequestDTO dto);

    ProduitRequestDTO toResponseDto(Produit produit);
}
