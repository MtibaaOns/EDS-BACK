package org.example.authentiation.controllers;

import org.example.authentiation.entities.PieceRechange;
import org.example.authentiation.services.PieceRechangeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/piecesrechanges")
public class PieceRechangeResouce {
    private final PieceRechangeService pieceRechangeService;

    public PieceRechangeResouce(PieceRechangeService pieceRechangeService) {
        this.pieceRechangeService = pieceRechangeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PieceRechange>> getAllPiecesRechanges() {
        List<PieceRechange> piecesRechange = pieceRechangeService.findAllPiecesRechange();
        return new ResponseEntity<>(piecesRechange, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PieceRechange> getPieceRechangeById(@PathVariable("id") Long id) {
        PieceRechange pieceRechange = pieceRechangeService.findPieceRechangeById(id);
        return new ResponseEntity<>(pieceRechange, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PieceRechange> addPieceRechange(@RequestBody PieceRechange pieceRechange) {
        PieceRechange newPieceRechange = pieceRechangeService.addPieceRechange(pieceRechange);
        return new ResponseEntity<>(newPieceRechange, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PieceRechange> updatePieceRechange(@PathVariable Long id, @RequestParam String desPiece, @RequestParam double prixAchat, @RequestParam Integer tauxTVA, @RequestParam String categoriePiece) {
        PieceRechange updatedPieceRechange = pieceRechangeService.updatePieceRechange(id, desPiece, prixAchat, tauxTVA, categoriePiece);
        return new ResponseEntity<>(updatedPieceRechange, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePieceRechange(@PathVariable("id") Long id) {
        pieceRechangeService.deletePieceRechange(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}