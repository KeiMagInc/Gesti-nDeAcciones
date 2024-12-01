/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.company.stockmanagement.ui;

import com.company.stockmanagement.AlphaVantageAPI;
import com.company.stockmanagement.StockController;
import com.company.stockmanagement.StockDashboard;
import com.company.stockmanagement.StockData;
import com.company.stockmanagement.StockValidator;
import com.company.stockmanagement.StockValue;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saidl
 */
public class DashboardClient extends javax.swing.JFrame {

    /**
     * Creates new form dashboardClient
     */
    // Declaración de la variable controller como una variable de instancia
    private StockController controller;
    private AlphaVantageAPI api;

    public DashboardClient() {
        initComponents();
        // Inicializamos el controlador con la vista (DashboardClient) y la clave de la API
        String apiKey = "70QX4UDI1NSM2LKD"; // Clave de API
        controller = new StockController(this, apiKey);
        this.api = new AlphaVantageAPI(apiKey);
    }

    public void updateTable(String symbol, int quantity, String purchaseDate, double purchasePrice,
            double currentPrice, StockValue stockValues) {
        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Crear un array con los datos de la nueva fila
        Object[] newRow = new Object[]{
            symbol,
            quantity,
            purchaseDate,
            purchasePrice,
            currentPrice,
            stockValues.getUnitGain(),
            stockValues.getUnitPercentage(),
            stockValues.getTotalBalance(),
            stockValues.getTotalGain()
        };

        // Insertar la fila al principio (índice 0)
        model.insertRow(0, newRow);

        // Actualizar la vista de la tabla
        jTable1.setModel(model);

        //Mostrar mensaje de que se guardo la accion
        javax.swing.JOptionPane.showMessageDialog(this, "Successfully saved");
    }

