package org.example.authentiation.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity

@Table(name = "stock")
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_stock", nullable = false, updatable = false)
    private Long idStock;

    @Column(name = "qtite_stock")
    private Integer qtiteStock;

    @ManyToOne
    @JoinColumn(name = "id_depot", nullable = false)
    private Depot depot;

    @ManyToOne
    @JoinColumn(name = "id_piece_rechange", nullable = false)
    private PieceRechange pieceRechange;

    public Stock() {
        // Constructeur par défaut requis par JPA
    }

    public Stock(Integer qtiteStock, Depot depot, PieceRechange pieceRechange) {
        this.qtiteStock = qtiteStock;
        this.depot = depot;
        this.pieceRechange = pieceRechange;
    }

    public Long getIdStock() {
        return idStock;
    }

    public void setIdStock(Long idStock) {
        this.idStock = idStock;
    }

    public Integer getQtiteStock() {
        return qtiteStock;
    }

    public void setQtiteStock(Integer qtiteStock) {
        this.qtiteStock = qtiteStock;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public PieceRechange getPieceRechange() {
        return pieceRechange;
    }

    public void setPieceRechange(PieceRechange pieceRechange) {
        this.pieceRechange = pieceRechange;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "idStock=" + idStock +
                ", qtiteStock=" + qtiteStock +
                ", depot=" + depot +
                ", pieceRechange=" + pieceRechange +
                '}';
    }
}