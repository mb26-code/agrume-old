package fr.umontpellier.hai925i.agrume.model;

import jakarta.persistence.*;

@Entity
public class Batiment {
    @Id
    private String codeB;

    private int anneeC;

    @ManyToOne
    @JoinColumn(name="campus")
    private Campus campus;


    public Batiment() {}

    public Batiment(String codeB, int anneeC, Campus campus) {
        super();
        this.codeB = codeB;
        this.anneeC = anneeC;
        this.campus = campus;
    }

    public String getCodeB() {
        return codeB;
    }

    public void setCodeB(String codeB) {
        this.codeB = codeB;
    }

    public int getAnneeC() {
        return anneeC;
    }

    public void setAnneeC(int anneeC) {
        this.anneeC = anneeC;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    @Override
    public String toString() {
        return "Batiment [codeB=" + codeB  + ", anneeC=" + anneeC + "]";
    }

}
