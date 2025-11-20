package fr.umontpellier.hai925i.agrume.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Campus {

    @Id
    private String nom;

    private String ville;


    @OneToMany(fetch = FetchType.LAZY, mappedBy="campus", cascade = CascadeType.REMOVE)
    private List<Batiment> batiments = new ArrayList<Batiment>();


    public Campus() {
    }

    public Campus(String nom, String ville) {
        super();
        this.nom = nom;
        this.ville = ville;

        this.batiments = new ArrayList<Batiment>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) { this.nom = nom; }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }


    public List<Batiment> getBatiments() {
        return batiments;
    }

    public void setBatiments(List<Batiment> batiments) {
        this.batiments = batiments;
    }


    @Override
    public String toString() {
        return "Campus { nom: " + nom + ", ville: " + ville + " }";
    }

}
