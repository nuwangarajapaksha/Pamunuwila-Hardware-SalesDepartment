/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author EZIO AUDITORY
 */
public class GrnModel {

    private Connection dbConnection;
    static Logger logger = Logger.getLogger(GrnModel.class.getName());

    public GrnModel() {
        dbConnection = database.DBConnection.getConnection();
    }

    public int getGrnNo() {
        String query = "SELECT * FROM grn ORDER BY grn_no DESC LIMIT 1";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            int grnNo = 0;
            while (rs.next()) {
                grnNo = rs.getInt("grn_no");
                logger.debug("return grnNo");
                return grnNo;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
        logger.debug("return 0");
        return 0;
    }

    public String saveGrn(String grnNo, Date grnDate, int supplierNo, String itemCount, String totalDiscount, String totalVat, String totalAmount) {
        String query = "INSERT INTO grn(grn_no, grn_date, supplier_no, grn_item_count, grn_discount, grn_vat, grn_amount)"
                + "VALUE(?,?,?,?,?,?,?)";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, grnNo);
            psm.setDate(2, new java.sql.Date(grnDate.getTime()));
            psm.setInt(3, supplierNo);
            psm.setString(4, itemCount);
            psm.setString(5, totalDiscount);
            psm.setString(6, totalVat);
            psm.setString(7, totalAmount);
            psm.execute();
            logger.debug("Query execution done");
            logger.debug("return result");
            return "Save Successful";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
            logger.error("return result");
            return "Save Error !";
        }
    }

    public String saveGrnItem(int productNo, double unitSellPrice, double qty, double unitBuyPrice, double discount, double vat, double amount, String grnNo) {
        String query = "INSERT INTO grn_item(product_no, grn_item_quantity, grn_item_unit_buy_price, grn_item_discount, grn_item_vat, grn_item_amount, grn_no) VALUE(?,?,?,?,?,?,?)";
        logger.debug("SQL query String: " + query);
        
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, productNo);
            psm.setDouble(2, qty);
            psm.setDouble(3, unitBuyPrice);
            psm.setDouble(4, discount);
            psm.setDouble(5, vat);
            psm.setDouble(6, amount);
            psm.setString(7, grnNo);
            psm.execute();
            logger.debug("Query execution done");        
            logger.debug("return result");
            return "Save Successful";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
            logger.error("return result");
            return "Save Error !";
        }
    }
    
    public String updateStock(Date grnDate, int productNo, double qty, double unitSellPrice) {
        String query = "INSERT INTO stock(stock_date, product_no, stock_quantity, stock_unit_sell_price, stock_last_update, stock_status) VALUE(?,?,?,?,?,?)";
        logger.debug("SQL query String: " + query);
        
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setDate(1, new java.sql.Date(grnDate.getTime()));
            psm.setDouble(2, productNo);
            psm.setDouble(3, qty);
            psm.setDouble(4, unitSellPrice);
            psm.setDate(5, new java.sql.Date(grnDate.getTime()));
            psm.setInt(6, 1);
            psm.execute();
            logger.debug("Query execution done");
            logger.debug("return result");
            return "Save Successful";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
            logger.error("return result");
            return "Save Error !";
        }
    }

    public void loadGrnHistoryTable(String keyword, DefaultTableModel grnHistoryTableModel) {
        String query = "SELECT * FROM grn INNER JOIN supplier "
                + "ON grn.supplier_no = supplier.supplier_no "
                + "WHERE grn_no LIKE ? OR grn_date LIKE ? OR supplier_name LIKE ? ORDER BY grn_no";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, "%" + keyword + "%");
            psm.setString(2, "%" + keyword + "%");
            psm.setString(3, "%" + keyword + "%");
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            grnHistoryTableModel.setRowCount(0);
            while (rs.next()) {
                int grnNo = rs.getInt("grn_no");
                Date date = rs.getDate("grn_date");
                String supplierName = rs.getString("supplier_name");
                int itemCount = rs.getInt("grn_item_count");
                double totatlDiscount = rs.getDouble("grn_discount");
                double totatlVat = rs.getDouble("grn_vat");
                double totatlAmount = rs.getDouble("grn_amount");
                rowData = new Object[]{grnNo, date, supplierName, itemCount, totatlDiscount, totatlVat, totatlAmount};
                grnHistoryTableModel.addRow(rowData);
                logger.debug("grnHistoryTable [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

}
