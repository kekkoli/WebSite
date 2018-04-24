/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.fpw;
import java.util.ArrayList;
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
        news1.setCategory("first");
        news1.setDescrizione("Molto bello");
        news1.setUrlImagine("Immagine1.jpg");
        news1.setTitle("BEllo");
        news1.setUser(userFactory.getUserById(0));
        
        News news2 = new News();
        news1.setId(1);
        news1.setCategory("second");
        news1.setDescrizione("crosticino");
        news1.setUrlImagine("Immagine2.jpg");
        news1.setTitle("crosta");
        news1.setUser(userFactory.getUserById(1));
        
        News news3 = new News();
        news1.setId(2);
        news1.setCategory("third");
        news1.setDescrizione("grattastinchi");
        news1.setUrlImagine("Immagine1.jpg");
        news1.setTitle("gatto");
        news1.setUser(userFactory.getUserById(2));
        
        listNews.add(news1);
        listNews.add(news2);
        listNews.add(news3);
}
    
    public static NewsFactory getInstance()
    {
        if (instance == null)
            instance = new NewsFactory();
        
        return instance;
    }
    
}
