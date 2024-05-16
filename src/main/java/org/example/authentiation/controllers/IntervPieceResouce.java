package org.example.authentiation.controllers;

import org.example.authentiation.entities.Interv_piece;
import org.example.authentiation.services.IntervPieceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/intervPieces")
public class IntervPieceResouce {
    private final IntervPieceService intervPieceService;

    public IntervPieceResouce(IntervPieceService intervPieceService) {
        this.intervPieceService = intervPieceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Interv_piece>> getAllIntervPieces() {
        List<Interv_piece> intervPieces = intervPieceService.findAllIntervPieces();
        return new ResponseEntity<>(intervPieces, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Interv_piece> getIntervPieceById(@PathVariable("id") Long id) {
        Interv_piece intervPiece = intervPieceService.findIntervPieceById(id);
        return new ResponseEntity<>(intervPiece, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Interv_piece> addIntervPiece(@RequestBody Interv_piece intervPiece) {
        Interv_piece newIntervPiece = intervPieceService.addIntervPiece(intervPiece);
        return new ResponseEntity<>(newIntervPiece, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Interv_piece> updateIntervPiece(@PathVariable("id") Long id, @RequestParam Double prixTotal, @RequestParam Integer quantitePiece) {
        Interv_piece updatedIntervPiece = intervPieceService.updateIntervPiece(id, prixTotal, quantitePiece);
        return new ResponseEntity<>(updatedIntervPiece, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteIntervPiece(@PathVariable("id") Long id) {
        intervPieceService.deleteIntervPieceById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}