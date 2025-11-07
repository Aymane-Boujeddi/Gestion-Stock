package com.gestion.stock.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bons_sortie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BonSortie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String numero;

    @Column(name = "date_sortie", nullable = false)
    private LocalDateTime dateSortie;

    @Column(nullable = false)
    private String atelier;

    @Column(nullable = false)
    private String motif; // texte libre : PRODUCTION, MAINTENANCE, etc.

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutBonSortie statut;

    @Column(name = "motif_details")
    private String motifDetails;

    @OneToMany(mappedBy = "bonSortie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BonSortieItem> items = new ArrayList<>();

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

}
