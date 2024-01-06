package fsts.simulation.service;

import fsts.simulation.entity.Airoport;
import fsts.simulation.entity.Distance;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Set;

@Transactional
public interface AeroportService {
    public Airoport findAiroport (Long id);
    public List<Airoport> findAllAirports();
    public void saveAiroport(Airoport airoport);
    public Airoport updateAiroport(Airoport airoport);
    public void deleteAiroport(Long id);
}
