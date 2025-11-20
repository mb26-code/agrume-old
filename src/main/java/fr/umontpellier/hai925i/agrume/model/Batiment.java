package fr.umontpellier.hai925i.agrume.model;

import jakarta.persistence.*;


@Entity
public class Batiment {
    @Id
    private String id;

    private int annee;

    @ManyToOne
    @JoinColumn(name="campus")
    private Campus campus;


    public Batiment() {}

    public Batiment(String id, int annee, Campus campus) {
        super();
        this.id = id;
        this.annee = annee;
        this.campus = campus;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }


    @Override
    public String toString() {
        return "Batiment { id: " + id + ", annee: " + annee + " }";
    }

}
