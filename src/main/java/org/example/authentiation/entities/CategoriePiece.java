package org.example.authentiation.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "categorie_piece")
public class CategoriePiece implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "code_categorie")
    private String codeCategorie;

    @Column(name = "des_categorie")
    private String desCategorie;

    public CategoriePiece() {
        // Constructeur par défaut requis par JPA
    }

    public CategoriePiece(String codeCategorie, String desCategorie) {
        this.codeCategorie = codeCategorie;
        this.desCategorie = desCategorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeCategorie() {
        return codeCategorie;
    }

    public void setCodeCategorie(String codeCategorie) {
        this.codeCategorie = codeCategorie;
    }

    public String getDesCategorie() {
        return desCategorie;
    }

    public void setDesCategorie(String desCategorie) {
        this.desCategorie = desCategorie;
    }

    @Override
    public String toString() {
        return "CategoriePiece{" +
                "id=" + id +
                ", codeCategorie='" + codeCategorie + '\'' +
                ", desCategorie='" + desCategorie + '\'' +
                '}';
    }
}