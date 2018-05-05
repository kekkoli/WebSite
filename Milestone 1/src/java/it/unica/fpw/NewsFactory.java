/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.fpw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
/**
 *
 * @author kekko
 */
public class NewsFactory {
    
     
    private static NewsFactory instance;
    private ArrayList<News> listNews = new ArrayList<>();
    
    
    
    private NewsFactory()   {
        UserFactory userFactory = UserFactory.getInstance();

        News news1 = new News();
        news1.setId(0);
        news1.setCategory("Prove");
        news1.setDescrizione("Molto belloMolto belloMolto belloMolto belloMolto bello");
        news1.setUrlImagine("img/dovizioso.jpeg");
        news1.setTitle("BEllo");
        news1.setDate(new Date(2000,10,3));
        news1.setUser(userFactory.getUserById(0));
        
        
        
        News news2 = new News();
        news2.setId(1);
        news2.setCategory("Piloti");
        news2.setDescrizione("crosticinocrosticinocrosticinocrosticino");
        news2.setUrlImagine("img/dovizioso.jpeg");
        news2.setTitle("crosta");
        news2.setDate(new Date(2018,11,30));    
        news2.setUser(userFactory.getUserById(1));
        
        News news3 = new News();
        news3.setId(2);
        news3.setCategory("Piloti");
        news3.setDescrizione("grattastinchiksjefhkshfziszhfsofzmsoa");
        news3.setUrlImagine("img/dovizioso.jpeg");
        news3.setTitle("gatto");
        news3.setDate(new Date(1,2,3));
        news3.setUser(userFactory.getUserById(2));
        
        News news4 = new News();
        news4.setId(4);
        news4.setCategory("Prove");
        news4.setDescrizione("Molto belloMolto belloMolto belloMolto belloMolto bello");
        news4.setUrlImagine("img/dovizioso.jpeg");
        news4.setTitle("BEllo");
        news4.setDate(new Date(2000,10,15));
        news4.setUser(userFactory.getUserById(0));
        
        listNews.add(news1);
        listNews.add(news2);
        listNews.add(news3);
        listNews.add(news4);
}
    
    public static NewsFactory getInstance()
    {
        if (instance == null)
            instance = new NewsFactory();
        
        return instance;
    }
     public ArrayList<News> getNews(){
         Collections.sort(listNews);
         return listNews;
    }
     
    public News getNewsById(int id){
        for(News news : listNews){
            if(news.getId() == id)
                return news;
        }
        return null;
    }
    public ArrayList<News> getNewsByCategory(String category){
        ArrayList<News> listNewsCategory = new ArrayList<>();
        for(News news : listNews)
            if(news.getCategory().equals(category))
                listNewsCategory.add(news);
        return listNewsCategory;
    }
    
    public ArrayList<News> getNewsByUser(User user){
        ArrayList<News> listNewsCategory = new ArrayList<>();
        for(News news : listNews)
            if(news.getUser().getId() == user.getId())
                listNewsCategory.add(news);
        return listNewsCategory;
    }
}
     
     

