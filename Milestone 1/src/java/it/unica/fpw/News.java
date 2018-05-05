/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.fpw;
import java.util.Date;


/**
 *
 * @author kekko
 */
public class News implements Comparable<News> {

    private int id;
    private Date date;
    private String title;
    private String category;
    private String urlImagine;
    private String descrizione;
    private User user;

    public News(){
        this.id = 3;
        this.title = "Curiosita dal web";
        this.category = "News";
        this.descrizione = "Dal web ci sono giunte notizie bellissime";
        this.urlImagine = "immagine.jpg";
        this.user = new User();
        this.date = new Date(1,2,3);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the day
     */
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the urlImagine
     */
    public String getUrlImagine() {
        return urlImagine;
    }

    /**
     * @param urlImagine the urlImagine to set
     */
    public void setUrlImagine(String urlImagine) {
        this.urlImagine = urlImagine;
    }

    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * @return the autor
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the autor to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the date
     */
    public String printDate(){
        String a = date.getDate() + "/" +  (date.getMonth()+1) + "/" +date.getYear();
        return a;
    }

    @Override
    public int compareTo(News o) {
        if(date.after(o.date))
            return 1;
       return -1; 
    }
    
 

 

                
}
