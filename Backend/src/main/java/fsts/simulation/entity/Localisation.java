package fsts.simulation.entity;

import jakarta.persistence.*;

@Entity
public class Localisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_loca;
    private int x;
    private int y;
    private int z;

    public Localisation(){}

    public Localisation(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public long getId_loca() {
        return id_loca;
    }

    public void setId_loca(Long id_loca) {
        this.id_loca = id_loca;
    }
}
