        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.fpw;
import java.util.Collections;
import java.time.LocalDate;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author kekko
 */
public class NewsFactory {
    /*La newsFactory si occupa di restituire le News su richiesta.
    Contiene dei metodi che restituiscono una o piu' News in base a id,categoria
     e autore.Le news vengono pescate dal database.
    Vi e' inoltre il medotodo che consente la modifica o creazione
    della news,sempre su database.*/
    
    private static NewsFactory instance;
    private ArrayList<News> listNews = new ArrayList<>();
    
    private NewsFactory(){
    }
    
    public static NewsFactory getInstance()
    {
        if (instance == null)
            instance = new NewsFactory();
        
        return instance;
    }
     public ArrayList<News> getNews(){
       ArrayList<News>  newsDb = new ArrayList<News>();

        try {
            Connection conn = DatabaseManager.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from News";
            ResultSet set = stmt.executeQuery(sql);
            UserFactory usr = UserFactory.getInstance();
            
            while (set.next()) {
                News nuovaNews = new News();
                nuovaNews.setId(set.getInt("id_news"));
                nuovaNews.setTitle(set.getString("titolo"));
                nuovaNews.setTesto(set.getString("testo"));
                nuovaNews.setUrlImagine(set.getString("img"));
                nuovaNews.setDescrizione(set.getString("didascalia"));
                nuovaNews.setCategory(set.getInt("categoria"));
                nuovaNews.setDate(set.getDate("data").toLocalDate());
                
                nuovaNews.setUser(usr.getUserById(set.getInt("autore")));
                
                newsDb.add(nuovaNews);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return newsDb;
    }
     
    public News getNewsById(int id){
        try {
            Connection conn = DatabaseManager.getInstance().getConnection();
            String sql = "select * from News where id_news = ?";
            News news = new News();
            UserFactory usr = UserFactory.getInstance();


            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet set = stmt.executeQuery();
            if (set.next()) {
                news.setId(set.getInt("id_news"));
                news.setTitle(set.getString("titolo"));
                news.setTesto(set.getString("testo"));
                news.setUrlImagine(set.getString("img"));
                news.setDescrizione(set.getString("didascalia"));
                news.setCategory(set.getInt("categoria"));
                news.setDate(set.getDate("data").toLocalDate());
                news.setUser(usr.getUserById(set.getInt("autore")));
               return news;
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public ArrayList<News> getNewsByCategory(Categoria category){
        ArrayList<News>  newsDb = new ArrayList<News>();
        try {
            Connection conn = DatabaseManager.getInstance().getConnection();
            String sql = "select * from News where categoria = ?";
            UserFactory usr = UserFactory.getInstance();


            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, category.ordinal());

            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                News news = new News();
                news.setId(set.getInt("id_news"));
                news.setTitle(set.getString("titolo"));
                news.setTesto(set.getString("testo"));
                news.setUrlImagine(set.getString("img"));
                news.setDescrizione(set.getString("didascalia"));
                news.setCategory(set.getInt("categoria"));
                news.setDate(set.getDate("data").toLocalDate());
                news.setUser(usr.getUserById(set.getInt("autore")));
                newsDb.add(news);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return newsDb;
    }
   
    public ArrayList<News> getNewsByUser(User user) {
        ArrayList<News> newsDb = new ArrayList<News>();
        try {
            Connection conn = DatabaseManager.getInstance().getConnection();
            String sql = "select * from News where autore = ?";
            UserFactory usr = UserFactory.getInstance();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getId());

            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                News news = new News();
                news.setId(set.getInt("id_news"));
                news.setTitle(set.getString("titolo"));
                news.setTesto(set.getString("testo"));
                news.setUrlImagine(set.getString("img"));
                news.setDescrizione(set.getString("didascalia"));
                news.setCategory(set.getInt("categoria"));
                news.setDate(set.getDate("data").toLocalDate());
                news.setUser(usr.getUserById(set.getInt("autore")));
                newsDb.add(news);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return newsDb;
    }
    
    public int addNews(String tit,String tes,String url,String descr,
            Categoria c,LocalDate dat,User us){
        int idNuova = -1;
         try {
            Connection conn = DatabaseManager.getInstance().getConnection();
            
            String sql = "insert into News(titolo, testo,img,didascalia,categoria,"
                    + "data,autore) values (?, ?, ?, ?, ?, ?, ?)" ;
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, tit);
            stmt.setString(2, tes);
            stmt.setString(3, url);
            stmt.setString(4, descr);
            stmt.setInt(5, c.ordinal());
            stmt.setDate(6,Date.valueOf(dat));
            stmt.setInt(7, us.getId());
            
            stmt.executeUpdate();
             
            sql = "select * from News where testo = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,tes);
            ResultSet set = stmt.executeQuery();
            if(set.next())
                idNuova = (set.getInt("id_news"));
            stmt.close();
            
            conn.close();
            
            return idNuova;

         }
         catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
         return idNuova;
    }
    
    public void updateNews(String tit,String tes,String url,String descr,
            Categoria c,LocalDate dat,User us,int id){
         try {
            Connection conn = DatabaseManager.getInstance().getConnection();
            
            String sql = "update News set titolo=?, testo=?, img=?, didascalia=?,"
                    + "categoria=?, data=?,autore=? where id_news = ?" ;
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, tit);
            stmt.setString(2, tes);
            stmt.setString(3, url);
            stmt.setString(4, descr);
            stmt.setInt(5, c.ordinal());
            stmt.setDate(6,Date.valueOf(dat));
            stmt.setInt(7, us.getId());
            stmt.setInt(8,id);
            
            stmt.executeUpdate();
             
            stmt.close();
            
            conn.close();
            

         }
         catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public ArrayList<News> getNewsByContent(String p) {
        ArrayList<News> newsDb = new ArrayList<News>();
        try {
            Connection conn = DatabaseManager.getInstance().getConnection();
            String sql = "select * from News where testo like ?";
            UserFactory usr = UserFactory.getInstance();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,"%" + p + "%");

            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                News news = new News();
                news.setId(set.getInt("id_news"));
                news.setTitle(set.getString("titolo"));
                news.setTesto(set.getString("testo"));
                news.setUrlImagine(set.getString("img"));
                news.setDescrizione(set.getString("didascalia"));
                news.setCategory(set.getInt("categoria"));
                news.setDate(set.getDate("data").toLocalDate());
                news.setUser(usr.getUserById(set.getInt("autore")));
                newsDb.add(news);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return newsDb;
    }
}
     
     

