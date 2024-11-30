package com.company.stockmanagement;

import java.util.Scanner;

public class StockManagement {

    public static void main(String[] args) {
        // Crear instancia del escáner para entrada de datos
        Scanner scanner = new Scanner(System.in);

        // Clave API de Alpha Vantage (reemplaza con tu clave)
        String apiKey = "VPM7079HKZJGEWZN";  // Reemplaza con tu clave API de Alpha Vantage

        // Crear una instancia de AlphaVantageAPI
        AlphaVantageAPI api = new AlphaVantageAPI(apiKey);

        boolean continuar = true;

        while (continuar) {
            try {
                // Solicitar datos al usuario
                System.out.print("Ingresa el nombre de la acción: ");
                String symbol = scanner.nextLine();

                System.out.print("Ingresa el precio al que compraste la acción: ");
                double purchasePrice = StockValidator.obtenerDecimalPositivo(scanner);

                String purchaseDate = StockValidator.obtenerFechaValida(scanner);

                System.out.print("Ingresa la cantidad de acciones compradas: ");
                int quantity = StockValidator.obtenerEnteroPositivo(scanner);

                // Simular obtención del precio actual (puedes reemplazar con la API)
                double currentPrice = api.obtenerPrecioActual(symbol);

                // Calcular valores relacionados con las acciones
                StockValue stockValues = StockDashboard.calculateStockValues(purchasePrice, currentPrice, quantity);

                // Actualizar el dashboard con los datos ingresados
                StockDashboard.updateDashboard(
                    symbol,
                    quantity,
                    purchaseDate,
                    purchasePrice,
                    currentPrice,
                    stockValues.getUnitGain(),
                    stockValues.getUnitPercentage(),
                    stockValues.getTotalBalance(),
                    stockValues.getTotalGain()
                );

                // Preguntar si desea realizar otra operación
                System.out.print("\n¿Quieres registrar otra acción? (s/n): ");
                String respuesta = scanner.nextLine().trim().toLowerCase();
                if (!respuesta.equals("s")) {
                    continuar = false;
                }

            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }

        // Cerrar el escáner
        scanner.close();
    }
}
