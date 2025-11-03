package com.gestion.stock.entity;


import com.gestion.stock.enums.StatutCommande;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "commandes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "montant_totale")
    private Double montanTotale;

    @Column(name = "date_commande")
    private LocalDateTime dateCommnande;

    @Column(name = "statut_commande")
    @Enumerated(EnumType.STRING)
    private StatutCommande statutCommande;


    @ManyToOne
    @JoinColumn(name= "fournisseur_id")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    private List<DetailsCommande> detailsCommandes;






}
