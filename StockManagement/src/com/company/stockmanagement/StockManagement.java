/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.company.stockmanagement;

import com.company.stockmanagement.ui.DashboardClient;

/**
 * Main class for managing stock. It allows users to register information about
 * purchased stocks, obtain the current price using the Alpha Vantage API, and
 * calculate and display the associated stock values.
 *
 * The class flow includes user input validation, retrieving data from the API,
 * calculating stock values, and updating a dashboard with the entered
 * information.
 *
 * @author Gabriel
 */
public class StockManagement {

    /**
     * Main method that runs the stock management program. Allows the user to
     * input data about purchased stocks and calculates the associated stock
     * values.
     *
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        // Launch the graphical user interface (DashboardClient)
        java.awt.EventQueue.invokeLater(() -> {
            // Start the JFrame of the UI
            new DashboardClient().setVisible(true);
        });
    }
}
