package org.example.authentiation.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Facture")
public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "date")
    private String date;

    @Column(name = "client")
    private String client;

    @Column(name = "totalHT")
    private Double totalHT;

    @Column(name = "tva")
    private Integer tva;

    @Column(name = "totalTTC")
    private Double totalTTC;

    private Date dateN;



    public Facture() {
    }

    public Facture(String code, String date, String client, Double totalHT, Integer tva, Date dateN) {
        this.code = code;
        this.date = date;
        this.client = client;
        this.totalHT = totalHT;
        this.tva = tva;
        this.dateN = dateN;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Double getTotalHT() {
        return totalHT;
    }

    public void setTotalHT(Double totalHT) {
        this.totalHT = totalHT;
    }

    public Integer getTva() {
        return tva;
    }

    public void setTva(Integer tva) {
        this.tva = tva;
    }



    public Double getTotalTTC() {
        return totalTTC;
    }

    public void setTotalTTC(Double totalTTC) {
        this.totalTTC = totalTTC;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", date=" + date +
                ", client='" + client + '\'' +
                ", totalHT=" + totalHT +
                ", tva=" + tva +
                ", totalTTC=" + totalTTC +
                '}';
    }

    public Date getDateN() {
        return dateN;
    }

    public void setDateN(Date dateN) {
        this.dateN = dateN;
    }
}