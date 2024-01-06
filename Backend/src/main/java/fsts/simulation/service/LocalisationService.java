package fsts.simulation.service;

import fsts.simulation.entity.Localisation;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface LocalisationService {
    public Localisation findLocalisation (Long id);
    public List<Localisation> findAllLocalisations();
    public void saveLocalisation(Localisation localisation);
    public void deleteLocalisation(Long id);
}
