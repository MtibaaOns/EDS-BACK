package org.example.authentiation.repositories;


import org.example.authentiation.entities.Cause;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CauseRepo extends JpaRepository<Cause, Long> {
    void deleteCauseById(Long id);
    Optional<Cause> findCauseById(Long id);
}