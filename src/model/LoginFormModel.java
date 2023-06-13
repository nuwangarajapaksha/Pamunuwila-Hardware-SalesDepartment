/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.log4j.Logger;

/**
 *
 * @author EZIO AUDITORY
 */
public class LoginFormModel {

    private Connection dbConnection;
    static Logger logger = Logger.getLogger(LoginFormModel.class.getName());

    public LoginFormModel() {
        dbConnection = database.DBConnection.getConnection();
    }

    public Object[] getUserData(String username, String password) {
        String query = "SELECT * FROM user INNER JOIN jobrole ON user.jobrole_no = jobrole.jobrole_no WHERE user_username = ? AND user_status = ?";
        logger.debug("SQL query String: " + query);
        
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, username);
            psm.setInt(2, 1);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            
            Object[] rowData = null;
            int logingStatus = 0;
            int userNo = 0;
            String usernameChecked = null;
            String passwordChecked = null;
            int jobroleNo = 0;
            String jobroleName = null;

            while (rs.next()) {
                userNo = rs.getInt("user_no");
                usernameChecked = rs.getString("user_username");
                passwordChecked = rs.getString("user_password");
                jobroleNo = rs.getInt("user.jobrole_no");
                jobroleName = rs.getString("jobrole_name");
                
                logger.debug("Check validation of username & password");
                if (usernameChecked.equals(username) && passwordChecked.equals(password)) {
                    logingStatus = 1;
                } else {
                    logingStatus = 2;
                }
                logger.debug("Set login status");
            }
            rowData = new Object[]{logingStatus, userNo, usernameChecked, jobroleNo, jobroleName};
            logger.debug("return rowData");
            return rowData;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
        logger.debug("return null");
        return null;
    }

}
