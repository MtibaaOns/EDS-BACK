package org.example.authentiation.controllers;

import lombok.AllArgsConstructor;
import org.example.authentiation.entities.TypeUser;
import org.example.authentiation.entities.Utilisateur;
import org.example.authentiation.services.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("Utilisateur")
@AllArgsConstructor
public class UtilisateurController {
    private final UtilisateurService utilisateurService;



   @GetMapping("/all")

    public ResponseEntity<List<Utilisateur>> getAllUtilisateur() {
        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateur();
        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable("id") Long id) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }
    @GetMapping("/role/{role}")
    public List<Utilisateur> getUtilisateursByRole(@PathVariable TypeUser role) {
        return utilisateurService.getAllUtilisateurByRole(role);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@RequestBody Utilisateur utilisateur, @PathVariable Long id) {
        Utilisateur updatedUtilisateur = utilisateurService.updateUtilisateur(
                utilisateur,
                id,
                utilisateur.getNom(),
                utilisateur.getPrenom(),
                utilisateur.getAdresse(),
                utilisateur.getTel(),
                utilisateur.getEmail(),
                utilisateur.getLogin(),
                utilisateur.getPassword(),
                utilisateur.getMf(),
                utilisateur.getRaisonSocial(),
                utilisateur.getSpecialite(),
                utilisateur.getRole()
        );
        return new ResponseEntity<>(updatedUtilisateur, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUtilisateur(@PathVariable("id") Long id) {

        utilisateurService.deleteUtilisateur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
