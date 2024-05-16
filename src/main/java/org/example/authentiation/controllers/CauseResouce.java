package org.example.authentiation.controllers;


import org.example.authentiation.entities.Cause;
import org.example.authentiation.services.CauseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/causes")
public class CauseResouce {
    private final CauseService causeService;

    public CauseResouce(CauseService causeService) {
        this.causeService = causeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cause>> getAllCauses() {
        List<Cause> causes = causeService.findAllCauses();
        return new ResponseEntity<>(causes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Cause> getCauseById(@PathVariable("id") Long id) {
        Cause cause = causeService.findCauseById(id);
        return new ResponseEntity<>(cause, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Cause> addCause(@RequestBody Cause cause) {
        Cause newCause = causeService.addCause(cause);
        return new ResponseEntity<>(newCause, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cause> updateCause(@RequestBody Cause cause, @PathVariable Long id, @RequestParam String libCause) {
        Cause updatedCause = causeService.updateCause(cause, id, libCause);
        return new ResponseEntity<>(updatedCause, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCause(@PathVariable("id") Long id) {
        causeService.deleteCause(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}