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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kekko
 */
public class CommentiFactory {

    private static CommentiFactory instance;
    private ArrayList<Commenti> listCommenti = new ArrayList<>();

    private CommentiFactory() {
    }

    public static CommentiFactory getInstance() {
        if (instance == null) {
            instance = new CommentiFactory();
        }
        return instance;
    }

    public ArrayList<Commenti> getCommentsByIdNews(int id) {
        /*Questo metodo restituisce la lista dei commenti passato il parametro ID 
        della news corrispondente*/

        ArrayList<Commenti> commDb = new ArrayList<>();

        try {
            Connection conn = DatabaseManager.getInstance().getConnection();
            String sql = "select * from Comments where news = ?";
            UserFactory usr = UserFactory.getInstance();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet set = stmt.executeQuery();

            //Se e' presente almeno un Commento viene restituito
            while (set.next()) {
                Commenti comm = new Commenti();
                comm.setUser(usr.getUserById(set.getInt("autore")));
                comm.setIdNews(set.getInt("news"));
                comm.setContenuto(set.getString("contenuto"));
                comm.setData(LocalDate.now());
                comm.setId(set.getInt("id_comm"));
                commDb.add(comm);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return commDb;
    }
}
