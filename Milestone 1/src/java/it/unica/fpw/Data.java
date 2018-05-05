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
public class Data {
    private int day;
    private int month;
    private int year;
    
    public Data(int day, int month, int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }
    
    
    public String getData(){
         String a = day + "/" + month + "/" + year;
         return a;
    }
    
    public void setData(int day,int month,int year){
        setDay(day);
        setMonth(month);
        setYear(year);
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
    
    
}
