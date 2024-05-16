package org.example.authentiation.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "cause")
public class Cause implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "code_cause")
    private String codeCause;


    @Column(name = "lib_cause")
    private String libCause;


    public Cause() {
        // Constructeur par défaut requis par JPA
    }

    public Cause(String libCause, String codeCause) {
        this.libCause = libCause;
        this.codeCause = codeCause;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibCause() {
        return libCause;
    }

    public void setLibCause(String libCause) {
        this.libCause = libCause;
    }

    public String getCodeCause() {
        return codeCause;
    }

    public void setCodeCause(String codeCause) {
        this.codeCause = codeCause;
    }

    @Override
    public String toString() {
        return "Cause{" +
                "id=" + id +
                ", libCause='" + libCause + '\'' +
                ", codeCause='" + codeCause + '\'' +
                '}';
    }
}