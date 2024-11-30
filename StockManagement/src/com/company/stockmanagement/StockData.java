package com.company.stockmanagement;

/**
 * Representa los datos de una acción, incluyendo el precio de compra y el precio actual.
 * Proporciona métodos para acceder a estos valores.
 * 
 * @author 
 */
public class StockData {

    /** Precio de compra de la acción. */
    private Double purchasePrice;

    /** Precio actual de la acción. */
    private Double currentPrice;

    /**
     * Constructor de la clase StockData.
     * 
     * @param purchasePrice el precio de compra de la acción.
     * @param currentPrice el precio actual de la acción.
     */
    public StockData(Double purchasePrice, Double currentPrice) {
        this.purchasePrice = purchasePrice;
        this.currentPrice = currentPrice;
    }

    /**
     * Obtiene el precio de compra de la acción.
     * 
     * @return el precio de compra.
     */
    public Double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * Obtiene el precio actual de la acción.
     * 
     * @return el precio actual.
     */
    public Double getCurrentPrice() {
        return currentPrice;
    }
}
