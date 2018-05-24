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
public class User {
    private String name;
    private String surname;
    private String urlImagine;
    private String description;
    private String password;
    private String email;
    private int id;
    private LocalDate date;
    private Ruolo ruolo;
    
    /*Classe che gestisce gli User.*/
    public User(){
        this.name = "Francesco";
        this.surname = "Ligas";
        this.urlImagine = "immagine.jpg";
        this.description = "e' bello cio' che piace";
        this.id=0;
        this.date =  LocalDate.of(1,2,3);
        this.password = "123456";
        this.email= "ginopippo@gmail.com";
        this.ruolo = Ruolo.Ospite;
        
    }

    /**
     * @return the Nome
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the Nome to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cognome
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the cognome to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the urlImmagine
     */
    public String getUrlImagine() {
        return urlImagine;
    }

    /**
     * @param urlImagine the urlImmagine to set
     */
    public void setUrlImagine(String urlImagine) {
        this.urlImagine = urlImagine;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the ruolo
     */
    public Ruolo getRuolo() {
        return ruolo;
    }

    /**
     * @param ruolo the ruolo to set
     */
    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }
    
    public void setRuolo(int r){
        switch(r){
            case 0:
                this.ruolo = Ruolo.Autore;
                break;
            case 1:
                this.ruolo = Ruolo.Lettore;
                break;
            case 2:
                this.ruolo = Ruolo.Ospite;
        }
    }
    
        public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
}
