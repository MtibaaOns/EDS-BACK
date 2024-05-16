package org.example.authentiation.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "intervention")
public class Interventions implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String cause;
    private Boolean facturer;
    private Double montantHT;
    private Boolean cloturer;
    private String dateDeb;
    private String dateFin;
    private String code;
    private String duree;
    private String observation;
    private String technicien;
    private String client;
    private String pieceRechange;



    public Interventions() {
    }

    public Interventions(String cause, Boolean facturer, Double montantHT, Boolean cloturer, String dateDeb, String dateFin, String code, String duree, String observation, String technicien, String client, String pieceRechange, String technicienId) {
        this.cause = cause;
        this.facturer = facturer;
        this.montantHT = montantHT;
        this.cloturer = cloturer;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.code = code;
        this.duree = duree;
        this.observation = observation;
        this.technicien = technicien;
        this.client = client;
        this.pieceRechange = pieceRechange;

    }




    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getCause() {
        return cause;
    }

    public void setFacturer(Boolean facturer) {
        this.facturer = facturer;
    }

    public Boolean getFacturer() {
        return facturer;
    }

    public void setMontantHT(Double montantHT) {
        this.montantHT = montantHT;
    }

    public Double getMontantHT() {
        return montantHT;
    }

    public void setCloturer(Boolean cloturer) {
        this.cloturer = cloturer;
    }

    public Boolean getCloturer() {
        return cloturer;
    }

    public void setDateDeb(String dateDeb) {
        this.dateDeb = dateDeb;
    }

    public String getDateDeb() {
        return dateDeb;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDuree() {
        return duree;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getObservation() {
        return observation;
    }

    public void setTechnicien(String technicien) {
        this.technicien = technicien;
    }

    public String getTechnicien() {
        return technicien;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getClient() {
        return client;
    }

    public void setPieceRechange(String pieceRechange) {
        this.pieceRechange = pieceRechange;
    }

    public String getPieceRechange() {
        return pieceRechange;
    }

    public String toString() {
        return "Intervention{" +
                "id=" + id +
                ", cause='" + cause + '\'' +
                ", facturer=" + facturer +
                ", montantHT=" + montantHT +
                ", cloturer=" + cloturer +
                ", dateDeb='" + dateDeb + '\'' +
                ", dateFin='" + dateFin + '\'' +
                ", code='" + code + '\'' +
                ", duree='" + duree + '\'' +
                ", observation='" + observation + '\'' +
                ", technicien='" + technicien + '\'' +
                ", client='" + client + '\'' +
                ", pieceRechange='" + pieceRechange + '\'' +

                '}';
    }
}