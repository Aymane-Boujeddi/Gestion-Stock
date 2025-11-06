package com.gestion.stock.service.impl;

import com.gestion.stock.dto.response.StockResponseDTO;
import com.gestion.stock.entity.DetailsCommande;
import com.gestion.stock.entity.MouvementStock;
import com.gestion.stock.entity.Produit;
import com.gestion.stock.entity.Stock;
import com.gestion.stock.mapper.DetailsCommandetoStockMapper;
import com.gestion.stock.mapper.StockMapper;
import com.gestion.stock.mapper.StockToMouvementMapper;
import com.gestion.stock.repository.MouvementStockRepository;
import com.gestion.stock.repository.ProduitRepository;
import com.gestion.stock.repository.StockRepository;
import com.gestion.stock.service.StockService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final MouvementStockRepository mouvementStockRepository;
    private final ProduitRepository produitRepository;
    private final DetailsCommandetoStockMapper detailsToStockMapper;
    private final StockToMouvementMapper stockToMouvementMapper;
    private final StockMapper stockMapper;

    @Override
    public List<StockResponseDTO> createStockLotsAndMouvement(List<DetailsCommande> detailsCommandeList) {
       return detailsCommandeList.stream().map(detailsCommande -> {

           Stock newStock =  detailsToStockMapper.detailsToStock(detailsCommande);
           newStock.setDateEntre(LocalDateTime.now());
            Stock  savedStock=stockRepository.save(newStock);
            Produit updateProduct = produitRepository.findById(savedStock.getProduit().getId()).orElseThrow(() -> new EntityNotFoundException("Produit not found id : " + savedStock.getProduit().getId()));
            updateProduct.setStockActuel(savedStock.getQuantiteActuel());
            produitRepository.save(updateProduct);
            MouvementStock mouvementEntree = stockToMouvementMapper.toMouvementEntre(savedStock);
            mouvementStockRepository.save(mouvementEntree);
           return stockMapper.toResponseDto(savedStock);

        }).toList();


    }

    @Override
    public List<StockResponseDTO> allStock() {
        List<Stock> stockList = stockRepository.findAll();
        return stockList.stream().map(stockMapper::toResponseDto).toList();
    }
}
