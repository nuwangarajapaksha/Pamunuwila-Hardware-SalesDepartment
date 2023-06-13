/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.SupplierModel;
import org.apache.log4j.Logger;

/**
 *
 * @author EZIO AUDITORY
 */
public class LoadSupplierDialog extends javax.swing.JDialog {

    /**
     * Creates new form LoadSupplierDialog
     */
    private SupplierModel supplierModel;
    static Logger logger = Logger.getLogger(LoadSupplierDialog.class.getName());
    DefaultTableModel supplierTableModel;
    
    int supplierNoo;
    String supplierName = "Select Supplier";

    public LoadSupplierDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        logger.debug("Access to LoadSupplierDialog.java");
        
        supplierTableModel = (DefaultTableModel) supplierTable.getModel();
        supplierModel = new SupplierModel();
        
        loadSupplierTable("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        supplierTable = new javax.swing.JTable();
        keywordField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Select Supplier");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Suppliers", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        supplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "NIC", "Email", "Contact No", "Address", "City", "District", "Province", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        supplierTable.setRowHeight(25);
        supplierTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplierTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(supplierTable);
        if (supplierTable.getColumnModel().getColumnCount() > 0) {
            supplierTable.getColumnModel().getColumn(0).setMinWidth(60);
            supplierTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            supplierTable.getColumnModel().getColumn(1).setMinWidth(150);
            supplierTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            supplierTable.getColumnModel().getColumn(2).setMinWidth(120);
            supplierTable.getColumnModel().getColumn(2).setPreferredWidth(120);
            supplierTable.getColumnModel().getColumn(3).setMinWidth(160);
            supplierTable.getColumnModel().getColumn(3).setPreferredWidth(160);
            supplierTable.getColumnModel().getColumn(4).setMinWidth(100);
            supplierTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            supplierTable.getColumnModel().getColumn(5).setMinWidth(200);
            supplierTable.getColumnModel().getColumn(5).setPreferredWidth(200);
            supplierTable.getColumnModel().getColumn(6).setMinWidth(110);
            supplierTable.getColumnModel().getColumn(6).setPreferredWidth(110);
            supplierTable.getColumnModel().getColumn(7).setMinWidth(110);
            supplierTable.getColumnModel().getColumn(7).setPreferredWidth(110);
            supplierTable.getColumnModel().getColumn(8).setMinWidth(110);
            supplierTable.getColumnModel().getColumn(8).setPreferredWidth(110);
            supplierTable.getColumnModel().getColumn(9).setMinWidth(60);
            supplierTable.getColumnModel().getColumn(9).setPreferredWidth(60);
        }

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(keywordField, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1288, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(keywordField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1346, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void keywordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_keywordFieldFocusGained
        // TODO add your handling code here:
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
        logger.debug("Search supplier data");
        loadSupplierTable(keyword);
    }//GEN-LAST:event_keywordFieldKeyReleased

    private void supplierTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierTableMouseClicked
        // TODO add your handling code here:
        int row = supplierTable.getSelectedRow();
        int supplierNo = (int) supplierTableModel.getValueAt(row, 0);
        Object[] supplierData = supplierModel.getSelectedSupplierData(supplierNo);

        supplierNoo = (int) supplierData[0];
        supplierName = (String) supplierData[1];
        logger.debug("Assign values to variables");
        this.dispose();
        logger.debug("LoadSupplierDialog.java Dispose");
    }//GEN-LAST:event_supplierTableMouseClicked
    
    Object[] getSupplierData() {
       Object[] rowdata = new Object[]{supplierNoo,supplierName};
       logger.debug("return rowData");
       return rowdata;
    }
    
    private void loadSupplierTable(String keyword){
        supplierModel.loadSupplierTable(keyword, supplierTableModel);
        logger.debug("Load supplier table");
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
//            java.util.logging.Logger.getLogger(LoadSupplierDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LoadSupplierDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LoadSupplierDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LoadSupplierDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoadSupplierDialog dialog = new LoadSupplierDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField keywordField;
    private javax.swing.JTable supplierTable;
    // End of variables declaration//GEN-END:variables

    
}
