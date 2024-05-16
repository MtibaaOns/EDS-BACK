package org.example.authentiation.entities;

import jakarta.persistence.*;

import java.io.Serializable;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "specialite")
public class specialite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Integer codeSpec;
    @Column(name = "libSpec")
    private String libSpec;
    @Column(name = "code")
    private String code;

    public specialite() {
        // Constructeur par défaut requis par JPA
    }

    public specialite(String libSpec, String code) {
        this.libSpec = libSpec;
        this.code = code;
    }

    public Integer getCodeSpec() {
        return codeSpec;
    }

    public void setCodeSpec(Integer codeSpec) {
        this.codeSpec = codeSpec;
    }

    public String getLibSpec() {
        return libSpec;
    }

    public void setLibSpec(String libSpec) {
        this.libSpec = libSpec;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "specialite{" +
                "codeSpec=" + codeSpec +
                ", libSpec='" + libSpec + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}