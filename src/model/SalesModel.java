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
public class SalesModel {

    private Connection dbConnection;
    static Logger logger = Logger.getLogger(SalesModel.class.getName());

    public SalesModel() {
        dbConnection = database.DBConnection.getConnection();
    }

    public int getInvoiceNo() {
        String query = "SELECT * FROM customer_invoice ORDER BY customer_invoice_no DESC LIMIT 1";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            int invoiceNo = 0;
            while (rs.next()) {
                invoiceNo = rs.getInt("customer_invoice_no");
                logger.debug("return invoiceNo");
                return invoiceNo;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
        logger.debug("return 0");
        return 0;
    }

    public String saveInvoice(String invoiceNo, Date invoiceDate, int customerNo, String itemCount, String totalDiscount, String totalTax, String totalAmount) {
        String query = "INSERT INTO customer_invoice(customer_invoice_no, customer_invoice_date, customer_no, customer_invoice_item_count, customer_invoice_discount, customer_invoice_tax, customer_invoice_amount)"
                + "VALUE(?,?,?,?,?,?,?)";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, invoiceNo);
            psm.setDate(2, new java.sql.Date(invoiceDate.getTime()));
            psm.setInt(3, customerNo);
            psm.setString(4, itemCount);
            psm.setString(5, totalDiscount);
            psm.setString(6, totalTax);
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

    public String saveSales(int productNo, double qty, double unitSellPrice, double discount, double tax, double amount, String invoiceNo) {
        String query = "INSERT INTO sales(product_no, sales_quantity, sales_unit_sell_price, sales_discount, sales_tax, sales_amount, customer_invoice_no) VALUE(?,?,?,?,?,?,?)";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, productNo);
            psm.setDouble(2, qty);
            psm.setDouble(3, unitSellPrice);
            psm.setDouble(4, discount);
            psm.setDouble(5, tax);
            psm.setDouble(6, amount);
            psm.setString(7, invoiceNo);
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

    public String updateStock(int stockNo, double qty, Date invoiceDate) {
        String query1 = "SELECT * FROM stock WHERE stock_no = ?";
        String query2 = "UPDATE stock SET stock_quantity = ?, stock_last_update = ? WHERE stock_no = ?";
        String query3 = "UPDATE stock SET stock_quantity = ?, stock_last_update = ?, stock_status = ? WHERE stock_no = ?";
        logger.debug("SQL query String: " + query1);
        logger.debug("SQL query String: " + query2);
        logger.debug("SQL query String: " + query3);
        try {
            PreparedStatement psm1 = dbConnection.prepareStatement(query1);
            psm1.setInt(1, stockNo);
            ResultSet rs = psm1.executeQuery();
            logger.debug("Query1 execution done");
            double availableQty = 0;
            while (rs.next()) {
                availableQty = rs.getDouble("stock_quantity") - qty;
            }
            if (availableQty != 0) {
                PreparedStatement psm2 = dbConnection.prepareStatement(query2);
                psm2.setDouble(1, availableQty);
                psm2.setDate(2, new java.sql.Date(invoiceDate.getTime()));
                psm2.setInt(3, stockNo);
                psm2.execute();
                logger.debug("Query2 execution done");
            } else {
                PreparedStatement psm3 = dbConnection.prepareStatement(query3);
                psm3.setDouble(1, availableQty);
                psm3.setDate(2, new java.sql.Date(invoiceDate.getTime()));
                psm3.setInt(3, 0);
                psm3.setInt(4, stockNo);
                psm3.execute();
                logger.debug("Query3 execution done");
            }     
            logger.debug("return result");
            return "Save Successful";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
            logger.error("return result");
            return "Save Error !";
        }
    }

    public double getAvailableStockQty(String stockNo) {
        String query = "SELECT * FROM stock WHERE stock_no = ?";
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, stockNo);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query1 execution done");
            while (rs.next()) {
                double availableStockQty = rs.getDouble("stock_quantity");
                logger.debug("return available stock qty");
                return availableStockQty;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
        logger.debug("return 0");
        return 0;
    }

    public void loadInvoiceHistoryTable(String keyword, DefaultTableModel invoiceHistoryTableModel) {
        String query = "SELECT * FROM customer_invoice INNER JOIN customer "
                + "ON customer_invoice.customer_no = customer.customer_no "
                + "WHERE customer_invoice_no LIKE ? OR customer_invoice_date LIKE ? OR customer_name LIKE ? ORDER BY customer_invoice_no";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, "%" + keyword + "%");
            psm.setString(2, "%" + keyword + "%");
            psm.setString(3, "%" + keyword + "%");
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            invoiceHistoryTableModel.setRowCount(0);
            while (rs.next()) {
                int invoiceNo = rs.getInt("customer_invoice_no");
                Date date = rs.getDate("customer_invoice_date");
                String customerName = rs.getString("customer_name");
                int itemCount = rs.getInt("customer_invoice_item_count");
                double totatlDiscount = rs.getDouble("customer_invoice_discount");
                double totatlTax = rs.getDouble("customer_invoice_tax");
                double totatlAmount = rs.getDouble("customer_invoice_amount");
                rowData = new Object[]{invoiceNo, date, customerName, itemCount, totatlDiscount, totatlTax, totatlAmount};
                invoiceHistoryTableModel.addRow(rowData);
                logger.debug("loadInvoiceHistoryTable [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }
}
