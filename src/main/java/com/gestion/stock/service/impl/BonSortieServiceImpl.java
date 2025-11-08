package com.gestion.stock.service.impl;

import com.gestion.stock.dto.request.BonSortieRequestDto;
import com.gestion.stock.dto.response.BonSortieResponseDTO;
import com.gestion.stock.entity.*;
import com.gestion.stock.mapper.BonSortieItemMapper;
import com.gestion.stock.mapper.BonSortieMapper;
import com.gestion.stock.repository.BonSortieRepository;
import com.gestion.stock.service.BonSortieService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class BonSortieServiceImpl implements BonSortieService {

    private final BonSortieRepository bonSortieRepository;
    private final BonSortieMapper mapper;


    @Override
    public BonSortieResponseDTO createBonSortie(BonSortieRequestDto bonSortieRequestDto) {
        BonSortie newBonSortie = mapper.toEntity(bonSortieRequestDto);
        newBonSortie.setDateSortie(LocalDateTime.now());
        newBonSortie.setStatut(StatutBonSortie.BROUILLON);
        newBonSortie.getItems().forEach(item -> item.setBonSortie(newBonSortie));

        return mapper.toResponseDTO(bonSortieRepository.save(newBonSortie));
    }
    @Override
    public List<BonSortieResponseDTO> getAllBonsSortie() {
        return bonSortieRepository.findAll().stream().map(mapper::toResponseDTO).toList();
    }

}