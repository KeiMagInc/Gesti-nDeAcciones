package com.company.stockmanagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * Clase utilitaria para validar datos relacionados con acciones, incluyendo
 * números decimales, números enteros y fechas.
 */
public class StockValidator {

    /**
     * Valida que una cadena represente un número decimal positivo.
     *
     * @param input el texto a validar.
     * @return el número decimal si es válido, o -1 si no lo es.
     */
    public static double validarDecimalPositivo(String input) {
        try {
            double numero = Double.parseDouble(input);
            if (numero > 0) {
                return numero;
            } else {
                JOptionPane.showMessageDialog(null, "Entrada inválida: Purchase price debe ser mayor a 0");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida en purchase price. Ingresa un número decimal válido.");
        }
        return -1;
    }

    /**
     * Valida que una cadena represente un número entero positivo.
     *
     * @param input el texto a validar.
     * @return el número entero si es válido, o -1 si no lo es.
     */
    public static int validarEnteroPositivo(String input) {
        try {
            int numero = Integer.parseInt(input);
            if (numero > 0) {
                return numero;
            } else {
                JOptionPane.showMessageDialog(null, "Entrada inválida:  Quantity debe ser mayor a 0");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida: Quantity debe ser un número entero.");
        }
        return -1;
    }

    /**
     * Valida que una cadena sea una fecha válida en formato
     * <code>dd/MM/yyyy</code>.
     *
     * @param input el texto a validar.
     * @return la fecha si es válida, o null si no lo es.
     */
    public static String validarFecha(String input) {
    try {
        // Cambiar el formato de entrada a dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        Date date = dateFormat.parse(input);

        // Obtener la fecha actual
        Date today = new Date();

        // Validar rango de fechas
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        int year = Integer.parseInt(yearFormat.format(date));
        if (year >= 2000 && date.compareTo(today) <= 0) {
            // Retornar la fecha en el mismo formato dd/MM/yyyy
            return dateFormat.format(date);
        } else if (year < 2000) {
            JOptionPane.showMessageDialog(null, "El año debe ser mayor o igual a 2000.");
        } else {
            JOptionPane.showMessageDialog(null, "La fecha no puede ser mayor a la fecha actual.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Por favor, ingresa una fecha válida en el formato dd/MM/yyyy.");
    }
    return null;
}


}
