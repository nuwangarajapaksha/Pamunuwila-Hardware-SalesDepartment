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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author EZIO AUDITORY
 */
public class ProductModel {

    private Connection dbConnection;
    static Logger logger = Logger.getLogger(ProductModel.class.getName());

    public ProductModel() {
        dbConnection = database.DBConnection.getConnection();
    }

    public int getProductNo() {
        String query = "SELECT * FROM product ORDER BY product_no DESC LIMIT 1";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            int productNo = 0;
            while (rs.next()) {
                productNo = rs.getInt("product_no");
                logger.debug("return productNo");
                return productNo;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
        logger.debug("return 0");
        return 0;
    }

    public String registerProduct(String productNo, String name, int unitNo, String discount, String tax, String image, String description) {
        String query = "INSERT INTO product(product_no, product_name, product_image_url, product_description, unit_no, product_discount, product_tax, product_status)"
                + "VALUE(?,?,?,?,?,?,?,?)";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, productNo);
            psm.setString(2, name);
            psm.setString(3, image);
            psm.setString(4, description);
            psm.setInt(5, unitNo);
            psm.setString(6, discount);
            psm.setString(7, tax);
            psm.setInt(8, 1);
            psm.execute();
            logger.debug("Query execution done");    
            logger.debug("return result");
            return "Register Successful";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
            logger.error("return result");
            return "Register Error !";
        }
    }

    public String updateProduct(String productNo, String name, int unitNo, String discount, String tax) {
        String query = "UPDATE product SET product_name = ?, unit_no = ?, product_discount = ?, product_tax = ? "
                + "WHERE product_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, name);
            psm.setInt(2, unitNo);
            psm.setString(3, discount);
            psm.setString(4, tax);
            psm.setString(5, productNo);
            psm.execute();
            logger.debug("Query execution done");
            logger.debug("return result");
            return "Update Successful";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
            logger.error("return result");
            return "Update Error !";
        }
    }

    public String saveProduct(String productNo, String image, String description) {
        String query = "UPDATE product SET product_image_url = ?, product_description = ? WHERE product_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, image);
            psm.setString(2, description);
            psm.setString(3, productNo);
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

    public String removeProduct(String productNo) {
        String query = "UPDATE product SET product_status = ? WHERE product_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, 0);
            psm.setString(2, productNo);
            psm.execute();
            logger.debug("Query execution done");
            logger.debug("return result");
            return "Remove Successful";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
            logger.error("return result");
            return "Remove Error !";
        }
    }

    public void loadProductTable(String keyword, DefaultTableModel productTableModel) {
        String query = "SELECT * FROM product INNER JOIN unit "
                + "ON product.unit_no = unit.unit_no "
                + "WHERE (product_no LIKE ? OR product_name LIKE ?) AND product_status = ? ORDER BY product_no";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, "%" + keyword + "%");
            psm.setString(2, "%" + keyword + "%");
            psm.setInt(3, 1);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            productTableModel.setRowCount(0);
            while (rs.next()) {
                int productNo = rs.getInt("product_no");
                String productName = rs.getString("product_name");
                String image = rs.getString("product_image_url");

                ImageIcon ii = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(160, 100, Image.SCALE_SMOOTH));
                JLabel imageLable = new JLabel();
                imageLable.setIcon(ii);

                String description = rs.getString("product_description");
                String unitName = rs.getString("unit_name");
                double discount = rs.getDouble("product_discount");
                double tax = rs.getDouble("product_tax");
                rowData = new Object[]{productNo, productName, imageLable, description, unitName, discount, tax};
                productTableModel.addRow(rowData);
                logger.debug("loadProductTable [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

    public Object[] getSelectedProductData(int productNo) {
        String query = "SELECT * FROM product INNER JOIN unit ON product.unit_no = unit.unit_no WHERE product_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, productNo);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            while (rs.next()) {
                int productNoo = rs.getInt("product_no");
                String productName = rs.getString("product_name");
                String unitName = rs.getString("unit_name");
                double discount = rs.getDouble("product_discount");
                double tax = rs.getDouble("product_tax");
                String image = rs.getString("product_image_url");
                String description = rs.getString("product_description");
                rowData = new Object[]{productNoo, productName, unitName, discount, tax, image, description};
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
}