    // Método para actualizar los valores de la tabla
    private void refreshTable() {
        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            // Obtener los valores de las columnas de cada fila, comenzando desde la columna 4
            String symbol = model.getValueAt(i, 0) != null ? model.getValueAt(i, 0).toString() : "";
            int quantity = model.getValueAt(i, 1) != null ? Integer.parseInt(model.getValueAt(i, 1).toString()) : 0;
            String purchaseDate = model.getValueAt(i, 2) != null ? model.getValueAt(i, 2).toString() : "";
            double purchasePrice = model.getValueAt(i, 3) != null ? Double.parseDouble(model.getValueAt(i, 3).toString()) : 0.0;

            try {
                if (api == null) {
                    javax.swing.JOptionPane.showMessageDialog(this, "API not initialized.");
                    return;
                }

                // Obtener el precio actual de la acción usando la API
                double currentPrice = api.obtenerPrecioActual(symbol);

                // Verificar que el precio actual no sea -1 (indicación de error en la API)
                if (currentPrice == -1) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Error retrieving current price for " + symbol);
                    continue;  // Si no se pudo obtener el precio, salta a la siguiente fila
                }

                // Calcular los valores de la acción
                StockValue stockValues = StockDashboard.calculateStockValues(purchasePrice, currentPrice, quantity);

                // Actualizar los valores de la tabla desde la columna 4 en adelante
                model.setValueAt(currentPrice, i, 4);  // Columna de precio actual
                model.setValueAt(stockValues.getUnitGain(), i, 5);  // Columna de ganancia por unidad
                model.setValueAt(stockValues.getUnitPercentage(), i, 6);  // Columna de porcentaje de ganancia
                model.setValueAt(stockValues.getTotalBalance(), i, 7);  // Columna de saldo total
                model.setValueAt(stockValues.getTotalGain(), i, 8);  // Columna de ganancia total

                // Actualizar la vista de la tabla
                jTable1.setModel(model);
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error updating the table: " + e.getMessage());
            }
        }

        // Mostrar mensaje de que la tabla se actualizó
        javax.swing.JOptionPane.showMessageDialog(this, "Table successfully updated");
    }

    // Método para mostrar mensajes de error
    public void showError(String message) {
        javax.swing.JOptionPane.showMessageDialog(this, message);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new javax.swing.JPanel();
        txtStockManager = new javax.swing.JLabel();
        actionInfo = new javax.swing.JPanel();
        txtWelcome = new javax.swing.JLabel();
        txtRegister = new javax.swing.JLabel();
        txtSymnol = new javax.swing.JLabel();
        comboBoxSymbol = new javax.swing.JComboBox<>();
        txtPurchasePrice = new javax.swing.JLabel();
        txtFPurchasePrice = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JLabel();
        txtFQuantity = new javax.swing.JTextField();
        txtPurchaseDate = new javax.swing.JLabel();
        txtFPurchaseDate = new javax.swing.JTextField();
        btnSaveAction = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));

        panelHeader.setBackground(new java.awt.Color(255, 255, 255));

        txtStockManager.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        txtStockManager.setText("STOCK MANAGER");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtStockManager, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(txtStockManager, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        actionInfo.setBackground(new java.awt.Color(255, 255, 255));

        txtWelcome.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txtWelcome.setText("Welcome");

        txtRegister.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtRegister.setText("Stock register");

        txtSymnol.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtSymnol.setText("Symbol:");

        comboBoxSymbol.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboBoxSymbol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AAPL", "AMZN", "MSFT", " " }));

        txtPurchasePrice.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtPurchasePrice.setText("Purchase price:");

        txtFPurchasePrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFPurchasePriceActionPerformed(evt);
            }
        });

        txtQuantity.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtQuantity.setText("Quantity:");

        txtPurchaseDate.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtPurchaseDate.setText("Purchase date:");

        txtFPurchaseDate.setText("dd/mm/yyyy");

        btnSaveAction.setBackground(new java.awt.Color(0, 153, 255));
        btnSaveAction.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnSaveAction.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveAction.setText("Save");
        btnSaveAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("My Stock");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Stock Name", "Quantity", "Purchase Date", "Purchase Price", "Current Price", "Unit Gain", "Unit Percentage", "Total Balance", "Total Gain"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout actionInfoLayout = new javax.swing.GroupLayout(actionInfo);
        actionInfo.setLayout(actionInfoLayout);
        actionInfoLayout.setHorizontalGroup(
            actionInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionInfoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(actionInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(actionInfoLayout.createSequentialGroup()
                        .addGroup(actionInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSaveAction, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRegister)
                            .addComponent(txtWelcome)
                            .addGroup(actionInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(actionInfoLayout.createSequentialGroup()
                                    .addComponent(txtPurchasePrice)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFPurchasePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(actionInfoLayout.createSequentialGroup()
                                    .addComponent(txtSymnol)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboBoxSymbol, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(actionInfoLayout.createSequentialGroup()
                                    .addGroup(actionInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(actionInfoLayout.createSequentialGroup()
                                            .addComponent(txtQuantity)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, actionInfoLayout.createSequentialGroup()
                                            .addComponent(txtPurchaseDate)
                                            .addGap(48, 48, 48)))
                                    .addGroup(actionInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtFQuantity)
                                        .addComponent(txtFPurchaseDate, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(actionInfoLayout.createSequentialGroup()
                        .addGroup(actionInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(actionInfoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(785, 785, 785)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 927, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 41, Short.MAX_VALUE))))
        );
        actionInfoLayout.setVerticalGroup(
            actionInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionInfoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtWelcome)
                .addGap(18, 18, 18)
                .addComponent(txtRegister)
                .addGap(18, 18, 18)
                .addGroup(actionInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSymnol)
                    .addComponent(comboBoxSymbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(actionInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPurchasePrice)
                    .addComponent(txtFPurchasePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(actionInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantity)
                    .addComponent(txtFQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(actionInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPurchaseDate)
                    .addComponent(txtFPurchaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSaveAction)
                .addGap(26, 26, 26)
                .addGroup(actionInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(actionInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actionInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFPurchasePriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFPurchasePriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFPurchasePriceActionPerformed

    private void btnSaveActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionActionPerformed
        // Obtener los valores ingresados por el usuario
        String symbol = comboBoxSymbol.getSelectedItem().toString();
        String purchasePriceText = txtFPurchasePrice.getText();
        String quantityText = txtFQuantity.getText();
        String purchaseDateText = txtFPurchaseDate.getText();

        // Crear un StringBuilder para acumular errores
        StringBuilder errores = new StringBuilder();

        // Validar los valores ingresados y acumular errores si existen
        double purchasePrice = StockValidator.validarDecimalPositivo(purchasePriceText, errores);
        int quantity = StockValidator.validarEnteroPositivo(quantityText, errores);
        String purchaseDate = StockValidator.validarFecha(purchaseDateText, errores);

        // Si hay errores, mostrar el mensaje acumulado
        if (errores.length() > 0) {
            JOptionPane.showMessageDialog(this, "Errores encontrados:\n" + errores.toString());
        } else {
            // Si todos los valores son válidos, proceder con el controlador
            controller.processStockData(symbol, purchasePrice, quantity, purchaseDate);
        }
    }//GEN-LAST:event_btnSaveActionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        refreshTable();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionInfo;
    private javax.swing.JButton btnSaveAction;
    private javax.swing.JComboBox<String> comboBoxSymbol;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JTextField txtFPurchaseDate;
    private javax.swing.JTextField txtFPurchasePrice;
    private javax.swing.JTextField txtFQuantity;
    private javax.swing.JLabel txtPurchaseDate;
    private javax.swing.JLabel txtPurchasePrice;
    private javax.swing.JLabel txtQuantity;
    private javax.swing.JLabel txtRegister;
    private javax.swing.JLabel txtStockManager;
    private javax.swing.JLabel txtSymnol;
    private javax.swing.JLabel txtWelcome;
    // End of variables declaration//GEN-END:variables

}
