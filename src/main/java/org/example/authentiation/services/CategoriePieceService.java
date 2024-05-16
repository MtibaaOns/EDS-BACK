package org.example.authentiation.services;

import org.example.authentiation.entities.CategoriePiece;
import org.example.authentiation.exception.CategoriePieceNotFoundException;
import org.example.authentiation.repositories.CategoriePieceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoriePieceService {
    private final CategoriePieceRepo categoriePieceRepo;
    private static long idCounter = 0;

    @Autowired
    public CategoriePieceService(CategoriePieceRepo categoriePieceRepo) {
        this.categoriePieceRepo = categoriePieceRepo;
    }

    /**
     * Ajoute une nouvelle catégorie de pièce
     */
    public CategoriePiece addCategoriePiece(CategoriePiece categoriePiece) {
        long newId = generateUniqueId();
        categoriePiece.setId(newId);
        return categoriePieceRepo.save(categoriePiece);
    }

    /**
     * Génère un identifiant unique pour une nouvelle catégorie de pièce
     */
    private synchronized long generateUniqueId() {
        return ++idCounter;
    }

    /**
     * Récupère toutes les catégories de pièces
     */
    public List<CategoriePiece> findAllCategoriesPieces() {
        return categoriePieceRepo.findAll();
    }

    /**
     * Met à jour une catégorie de pièce existante
     */
    public CategoriePiece updateCategoriePiece(CategoriePiece categoriePiece, Long id, String desCategorie) {
        Optional<CategoriePiece> optionalCategoriePiece = categoriePieceRepo.findCategoriePieceById(id);
        CategoriePiece myCategoriePiece = optionalCategoriePiece.orElseThrow(() -> new CategoriePieceNotFoundException("CategoriePiece by id " + id + " was not found"));
        myCategoriePiece.setDesCategorie(desCategorie);
        return categoriePieceRepo.save(myCategoriePiece);
    }

    /**
     * Récupère une catégorie de pièce par son identifiant
     */
    public CategoriePiece findCategoriePieceById(Long id) {
        return categoriePieceRepo.findCategoriePieceById(id)
                .orElseThrow(() -> new CategoriePieceNotFoundException("CategoriePiece by id " + id + " was not found"));
    }

    /**
     * Supprime une catégorie de pièce par son identifiant
     */
    public void deleteCategoriePiece(Long id) {
        categoriePieceRepo.deleteCategoriePieceById(id);
    }
}