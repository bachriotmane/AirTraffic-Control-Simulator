package fsts.simulation.dao;

import fsts.simulation.entity.Probleme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepo extends JpaRepository<Probleme,Long> {
}
