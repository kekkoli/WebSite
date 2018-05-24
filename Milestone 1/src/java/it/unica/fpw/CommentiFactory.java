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
    
    private CommentiFactory()   {
        UserFactory userFactory = UserFactory.getInstance();
        
        Commenti commento1 = new Commenti();       
        commento1.setContenuto("Articolo bellissimo!");
        commento1.setId(0);
        commento1.setUser(userFactory.getUserById(0));
        
        Commenti commento2 = new Commenti();
        commento2.setId(1);
        commento2.setContenuto("Articolo bellissimo!");
        commento2.setUser(userFactory.getUserById(1));

        
        Commenti commento3 = new Commenti();
        commento3.setId(2);
        commento3.setContenuto("Articolo bellissimo!");
        commento3.setUser(userFactory.getUserById(2));
        
        Commenti commento4 = new Commenti();
        commento4.setId(3);
        commento4.setContenuto("Articolo bellissimo!");
        commento4.setUser(userFactory.getUserById(1));
 
        listCommenti.add(commento1);
        listCommenti.add(commento2);
        listCommenti.add(commento3);
        listCommenti.add(commento4);
    }
    
     public static CommentiFactory getInstance(){
        if (instance == null)
            instance = new CommentiFactory();
        return instance;
    }
     
    public ArrayList<Commenti> getCommentsByIdNews(int id){
                    ArrayList <Commenti> commDb = new ArrayList<>();

        try {
            Connection conn = DatabaseManager.getInstance().getConnection();
            String sql = "select * from Comments where news = ?";
            UserFactory usr = UserFactory.getInstance();


            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet set = stmt.executeQuery();
            while(set.next()) {
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