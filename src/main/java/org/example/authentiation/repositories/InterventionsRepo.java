package org.example.authentiation.repositories;


import org.example.authentiation.entities.Interventions;
import org.example.authentiation.entities.demande_intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InterventionsRepo extends JpaRepository<Interventions, Long> {

    void deleteInterventionById(Long id);
    List<Interventions> findInterventionsByTechnicien(String technicien);
    List<Interventions> findInterventionsByClient(String client);
    Optional<Interventions> findInterventionById(Long id);

    @Query("SELECT c FROM Interventions c WHERE DATE_FORMAT(c.date, '%d-%m-%Y') = :dateFormatted AND c.cloturer = true")
    List<Interventions> findInterventionsByFormattedDateCreation(@Param("dateFormatted") String dateFormatted);

}
