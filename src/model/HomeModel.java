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
import org.apache.log4j.Logger;

/**
 *
 * @author EZIO AUDITORY
 */
public class HomeModel {
    private Connection dbConnection;
    static Logger logger = Logger.getLogger(HomeModel.class.getName());

    public HomeModel() {
        dbConnection = database.DBConnection.getConnection();
    }
    
    public double getPurchaseAmount(){
       String query = "SELECT SUM(grn_amount) FROM grn" ;
       logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            double purchaseAmount = 0;
            while (rs.next()) {
                purchaseAmount = rs.getDouble("SUM(grn_amount)");
                logger.debug("return purchaseAmount");
                return purchaseAmount;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        } 
        logger.debug("return 0");
        return 0;
    }
    
    public double getSalesAmount(){
       String query = "SELECT SUM(customer_invoice_amount) FROM customer_invoice;" ;
       logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            double salesAmount = 0;
            while (rs.next()) {
                salesAmount = rs.getDouble("SUM(customer_invoice_amount)");
                logger.debug("return salesAmount");
                return salesAmount;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        } 
        logger.debug("return null");
        return 0;
    }
}
