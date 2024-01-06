package fsts.simulation.RestController;

import fsts.simulation.entity.Airoport;
import fsts.simulation.entity.Avion;
import fsts.simulation.entity.Vol;
import fsts.simulation.service.AvionService;
import fsts.simulation.service.VolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/vol")
public class VolRestController {
    @Autowired
    private VolService volService;

    @GetMapping
    public List<Vol> getAllVols() {
        volService.foundConfusion();
        List<Vol> vols = volService.findAllVol();
        return vols;
    }
    @GetMapping("/{id}")
    public Vol getVolById(@PathVariable Long id) {
        Vol vol = volService.findVol(id);
        return vol;
    }

    @PostMapping("/Dijkstra")
    public List<Airoport> getDijkstraChemin(@RequestBody Vol currentVol) {
        Airoport currentAeroprt= currentVol.getAeroportDebut();
        Airoport FutureAeroprt= currentVol.getAeroportArrive();
        return  volService.dijkstraMethode(currentAeroprt,FutureAeroprt);

    }
    @PostMapping
    public String createVol(@RequestBody Vol vol) {
        volService.saveVol(vol);
        return "Vol created succfully";
    }

    @PutMapping("/{id}")
    public String updateVol(@PathVariable Long id, @RequestBody Vol updatedVole) {
        Vol vol = volService.findVol(id);
        updatedVole.setId_vol(id);
        volService.saveVol(updatedVole);
        return "Vol Update succefully";
    }

    @DeleteMapping("/{id}")
    public String deleteVol(@PathVariable Long id) {
        Vol vol = volService.findVol(id);

        volService.deleteVol(id);
        return "delet succefully";
    }
}
