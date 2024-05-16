package org.example.authentiation.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import java.io.Serializable;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "Société")
public class Société implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;

    @Column(name = "RaisonSocial")
    private String raisonSocial;

    @Column(name = "Adresse")
    private String adresse;

    @Column(name = "Email")
    private String email;

    @Column(name = "Tel")
    private String tel;

    @Column(name = "MF")
    private String mf;

    public Société() {
        // Constructeur par défaut requis par JPA
    }

    public Société(String raisonSocial, String adresse, String email, String tel, String mf) {
        this.raisonSocial = raisonSocial;
        this.adresse = adresse;
        this.email = email;
        this.tel = tel;
        this.mf = mf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMf() {
        return mf;
    }

    public void setMp(String mf) {
        this.mf = mf;
    }

    @Override
    public String toString() {
        return "Société{" +
                "id=" + id +
                ", raisonSocial='" + raisonSocial + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", mf='" + mf + '\'' +
                '}';
    }
}