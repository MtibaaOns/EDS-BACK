package org.example.authentiation.controllers;

import org.example.authentiation.services.specialiteService;
import org.example.authentiation.entities.specialite;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/specialites")
public class specialiteResouce {
    private final specialiteService specialiteService;

    public specialiteResouce(specialiteService specialiteService) {
        this.specialiteService = specialiteService;
    }

    @GetMapping("all")
    public ResponseEntity<List<specialite>> getAllSpecialites() {
        List<specialite> specialites = specialiteService.findAllSpecialites();
        return new ResponseEntity<>(specialites, HttpStatus.OK);
    }

    @GetMapping("/find/{codeSpec}")
    public ResponseEntity<specialite> getSpecialiteByCodeSpec(@PathVariable("codeSpec") Integer codeSpec) {
      specialite Specialite = specialiteService.findSpecialiteBycodeSpec(codeSpec);
        return new ResponseEntity<>(Specialite, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<specialite> addSpecialite(@RequestBody specialite specialite) {
        specialite newSpecialite = specialiteService.addSpecialite(specialite);
        return new ResponseEntity<>(newSpecialite, HttpStatus.CREATED);
    }

    @PutMapping("/update/{codeSpec}")
    public ResponseEntity<specialite> updateSpecialite(@RequestBody specialite specialite, @PathVariable Integer codeSpec, @RequestParam String libSpec) {
        specialite updatedSpecialite = specialiteService.updateSpecialite(specialite, codeSpec, libSpec);
        return new ResponseEntity<>(updatedSpecialite, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{codeSpec}")
    public ResponseEntity<?> deleteSpecialite(@PathVariable("codeSpec") Integer codeSpec) {
        specialiteService.deleteSpecialite(codeSpec);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
