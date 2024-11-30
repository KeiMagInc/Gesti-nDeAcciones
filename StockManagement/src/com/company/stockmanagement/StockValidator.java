package com.company.stockmanagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StockValidator {

    /**
     * Método para validar un número decimal positivo.
     */
    public static double obtenerDecimalPositivo(Scanner scanner) {
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
    public static int obtenerEnteroPositivo(Scanner scanner) {
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
     * Método para validar una fecha en formato yyyy-MM-dd y rango entre 1900 y 2024.
     */
    public static String obtenerFechaValida(Scanner scanner) {
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
