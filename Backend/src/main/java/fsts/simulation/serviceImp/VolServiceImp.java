package fsts.simulation.serviceImp;

import fsts.simulation.dao.AvionRepo;
import fsts.simulation.dao.VolRepo;
import fsts.simulation.entity.Airoport;
import fsts.simulation.entity.Avion;
import fsts.simulation.entity.Distance;
import fsts.simulation.entity.Vol;
import fsts.simulation.service.AeroportService;
import fsts.simulation.service.DistanceService;
import fsts.simulation.service.VolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VolServiceImp implements VolService {
    @Autowired
    VolRepo volRepo;
    @Autowired
    AvionRepo avionRepo;

    @Autowired
    AeroportService aeroportService;

    @Autowired
    DistanceService distanceService;
    @Override
    public Vol findVol(Long id) {
        Optional<Vol> optional = volRepo.findById(id);
        if(optional.isEmpty()){
            throw new RuntimeException("Le vol" + id +" n'existe pas");
        }
        return optional.get();
    }

    @Override
    public List<Vol> findAllVol() {
        return volRepo.findAll();
    }

    @Override
    public void saveVol(Vol vol) {
        Avion v=vol.getAvion();
        v.setFree(false);
        avionRepo.save(v);
        vol.setAvion(v);
        volRepo.save(vol);
    }

    @Override
    public void deleteVol(Long id) {
        volRepo.deleteById(id);
    }

    public Map<Airoport, List<Distance>> getGraph(List<Airoport> airports, List<Distance> distances) {
        Map<Airoport, List<Distance>> adjacencyList = new HashMap<>();
        for (Airoport airport : airports) {
            adjacencyList.put(airport, new ArrayList<>());

        }

        for (Distance distance : distances){
            adjacencyList.get(distance.getCurrentAerport()).add(distance);
        }
        return adjacencyList;
    }

    @Override
    public List<Airoport> dijkstraMethode(Airoport airoportDebut, Airoport airoportArrive) {
        Map<Airoport, Double> distanceMap = new HashMap<>();
        Map<Airoport, Airoport> predecessorMap = new HashMap<>();
        PriorityQueue<Airoport> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distanceMap::get));
        Map<Airoport, List<Distance>> adjacencyList = getGraph(aeroportService.findAllAirports(), distanceService.distances());

        System.out.println("Adjacency List:");
        for (Map.Entry<Airoport, List<Distance>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        if ( adjacencyList == null ) {
            throw new RuntimeException("Adjacency list is null");
        }

        // Initialize distances
        for (Airoport airport : adjacencyList.keySet()) {
            distanceMap.put(airport, Double.MAX_VALUE);
        }
        distanceMap.put(airoportDebut, 0.0);

        priorityQueue.offer(airoportDebut);

        while (!priorityQueue.isEmpty()) {
            Airoport currentAirport = priorityQueue.poll();

            for (Distance distance : adjacencyList.getOrDefault(currentAirport, Collections.emptyList())) {
                Airoport neighbor = distance.getToAerport();
                double newDistance = distanceMap.get(currentAirport) + distance.getDistance();

                if (newDistance < distanceMap.get(neighbor)) {
                    distanceMap.put(neighbor, newDistance);
                    predecessorMap.put(neighbor, currentAirport);
                    priorityQueue.offer(neighbor);
                }
            }
        }

        // If there is no path to airoportArrive, return a list with only airoportDebut
        if (!predecessorMap.containsKey(airoportArrive)) {
            System.out.println("No direct path found from " + airoportDebut + " to " + airoportArrive + ".");

            return Collections.singletonList(airoportDebut);
        }

        // Reconstruct the shortest path
        List<Airoport> shortestPath = new ArrayList<>();
        Airoport current = airoportArrive;

        while (current != null) {
            shortestPath.add(current);
            current = predecessorMap.get(current);
        }
        Collections.reverse(shortestPath);

        return shortestPath;
    }

    @Override
    public void foundConfusion() {
        List<Vol> vols = volRepo.findAll();

        for (int i = 0; i < vols.size(); i++) {
            Vol vol1 = vols.get(i);

            for (int j = i + 1; j < vols.size(); j++) {
                Vol vol2 = vols.get(j);

                if (vol1.getAeroportArrive().equals(vol2.getAeroportArrive()) &&
                        Math.abs(vol1.getDateArrive().getTime() - vol2.getDateArrive().getTime()) <= 3000) {
                    if(vol1.getDateArrive().getTime() < vol2.getDateArrive().getTime()){
                        vol1.setConfusion(true);
                        volRepo.save(vol1);
                    }else {
                        vol2.setConfusion(true);
                        volRepo.save(vol2);
                    }


                }
            }
        }
    }



    @Override
    public void startVol(List<Airoport> trajet) {

    }
}
