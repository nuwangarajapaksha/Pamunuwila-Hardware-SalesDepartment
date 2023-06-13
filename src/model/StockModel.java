/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author EZIO AUDITORY
 */
public class StockModel {

    private Connection dbConnection;
    static Logger logger = Logger.getLogger(ProductModel.class.getName());

    public StockModel() {
        dbConnection = database.DBConnection.getConnection();
    }

    public void loadStockTable(String keyword, DefaultTableModel stockTableModel) {
        String query = "SELECT * FROM stock INNER JOIN product INNER JOIN unit "
                + "ON stock.product_no = product.product_no AND product.unit_no = unit.unit_no "
                + "WHERE (stock_no LIKE ? OR stock.product_no LIKE ? OR product_name LIKE ?) AND stock_status = ? ORDER BY stock_no";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, "%" + keyword + "%");
            psm.setString(2, "%" + keyword + "%");
            psm.setString(3, "%" + keyword + "%");
            psm.setInt(4, 1);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            stockTableModel.setRowCount(0);
            while (rs.next()) {
                int stockNo = rs.getInt("stock_no");
                int productNo = rs.getInt("stock.product_no");
                String productName = rs.getString("product_name");
                String image = rs.getString("product_image_url");

                ImageIcon ii = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(160, 100, Image.SCALE_SMOOTH));
                JLabel imageLable = new JLabel();
                imageLable.setIcon(ii);

                String description = rs.getString("product_description");
                double availableQty = rs.getDouble("stock_quantity");
                String unitName = rs.getString("unit_name");
                double stockUnitSellPrice = rs.getDouble("stock_unit_sell_price");
                double discount = rs.getDouble("product_discount");
                double tax = rs.getDouble("product_tax");
                rowData = new Object[]{stockNo, productNo, productName, imageLable, description, availableQty, unitName, stockUnitSellPrice, discount, tax};
                stockTableModel.addRow(rowData);
                logger.debug("loadStockTable [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

    public Object[] getSelectedStockData(int stockNo) {
        String query = "SELECT * FROM stock INNER JOIN product INNER JOIN unit ON stock.product_no = product.product_no AND product.unit_no = unit.unit_no WHERE stock_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, stockNo);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            while (rs.next()) {
                int stockNoo = rs.getInt("stock_no");
                int productNoo = rs.getInt("stock.product_no");
                String productName = rs.getString("product_name");
                double availableQty = rs.getDouble("stock_quantity");
                String unitName = rs.getString("unit_name");
                double stockUnitSellPrice = rs.getDouble("stock_unit_sell_price");
                double discount = rs.getDouble("product_discount");
                double tax = rs.getDouble("product_tax");
                rowData = new Object[]{stockNoo, productNoo, productName, availableQty, unitName, stockUnitSellPrice, discount, tax};
                logger.debug("return rowData");
                return rowData;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
        logger.debug("return null");
        return null;
    }

    public void loadStockTableMain(String keyword, DefaultTableModel stockTableModel) {
        String query = "SELECT * FROM stock INNER JOIN product INNER JOIN unit "
                + "ON stock.product_no = product.product_no AND product.unit_no = unit.unit_no "
                + "WHERE (stock_no LIKE ? OR stock_date LIKE ? OR stock.product_no LIKE ? OR product_name LIKE ?) AND stock_status = ? ORDER BY stock_no";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, "%" + keyword + "%");
            psm.setString(2, "%" + keyword + "%");
            psm.setString(3, "%" + keyword + "%");
            psm.setString(4, "%" + keyword + "%");
            psm.setInt(5, 1);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            stockTableModel.setRowCount(0);
            while (rs.next()) {
                int stockNo = rs.getInt("stock_no");
                Date stockDate = rs.getDate("stock_date");
                int productNo = rs.getInt("stock.product_no");
                String productName = rs.getString("product_name");
                String image = rs.getString("product_image_url");

                ImageIcon ii = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(160, 100, Image.SCALE_SMOOTH));
                JLabel imageLable = new JLabel();
                imageLable.setIcon(ii);

                String description = rs.getString("product_description");
                double availableQty = rs.getDouble("stock_quantity");
                String unitName = rs.getString("unit_name");
                double stockUnitSellPrice = rs.getDouble("stock_unit_sell_price");
                double discount = rs.getDouble("product_discount");
                double tax = rs.getDouble("product_tax");
                Date lastUpdate = rs.getDate("stock_last_update");
                rowData = new Object[]{stockNo, stockDate, productNo, productName, imageLable, description, availableQty, unitName, stockUnitSellPrice, discount, tax, lastUpdate};
                stockTableModel.addRow(rowData);
                logger.debug("loadStockTableMain [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

}
