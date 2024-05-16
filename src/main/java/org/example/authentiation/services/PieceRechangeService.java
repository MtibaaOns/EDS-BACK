package org.example.authentiation.services;


import org.example.authentiation.entities.PieceRechange;
import org.example.authentiation.exception.PieceRechangeNotFoundException;
import org.example.authentiation.repositories.PieceRechangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PieceRechangeService {
    private final PieceRechangeRepo pieceRechangeRepo;

    @Autowired
    public PieceRechangeService(PieceRechangeRepo pieceRechangeRepo) {
        this.pieceRechangeRepo = pieceRechangeRepo;
    }

    /**
     * Ajoute une nouvelle pièce de rechange
     */
    public PieceRechange addPieceRechange(PieceRechange pieceRechange) {
        return pieceRechangeRepo.save(pieceRechange);
    }

    /**
     * Récupère toutes les pièces de rechange
     */
    public List<PieceRechange> findAllPiecesRechange() {
        return pieceRechangeRepo.findAll();
    }

    /**
     * Met à jour une pièce de rechange existante
     */
    public PieceRechange updatePieceRechange(Long id, String desPiece, double prixAchat, Integer tauxTVA,String categoriePiece) {
        Optional<PieceRechange> optionalPieceRechange = pieceRechangeRepo.findPieceRechangeById(id);
        PieceRechange myPieceRechange = optionalPieceRechange.orElseThrow(() -> new PieceRechangeNotFoundException("PieceRechange by id " + id + " was not found"));
        myPieceRechange.setDesPiece(desPiece);
        myPieceRechange.setPrixAchat(prixAchat);
        myPieceRechange.setTauxTVA(tauxTVA);
        myPieceRechange.setCategoriePiece(categoriePiece);

        return pieceRechangeRepo.save(myPieceRechange);
    }

    /**
     * Récupère une pièce de rechange par son identifiant
     */
    public PieceRechange findPieceRechangeById(Long id) {
        return pieceRechangeRepo.findPieceRechangeById(id)
                .orElseThrow(() -> new PieceRechangeNotFoundException("PieceRechange by id " + id + " was not found"));
    }

    /**
     * Supprime une pièce de rechange par son identifiant
     */
    public void deletePieceRechange(Long id) {
        pieceRechangeRepo.deletePieceRechangeById(id);
    }
}