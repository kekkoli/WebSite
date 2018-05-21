/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.fpw;
import java.util.Collections;

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
public class NewsFactory {
    
     
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
       ArrayList<News> userDb = new ArrayList<News>();

        try {
            Connection conn = DatabaseManager.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from News";
            ResultSet set = stmt.executeQuery(sql);

            while (set.next()) {
                News nuovaNews = new News();
                nuovaNews.setId(set.getInt("id_news"));
                nuovaNews.setName(set.getString("name"));
                
                userDb.add(News nuovaNews);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userDb;
    }
     
    public News getNewsById(int id){
        for(News news : listNews){
            if(news.getId() == id)
                return news;
        }
        return null;
    }
    
    public ArrayList<News> getNewsByCategory(Categoria category){
        ArrayList<News> listNewsCategory = new ArrayList<>();
        for(News news : listNews)
            if(news.getCategory().equals(category))
                listNewsCategory.add(news);
        Collections.sort(listNewsCategory);
        return listNewsCategory;
    }
    
    public ArrayList<News> getNewsByUser(User user){
        ArrayList<News> listNewsByUser = new ArrayList<>();
        for(News news : listNews)
            if(news.getUser().getId() == user.getId())
                listNewsByUser.add(news);
        return listNewsByUser;
    }
}
     
     

