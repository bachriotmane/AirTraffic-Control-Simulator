package fsts.simulation.dao;

import fsts.simulation.entity.Localisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface LocalisationRepo extends JpaRepository<Localisation,Long> {

}
