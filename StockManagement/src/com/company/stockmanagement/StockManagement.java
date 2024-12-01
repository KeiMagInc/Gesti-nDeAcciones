package com.company.stockmanagement;

import com.company.stockmanagement.ui.DashboardClient;
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
        // Lanza la interfaz gráfica de usuario (DashboardClient)
        java.awt.EventQueue.invokeLater(() -> {
            // Inicia el JFrame de la UI
            new DashboardClient().setVisible(true);
        });
}
}