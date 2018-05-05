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

public class UserFactory {
    
    
    private static UserFactory instance;
    private ArrayList<User> userList = new ArrayList<>();
    
    private UserFactory(){
        
        User user1 = new User();
        user1.setId(0);
        user1.setName("Davide");
        user1.setSurname("De Luca");
        user1.setPassword("bluesky");
        user1.setUrlImagine("immagine1.jpg");
        user1.setDescription("Il cielo e' sempre piu blu");
        user1.setEmail("ginopippo@gmail.com");
        user1.setDay(1);
        user1.setRuolo(Ruolo.Autore);
        user1.setMonth(4);
        user1.setYear(1990);

        User user2 = new User();
        user2.setId(1);
        user2.setName("Mario");
        user2.setSurname("molinaro");
        user2.setPassword("wasabi");
        user2.setUrlImagine("immagine2.jpg");
        user2.setDescription("Cio che non ti uccide ti fortifica");
        user2.setEmail("frellele@gmail.com");
        user2.setDay(4);
        user2.setRuolo(Ruolo.Autore);
        user2.setMonth(11);
        user2.setYear(1995);
        
        User user3 = new User();
        user3.setId(2);
        user3.setName("Giulio");
        user3.setSurname("campus");
        user3.setPassword("crosta");
        user3.setUrlImagine("immagine3.jpg");
        user3.setDescription("Non guardare al passato pensa al futuro");       
        user3.setEmail("asdrubale@gmail.com");
        user3.setRuolo(Ruolo.Ospite);
        user3.setDay(7);
        user3.setMonth(2);
        user3.setYear(1998);
       
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }
    
    public static UserFactory getInstance()
    {
        if (instance == null)
            instance = new UserFactory();
        return instance;
    }
    
    public User getUserById(int id)
    {
        for (User user : userList)
            if (user.getId() == id)
                return user;
        return null;
    }
    public boolean login(String email, String password){
        for(User user : userList ){
            if(user.getEmail().equals(email) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }
    
    public User getUserByEmail(String email){
        for(User user : userList ){
            if(user.getEmail().equals(email))
                return user;
        }
        return null; 
    }
    
}   
