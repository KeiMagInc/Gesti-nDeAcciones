/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.stockmanagement;

/**
 *
 * @author Gabriel
 */
public class StockValue {

    private double totalCost;
    private double currentValue;
    private double gainLoss;
    private double percentage;
    private double unitGain;
    private double unitPercentage;
    private double totalBalance;
    private double totalGain;

    // Constructor
    public StockValue(double totalCost, double currentValue, double gainLoss, double percentage,
            double unitGain, double unitPercentage, double totalBalance, double totalGain) {
        this.totalCost = totalCost;
        this.currentValue = currentValue;
        this.gainLoss = gainLoss;
        this.percentage = percentage;
        this.unitGain = unitGain;
        this.unitPercentage = unitPercentage;
        this.totalBalance = totalBalance;
        this.totalGain = totalGain;
    }

    // Getters
    public double getTotalCost() {
        return totalCost;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public double getGainLoss() {
        return gainLoss;
    }

    public double getPercentage() {
        return percentage;
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

    // Setters
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public void setGainLoss(double gainLoss) {
        this.gainLoss = gainLoss;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setUnitGain(double unitGain) {
        this.unitGain = unitGain;
    }

    public void setUnitPercentage(double unitPercentage) {
        this.unitPercentage = unitPercentage;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public void setTotalGain(double totalGain) {
        this.totalGain = totalGain;
    }
}
