/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.stockmanagement;

import com.company.stockmanagement.ui.DashboardClient;

/**
 *
 * @author saidl
 */
public class StockController {

    private DashboardClient view;
    private AlphaVantageAPI api;

    public StockController(DashboardClient view, String apiKey) {
        this.view = view;
        this.api = new AlphaVantageAPI(apiKey);  // Crear instancia de la API con la clave proporcionada
    }

    // Método para procesar los datos de la acción
    public void processStockData(String symbol, double purchasePrice, int quantity, String purchaseDate) {
        try {
            // Obtener el precio actual de la acción usando la API
            double currentPrice = api.obtenerPrecioActual(symbol);

            // Calcular los valores de la acción
            StockValue stockValues = calculateStockValues(purchasePrice, currentPrice, quantity);

            // Actualizar la vista (la tabla) con los resultados calculados
            view.updateTable(symbol, quantity, purchaseDate, purchasePrice, currentPrice, stockValues);
        } catch (Exception e) {
            // Enviar el error a la vista (por ejemplo, un mensaje emergente)
            view.showError("Error: " + e.getMessage());
        }
    }

    public void handleSave(String symbol, String purchasePriceText, String quantityText, String purchaseDateText) {
        // Crear un StringBuilder para acumular errores
        StringBuilder errores = new StringBuilder();

        // Validar los valores ingresados y acumular errores si existen
        double purchasePrice = StockValidator.validarDecimalPositivo(purchasePriceText, errores);
        int quantity = StockValidator.validarEnteroPositivo(quantityText, errores);
        String purchaseDate = StockValidator.validarFecha(purchaseDateText, errores);

        // Si hay errores, mostrar el mensaje acumulado
        if (errores.length() > 0) {
            // Mostrar el mensaje de error a la vista
            view.showError("Errores encontrados:\n" + errores.toString());
        } else {
            // Si todos los valores son válidos, procesar los datos
            processStockData(symbol, purchasePrice, quantity, purchaseDate);
        }
    }

    public static StockValue calculateStockValues(double purchasePrice, double currentPrice, int quantity) {
        double totalCost = purchasePrice * quantity;
        double totalBalance = currentPrice * quantity;

        double unitGain = currentPrice - purchasePrice;
        double unitPercentage = (unitGain / purchasePrice) * 100;

        double totalGain = totalBalance - totalCost;

        return new StockValue( totalCost, currentPrice, unitGain,  unitPercentage,  totalBalance,  totalGain);
    }

}
