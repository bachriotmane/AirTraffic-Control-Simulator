package fsts.simulation.service;

import fsts.simulation.entity.Airoport;
import fsts.simulation.entity.Vol;

import java.util.List;

public interface VolService {
    public Vol findVol (Long id);
    public List<Vol> findAllVol();
    public void saveVol(Vol vol);
    public void deleteVol(Long id);
    public List<Airoport> dijkstraMethode(Airoport airoportDebut , Airoport airoportArrive);
    public void foundConfusion();

    public void startVol(List<Airoport> trajet);
}
