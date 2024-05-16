package org.example.authentiation.services;


import org.example.authentiation.entities.Cause;
import org.example.authentiation.exception.CauseNotFoundExeption;
import org.example.authentiation.repositories.CauseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CauseService {
    private final CauseRepo causeRepo;
    private static long idCounter = 0;

    @Autowired
    public CauseService(CauseRepo causeRepo) {
        this.causeRepo = causeRepo;
    }

    /**
     * Ajoute une nouvelle cause
     */
    public Cause addCause(Cause cause) {
        long newId = generateUniqueId();
        cause.setId(newId);
        return causeRepo.save(cause);
    }

    /**
     * Génère un identifiant unique pour une nouvelle cause
     */
    private synchronized long generateUniqueId() {
        return ++idCounter;
    }

    /**
     * Récupère toutes les causes
     */
    public List<Cause> findAllCauses() {
        return causeRepo.findAll();
    }

    /**
     * Met à jour une cause existante
     */
    public Cause updateCause(Cause cause, Long id, String libCause) {
        Optional<Cause> optionalCause = causeRepo.findCauseById(id);
        Cause myCause = optionalCause.orElseThrow(() -> new CauseNotFoundExeption("Cause by id " + id + " was not found"));
        myCause.setLibCause(libCause);
        return causeRepo.save(myCause);
    }

    /**
     * Récupère une cause par son identifiant
     */
    public Cause findCauseById(Long id) {
        return causeRepo.findCauseById(id)
                .orElseThrow(() -> new CauseNotFoundExeption("Cause by id " + id + " was not found"));
    }

    /**
     * Supprime une cause par son identifiant
     */
    public void deleteCause(Long id) {
        causeRepo.deleteCauseById(id);
    }
}