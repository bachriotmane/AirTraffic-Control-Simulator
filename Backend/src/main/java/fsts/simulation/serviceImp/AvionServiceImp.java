package fsts.simulation.serviceImp;

import fsts.simulation.dao.AvionRepo;
import fsts.simulation.entity.Avion;
import fsts.simulation.entity.Vol;
import fsts.simulation.service.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvionServiceImp implements AvionService {

    @Autowired
    private AvionRepo avionRepo;
    @Override
    public Avion findAvion(Long id) {
        Optional<Avion> optional = avionRepo.findById(id);
        if(optional.isEmpty()){
            throw new RuntimeException("L'avion " + id +" n'existe pas");
        }
        return optional.get();
    }

    @Override
    public List<Avion> findAllAvion() {
        return avionRepo.findAll();
    }

    @Override
    public List<Avion> findFreeAvion() {
        return avionRepo.getAvions();
    }


    @Override
    public void saveAvion(Avion avion) {
         avionRepo.save(avion);
    }


    @Override
    public void deleteAvion(Long id) {
        avionRepo.deleteById(id);
    }

    public List<Avion> getFreeAvions(Long idAeroport){
       return avionRepo.getFreeAvions(idAeroport);
    }

    @Override
    public void fly() {

    }

    @Override
    public void atterrir() {

    }

    @Override
    public void decoller() {

    }
}
