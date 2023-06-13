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
public class SupplierModel {

    private Connection dbConnection;
    static Logger logger = Logger.getLogger(SupplierModel.class.getName());

    public SupplierModel() {
        dbConnection = database.DBConnection.getConnection();
    }
    
    public int getSupplierNo() {
        String query = "SELECT * FROM supplier ORDER BY supplier_no DESC LIMIT 1";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            int supplierNo = 0;
            while (rs.next()) {
                supplierNo = rs.getInt("supplier_no");
                logger.debug("return supplierNo");
                return supplierNo;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
        logger.debug("return 0");
        return 0;
    }
    
    public String registerSupplier(String supplierNo, String name, String nic, String email, String contactNo, String address, String city, int distictNo, int provinceNo, String gender) {
        String query = "INSERT INTO supplier(supplier_no, supplier_name, supplier_nic, supplier_email, supplier_contact_no, supplier_address, supplier_city, district_no, province_no, supplier_gender, supplier_status)"
                + "VALUE(?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, supplierNo);
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

    public String updateSupplier(String supplierNo, String name, String nic, String email, String contactNo, String address, String city, int distictNo, int provinceNo, String gender) {
        String query = "UPDATE supplier SET supplier_name = ?, supplier_nic = ?, supplier_email = ?, supplier_contact_no = ?, supplier_address = ?, supplier_city = ?, "
                + "district_no = ?, province_no = ?, supplier_gender = ? WHERE supplier_no = ?";
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
            psm.setString(10, supplierNo);
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

    public String removeSupplier(String supplierNo) {
        String query = "UPDATE supplier SET supplier_status = ? WHERE supplier_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, 0);
            psm.setString(2, supplierNo);
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

    public void loadSupplierTable(String keyword, DefaultTableModel supplierTableModel) {
        String query = "SELECT * FROM supplier INNER JOIN district INNER JOIN province "
                + "ON supplier.district_no = district.district_no AND supplier.province_no = province.province_no "
                + "WHERE (supplier_no LIKE ? OR supplier_name LIKE ? OR supplier_nic LIKE ? OR supplier_contact_no LIKE ? OR supplier_city LIKE ?) AND supplier_status = ? ORDER BY supplier_no";
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
            supplierTableModel.setRowCount(0);
            while (rs.next()) {
                int supplierNo = rs.getInt("supplier_no");
                String name = rs.getString("supplier_name");
                String nic = rs.getString("supplier_nic");
                String email = rs.getString("supplier_email");
                String contactNo = rs.getString("supplier_contact_no");
                String address = rs.getString("supplier_address");
                String city = rs.getString("supplier_city");
                String district = rs.getString("district_name");
                String province = rs.getString("province_name");
                String gender = rs.getString("supplier_gender");
                rowData = new Object[]{supplierNo, name, nic, email, contactNo, address, city, district, province, gender};
                supplierTableModel.addRow(rowData);
                logger.debug("loadSupplierTable [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

    public Object[] getSelectedSupplierData(int supplierNo) {
        String query = "SELECT * FROM supplier WHERE supplier_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, supplierNo);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            while (rs.next()) {
                int supplierNoo = rs.getInt("supplier_no");
                String name = rs.getString("supplier_name");
                String nic = rs.getString("supplier_nic");
                String email = rs.getString("supplier_email");
                String contactNo = rs.getString("supplier_contact_no");
                String address = rs.getString("supplier_address");
                String city = rs.getString("supplier_city");
                int districtNo = rs.getInt("district_no");
                int provinceNo = rs.getInt("province_no");
                String gender = rs.getString("supplier_gender");
                rowData = new Object[]{supplierNoo, name, nic, email, contactNo, address, city, districtNo, provinceNo, gender};
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
