package org.example.authentiation.repositories;


import org.example.authentiation.entities.Interventions;
import org.example.authentiation.entities.demande_intervention;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InterventionsRepo extends JpaRepository<Interventions, Long> {

    void deleteInterventionById(Long id);
    List<Interventions> findInterventionsByTechnicien(String technicien);
    Optional<Interventions> findInterventionById(Long id);



}
