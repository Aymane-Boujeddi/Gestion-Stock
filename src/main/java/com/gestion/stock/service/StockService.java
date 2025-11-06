package com.gestion.stock.service;

import com.gestion.stock.dto.response.StockResponseDTO;
import com.gestion.stock.entity.Commande;
import com.gestion.stock.entity.DetailsCommande;

import java.util.List;

public interface StockService {

    public List<StockResponseDTO> createStockLotsAndMouvement(List<DetailsCommande> detailsCommandeList);
}
