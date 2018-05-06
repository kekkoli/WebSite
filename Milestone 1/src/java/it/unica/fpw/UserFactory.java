/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.fpw;
import java.time.LocalDate;
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
        user1.setDate(LocalDate.of(2010,2,3));
        user1.setDescription("Il cielo e' sempre piu blu");
        user1.setEmail("ginopippo@gmail.com");
        user1.setRuolo(Ruolo.Autore);

        User user2 = new User();
        user2.setId(1);
        user2.setName("Mario");
        user2.setSurname("molinaro");
        user2.setPassword("wasabi");
        user2.setUrlImagine("immagine2.jpg");
        user1.setDate(LocalDate.of(2012,11,4));
        user2.setDescription("Cio che non ti uccide ti fortifica");
        user2.setEmail("frellele@gmail.com");
        user2.setRuolo(Ruolo.Autore);
        
        User user3 = new User();
        user3.setId(2);
        user3.setName("Giulio");
        user3.setSurname("campus");
        user3.setPassword("crosta");
        user1.setDate(LocalDate.of(2017,2,13));
        user3.setUrlImagine("immagine3.jpg");
        user3.setDescription("Non guardare al passato pensa al futuro");       
        user3.setEmail("asdrubale@gmail.com");
        user3.setRuolo(Ruolo.Ospite);
       
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
