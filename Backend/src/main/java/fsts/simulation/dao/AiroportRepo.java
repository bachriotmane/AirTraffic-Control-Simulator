package fsts.simulation.dao;

import fsts.simulation.entity.Airoport;
import fsts.simulation.entity.Distance;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(path = "airoports")
public interface AiroportRepo extends JpaRepository<Airoport,Long> {
}
