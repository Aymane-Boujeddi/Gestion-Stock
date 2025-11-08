package com.gestion.stock.service;


import com.gestion.stock.dto.request.BonSortieRequestDto;
import com.gestion.stock.dto.response.BonSortieResponseDTO;

import java.util.List;

public interface BonSortieService {
    public BonSortieResponseDTO createBonSortie(BonSortieRequestDto bonSortieRequestDto);
    public List<BonSortieResponseDTO> getAllBonsSortie();
    public BonSortieResponseDTO getBonSortieById(Long id);

}
