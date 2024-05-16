package org.example.authentiation.services;

import org.example.authentiation.entities.TypeUser;
import org.example.authentiation.entities.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {



    public List<Utilisateur> getAllUtilisateur();
    public List<Utilisateur> getAllUsersForAdmin();
    public Utilisateur getUtilisateurById(Long id) ;


        Utilisateur getUtilisateurByEmail(String email);
    public List<Utilisateur> getAllUtilisateurByRole(TypeUser role);

    Utilisateur updateUtilisateur(Utilisateur utilisateur, Long id, String nom, String prenom, String adresse, String tel, String email, String login, String password, String raisonSocial, String mf, String specialite,TypeUser role);


    void deleteUtilisateur(Long id);
}
