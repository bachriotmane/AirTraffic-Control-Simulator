package fsts.simulation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Airoport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAeroport;
    private boolean isWorking;
    @Column(name = "nom")
    private String nom;
    @Column(name = "nbr_piste")
    private int nbrPiste;
    @Column(name = "nbr_place_sol")
    private int nbrPlaceSol;
    @Column(name = "temps_access_pist")
    private int tempsAccessPiste;
    @Column(name = "delai_anti_collition")
    private int delaiAntCollision;
    @Column(name = "temps_decolage")
    private int tempsDecolage;
    @Column(name = "durre_boucle_dattent")
    private int durreeBoucleDattent;
    @Column(name = "delai_au_sol")
    private int delaiAuSol;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_localisation", unique = true)
    private Localisation localisation;

    @JsonIgnore
    @OneToMany(mappedBy = "airoport")
    List<Avion> avions;

    public Airoport(){}

    public Airoport(String nom, int nbrPiste, int nbrPlaceSol, int tempsAccessPiste, int delaiAntCollision, int tempsDecolage,
                    int durreeBoucleDattent, int delaiAuSol, Localisation localisation,boolean isWorking,List<Avion> avions) {
        this.nom = nom;
        this.nbrPiste = nbrPiste;
        this.nbrPlaceSol = nbrPlaceSol;
        this.tempsAccessPiste = tempsAccessPiste;
        this.delaiAntCollision = delaiAntCollision;
        this.tempsDecolage = tempsDecolage;
        this.durreeBoucleDattent = durreeBoucleDattent;
        this.delaiAuSol = delaiAuSol;
        this.isWorking = isWorking;
        this.localisation = localisation;
        this.avions = avions;
    }

    public long getIdAeroport() {
        return idAeroport;
    }

    public void setIdAeroport(long idAeroport) {
        this.idAeroport = idAeroport;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbrPiste() {
        return nbrPiste;
    }

    public void setNbrPiste(int nbrPiste) {
        this.nbrPiste = nbrPiste;
    }

    public int getNbrPlaceSol() {
        return nbrPlaceSol;
    }

    public void setNbrPlaceSol(int nbrPlaceSol) {
        this.nbrPlaceSol = nbrPlaceSol;
    }

    public int getTempsAccessPiste() {
        return tempsAccessPiste;
    }

    public void setTempsAccessPiste(int tempsAccessPiste) {
        this.tempsAccessPiste = tempsAccessPiste;
    }

    public int getDelaiAntCollision() {
        return delaiAntCollision;
    }

    public void setDelaiAntCollision(int delaiAntCollision) {
        this.delaiAntCollision = delaiAntCollision;
    }

    public int getTempsDecolage() {
        return tempsDecolage;
    }

    public void setTempsDecolage(int tempsDecolage) {
        this.tempsDecolage = tempsDecolage;
    }

    public int getDurreeBoucleDattent() {
        return durreeBoucleDattent;
    }

    public void setDurreeBoucleDattent(int durreeBoucleDattent) {
        this.durreeBoucleDattent = durreeBoucleDattent;
    }

    public int getDelaiAuSol() {
        return delaiAuSol;
    }

    public void setDelaiAuSol(int delaiAuSol) {
        this.delaiAuSol = delaiAuSol;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    public void setIdAeroport(Long idAeroport) {
        this.idAeroport = idAeroport;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    @Override
    public String toString() {
        return "Airoport{" +
                "idAeroport=" + idAeroport +
                ", isWorking=" + isWorking +
                ", nom='" + nom + '\'' +
                ", nbrPiste=" + nbrPiste +
                ", nbrPlaceSol=" + nbrPlaceSol +
                ", tempsAccessPiste=" + tempsAccessPiste +
                ", delaiAntCollision=" + delaiAntCollision +
                ", tempsDecolage=" + tempsDecolage +
                ", durreeBoucleDattent=" + durreeBoucleDattent +
                ", delaiAuSol=" + delaiAuSol +
                ", localisation=" + localisation +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airoport airoport = (Airoport) o;
        return Objects.equals(idAeroport, airoport.idAeroport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAeroport);
    }

    public List<Avion> getAvions() {
        return avions;
    }

    public void setAvions(List<Avion> avions) {
        this.avions = avions;
    }
}
