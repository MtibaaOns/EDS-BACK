package org.example.authentiation.repositories;


import org.example.authentiation.entities.Interventions;
import org.example.authentiation.entities.contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface contratRepo extends JpaRepository<contrat,Long> {


    void deleteContratBynumcontrat(Long numcontart);
    List<contrat> findContratsByClient(String client);

    Optional<contrat> findContratBynumcontrat(Long numcontart);

    @Query("SELECT c FROM contrat c WHERE DATE_FORMAT(c.date, '%d-%m-%Y') = :dateFormatted")
    List<contrat> findContratsByFormattedDateCreation(@Param("dateFormatted") String dateFormatted);


}

