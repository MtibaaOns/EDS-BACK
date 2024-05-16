package org.example.authentiation.repositories;

import org.example.authentiation.entities.Société;
import org.example.authentiation.entities.TypeUser;
import org.example.authentiation.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

  
    Optional<Utilisateur> findByEmail(String email);
    Optional<Utilisateur> findByLogin(String Login);
    Optional<Utilisateur> findUtilisateurById (Long id);
    @Query("SELECT u FROM Utilisateur u WHERE u.role = :role")
    List<Utilisateur> getAllUtilisateurByRole(@Param("role") TypeUser role);
}
