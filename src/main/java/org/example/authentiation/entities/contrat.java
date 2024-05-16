package org.example.authentiation.entities;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import java.io.Serializable;

@Entity
@Table(name = "contrat")
public class contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long numcontrat;

    @Column(name = "code")
    private String code;
    private String dateDebut;
    private String dateFin;
    private Integer nbInterMois;
    private Integer nbInterAnnee;
    private Double mtForfaitaire;
    private String client;
    public  contrat(){

    }

    public contrat(Long numcontrat, String dateDebut, String dateFin, Integer nbInterMois, Integer nbInterAnnee, Double mtForfaitaire) {
        this.numcontrat = numcontrat;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbInterMois = nbInterMois;
        this.nbInterAnnee = nbInterAnnee;
        this.mtForfaitaire = mtForfaitaire;
        this.client = client;
    }
    public void setNumcontrat(Long numcontrat) {
        this.numcontrat = numcontrat;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public void setNbInterMois(Integer nbInterMois) {
        this.nbInterMois = nbInterMois;
    }

    public void setNbInterAnnee(Integer nbInterAnnee) {
        this.nbInterAnnee = nbInterAnnee;
    }

    public void setMtForfaitaire(Double mtForfaitaire) {
        this.mtForfaitaire = mtForfaitaire;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public Long getNumcontrat() {
        return numcontrat;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public Integer getNbInterMois() {
        return nbInterMois;
    }

    public Integer getNbInterAnnee() {
        return nbInterAnnee;
    }

    public Double getMtForfaitaire() {
        return mtForfaitaire;
    }
    public String getCode() {
        return code;
    }
    public void setClient(String client) {
        this.client = client;
    }

    public String getClient() {
        return client;
    }



    public String toString() {
        return "Contrat{" +
                "numcontrat=" + numcontrat +
                ", dateDebut=" + dateDebut +
                ", client=" + client +
                ", code=" + code +
                ", dateFin=" + dateFin +
                ", nbInterMois=" + nbInterMois +
                ", nbInterAnnee=" + nbInterAnnee +
                ", mtForfaitaire=" + mtForfaitaire +
                '}';
    }
}