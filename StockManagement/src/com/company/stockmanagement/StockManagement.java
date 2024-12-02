package com.company.stockmanagement;

import com.company.stockmanagement.ui.DashboardClient;

public class StockManagement {

    public static void main(String[] args) {
        // Establecer el usuario actual antes de abrir la interfaz
        Usuario usuario = new Usuario("1", "Gabriel ");

        // Ahora lanzamos la interfaz pasándole el usuario
        java.awt.EventQueue.invokeLater(() -> {
            // Iniciar la interfaz y pasar el usuario
            new DashboardClient(usuario).setVisible(true);
        });
    }
}
