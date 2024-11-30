package com.company.stockmanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                double purchasePrice = obtenerDecimalPositivo(scanner);

                String purchaseDate = obtenerFechaValida(scanner);

                System.out.print("Ingresa la cantidad de acciones compradas: ");
                int quantity = obtenerEnteroPositivo(scanner);

                // Simular obtención del precio actual (puedes reemplazar con la API)
                double currentPrice = api.obtenerPrecioActual(symbol);

                // Calcular valores relacionados con las acciones
                double unitGain = currentPrice - purchasePrice;
                double unitPercentage = (unitGain / purchasePrice) * 100;
                double totalBalance = currentPrice * quantity;
                double totalGain = unitGain * quantity;

                // Actualizar el dashboard con los datos ingresados
                StockDashboard.updateDashboard(
                        symbol,
                        quantity,
                        purchaseDate,
                        purchasePrice,
                        currentPrice,
                        unitGain,
                        unitPercentage,
                        totalBalance,
                        totalGain
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
        System.out.println("¡Gracias por usar StockManagement!");
    }

    /**
     * Método para validar un número decimal positivo.
     */
    private static double obtenerDecimalPositivo(Scanner scanner) {
        double numero;
        while (true) {
            try {
                numero = Double.parseDouble(scanner.nextLine());
                if (numero > 0) {
                    return numero;
                } else {
                    System.out.print("El número debe ser mayor a 0. Intenta de nuevo: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Ingresa un número decimal válido: ");
            }
        }
    }

    /**
     * Método para validar un número entero positivo.
     */
    private static int obtenerEnteroPositivo(Scanner scanner) {
        int numero;
        while (true) {
            try {
                numero = Integer.parseInt(scanner.nextLine());
                if (numero > 0) {
                    return numero;
                } else {
                    System.out.print("El número debe ser mayor a 0. Intenta de nuevo: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Ingresa un número entero válido: ");
            }
        }
    }

    /**
     * Método para validar una fecha en formato yyyy-MM-dd y con rango
     * razonable.
     */
    /**
     * Método para validar una fecha en formato yyyy-MM-dd y rango entre 1900 y
     * 2024.
     */
    private static String obtenerFechaValida(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Ingresa la fecha de compra (formato: yyyy-MM-dd): ");
                String fechaIngresada = scanner.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);
                Date date = dateFormat.parse(fechaIngresada);

                // Validar rango de fechas
                SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
                int year = Integer.parseInt(yearFormat.format(date));
                if (year >= 1900 && year <= 2024) {
                    return fechaIngresada;
                } else {
                    System.out.println("El año debe estar entre 1900 y 2024. Intenta de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Por favor, ingresa una fecha válida en el formato yyyy-MM-dd.");
            }
        }
    }

}
