package com.company.stockmanagement;

import java.util.Scanner;

/**
 * Clase principal para gestionar el stock de acciones. Permite al usuario registrar
 * información sobre las acciones compradas, obtener el precio actual mediante la API
 * de Alpha Vantage y calcular y mostrar los valores asociados a las acciones.
 * 
 * El flujo de la clase incluye la validación de la entrada del usuario, la obtención de datos
 * de la API, el cálculo de los valores de las acciones y la actualización de un dashboard con la
 * información ingresada.
 * 
 * @author Gabriel
 */
public class StockManagement {

    /**
     * Método principal que ejecuta el programa de gestión de acciones.
     * Permite al usuario ingresar datos sobre las acciones compradas y calcula
     * los valores relacionados con las acciones.
     * 
     * @param args los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        // Crear instancia del escáner para entrada de datos
        Scanner scanner = new Scanner(System.in);

        // Clave API de Alpha Vantage (reemplaza con tu clave)
        String apiKey = "VPM7079HKZJGEWZN";  // Reemplaza con tu clave API de Alpha Vantage

        // Crear una instancia de AlphaVantageAPI
        AlphaVantageAPI api = new AlphaVantageAPI(apiKey);

        // Bandera para continuar o detener el ciclo de entrada
        boolean continuar = true;

        // Ciclo principal que solicita y procesa los datos del usuario
        while (continuar) {
            try {
                // Solicitar datos al usuario
                System.out.print("Ingresa el nombre de la acción: ");
                String symbol = scanner.nextLine();

                System.out.print("Ingresa el precio al que compraste la acción: ");
                double purchasePrice = StockValidator.obtenerDecimalPositivo(scanner);

                // Validar y obtener la fecha de compra de la acción
                String purchaseDate = StockValidator.obtenerFechaValida(scanner);

                System.out.print("Ingresa la cantidad de acciones compradas: ");
                int quantity = StockValidator.obtenerEnteroPositivo(scanner);

                // Simular obtención del precio actual (puedes reemplazar con la API)
                double currentPrice = api.obtenerPrecioActual(symbol);

                // Calcular valores relacionados con las acciones usando la clase StockDashboard
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

        // Cerrar el escáner al final del ciclo
        scanner.close();
    }
}
