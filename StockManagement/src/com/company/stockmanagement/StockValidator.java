/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.company.stockmanagement;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class to validate data related to stocks, including decimal numbers,
 * integers, and dates.
 */
public class StockValidator {

    /**
     * Validates a positive decimal number.
     *
     * @param input the input string to validate.
     * @param errors the StringBuilder to accumulate error messages.
     * @return the validated decimal number or -1 if invalid.
     */
    public static double validatePositiveDecimal(String input, StringBuilder errors) {
        try {
            double number = Double.parseDouble(input);
            if (number > 0) {
                return number;
            } else {
                errors.append("Purchase price must be greater than 0.\n");
            }
        } catch (NumberFormatException e) {
            errors.append("Purchase price must be a valid decimal number.\n");
        }
        return -1;
    }

    /**
     * Validates a positive integer.
     *
     * @param input the input string to validate.
     * @param errors the StringBuilder to accumulate error messages.
     * @return the validated integer or -1 if invalid.
     */
    public static int validatePositiveInteger(String input, StringBuilder errors) {
        try {
            int number = Integer.parseInt(input);
            if (number > 0) {
                return number;
            } else {
                errors.append("Quantity must be greater than 0.\n");
            }
        } catch (NumberFormatException e) {
            errors.append("Quantity must be a valid integer number.\n");
        }
        return -1;
    }

    /**
     * Validates a date in the format dd/MM/yyyy.
     *
     * @param input the input date string to validate.
     * @param errors the StringBuilder to accumulate error messages.
     * @return the validated date in the format dd/MM/yyyy or null if invalid.
     */
    public static String validateDate(String input, StringBuilder errors) {
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
                errors.append("The year of the date must be greater than or equal to 2000.\n");
            } else {
                errors.append("The date cannot be later than the current date.\n");
            }
        } catch (Exception e) {
            errors.append("Invalid date: Incorrect format. Use dd/MM/yyyy.\n");
        }
        return null;
    }
}
