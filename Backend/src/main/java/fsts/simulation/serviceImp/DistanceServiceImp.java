package fsts.simulation.serviceImp;

import fsts.simulation.dao.DistanceRepo;
import fsts.simulation.entity.Airoport;
import fsts.simulation.entity.Distance;
import fsts.simulation.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistanceServiceImp implements DistanceService {
    @Autowired
    DistanceRepo distanceRepo;

    @Override
    public Distance findDistance(Long id_airoportCurrent, Long id_airoportAutre) {
        return distanceRepo.findByCurrentAerportIdAndToAerportId(id_airoportCurrent,id_airoportAutre).get();
    }

    @Override
    public List<Distance> distances() {
        return distanceRepo.findAll();
    }

    @Override
    public void save(Distance distance) {
        distanceRepo.save(distance);
    }

    @Override
    public void deleteDistance(Long id) {
        distanceRepo.deleteById(id);
    }

    @Override
    public double calculateDistance(Airoport a1, Airoport a2) {
        int x1,x2,y1,y2;
        x1=a1.getLocalisation().getX();
        x2=a2.getLocalisation().getX();
        y1=a1.getLocalisation().getY();
        y2=a2.getLocalisation().getY();

        return Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
    }
}
