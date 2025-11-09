package com.gestion.stock.service.impl;

import com.gestion.stock.dto.request.BonSortieRequestDto;
import com.gestion.stock.dto.request.BonSortieUpdateRequestDTO;
import com.gestion.stock.dto.response.BonSortieResponseDTO;
import com.gestion.stock.entity.*;
import com.gestion.stock.enums.*;
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
    private final BonSortieItemMapper bonSortieItemMapper;


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
    @Override
    public BonSortieResponseDTO getBonSortieById(Long id) {
        BonSortie bonSortie = bonSortieRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Bon de sortie introuvable avec l'id : " + id));

        return mapper.toResponseDTO(bonSortie);
    }
    @Override
    public BonSortieResponseDTO updateBonSortie(Long id, BonSortieUpdateRequestDTO bonSortieUpdateRequestDto) {
        BonSortie existingBon = bonSortieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bon de sortie introuvable avec l'id : " + id));

        if (existingBon.getStatut() != StatutBonSortie.BROUILLON) {
            throw new IllegalStateException("Seuls les bons de sortie en BROUILLON peuvent être modifiés.");
        }

        if (bonSortieUpdateRequestDto.getAtelier() != null) {
            existingBon.setAtelier(bonSortieUpdateRequestDto.getAtelier());
        }
        if (bonSortieUpdateRequestDto.getMotif() != null) {
            existingBon.setMotif(MotifType.valueOf(bonSortieUpdateRequestDto.getMotif().toUpperCase()));
        }
        if (bonSortieUpdateRequestDto.getMotifDetails() != null) {
            existingBon.setMotifDetails(bonSortieUpdateRequestDto.getMotifDetails());
        }
        if (bonSortieUpdateRequestDto.getItems() != null) {
            existingBon.getItems().clear();
            existingBon.getItems().addAll(
                    bonSortieUpdateRequestDto.getItems().stream()
                            .map(bonSortieItemMapper::toEntity)
                            .peek(item -> item.setBonSortie(existingBon))
                            .toList()
            );
        }

        existingBon.setUpdatedAt(LocalDateTime.now());

        return mapper.toResponseDTO(bonSortieRepository.save(existingBon));
    }

    @Override
    public BonSortieResponseDTO updateBonSortieToAnnuler(Long id) {
        BonSortie updatingBonSortie = bonSortieRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("BonSortie not found id : "+ id));
        updatingBonSortie.setStatut(StatutBonSortie.ANNULE);
        return mapper.toResponseDTO(bonSortieRepository.save(updatingBonSortie));
    }


}