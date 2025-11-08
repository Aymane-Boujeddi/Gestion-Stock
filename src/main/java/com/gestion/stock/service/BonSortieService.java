package com.gestion.stock.service;


import com.gestion.stock.dto.request.BonSortieRequestDto;
import com.gestion.stock.dto.response.BonSortieResponseDTO;

public interface BonSortieService {
    public BonSortieResponseDTO createBonSortie(BonSortieRequestDto bonSortieRequestDto);
}
