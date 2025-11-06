package com.gestion.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.stock.entity.Commande;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande , Long> {
}
