package com.company.stockmanagement;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String id;
    private String nombre;
    private List<StockRecord> stockRecords;

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.stockRecords = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<StockRecord> getStockRecords() {
        return stockRecords;
    }

    // Método para agregar un registro de stock
    public void addStockRecord(StockRecord record) {
        this.stockRecords.add(record);
    }
}
