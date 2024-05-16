package org.example.authentiation.repositories;

import org.example.authentiation.entities.PieceRechange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PieceRechangeRepo  extends JpaRepository<PieceRechange, Long> {
    void deletePieceRechangeById(Long id);
    Optional<PieceRechange> findPieceRechangeById(Long id);
}