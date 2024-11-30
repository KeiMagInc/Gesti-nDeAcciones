/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.stockmanagement;

/**
 *
 * @author Gabriel
 */
public class StockData {

    private Double purchasePrice;
    private Double currentPrice;

    public StockData(Double purchasePrice, Double currentPrice) {
        this.purchasePrice = purchasePrice;
        this.currentPrice = currentPrice;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }
}
