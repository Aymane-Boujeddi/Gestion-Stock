package com.gestion.stock.mapper;


import com.gestion.stock.dto.request.CommandeRequestDTO;
import com.gestion.stock.dto.request.DetailsCommandeRequestDTO;
import com.gestion.stock.dto.response.CommandeResponseDTO;
import com.gestion.stock.dto.response.DetailsCommandeResponseDTO;
import com.gestion.stock.entity.DetailsCommande;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetailsCommandeMapper {

    DetailsCommande toEntity(CommandeRequestDTO.DetailsCommandeRequestDTO detailsCommandeDTO);

    CommandeResponseDTO.DetailsCommandeResponseDTO toResponseDTO(DetailsCommande detailsCommande);
}
