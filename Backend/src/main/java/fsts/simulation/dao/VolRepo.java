package fsts.simulation.dao;

import fsts.simulation.entity.Vol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface VolRepo extends JpaRepository<Vol,Long> {

}
