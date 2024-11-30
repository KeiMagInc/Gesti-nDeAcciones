package com.company.stockmanagement;

/**
 * Representa los valores de una acción, incluyendo el costo total, el valor actual,
 * las ganancias/pérdidas, el porcentaje de ganancia/pérdida, y el saldo total.
 * Proporciona métodos para acceder y modificar estos valores.
 * 
 * @author 
 */
public class StockValue {

    /** Costo total de la acción. */
    private double totalCost;

    /** Valor actual de la acción. */
    private double currentValue;

    /** Ganancia o pérdida de la acción. */
    private double gainLoss;

    /** Porcentaje de ganancia o pérdida. */
    private double percentage;

    /** Ganancia por unidad de la acción. */
    private double unitGain;

    /** Porcentaje de ganancia por unidad de la acción. */
    private double unitPercentage;

    /** Saldo total de la inversión en la acción. */
    private double totalBalance;

    /** Ganancia total obtenida de la acción. */
    private double totalGain;

    /**
     * Constructor de la clase StockValue.
     * 
     * @param totalCost el costo total de la acción.
     * @param currentValue el valor actual de la acción.
     * @param gainLoss las ganancias o pérdidas de la acción.
     * @param percentage el porcentaje de ganancia o pérdida.
     * @param unitGain la ganancia por unidad.
     * @param unitPercentage el porcentaje de ganancia por unidad.
     * @param totalBalance el saldo total de la inversión.
     * @param totalGain la ganancia total obtenida.
     */
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

    /**
     * Obtiene el costo total de la acción.
     * 
     * @return el costo total.
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Obtiene el valor actual de la acción.
     * 
     * @return el valor actual.
     */
    public double getCurrentValue() {
        return currentValue;
    }

    /**
     * Obtiene la ganancia o pérdida de la acción.
     * 
     * @return la ganancia o pérdida.
     */
    public double getGainLoss() {
        return gainLoss;
    }

    /**
     * Obtiene el porcentaje de ganancia o pérdida de la acción.
     * 
     * @return el porcentaje de ganancia o pérdida.
     */
    public double getPercentage() {
        return percentage;
    }

    /**
     * Obtiene la ganancia por unidad de la acción.
     * 
     * @return la ganancia por unidad.
     */
    public double getUnitGain() {
        return unitGain;
    }

    /**
     * Obtiene el porcentaje de ganancia por unidad de la acción.
     * 
     * @return el porcentaje de ganancia por unidad.
     */
    public double getUnitPercentage() {
        return unitPercentage;
    }

    /**
     * Obtiene el saldo total de la inversión en la acción.
     * 
     * @return el saldo total.
     */
    public double getTotalBalance() {
        return totalBalance;
    }

    /**
     * Obtiene la ganancia total obtenida de la acción.
     * 
     * @return la ganancia total.
     */
    public double getTotalGain() {
        return totalGain;
    }

    /**
     * Establece el costo total de la acción.
     * 
     * @param totalCost el costo total a establecer.
     */
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * Establece el valor actual de la acción.
     * 
     * @param currentValue el valor actual a establecer.
     */
    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * Establece las ganancias o pérdidas de la acción.
     * 
     * @param gainLoss las ganancias o pérdidas a establecer.
     */
    public void setGainLoss(double gainLoss) {
        this.gainLoss = gainLoss;
    }

    /**
     * Establece el porcentaje de ganancia o pérdida de la acción.
     * 
     * @param percentage el porcentaje de ganancia o pérdida a establecer.
     */
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    /**
     * Establece la ganancia por unidad de la acción.
     * 
     * @param unitGain la ganancia por unidad a establecer.
     */
    public void setUnitGain(double unitGain) {
        this.unitGain = unitGain;
    }

    /**
     * Establece el porcentaje de ganancia por unidad de la acción.
     * 
     * @param unitPercentage el porcentaje de ganancia por unidad a establecer.
     */
    public void setUnitPercentage(double unitPercentage) {
        this.unitPercentage = unitPercentage;
    }

    /**
     * Establece el saldo total de la inversión en la acción.
     * 
     * @param totalBalance el saldo total a establecer.
     */
    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    /**
     * Establece la ganancia total obtenida de la acción.
     * 
     * @param totalGain la ganancia total a establecer.
     */
    public void setTotalGain(double totalGain) {
        this.totalGain = totalGain;
    }
}
