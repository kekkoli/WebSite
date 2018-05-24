/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.fpw;

import java.time.LocalDate;

/**
 *
 * @author kekko
 */
public class Commenti {

    /**
     * @return the data
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(LocalDate data) {
        this.data = data;
    }
    
    private User user;
    private String contenuto;
    private int id;
    private int idNews;
    private LocalDate data;
    
    public Commenti(){
        this.user = new User(); 
        this.contenuto = "Articolo bellissimo!";
        this.idNews = 0;
        this.data = LocalDate.now();
        this.id=0;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the contenuto
     */
    public String getContenuto() {
        return contenuto;
    }

    /**
     * @param contenuto the contenuto to set
     */
    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
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
     * @return the idNews
     */
    public int getIdNews() {
        return idNews;
    }

    /**
     * @param idNews the idNews to set
     */
    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }
    
}
