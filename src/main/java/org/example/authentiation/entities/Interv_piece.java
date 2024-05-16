package org.example.authentiation.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import java.io.Serializable;


@Entity
@Table(name = "interv_piece")

public class Interv_piece implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "prixTotal")
    private Double prixTotal;

    @Column(name = "quantitePiece")
    private Integer quantitePiece;

    @Column(name = "codeInterv")
    private String codeInterv;

    @Column(name = "codePiece")
    private String codePiece;
    public Interv_piece() {
    }

    public Interv_piece(Double prixTotal, Integer quantitePiece, String codeInterv, String codePiece) {
        this.prixTotal = prixTotal;
        this.quantitePiece = quantitePiece;
        this.codeInterv = codeInterv;
        this.codePiece = codePiece;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Integer getQuantitePiece() {
        return quantitePiece;
    }

    public void setQuantitePiece(Integer quantitePiece) {
        this.quantitePiece = quantitePiece;
    }

    public String getCodeInterv() {
        return codeInterv;
    }

    public void setCodeInterv(String codeInterv) {
        this.codeInterv = codeInterv;
    }

    public String getCodePiece() {
        return codePiece;
    }

    public void setCodePiece(String codePiece) {
        this.codePiece = codePiece;
    }

@Override
public String toString() {
    return "Interv_piece{" +
            "id=" + id +
            ", prixTotal=" + prixTotal +
            ", quantitePiece=" + quantitePiece +
            ", codeInterv='" + codeInterv + '\'' +
            ", codePiece='" + codePiece + '\'' +
            '}';
}}
