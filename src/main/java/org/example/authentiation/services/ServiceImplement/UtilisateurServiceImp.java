package org.example.authentiation.services.ServiceImplement;

import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.example.authentiation.entities.TypeUser;
import org.example.authentiation.entities.Utilisateur;
import org.example.authentiation.exception.UtilisateurNotFoundException;
import org.example.authentiation.repositories.UtilisateurRepository;
import org.example.authentiation.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UtilisateurServiceImp implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private static long idCounter = 0;


    private synchronized long generateUniqueId() {
        return ++idCounter;
    }

    public List<Utilisateur> getAllUtilisateur()  {
        return utilisateurRepository.findAll();
    }

    @Override
    public List<Utilisateur> getAllUsersForAdmin() {

        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur getUtilisateurById(Long id) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
        return utilisateurOptional.orElse(null);
    }


@Override
    public List<Utilisateur> getAllUtilisateurByRole(TypeUser role) {
        return utilisateurRepository.getAllUtilisateurByRole(role);
    }




    @Override
    public Utilisateur getUtilisateurByEmail(String email) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findByEmail(email);
        return utilisateurOptional.orElse(null);
    }


    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur, Long id, String nom, String prenom, String adresse, String tel, String email, String login, String password, String raisonSocial, String mf, String specialite,TypeUser role) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);

        Utilisateur myutilisateur = optionalUtilisateur.orElseThrow(() -> new UtilisateurNotFoundException("utilisateur by id " + id + " was not found"));
        myutilisateur.setNom(nom);
        myutilisateur.setPrenom(prenom);
        myutilisateur.setAdresse(adresse);
        myutilisateur.setEmail(email);
        myutilisateur.setTel(tel);
        myutilisateur.setLogin(login);
        myutilisateur.setMf(mf);
        myutilisateur.setRaisonSocial(raisonSocial);
        myutilisateur.setSpecialite(specialite);
        myutilisateur.setRole(role);
        // Hashage du nouveau mot de passe
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        myutilisateur.setPassword(hashedPassword);

        // Vous pouvez également mettre à jour d'autres propriétés si nécessaire

        return utilisateurRepository.save(myutilisateur);
    }


    public Utilisateur findUtilisateurById(Long id){
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new UtilisateurNotFoundException("utilisateur by id " + id + " was not found"));
    }

    @Override
    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
