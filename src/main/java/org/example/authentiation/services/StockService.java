package org.example.authentiation.services;


import org.example.authentiation.entities.Stock;
import org.example.authentiation.exception.StockNotFoundException;
import org.example.authentiation.repositories.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StockService {
    private final StockRepo stockRepo;
    private static long idCounter = 0;

    @Autowired
    public StockService(StockRepo stockRepo) {
        this.stockRepo = stockRepo;
    }

    /**
     * Ajoute un nouveau stock
     */
    public Stock addStock(Stock stock) {
        long newId = generateUniqueId();
        stock.setIdStock(newId);
        return stockRepo.save(stock);
    }

    /**
     * Génère un identifiant unique pour un nouveau stock
     */
    private synchronized long generateUniqueId() {
        return ++idCounter;
    }

    /**
     * Récupère tous les stocks
     */
    public List<Stock> findAllStocks() {
        return stockRepo.findAll();
    }

    /**
     * Met à jour un stock existant
     */
    public Stock findStockById(Long id) {
        return stockRepo.findById(id)
                .orElseThrow(() -> new StockNotFoundException("Stock by id " + id + " was not found"));
    }

    public Stock updateStock(Stock stock, Long id, Integer qtiteStock) {
        Stock myStock = findStockById(id);
        myStock.setQtiteStock(qtiteStock);
        return stockRepo.save(myStock);
    }
    /**
     * Supprime un stock par son identifiant
     */
    public void deleteStock(Long id) {
        Stock stock = findStockById(id);
        stockRepo.delete(stock);
    }
}