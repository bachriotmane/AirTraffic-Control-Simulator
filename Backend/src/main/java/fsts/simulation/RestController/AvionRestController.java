package fsts.simulation.RestController;

import fsts.simulation.entity.Airoport;
import fsts.simulation.entity.Avion;
import fsts.simulation.service.AeroportService;
import fsts.simulation.service.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://127.0.0.1:5501")
@RestController
@RequestMapping("/avion")
public class AvionRestController {
    @Autowired
    private AvionService avionService;

    @GetMapping
    public List<Avion> getAllAvions() {
        List<Avion> avionss = avionService.findAllAvion();
        return avionss;
    }
    @GetMapping("/{id}")
    public Avion getAvionById(@PathVariable Long id) {
        Avion avion = avionService.findAvion(id);
        return avion;
    }
    @GetMapping("/Avionsfree/{id}")
    public List<Avion> getFreeAvionById(@PathVariable Long id){
        return avionService.getFreeAvions(id);
    }
    @PostMapping
    public String createAvion(@RequestBody Avion avion) {
        avionService.saveAvion(avion);
        return "Avion created successfully";
    }

    @GetMapping("/freeAvion")
    public List<Avion> freeAvions() {
        return avionService.findFreeAvion();
    }

    @PutMapping("/{id}")
    public String updateAvion(@PathVariable Long id, @RequestBody Avion updatedAvion) {
        Avion avion = avionService.findAvion(id);
        updatedAvion.setId_avoin(id);
        avionService.saveAvion(updatedAvion);
        return "Update succefully";
    }

    @DeleteMapping("/{id}")
    public String deleteAvion(@PathVariable Long id) {
        Avion avion = avionService.findAvion(id);

        avionService.deleteAvion(id);
        return "delet succefully";
    }
}
