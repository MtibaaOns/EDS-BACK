package org.example.authentiation.services;


import jakarta.transaction.Transactional;
import org.example.authentiation.entities.Interventions;
import org.example.authentiation.entities.demande_intervention;
import org.example.authentiation.exception.InterventionsNotFoundException;
import org.example.authentiation.exception.contratNotFoundException;
import org.example.authentiation.repositories.InterventionsRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InterventionsService {
    private final InterventionsRepo interventionsRepo;

    public InterventionsService(InterventionsRepo interventionsRepo) {

        this.interventionsRepo = interventionsRepo;
    }

    public Interventions addIntervention(Interventions intervention) {
        return interventionsRepo.save(intervention);
    }

    public List<Interventions> findAllInterventions() {
        return interventionsRepo.findAll();
    }

    public Interventions updateIntervention(Interventions intervention, Long id, String cause, Boolean facturer, Double montantHT, Boolean cloturer, String dateDeb, String dateFin, String duree, String observation, String technicien,String client,String pieceRechange) {
        Optional<Interventions> optionalIntervention = interventionsRepo.findInterventionById(id);
        Interventions myIntervention = optionalIntervention.orElseThrow(() -> new InterventionsNotFoundException("Intervention by id " + id + " was not found"));

        myIntervention.setCause(cause);
        myIntervention.setFacturer(facturer);
        myIntervention.setMontantHT(montantHT);
        myIntervention.setCloturer(cloturer);
        myIntervention.setDateDeb(dateDeb);
        myIntervention.setDateFin(dateFin);
        myIntervention.setDuree(duree);
        myIntervention.setObservation(observation);
        myIntervention.setTechnicien(technicien);
        myIntervention.setClient(client);
        myIntervention.setPieceRechange(pieceRechange);

        return interventionsRepo.save(myIntervention);
    }


    public Interventions findInterventionById(Long id){
        return interventionsRepo.findInterventionById(id)
                .orElseThrow(() -> new contratNotFoundException("Contrat by Numcontart " + id + " was not found"));
    }




    public void deleteIntervention(Long id) {
        interventionsRepo.deleteInterventionById(id);
    }

    public List<Interventions> getInterventionsByTechnician(String technician) {
        return interventionsRepo.findInterventionsByTechnicien(technician);
    }

}