package org.example.authentiation.services;

import lombok.RequiredArgsConstructor;
import org.example.authentiation.config.JwtService;
import org.example.authentiation.entities.Auth.AuthenticationRequest;
import org.example.authentiation.entities.Auth.AuthenticationResponse;
import org.example.authentiation.entities.Auth.RegisterRequest;
import org.example.authentiation.entities.TypeUser;
import org.example.authentiation.entities.Utilisateur;
import org.example.authentiation.repositories.UtilisateurRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = Utilisateur.builder()
                .email(registerRequest.getEmail())
                .nom(registerRequest.getNom())
                .login(registerRequest.getLogin())
                .adresse(registerRequest.getAdresse())
                .tel(registerRequest.getTel())
                .prenom(registerRequest.getPrenom())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(registerRequest.getRole())
                .raisonSocial(registerRequest.getRaisonSocial())
                .specialite(registerRequest.getSpecialite())
                .mf(registerRequest.getMf())

                .build();
        Utilisateur userResponse =  utilisateurRepository.save(user);
        var jwt = jwtService.generateToken(userResponse);
        return AuthenticationResponse.builder().token(jwt).id(user.getId())
                .role(String.valueOf(user.getRole())).nom(user.getNom()).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getLogin(),
                        authenticationRequest.getPassword()
                )
        );
        var user = utilisateurRepository.findByLogin(authenticationRequest.getLogin()).orElse(null);
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwt).id(user.getId())
                .role(String.valueOf(user.getRole())).nom(user.getNom()).build();
    }


}