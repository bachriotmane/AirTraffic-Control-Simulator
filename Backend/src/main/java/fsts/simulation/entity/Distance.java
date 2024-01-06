package fsts.simulation.entity;

import jakarta.persistence.*;

@Entity
public class Distance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double distance;
    @ManyToOne
    @JoinColumn(name = "current_airport_id")
    private Airoport currentAerport;

    @ManyToOne
    @JoinColumn(name = "to_airport_id")
    private Airoport toAerport;

    public Distance(){}
    public Distance(Double distance, Airoport currentAerport, Airoport toAerport) {
        this.distance = distance;
        this.currentAerport = currentAerport;
        this.toAerport = toAerport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Airoport getCurrentAerport() {
        return currentAerport;
    }

    public void setCurrentAerport(Airoport currentAerport) {
        this.currentAerport = currentAerport;
    }

    public Airoport getToAerport() {
        return toAerport;
    }

    public void setToAerport(Airoport toAerport) {
        this.toAerport = toAerport;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "id=" + id +
                ", distance=" + distance +
                ", currentAerport=" + currentAerport +
                ", toAerport=" + toAerport +
                '}';
    }
}
