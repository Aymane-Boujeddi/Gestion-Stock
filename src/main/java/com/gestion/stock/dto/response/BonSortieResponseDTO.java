package com.gestion.stock.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public class BonSortieResponseDTO {


    private String numeroBon;

    private LocalDateTime dateSortie;

    private String atelierDestinataire;

    private String motif;

    private String statutBonSortie;

    private List<BonSortieResponseDTO> items;

    private String createdBy;

    private LocalDateTime createdAt;
}
