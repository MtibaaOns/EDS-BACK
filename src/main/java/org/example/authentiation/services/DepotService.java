package org.example.authentiation.services;


import org.example.authentiation.entities.Depot;
import org.example.authentiation.exception.DepotNotFoundException;
import org.example.authentiation.repositories.DepotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepotService {
    private final DepotRepo depotRepo;
    private static long idCounter = 0;

    @Autowired
    public DepotService(DepotRepo depotRepo) {
        this.depotRepo = depotRepo;
    }

    /**
     * Ajoute un nouveau dépôt
     */
    public Depot addDepot(Depot depot) {
        long newId = generateUniqueId();
        depot.setId(newId);
        return depotRepo.save(depot);
    }

    /**
     * Génère un identifiant unique pour un nouveau dépôt
     */
    private synchronized long generateUniqueId() {
        return ++idCounter;
    }

    /**
     * Récupère tous les dépôts
     */
    public List<Depot> findAllDepots() {
        return depotRepo.findAll();
    }

    /**
     * Met à jour un dépôt existant
     */
    public Depot updateDepot(Depot depot, Long id, String libDep) {
        Optional<Depot> optionalDepot = depotRepo.findDepotById(id);
        Depot myDepot = optionalDepot.orElseThrow(() -> new DepotNotFoundException("Depot by id " + id + " was not found"));
        myDepot.setLibDep(libDep);
        return depotRepo.save(myDepot);
    }

    /**
     * Récupère un dépôt par son identifiant
     */
    public Depot findDepotById(Long id) {
        return depotRepo.findDepotById(id)
                .orElseThrow(() -> new DepotNotFoundException("Depot by id " + id + " was not found"));
    }

    /**
     * Supprime un dépôt par son identifiant
     */
    public void deleteDepot(Long id) {
        depotRepo.deleteDepotById(id);
    }

}