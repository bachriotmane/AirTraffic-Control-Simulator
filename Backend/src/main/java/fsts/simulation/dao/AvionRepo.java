package fsts.simulation.dao;

import fsts.simulation.entity.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AvionRepo extends JpaRepository<Avion,Long> {
    @Query("from Avion a where a.airoport IS NULL")
    public List<Avion> getAvions();

    @Query("from Avion a where a.airoport.idAeroport= :x and a.isFree = true")
    public List<Avion> getFreeAvions(@Param("x") Long idAeroport);

}
