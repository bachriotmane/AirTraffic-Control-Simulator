package fsts.simulation.service;

import fsts.simulation.entity.Airoport;
import fsts.simulation.entity.Avion;
import fsts.simulation.entity.Distance;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public interface DistanceService {
    public Distance findDistance (Long id_airoportCurrent , Long id_airoportAutre);
    public List<Distance> distances();
    public void save(Distance distance);
    public void deleteDistance(Long id);
    public double calculateDistance(Airoport a1, Airoport a2);
}
