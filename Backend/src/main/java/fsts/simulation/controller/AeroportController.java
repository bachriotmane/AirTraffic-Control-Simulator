package fsts.simulation.controller;

import fsts.simulation.entity.Airoport;
import fsts.simulation.service.AeroportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AeroportController {

    @Autowired
    private AeroportService airportService;

    @GetMapping
    public List<Airoport> getAllAirports() {
        List<Airoport> airports = airportService.findAllAirports();
        return airports;
    }

    // Get airport by ID
    @GetMapping("/{id}")
    public Airoport getAirportById(@PathVariable Long id) {
        Airoport airport = airportService.findAiroport(id);
        return airport;
    }

    // Create a new airport
    @PostMapping
    public String createAirport(@RequestBody Airoport airport) {
        airportService.saveAiroport(airport);
        return "Aeroport created succfully";
    }

    @PutMapping("/{id}")
    public String updateAirport(@PathVariable Long id, @RequestBody Airoport updatedAirport) {
        Airoport airport = airportService.findAiroport(id);
        updatedAirport.setIdAeroport(id);
        airportService.saveAiroport(updatedAirport);
        return "Update succefully";
    }

    @DeleteMapping("/{id}")
    public String deleteAirport(@PathVariable Long id) {
        Airoport airport = airportService.findAiroport(id);

        airportService.deleteAiroport(id);
        return "delet succefully";

    }
}

