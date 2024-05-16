package org.example.authentiation.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "depot")
public class Depot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "code_dep")
    private String codeDep;

    @Column(name = "lib_dep")
    private String libDep;

    public Depot() {
        // Constructeur par défaut requis par JPA
    }

    public Depot(String codeDep, String libDep) {
        this.codeDep = codeDep;
        this.libDep = libDep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeDep() {
        return codeDep;
    }

    public void setCodeDep(String codeDep) {
        this.codeDep = codeDep;
    }

    public String getLibDep() {
        return libDep;
    }

    public void setLibDep(String libDep) {
        this.libDep = libDep;
    }

    @Override
    public String toString() {
        return "Depot{" +
                "id=" + id +
                ", codeDep='" + codeDep + '\'' +
                ", libDep='" + libDep + '\'' +
                '}';
    }
}