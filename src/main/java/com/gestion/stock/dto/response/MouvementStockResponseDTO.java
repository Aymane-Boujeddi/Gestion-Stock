package com.gestion.stock.dto.response;

import com.gestion.stock.enums.TypeMouvement;

import java.time.LocalDateTime;

public class MouvementStockResponseDTO {

    private int quantite;
    private Double prix;
    private TypeMouvement typeMouvement;
    private LocalDateTime dateMouvement;
    private Long stockId;
}
