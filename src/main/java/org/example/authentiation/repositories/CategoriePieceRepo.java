package org.example.authentiation.repositories;


import org.example.authentiation.entities.CategoriePiece;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CategoriePieceRepo extends JpaRepository<CategoriePiece, Long> {
    void deleteCategoriePieceById(Long id);
    Optional<CategoriePiece> findCategoriePieceById(Long id);
}