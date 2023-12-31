/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import model.StockModel;
import org.apache.log4j.Logger;

/**
 *
 * @author EZIO AUDITORY
 */


public class LoadStockDialog extends javax.swing.JDialog {

    /**
     * Creates new form LoadProductDialog
     */
    private StockModel stockModel;
    static Logger logger = Logger.getLogger(LoadStockDialog.class.getName());
    DefaultTableModel stockTableModel;

    String stockNoo = "Select Stock";
    int productNoo;
    String productName;
    double availableQty;
    String productUnitName = "Number";
    double stockUnitSellPrice;
    double productDiscount;
    double productTax;

    public LoadStockDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        logger.debug("Access to LoadStockDialog.java");

        stockTableSettings(stockTable);

        stockTableModel = (DefaultTableModel) stockTable.getModel();
        stockModel = new StockModel();

        loadStockTable("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        keywordField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Select Stock");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Select Stock", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N
        jPanel3.setToolTipText("");

        keywordField.setForeground(new java.awt.Color(153, 153, 153));
        keywordField.setText("Search");
        keywordField.setToolTipText("Search");
        keywordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                keywordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                keywordFieldFocusLost(evt);
            }
        });
        keywordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keywordFieldKeyReleased(evt);
            }
        });

        stockTable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        stockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock No", "Product No", "Product Name", "Image", "Description ", "Available Qty", "Unit", "Unit Sell Price", "Discount", "Tax"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stockTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(stockTable);
        if (stockTable.getColumnModel().getColumnCount() > 0) {
            stockTable.getColumnModel().getColumn(0).setMinWidth(100);
            stockTable.getColumnModel().getColumn(0).setMaxWidth(100);
            stockTable.getColumnModel().getColumn(1).setMinWidth(100);
            stockTable.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 1003, Short.MAX_VALUE)
                        .addComponent(keywordField, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(keywordField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1530, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void keywordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_keywordFieldFocusGained
        if (keywordField.getText().equals("Search")) {
            keywordField.setText("");
            keywordField.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_keywordFieldFocusGained

    private void keywordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_keywordFieldFocusLost
        // TODO add your handling code here:
        if (keywordField.getText().equals("")) {
            keywordField.setText("Search");
            keywordField.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_keywordFieldFocusLost

    private void keywordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keywordFieldKeyReleased
        // TODO add your handling code here:
        String keyword = keywordField.getText();
        logger.debug("Search stock data");
        loadStockTable(keyword);
    }//GEN-LAST:event_keywordFieldKeyReleased

    private void stockTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockTableMouseClicked
        // TODO add your handling code here:
        int row = stockTable.getSelectedRow();
        int stockNo = (int) stockTableModel.getValueAt(row, 0);
        Object[] stockData = stockModel.getSelectedStockData(stockNo);

        stockNoo =  new String(stockData[0]+"");
        productNoo = (int) stockData[1];
        productName = (String) stockData[2];
        availableQty = (double) stockData[3];
        productUnitName = (String) stockData[4];
        stockUnitSellPrice = (double) stockData[5];
        productDiscount = (double) stockData[6];
        productTax = (double) stockData[7];
        logger.debug("Assign values to variables");
        this.dispose();
        logger.debug("LoadStockDialog.java Dispose");
    }//GEN-LAST:event_stockTableMouseClicked

    public void stockTableSettings(JTable jtable) {
        jtable.setRowHeight(100);
        jtable.getColumn("Image").setCellRenderer(new StockTableRenderer());
        jtable.getColumnModel().getColumn(0).setPreferredWidth(100);
    }

    Object[] getStockData() {
        Object[] rowdata = new Object[]{stockNoo, productNoo, productName, availableQty, productUnitName, stockUnitSellPrice, productDiscount, productTax};
        logger.debug("return rowData");
        return rowdata;
    }
    
    public void loadStockTable(String Keyword){
        stockModel.loadStockTable(Keyword, stockTableModel);
        logger.debug("Load stock table");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            UIManager.put("Table.showHorizontalLines", true);
            UIManager.put("Table.showVerticalLines", true);
            UIManager.put("ScrollBar.showButtons", true);
            UIManager.put("ScrollBar.width", 16);
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(LoadProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LoadProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LoadProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LoadProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoadStockDialog dialog = new LoadStockDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField keywordField;
    private javax.swing.JTable stockTable;
    // End of variables declaration//GEN-END:variables

}
