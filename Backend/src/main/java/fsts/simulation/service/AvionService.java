package fsts.simulation.service;

import fsts.simulation.entity.Airoport;
import fsts.simulation.entity.Avion;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Transactional
public interface AvionService {
    public Avion findAvion (Long id);
    public List<Avion> findAllAvion();
    public List<Avion> findFreeAvion();
    public void saveAvion(Avion avion);
    public void deleteAvion(Long id);
    public void fly();
    public void atterrir();
    public void decoller();
    List<Avion> getFreeAvions(Long idAeroport);
}
