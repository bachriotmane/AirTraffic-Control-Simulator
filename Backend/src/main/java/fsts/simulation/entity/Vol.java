package fsts.simulation.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Vol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vol;
    @ManyToOne
    @JoinColumn(name = "id_aero_debut")
    private Airoport aeroportDebut;
    @ManyToOne
    @JoinColumn(name = "id_aero_arrive")
    private Airoport aeroportArrive;
    private Date dateDepart;
    private Date dateArrive;

    private boolean confusion=false;

    public boolean isConfusion() {
        return confusion;
    }

    public void setConfusion(boolean confusion) {
        this.confusion = confusion;
    }

    @ManyToOne
    @JoinColumn(name = "id_avoin")
    private Avion avion;

    @ManyToMany(mappedBy = "vols")
    private List<Probleme> problemes;


    public Vol(){}

    public Vol(Airoport aeroportDebut, Airoport aeroportArrive, Date heurDepart, Date dateArrive, Avion avion) {
        this.aeroportDebut = aeroportDebut;
        this.aeroportArrive = aeroportArrive;
        this.dateDepart = heurDepart;
        this.dateArrive = dateArrive;
        this.avion = avion;
    }

    public Long getId_vol() {
        return id_vol;
    }

    public void setId_vol(Long id_vol) {
        this.id_vol = id_vol;
    }

    public Airoport getAeroportDebut() {
        return aeroportDebut;
    }

    public void setAeroportDebut(Airoport aeroportDebut) {
        this.aeroportDebut = aeroportDebut;
    }

    public Airoport getAeroportArrive() {
        return aeroportArrive;
    }

    public void setAeroportArrive(Airoport aeroportArrive) {
        this.aeroportArrive = aeroportArrive;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(Date dateArrive) {
        this.dateArrive = dateArrive;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public List<Probleme> getProblemes() {
        return problemes;
    }

    public void setProblemes(List<Probleme> problemes) {
        this.problemes = problemes;
    }

}

