package com.company.stockmanagement;

import com.company.stockmanagement.ui.DashboardClient;

/**
 * Controller class for managing stock data processing and interactions with the
 * view.
 */
public class StockController {

    private DashboardClient view;
    private AlphaVantageAPI api;
    private Usuario usuario;

    /**
     * Constructor for StockController.
     *
     * @param view the view interface (DashboardClient) to update the UI.
     * @param apiKey the API key for accessing AlphaVantage API.
     */
    public StockController(DashboardClient view, String apiKey) {
        this.view = view;
        this.api = new AlphaVantageAPI(apiKey);  // Create API instance with the provided key
        this.usuario = usuario;
    }

    /**
     * Processes stock data and updates the view with calculated stock values.
     *
     * @param symbol the stock symbol to retrieve data for.
     * @param purchasePrice the price at which the stock was purchased.
     * @param quantity the number of stocks purchased.
     * @param purchaseDate the date the stock was purchased.
     */
    public void processStockData(String symbol, double purchasePrice, int quantity, String purchaseDate, Usuario usuario) {
        try {
            // Get the current price of the stock using the API
            double currentPrice = api.getCurrentPrice(symbol);

            // Calculate stock values
            StockValue stockValues = calculateStockValues(purchasePrice, currentPrice, quantity);

            // Create the StockRecord with the stock values
            StockRecord record = new StockRecord(symbol, purchasePrice, quantity, purchaseDate);
            record.setStockValue(stockValues); // Set calculated stock values

            // Add the record to the user's stock records
            usuario.addStockRecord(record);

            // Update the view (table) with the calculated results
            view.updateTable(symbol, quantity, purchaseDate, purchasePrice, currentPrice, stockValues);
        } catch (Exception e) {
            // Send the error to the view (e.g., show an error message)
            view.showError("Error: " + e.getMessage());
        }
    }

    /**
     * Handles the save operation by validating inputs and processing data.
     *
     * @param symbol the stock symbol.
     * @param purchasePriceText the purchase price input as text.
     * @param quantityText the quantity input as text.
     * @param purchaseDateText the purchase date input as text.
     */
    public void handleSave(String symbol, String purchasePriceText, String quantityText, String purchaseDateText, Usuario usuario) {
        // Crear un StringBuilder para acumular los errores
        StringBuilder errors = new StringBuilder();

        // Validar los valores de entrada y acumular errores si hay
        double purchasePrice = StockValidator.validatePositiveDecimal(purchasePriceText, errors);
        int quantity = StockValidator.validatePositiveInteger(quantityText, errors);
        String purchaseDate = StockValidator.validateDate(purchaseDateText, errors);

        // Si hay errores, mostrar el mensaje de error
        if (errors.length() > 0) {
<<<<<<< HEAD
            // Mostrar el mensaje de error en la vista
            view.showError("Errors found:\n" + errors.toString());
        } else {
            // Si todos los valores son válidos, procesar los datos de stock
            processStockData(symbol, purchasePrice, quantity, purchaseDate, usuario);
=======
            view.showError("Errors found:\n" + errors);
            return; // Salir temprano si hay errores
>>>>>>> 78298b0e097054aba9e5f8bb8d35fc7be2c73e02
        }
        // Si todos los valores son válidos, procesar los datos
        processStockData(symbol, purchasePrice, quantity, purchaseDate);
    }

    /**
     * Calculates the stock values based on purchase price, current price, and
     * quantity.
     *
     * @param purchasePrice the price at which the stock was purchased.
     * @param currentPrice the current price of the stock.
     * @param quantity the number of stocks.
     * @return a StockValue object containing the calculated stock values.
     */
    public static StockValue calculateStockValues(double purchasePrice, double currentPrice, int quantity) {
        double totalCost = purchasePrice * quantity;
        double totalBalance = currentPrice * quantity;

        double unitGain = currentPrice - purchasePrice;
        double unitPercentage = (unitGain / purchasePrice) * 100;

        double totalGain = totalBalance - totalCost;

        return new StockValue(totalCost, currentPrice, unitGain, unitPercentage, totalBalance, totalGain);
    }
}
