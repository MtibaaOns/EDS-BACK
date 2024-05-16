package org.example.authentiation.repositories;

import org.example.authentiation.entities.Interv_piece;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface IntervPieceRepo extends JpaRepository<Interv_piece, Long> {
    void deleteIntervPieceById(Long id);
    Optional<Interv_piece> findIntervPieceById(Long id);
}