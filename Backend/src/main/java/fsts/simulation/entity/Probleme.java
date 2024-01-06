package fsts.simulation.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Probleme{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_probleme;
    private TypeProblem typeProblem;
    private String description;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "vol_problem",
            joinColumns = @JoinColumn(name="id_problem"),
            inverseJoinColumns = @JoinColumn(name="id_vol")
    )
    private List<Vol> vols;

    public Probleme(){}

    public Probleme(TypeProblem typeProblem, String description, List<Vol> vols) {
        this.typeProblem = typeProblem;
        this.description = description;
        this.vols = vols;
    }

    public Long getId_probleme() {
        return id_probleme;
    }

    public void setId_probleme(Long id_probleme) {
        this.id_probleme = id_probleme;
    }

    public TypeProblem getTypeProblem() {
        return typeProblem;
    }

    public void setTypeProblem(TypeProblem typeProblem) {
        this.typeProblem = typeProblem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Vol> getVols() {
        return vols;
    }

    public void setVols(List<Vol> vols) {
        this.vols = vols;
    }
}
