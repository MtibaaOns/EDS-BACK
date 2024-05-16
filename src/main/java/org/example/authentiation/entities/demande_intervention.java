package org.example.authentiation.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import java.io.Serializable;

@Entity
@Table(name = "demande_intervention")
public class demande_intervention implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long numDem;

    @Column(name = "code")
    private String code;

    private String statut;
    private String titre;
    private String priorite;
    private String dateFin; // Changement de LocalDate en String
    private String dateDeb; // Changement de LocalDate en String
    private String description;
    private Long clientId;


    public demande_intervention() {
    }

    public demande_intervention(Long numDem, String statut, String titre, String priorite, String dateDeb, String dateFin, String description,long clientId) {
        this.numDem = numDem;
        this.statut = statut;
        this.titre = titre;
        this.priorite = priorite;
        this.dateFin = dateFin;
        this.dateDeb = dateDeb;
        this.description = description;
        this.clientId = clientId;
    }
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    public Long getNumDem() {
        return numDem;
    }

    public void setNumDem(Long numDem) {
        this.numDem = numDem;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getPriorite() {
        return priorite;
    }

    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(String dateDeb) {
        this.dateDeb = dateDeb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "numDem=" + numDem +
                ", code='" + code + '\'' +
                ", statut='" + statut + '\'' +
                ", titre='" + titre + '\'' +
                ", priorite='" + priorite + '\'' +
                ", dateFin='" + dateFin + '\'' +
                ", dateDeb='" + dateDeb + '\'' +
                ", description='" + description + '\'' +
                ", clientId='" + clientId + '\'' +
                '}';
    }
}