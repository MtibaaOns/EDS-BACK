package org.example.authentiation.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "piece_rechange")
public class PieceRechange implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "code_piece")
    private String codePiece;

    @Column(name = "des_piece")
    private String desPiece;

    @Column(name = "prix_achat")
    private double prixAchat;

    @Column(name = "taux_tva")
    private Integer tauxTVA;

    @Column(name = "categorie_piece")
    private String categoriePiece;

    public PieceRechange() {
        // Constructeur par défaut requis par JPA
    }

    public PieceRechange(String codePiece, String desPiece, double prixAchat, Integer tauxTVA, String categoriePiece) {
        this.codePiece = codePiece;
        this.desPiece = desPiece;
        this.prixAchat = prixAchat;
        this.tauxTVA = tauxTVA;
        this.categoriePiece = categoriePiece;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodePiece() {
        return codePiece;
    }

    public void setCodePiece(String codePiece) {
        this.codePiece = codePiece;
    }

    public String getDesPiece() {
        return desPiece;
    }

    public void setDesPiece(String desPiece) {
        this.desPiece = desPiece;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Integer getTauxTVA() {
        return tauxTVA;
    }

    public void setTauxTVA(Integer tauxTVA) {
        this.tauxTVA = tauxTVA;
    }

    public String getCategoriePiece() {
        return categoriePiece;
    }

    public void setCategoriePiece(String categoriePiece) {
        this.categoriePiece = categoriePiece;
    }

    @Override
    public String toString() {
        return "PieceRechange{" +
                "id=" + id +
                ", codePiece='" + codePiece + '\'' +
                ", desPiece='" + desPiece + '\'' +
                ", prixAchat=" + prixAchat +
                ", tauxTVA=" + tauxTVA +
                ", categoriePiece='" + categoriePiece + '\'' +
                '}';
    }
}