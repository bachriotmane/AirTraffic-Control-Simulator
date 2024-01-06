package fsts.simulation.serviceImp;

import fsts.simulation.dao.LocalisationRepo;
import fsts.simulation.entity.Localisation;
import fsts.simulation.service.LocalisationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LocalisationServiceImp implements LocalisationService {

    @Autowired
    LocalisationRepo localisationRepo;
    @Override
    public Localisation findLocalisation(Long id) {
        Optional<Localisation> optional = localisationRepo.findById(id);
        if(optional.isEmpty()){
            throw new RuntimeException("Localisation num " + id +"  not found");
        }
        return optional.get();
    }

    @Override
    public List<Localisation> findAllLocalisations() {
        return localisationRepo.findAll();
    }

    @Override
    public void saveLocalisation(Localisation localisation) {

        localisationRepo.save(localisation);
    }

    @Override
    public void deleteLocalisation(Long id) {
        localisationRepo.deleteById(id);
    }
}
