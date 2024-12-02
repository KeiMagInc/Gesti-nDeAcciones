/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.stockmanagement;

public class StockRecord {
    private String symbol;
    private double purchasePrice;
    private int quantity;
    private String purchaseDate;
    private double currentPrice;
    private double unitGain;
    private double unitPercentage;
    private double totalBalance;
    private double totalGain;
    private StockValue stockValue;

    public StockRecord(String symbol, double purchasePrice, int quantity, String purchaseDate) {
        this.symbol = symbol;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public double getUnitGain() {
        return unitGain;
    }

    public double getUnitPercentage() {
        return unitPercentage;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public double getTotalGain() {
        return totalGain;
    }

    public StockValue getStockValue() {
        return stockValue;
    }

    // Establecer los valores calculados
    public void setStockValue(StockValue stockValue) {
        this.stockValue = stockValue;
        this.currentPrice = stockValue.getCurrentValue();
        this.unitGain = stockValue.getUnitGain();
        this.unitPercentage = stockValue.getUnitPercentage();
        this.totalBalance = stockValue.getTotalBalance();
        this.totalGain = stockValue.getTotalGain();
    }
}

