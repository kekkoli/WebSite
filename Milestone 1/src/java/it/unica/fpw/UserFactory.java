/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.fpw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kekko
 */
public class UserFactory {

    private static UserFactory instance;
    private ArrayList<User> userList = new ArrayList<>();

    private UserFactory() {
    }

    public static UserFactory getInstance() {
        if (instance == null) {
            instance = new UserFactory();
        }
        return instance;
    }

    public User getUserById(int id)   {
        try {
            Connection conn = DatabaseManager.getInstance().getConnection();
            String sql = "select * from Users where id_user = ?";
            User userToReturn = new User();
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            ResultSet set = stmt.executeQuery();
            
            if (set.next()){
                userToReturn.setId(set.getInt("id_user"));
                userToReturn.setName(set.getString("name"));
                userToReturn.setSurname(set.getString("surname"));
                userToReturn.setEmail(set.getString("email"));
                userToReturn.setPassword(set.getString("password"));
                userToReturn.setUrlImagine(set.getString("urlProfImg"));
            }
            
            stmt.close();
            conn.close();
            
            return userToReturn;
        } catch (SQLException ex) {
            Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
}

    public boolean login(String email, String password) {
       try {
            Connection conn = DatabaseManager.getInstance().getConnection();
            String sql = "select * from Users where email = ? and password =?";
            Boolean loggedIn = false;
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1,email);
            stmt.setString(2,password);
            
            ResultSet set = stmt.executeQuery();
            
            loggedIn = set.next();

            
            stmt.close();
            conn.close();
            
            return loggedIn;
                    
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
    }

    public User getUserByEmail(String email) {
         try {
            Connection conn = DatabaseManager.getInstance().getConnection();
            String sql = "select * from Users where email = ?";
            User userToReturn = new User();
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, email);
            
            ResultSet set = stmt.executeQuery();
            
            if (set.next()){
                userToReturn.setId(set.getInt("id_user"));
                userToReturn.setName(set.getString("name"));
                userToReturn.setSurname(set.getString("surname"));
                userToReturn.setEmail(set.getString("email"));
                userToReturn.setPassword(set.getString("password"));
                userToReturn.setUrlImagine(set.getString("urlProfImg"));
            }
            
            stmt.close();
            conn.close();
            
            return userToReturn;
                    
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }

    
    public ArrayList<User> getUsers() {
        ArrayList<User> userDb = new ArrayList<User>();

        try {
            Connection conn = DatabaseManager.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from Users";
            ResultSet set = stmt.executeQuery(sql);

            while (set.next()) {
                User userNuovo = new User();
                userNuovo.setId(set.getInt("id_user"));
                userNuovo.setName(set.getString("name"));
                userNuovo.setDescription(set.getString("descrizione"));
                userNuovo.setEmail(set.getString("email"));
                userNuovo.setDate(set.getDate("data").toLocalDate());
                userNuovo.setPassword(set.getString("password"));
                userNuovo.setUrlImagine(set.getString("urlProfImg"));
                
                
                
                userDb.add(userNuovo);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userDb;
    }
}
