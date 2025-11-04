package com.gestion.stock.service;

import com.gestion.stock.dto.request.CommandeRequestDTO;
import com.gestion.stock.dto.response.CommandeResponseDTO;
import com.gestion.stock.entity.Fournisseur;

import java.util.List;

public interface CommandeService {

    public CommandeResponseDTO saveCommande(CommandeRequestDTO commandeRequestDTO);
}
