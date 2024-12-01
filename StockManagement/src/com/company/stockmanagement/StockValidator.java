package com.company.stockmanagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * Clase utilitaria para validar datos relacionados con acciones, incluyendo
 * números decimales, números enteros y fechas.
 */
public class StockValidator {

    public static double validarDecimalPositivo(String input, StringBuilder errores) {
        try {
            double numero = Double.parseDouble(input);
            if (numero > 0) {
                return numero;
            } else {
                errores.append("Purchase price debe ser mayor a 0.\n");
            }
        } catch (NumberFormatException e) {
            errores.append("Purchase price debe ser un número decimal válido.\n");
        }
        return -1;
    }

    public static int validarEnteroPositivo(String input, StringBuilder errores) {
        try {
            int numero = Integer.parseInt(input);
            if (numero > 0) {
                return numero;
            } else {
                errores.append("Quantity debe ser mayor a 0.\n");
            }
        } catch (NumberFormatException e) {
            errores.append("Quantity debe ser un número entero válido.\n");
        }
        return -1;
    }

    public static String validarFecha(String input, StringBuilder errores) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            Date date = dateFormat.parse(input);

            Date today = new Date();
            SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
            int year = Integer.parseInt(yearFormat.format(date));

            if (year >= 2000 && date.compareTo(today) <= 0) {
                return dateFormat.format(date);
            } else if (year < 2000) {
                errores.append("El año de la fecha debe ser mayor o igual a 2000.\n");
            } else {
                errores.append("La fecha no puede ser mayor a la fecha actual.\n");
            }
        } catch (Exception e) {
            errores.append("Fecha inválida: Datos incorrectos en el formato dd/MM/yyyy.\\n");
        }
        return null;
    }
}

