package org.example.authentiation.entities.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.authentiation.entities.TypeUser;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private String adresse;
    private String login;
    private String password;
    private String raisonSocial;
    private String mf;
    private TypeUser role;
    private String specialite;

}