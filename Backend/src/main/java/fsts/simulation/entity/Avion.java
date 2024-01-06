package fsts.simulation.entity;

import jakarta.persistence.*;

@Entity
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_avoin;
    private boolean isFree;
    private double consomation;
    private double capaciteCarburant;
    private TypeAvion typeAvion;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_localisation")
    private Localisation localisation;
    @ManyToOne
    @JoinColumn(name = "aeroprt_id")
    private Airoport airoport;


    public Avion(){}

    public Avion(double consomation, double capaciteCarburant, TypeAvion typeAvion, Localisation localisation ,boolean isFree) {
        this.consomation = consomation;
        this.capaciteCarburant = capaciteCarburant;
        this.typeAvion = typeAvion;
        this.localisation = localisation;
        this.isFree = true;
    }

    public void setAiroport(Airoport airoport) {
        this.airoport = airoport;
    }

    public Airoport getAiroport() {
        return airoport;
    }

    public long getId_avoin() {
        return id_avoin;
    }

    public void setId_avoin(Long id_avoin) {
        this.id_avoin = id_avoin;
    }

    public double getConsomation() {
        return consomation;
    }

    public void setConsomation(double consomation) {
        this.consomation = consomation;
    }

    public double getCapaciteCarburant() {
        return capaciteCarburant;
    }

    public void setCapaciteCarburant(double capaciteCarburant) {
        this.capaciteCarburant = capaciteCarburant;
    }

    public TypeAvion getTypeAvion() {
        return typeAvion;
    }

    public void setTypeAvion(TypeAvion typeAvion) {
        this.typeAvion = typeAvion;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean flying) {
        isFree = flying;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "id_avoin=" + id_avoin +
                ", isFlying=" + isFree +
                ", consomation=" + consomation +
                ", capaciteCarburant=" + capaciteCarburant +
                ", typeAvion=" + typeAvion +
                ", localisation=" + localisation +
                '}';
    }
}
