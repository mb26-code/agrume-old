package fr.umontpellier.hai925i.agrume.model;

import jakarta.persistence.*;


@Entity
public class Salle {

    @Id
    private String numero;

    private int capacite;

    @Column(name = "type_")
    private String type;

    private String acces;

    private String etage;


    @ManyToOne
    @JoinColumn(name = "batiment")
    private Batiment batiment;


    public Salle() {
    }

    public Salle(String numero, int capacite, String type, String acces, String etage, Batiment batiment) {
        super();
        this.numero = numero;
        this.capacite = capacite;
        this.type = type;
        this.acces = acces;
        this.etage = etage;
        this.batiment = batiment;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAcces() {
        return acces;
    }

    public void setAcces(String acces) {
        this.acces = acces;
    }

    public String getEtage() {
        return etage;
    }

    public void setEtage(String etage) {
        this.etage = etage;
    }

    public Batiment getBatiment() {
        return batiment;
    }

    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }


    @Override
    public String toString() {
        return "Salle { numero: " + numero + ", capacite: " + capacite + ", type: " + type + " }";
    }
}