package org.example.authentiation.controllers;


import org.example.authentiation.entities.Facture;
import org.example.authentiation.entities.Interventions;
import org.example.authentiation.services.FactureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Factures")
public class FactureResouce {
    private final FactureService factureService;

    public FactureResouce(FactureService factureService) {
        this.factureService = factureService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Facture>> getAllFactures() {
        List<Facture> factures = factureService.findAllFactures();
        return new ResponseEntity<>(factures, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Facture> getFactureById(@PathVariable("id") Long id) {
        Facture facture = factureService.findFactureById(id);
        return new ResponseEntity<>(facture, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Facture> addFacture(@RequestBody Facture facture) {
        Facture newFacture = factureService.addFacture(facture);
        return new ResponseEntity<>(newFacture, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Facture> updateFacture(@RequestBody Facture facture, @PathVariable Long id, @RequestParam String date, @RequestParam String client, @RequestParam Double totalHT,@RequestParam Double totalTTC, @RequestParam Integer tva) {
        Facture updatedFacture = factureService.updateFacture(facture, id, date, client, totalHT, totalTTC,tva);
        return new ResponseEntity<>(updatedFacture, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFacture(@PathVariable("id") Long id) {
        factureService.deleteFacture(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/client/{client}")
    public List<Facture> getFactureByClient(@PathVariable String client) {
        return factureService.getFactureByClient(client);
    }
    @GetMapping("/today")
    public List<Facture> getFacturesForToday() {
        return factureService.getFacturesForToday();
    }
}