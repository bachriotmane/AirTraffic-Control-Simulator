package fsts.simulation.serviceImp;

import fsts.simulation.dao.ProblemRepo;
import fsts.simulation.entity.Avion;
import fsts.simulation.entity.Probleme;
import fsts.simulation.service.ProblemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProblemeServiceImp implements ProblemeService {

    @Autowired
    ProblemRepo problemRepo;
    @Override
    public Probleme findProbleme(Long id) {
        Optional<Probleme> optionalProbleme = problemRepo.findById(id);
        return optionalProbleme.orElse(null);
    }

    @Override
    public List<Probleme> findAllProbleme() {
        return problemRepo.findAll();
    }

    @Override
    public void saveProbleme(Probleme probleme) {
        problemRepo.save(probleme);
    }

    @Override
    public void deleteProbleme(Long id) {
        problemRepo.deleteById(id);
    }
}
