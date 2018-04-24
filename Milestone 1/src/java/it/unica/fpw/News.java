/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.fpw;

/**
 *
 * @author kekko
 */
public class News {

    private int id;
    private int day,month,year;
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
    public int getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

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
        
                
}
