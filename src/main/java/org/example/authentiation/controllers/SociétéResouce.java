package org.example.authentiation.controllers;


import org.example.authentiation.entities.Société;
import org.example.authentiation.services.SociétéService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/Sociétés")
public class SociétéResouce {
    private final SociétéService sociétéService;


    public SociétéResouce(SociétéService sociétéService) {
        this.sociétéService = sociétéService;
    }
    @GetMapping("all")
    public ResponseEntity<List<Société>> getAllSocietes(){
       List<Société> sociétés = sociétéService.findAllSociétés();
       return new ResponseEntity<>(sociétés, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Société> getSocieteById(@PathVariable("id")Long id){
        Société société = sociétéService.findSociétéById(id);
        return new ResponseEntity<>(société, HttpStatus.OK);
    }
    @PostMapping("/add")
    public  ResponseEntity<Société> addSociete(@RequestBody Société société ){
        Société newSociété = sociétéService.addSociété(société) ;
        return new ResponseEntity<>(newSociété, HttpStatus.CREATED);}
    @PutMapping("/update/{id}")
    public ResponseEntity<Société> updateSociete(@RequestBody Société société, @PathVariable Long id, @RequestParam String raisonSocial,@RequestParam String adresse,@RequestParam String email,@RequestParam String tel,@RequestParam String mf) {
        Société updateSociété = sociétéService.updateSociété(société, id, raisonSocial,adresse,email,tel,mf);
        return new ResponseEntity<>(updateSociété, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteSociete(@PathVariable("id")Long id){
        sociétéService.deleteSociété(id) ;
        return new ResponseEntity<>(HttpStatus.OK);

        }













}
