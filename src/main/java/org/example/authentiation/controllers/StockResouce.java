package org.example.authentiation.controllers;


import org.example.authentiation.entities.Stock;
import org.example.authentiation.services.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockResouce {
    private final StockService stockService;

    public StockResouce(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Stock>> getAllStocks() {
        List<Stock> stocks = stockService.findAllStocks();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable("id") Long id) {
        Stock stock = stockService.findStockById(id);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
        Stock newStock = stockService.addStock(stock);
        return new ResponseEntity<>(newStock, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Stock> updateStock(@RequestBody Stock stock, @PathVariable Long id, @RequestParam Integer qtiteStock) {
        Stock updatedStock = stockService.updateStock(stock, id, qtiteStock);
        return new ResponseEntity<>(updatedStock, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable("id") Long id) {
        stockService.deleteStock(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}