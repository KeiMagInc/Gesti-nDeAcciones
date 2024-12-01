/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.stockmanagement;

/**
 *
 * @author Gabriel
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;
import com.company.stockmanagement.StockData;

public class StockDashboard {

    // Lista para almacenar los registros de acciones
    private static List<String> stockRecords = new ArrayList<>();

    public static void updateDashboard(
            String stockName,
            int quantity,
            String purchaseDate,
            double purchasePrice,
            double currentPrice,
            double unitGain,
            double unitPercentage,
            double totalBalance,
            double totalGain
    ) {
        // Formatear los datos del registro
        String record = String.format(
                "Stock: %s | Fecha de compra: %s | Precio de compra (individual): %.2f | Cantidad: %d | Total de compra: %.2f | Fecha actual: %s | Precio actual (individual): %.2f | Ganancia unitaria: %.2f | %% Ganancia (porcentaje): %.2f%% | Balance total: %.2f | Ganancia total: %.2f",
                stockName, // Nombre del stock
                purchaseDate, // Fecha de compra
                purchasePrice, // Precio de compra (individual)
                quantity, // Cantidad
                purchasePrice * quantity, // Total de compra
                new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date()), // Fecha actual
                currentPrice, // Precio actual (individual)
                unitGain, // Ganancia unitaria
                unitPercentage, // Ganancia unitaria (%)
                totalBalance, // Balance total
                totalGain // Ganancia total
        );
        
        

        // Agregar el registro a la lista
        stockRecords.add(record);

        // Mostrar el registro actual
        System.out.println("=== Registro Actual ===");
        System.out.println("Stock: " + stockName);
        System.out.println("Fecha de compra: " + purchaseDate);
        System.out.println("Precio de compra (individual): " + String.format("%.2f", purchasePrice));
        System.out.println("Cantidad: " + quantity);
        System.out.println("Total de compra: " + String.format("%.2f", purchasePrice * quantity));
        System.out.println("Fecha actual: " + new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date()));
        System.out.println("Precio actual (individual): " + String.format("%.2f", currentPrice));
        System.out.println("Ganancia unitaria: " + String.format("%.2f", unitGain));
        System.out.println("Ganancia (%): " + String.format("%.2f", unitPercentage) + "%");
        System.out.println("Balance total: " + String.format("%.2f", totalBalance));
        System.out.println("Ganancia total: " + String.format("%.2f", totalGain));

        // Mostrar todos los registros acumulados
        showAllRecords();
    }

    /**
     * Muestra todos los registros acumulados.
     */
    public static void showAllRecords() {
        System.out.println("\n=== Historial de Registros ===");
        for (int i = 0; i < stockRecords.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, stockRecords.get(i));
        }
        System.out.println("==============================");
    }

    public static StockData fetchStockData(String stockName, String purchaseDate) throws Exception {
        String apiKey = "VPM7079HKZJGEWZN";  // Coloca tu clave de API aquí
        String urlString = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + stockName + "&apikey=" + apiKey + "&outputsize=full&datatype=csv";
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine).append("\n");
        }
        in.close();
        conn.disconnect();

        String[] rows = content.toString().split("\n");
        Double purchasePrice = null;
        Double currentPrice = null;

        for (String row : rows) {
            String[] columns = row.split(",");
            String date = columns[0];
            Double close = Double.parseDouble(columns[4]);

            if (date.equals(purchaseDate)) {
                purchasePrice = close;
            }
            if (new SimpleDateFormat("yyyy-MM-dd").parse(date).before(new Date()) && currentPrice == null) {
                currentPrice = close;
            }

            if (purchasePrice != null && currentPrice != null) {
                break;
            }
        }

        return new StockData(purchasePrice, currentPrice);
    }

    public static StockValue calculateStockValues(double purchasePrice, double currentPrice, int quantity) {
        double totalCost = purchasePrice * quantity;
        double totalBalance = currentPrice * quantity;

        double unitGain = currentPrice - purchasePrice;
        double unitPercentage = (unitGain / purchasePrice) * 100;

        double totalGain = totalBalance - totalCost;

        return new StockValue(totalCost, totalBalance, totalGain, (totalGain / totalCost) * 100,
                unitGain, unitPercentage, totalBalance, totalGain);
    }

}
