package org.example.authentiation.repositories;

import org.example.authentiation.entities.Facture;
import org.example.authentiation.entities.Interventions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FactureRepo extends JpaRepository<Facture, Long> {
    void deleteFactureById(Long id);
    List<Facture> findFactureByClient(String client);
    Optional<Facture> findFactureById(Long id);
    @Query("SELECT c FROM Facture c WHERE DATE_FORMAT(c.dateN, '%d-%m-%Y') = :dateFormatted")
    List<Facture> findFacturesByFormattedDateCreation(@Param("dateFormatted") String dateFormatted);

}