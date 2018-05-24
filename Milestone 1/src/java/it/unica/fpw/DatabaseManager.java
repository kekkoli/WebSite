/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.fpw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kekko
 */
public class DatabaseManager {
    /*Questa classe serve per gestire le connessioni dal database*/
    
    
    private static DatabaseManager instance;
    private String url;

    private DatabaseManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public Connection getConnection() {
        String db = "jdbc:mysql://ec2-52-47-198-123.eu-west-3.compute.amazonaws.com:443/fpw18_ligasfrancesco?zeroDateTimeBehavior=convertToNull";

        try {
            Connection conn = (Connection) DriverManager.getConnection(db, "fpw18_ligasfrancesco", "kekkoli");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
