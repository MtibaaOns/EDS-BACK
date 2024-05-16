package org.example.authentiation.repositories;


import org.example.authentiation.entities.Depot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepotRepo  extends JpaRepository<Depot, Long> {
    void deleteDepotById(Long id);
    Optional<Depot> findDepotById(Long id);
}