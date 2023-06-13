/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.log4j.Logger;

/**
 *
 * @author EZIO AUDITORY
 */
public class DBConnection {
    
    static Logger logger = Logger.getLogger(DBConnection.class.getName());

    private static Connection dbConnection;

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3307/pamunuwila_hardware_salesdepartment_db?useSSL=false", "root", "ass34");
            logger.debug("Get database connection");
        } catch (Exception e) {
            dbConnection = null;
            logger.error("Exception: " + e.getMessage());
        }
        logger.debug("return dbConnection");
        return dbConnection;
    }

//    public static void main(String[] args) {
//        try {
//            System.out.println(getConnection().getCatalog());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
