package org.example.authentiation.controllers;

import org.example.authentiation.entities.CategoriePiece;
import org.example.authentiation.services.CategoriePieceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoriespieces")
public class CategoriePieceResouce {
    private final CategoriePieceService categoriePieceService;

    public CategoriePieceResouce(CategoriePieceService categoriePieceService) {
        this.categoriePieceService = categoriePieceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoriePiece>> getAllCategoriesPieces() {
        List<CategoriePiece> categoriePieces = categoriePieceService.findAllCategoriesPieces();
        return new ResponseEntity<>(categoriePieces, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CategoriePiece> getCategoriePieceById(@PathVariable("id") Long id) {
        CategoriePiece categoriePiece = categoriePieceService.findCategoriePieceById(id);
        return new ResponseEntity<>(categoriePiece, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CategoriePiece> addCategoriePiece(@RequestBody CategoriePiece categoriePiece) {
        CategoriePiece newCategoriePiece = categoriePieceService.addCategoriePiece(categoriePiece);
        return new ResponseEntity<>(newCategoriePiece, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoriePiece> updateCategoriePiece(@RequestBody CategoriePiece categoriePiece, @PathVariable Long id, @RequestParam String desCategorie) {
        CategoriePiece updatedCategoriePiece = categoriePieceService.updateCategoriePiece(categoriePiece, id, desCategorie);
        return new ResponseEntity<>(updatedCategoriePiece, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategoriePiece(@PathVariable("id") Long id) {
        categoriePieceService.deleteCategoriePiece(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}