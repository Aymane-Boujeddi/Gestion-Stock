package com.gestion.stock.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BonSortieItemRequestDTO {

    private Long produitId;
    private Integer quantite;
}
