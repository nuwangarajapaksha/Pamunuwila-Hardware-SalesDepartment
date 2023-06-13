/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author EZIO AUDITORY
 */
public class CustomerModel {

    private Connection dbConnection;
    static Logger logger = Logger.getLogger(CustomerModel.class.getName());

    public CustomerModel() {
        dbConnection = database.DBConnection.getConnection();
    }
    
    public int getCustomerNo() {
        String query = "SELECT * FROM customer ORDER BY customer_no DESC LIMIT 1";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            int customerNo = 0;
            while (rs.next()) {
                customerNo = rs.getInt("customer_no");
                logger.debug("return customerNo");
                return customerNo;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
        logger.debug("return 0");
        return 0;
    }
    
    public String registerCustomer(String customerNo, String name, String nic, String email, String contactNo, String address, String city, int distictNo, int provinceNo, String gender) {
        String query = "INSERT INTO customer(customer_no, customer_name, customer_nic, customer_email, customer_contact_no, customer_address, customer_city, district_no, province_no, customer_gender, customer_status)"
                + "VALUE(?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug("SQL query String: " + query);
        
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, customerNo);
            psm.setString(2, name);
            psm.setString(3, nic);
            psm.setString(4, email);
            psm.setString(5, contactNo);
            psm.setString(6, address);
            psm.setString(7, city);
            psm.setInt(8, distictNo);
            psm.setInt(9, provinceNo);
            psm.setString(10, gender);
            psm.setInt(11, 1);
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

    public String updateCustomer(String customerNo, String name, String nic, String email, String contactNo, String address, String city, int distictNo, int provinceNo, String gender) {
        String query = "UPDATE customer SET customer_name = ?, customer_nic = ?, customer_email = ?, customer_contact_no = ?, customer_address = ?, customer_city = ?, "
                + "district_no = ?, province_no = ?, customer_gender = ? WHERE customer_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, name);
            psm.setString(2, nic);
            psm.setString(3, email);
            psm.setString(4, contactNo);
            psm.setString(5, address);
            psm.setString(6, city);
            psm.setInt(7, distictNo);
            psm.setInt(8, provinceNo);
            psm.setString(9, gender);
            psm.setString(10, customerNo);
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

    public String removeCustomer(String customerNo) {
        String query = "UPDATE customer SET customer_status = ? WHERE customer_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, 0);
            psm.setString(2, customerNo);
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

    public void loadCustomerTable(String keyword, DefaultTableModel customerTableModel) {
        String query = "SELECT * FROM customer INNER JOIN district INNER JOIN province "
                + "ON customer.district_no = district.district_no AND customer.province_no = province.province_no "
                + "WHERE (customer_no LIKE ? OR customer_name LIKE ? OR customer_nic LIKE ? OR customer_contact_no LIKE ? OR customer_city LIKE ?) AND customer_status = ? ORDER BY customer_no";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, "%" + keyword + "%");
            psm.setString(2, "%" + keyword + "%");
            psm.setString(3, "%" + keyword + "%");
            psm.setString(4, "%" + keyword + "%");
            psm.setString(5, "%" + keyword + "%");
            psm.setInt(6, 1);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            customerTableModel.setRowCount(0);
            while (rs.next()) {
                int customerNo = rs.getInt("customer_no");
                String name = rs.getString("customer_name");
                String nic = rs.getString("customer_nic");
                String email = rs.getString("customer_email");
                String contactNo = rs.getString("customer_contact_no");
                String address = rs.getString("customer_address");
                String city = rs.getString("customer_city");
                String district = rs.getString("district_name");
                String province = rs.getString("province_name");
                String gender = rs.getString("customer_gender");
                rowData = new Object[]{customerNo, name, nic, email, contactNo, address, city, district, province, gender};
                customerTableModel.addRow(rowData);
                logger.debug("loadCustomerTable [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

    public Object[] getSelectedCustomerData(int customerNo) {
        String query = "SELECT * FROM customer WHERE customer_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, customerNo);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            while (rs.next()) {
                int customerNoo = rs.getInt("customer_no");
                String name = rs.getString("customer_name");
                String nic = rs.getString("customer_nic");
                String email = rs.getString("customer_email");
                String contactNo = rs.getString("customer_contact_no");
                String address = rs.getString("customer_address");
                String city = rs.getString("customer_city");
                int districtNo = rs.getInt("district_no");
                int provinceNo = rs.getInt("province_no");
                String gender = rs.getString("customer_gender");
                rowData = new Object[]{customerNoo,name,nic,email,contactNo,address,city,districtNo,provinceNo,gender};
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
