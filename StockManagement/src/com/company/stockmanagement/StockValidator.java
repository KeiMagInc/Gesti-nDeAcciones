package com.company.stockmanagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Clase utilitaria para validar datos relacionados con acciones, incluyendo
 * números decimales, números enteros y fechas.
 */
public class StockValidator {

    /**
     * Valida y obtiene un número decimal positivo ingresado por el usuario.
     * 
     * @param scanner el objeto Scanner para leer la entrada del usuario.
     * @return un número decimal mayor a 0.
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
     * Valida y obtiene un número entero positivo ingresado por el usuario.
     * 
     * @param scanner el objeto Scanner para leer la entrada del usuario.
     * @return un número entero mayor a 0.
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
     * Valida y obtiene una fecha en formato <code>yyyy-MM-dd</code>. Asegura que
     * la fecha esté entre los años 1900 y 2024.
     * 
     * @param scanner el objeto Scanner para leer la entrada del usuario.
     * @return una fecha válida en formato <code>yyyy-MM-dd</code>.
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
