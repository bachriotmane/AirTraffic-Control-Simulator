package fsts.simulation.dao;

import fsts.simulation.entity.Distance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;
public interface DistanceRepo extends JpaRepository<Distance,Long> {
    @Query("SELECT d FROM Distance d WHERE (d.currentAerport.idAeroport = :id1 and d.toAerport.idAeroport = :id2) OR (d.currentAerport.idAeroport = :id2 and d.toAerport.idAeroport = :id1) ")
    Optional<Distance> findByCurrentAerportIdAndToAerportId(@Param("id1") Long id1, @Param("id2") Long id2);

}
