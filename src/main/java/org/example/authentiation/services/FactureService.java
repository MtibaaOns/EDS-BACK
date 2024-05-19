package org.example.authentiation.services;


import jakarta.transaction.Transactional;
import org.example.authentiation.entities.Facture;
import org.example.authentiation.entities.Interventions;
import org.example.authentiation.exception.FactureNotFoundException;
import org.example.authentiation.repositories.FactureRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FactureService {
    private final FactureRepo factureRepo;

    public FactureService(FactureRepo factureRepo) {
        this.factureRepo = factureRepo;
    }

    public Facture addFacture(Facture facture) {
        return factureRepo.save(facture);
    }

    public List<Facture> findAllFactures() {
        return factureRepo.findAll();
    }

    public Facture updateFacture(Facture facture, Long id, String date, String client, Double totalHT,Double totalTTC, Integer tva) {
        Optional<Facture> optionalFacture = factureRepo.findFactureById(id);
        Facture myFacture = optionalFacture.orElseThrow(() -> new FactureNotFoundException("Facture by id " + id + " was not found"));

        myFacture.setDate(date);
        myFacture.setClient(client);
        myFacture.setTotalHT(totalHT);
        myFacture.setTotalTTC(totalTTC);
        myFacture.setTva(tva);


        return factureRepo.save(myFacture);
    }

    public Facture findFactureById(Long id){
        return factureRepo.findFactureById(id)
                .orElseThrow(() -> new FactureNotFoundException("Facture by id " + id + " was not found"));
    }

    public void deleteFacture(Long id) {
        factureRepo.deleteFactureById(id);
    }

    public List<Facture> getFactureByClient(String client) {
        return factureRepo.findFactureByClient(client);    }

    public List<Facture> getFacturesForToday() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String todayFormatted = today.format(formatter);
        System.out.println(todayFormatted);
        return factureRepo.findFacturesByFormattedDateCreation(todayFormatted);
    }

}