package fr.umontpellier.hai925i.agrume.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Composante {

    @Id
    private String acronyme;

    private String nom;

    private String responsable;


    @ManyToMany
    @JoinTable(
            name = "exploite",
            joinColumns = @JoinColumn(name = "composante"),
            inverseJoinColumns = @JoinColumn(name = "batiment")
    )
    private List<Batiment> batiments = new ArrayList<Batiment>();


    public Composante() {
    }

    public Composante(String acronyme, String nom, String responsable) {
        super();
        this.acronyme = acronyme;
        this.nom = nom;
        this.responsable = responsable;
        this.batiments = new ArrayList<Batiment>();
    }

    public String getAcronyme() {
        return acronyme;
    }

    public void setAcronyme(String acronyme) {
        this.acronyme = acronyme;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public List<Batiment> getBatiments() {
        return batiments;
    }

    public void setBatiments(List<Batiment> batiments) {
        this.batiments = batiments;
    }


    @Override
    public String toString() {
        return "Composante { acronyme: " + acronyme + ", nom: " + nom + " }";
    }
}