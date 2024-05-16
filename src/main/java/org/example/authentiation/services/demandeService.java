package org.example.authentiation.services;

import jakarta.transaction.Transactional;
import org.example.authentiation.entities.demande_intervention;
import org.example.authentiation.exception.UtilisateurNotFoundException;
import org.example.authentiation.exception.demandeNotFoundException;
import org.springframework.stereotype.Service;
import org.example.authentiation.repositories.demandeRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class demandeService {
    private final demandeRepo demandeRepo;
    public demandeService(demandeRepo demandeRepo) {
        this.demandeRepo = demandeRepo;
    }
    private static long idCounter = 0;
    public demande_intervention addDemande(demande_intervention demandeIntervention) {
        long newNumDem = generateUniquenumDem();
        demandeIntervention.setNumDem(newNumDem);
        return demandeRepo.save(demandeIntervention);
    }

    private synchronized long generateUniquenumDem() {
        return ++idCounter;
    }
    public List<demande_intervention> findAllDemandes() {
        return demandeRepo.findAll();
    }

    public demande_intervention updateDemande(demande_intervention demande_intervention, Long numDem, String statut, String titre, String priorite, String dateDeb, String dateFin, String description) {
        Optional<demande_intervention> optionalDemande = demandeRepo.findDemandeBynumDem(numDem);
        demande_intervention myDemande = optionalDemande.orElseThrow(() -> new demandeNotFoundException("Client by id " + numDem + " was not found"));

        myDemande.setStatut(statut);
        myDemande.setTitre(titre);
        myDemande.setPriorite(priorite);
        myDemande.setDateFin(dateFin);
        myDemande.setDateDeb(dateDeb);
        myDemande.setDescription(description);

        return demandeRepo.save(myDemande);
    }


    public demande_intervention findDemandeBynumDem(Long numDem){
        return demandeRepo.findDemandeBynumDem(numDem)
                .orElseThrow(() -> new UtilisateurNotFoundException("Client by id " + numDem + " was not found"));
    }

    public void deleteDemande(Long numDem){
        demandeRepo.deleteDemandeBynumDem(numDem);
    }

    public List<demande_intervention> findDemandesByClientId(Long clientId) {
        return demandeRepo.findDemandesByClientId(clientId);
    }








}



