package org.example.authentiation.controllers;


import org.example.authentiation.entities.Depot;
import org.example.authentiation.services.DepotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depots")
public class DepotResouce {
    private final DepotService depotService;

    public DepotResouce(DepotService depotService) {
        this.depotService = depotService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Depot>> getAllDepots() {
        List<Depot> depots = depotService.findAllDepots();
        return new ResponseEntity<>(depots, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Depot> getDepotById(@PathVariable("id") Long id) {
        Depot depot = depotService.findDepotById(id);
        return new ResponseEntity<>(depot, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Depot> addDepot(@RequestBody Depot depot) {
        Depot newDepot = depotService.addDepot(depot);
        return new ResponseEntity<>(newDepot, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Depot> updateDepot(@RequestBody Depot depot, @PathVariable Long id, @RequestParam String libDep) {
        Depot updatedDepot = depotService.updateDepot(depot, id, libDep);
        return new ResponseEntity<>(updatedDepot, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDepot(@PathVariable("id") Long id) {
        depotService.deleteDepot(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
