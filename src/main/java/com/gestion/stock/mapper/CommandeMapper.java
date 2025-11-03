package com.gestion.stock.mapper;


import com.gestion.stock.dto.request.CommandeRequestDTO;
import com.gestion.stock.dto.response.CommandeResponseDTO;
import com.gestion.stock.entity.Commande;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommandeMapper {

    Commande toEntity(CommandeRequestDTO commandeRequestDTO);

    CommandeResponseDTO toResponseDto(Commande commande);
}
