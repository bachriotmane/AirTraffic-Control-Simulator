package fsts.simulation.service;

import fsts.simulation.entity.Localisation;
import fsts.simulation.entity.Probleme;

import java.util.List;

public interface ProblemeService {
    public Probleme findProbleme (Long id);
    public List<Probleme> findAllProbleme();
    public void saveProbleme( Probleme probleme);
    public void deleteProbleme(Long id);
}
