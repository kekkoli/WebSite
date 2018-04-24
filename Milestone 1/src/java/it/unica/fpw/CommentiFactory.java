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
        commento1.setId(1);
        commento2.setContenuto("Articolo bellissimo!");
        commento2.setUser(userFactory.getUserById(1));

        
        Commenti commento3 = new Commenti();
        commento1.setId(2);
        commento3.setContenuto("Articolo bellissimo!");
        commento3.setUser(userFactory.getUserById(2));
 
        listCommenti.add(commento1);
        listCommenti.add(commento2);
        listCommenti.add(commento3);
    }
    
     public static CommentiFactory getInstance(){
        if (instance == null)
            instance = new CommentiFactory();
        return instance;
    }
}
