package com.gestion.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.stock.entity.Commande;

public interface CommandeRepository extends JpaRepository<Commande , Long> {
}
