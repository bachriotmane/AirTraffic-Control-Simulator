package fsts.simulation.serviceImp;

import fsts.simulation.dao.AiroportRepo;
import fsts.simulation.dao.DistanceRepo;
import fsts.simulation.entity.Airoport;
import fsts.simulation.entity.Avion;
import fsts.simulation.entity.Distance;
import fsts.simulation.entity.Localisation;
import fsts.simulation.service.AeroportService;
import fsts.simulation.service.DistanceService;
import fsts.simulation.service.LocalisationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AeroprtServiceImp implements AeroportService {
    @Autowired
    AiroportRepo airoportRepo;
    @Autowired
    DistanceRepo distanceRepo;

    @Autowired
    DistanceService distanceService;

    @Autowired
    LocalisationService localisationService;

    @Override
    public Airoport findAiroport(Long id) {

        Optional<Airoport> optional = airoportRepo.findById(id);
        if(optional.isEmpty()){
            throw new RuntimeException("L'airoprt " + id +" n'existe pas");
        }
        return optional.get();
    }

    @Override
    public List<Airoport> findAllAirports() {
        return airoportRepo.findAll();
    }

    @Override
    public void saveAiroport(Airoport airoport) {
        List<Airoport> airoprts = findAllAirports();

        // Save the new airport
        airoportRepo.save(airoport);

        if (!airoprts.isEmpty()) {
            airoprts.forEach(e -> {
                double dist = distanceService.calculateDistance(e, airoport);

                // Save the distance from e to airoport
                Distance distance1 = new Distance(dist, e, airoport);
                distanceRepo.save(distance1);

                // Save the distance from airoport to e (bidirectional)
                Distance distance2 = new Distance(dist, airoport, e);
                distanceRepo.save(distance2);
            });
        }
    }


    @Override
    public Airoport updateAiroport(Airoport airoport) {
        return airoportRepo.save(airoport);
    }

    @Override
    public void deleteAiroport(Long id) {
         airoportRepo.deleteById(id);
    }
}
