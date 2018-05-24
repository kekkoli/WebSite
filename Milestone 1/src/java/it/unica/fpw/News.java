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
public class News implements Comparable <News>  {
    /*Classe News*/ 
    private int id;
    private LocalDate date;
    private String title;
    private Categoria category;
    private String urlImagine;
    private String descrizione;
    private String testo;
    private User user;

    public News(){
        this.id = -1;
        this.title = "Inserisci Titolo";
        this.category = Categoria.News;
        this.descrizione = "inserisci didascalia";
        this.urlImagine = "Inserisci Url immagine";
        this.user = new User();
        this.date = LocalDate.of(1,1,1);
        this.testo = "Inserisci Testo";
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
    
    public String estraiCaratteri(){
        if(testo.length() < 100)
            return testo;
        String a = testo.substring(0, 100) + "...";
        return a;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public int compareTo(News o) {
        if(this.date.compareTo(o.getDate())<0)
            return 1;
        return -1;
    }

    /**
     * @return the testo
     */
    public String getTesto() {
        return testo;
    }

    /**
     * @param testo the testo to set
     */
    public void setTesto(String testo) {
        this.testo = testo;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Categoria category) {
        this.category = category;
    }

    /**
     * @return the category
     */
    public Categoria getCategory() {
        return category;
    }
    
    public void setCategory(int c) {
        switch(c){
            case 0:
                this.category = Categoria.News;
                break;
            case 1:
                this.category = Categoria.Prove;
                break;
            case 2:
                this.category = Categoria.Ruote;
                break;
            case 3 :
                this.category = Categoria.Scuderie;
                break;
            case 4:
                this.category = Categoria.Piloti;
        }
    }
    
 

 

                
}
