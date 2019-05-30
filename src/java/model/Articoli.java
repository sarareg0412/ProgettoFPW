/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *sss
 * @author Sara
 */
public class Articoli implements Comparable<Articoli> {
    private String titolo;
    private List<Utenti> autori;        //Lista di autori dell'articolo
    private List<String> categorie;     //Lista di categorie
    private Date data;         //Formato aaaa-mm-gg
    private String testo;               //Stringa contenente il testo
    private String stato;               //Aperto, in valutazione, accettato, rifiutato 
    private int pid;                 //Pid articolo
    private URL immagine;
    
    public Articoli(){      //Creo le liste
        this.autori = new ArrayList<>();
        this.categorie = new ArrayList<>();
    }
    /**
     * @return the titolo
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * @param titolo the titolo to set
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     * @return the autori
     */
    public List<Utenti> getAutori() {
        return this.autori;
    }

    /**
     * @param autori the autori to set
     */
    public void setAutore(List<Utenti> autore) {
        this.autori = autore;
    }

    /**
     * @return the categorie
     */
    public List<String> getCategorie() {
        return categorie;
    }

    /**
     * @param categorie the categorie to set
     */
    public void setCategorie(List<String> categorie) {
        this.categorie = categorie;
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
     * @return the stato
     */
    public String getStato() {
        return stato;
    }

    /**
     * @param stato the stato to set
     */
    public void setStato(String stato) {
        this.stato = stato;
    }

    /**
     * @return the pid
     */
    public int getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(int pid) {
        this.pid = pid;
    }

    /**
     * @return the formatoData
     */
    public Date getData() {
        return data;
    }

    /**
     * @param formatoData the formatoData to set
     */
    public void setData(Date data) {
        this.data = data;
    } 
    
    @Override
    //Due articoli sono uguali se il loro titolo e formato data sono uguali
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Utenti)) {
            return false;
        }
        
        Articoli other = (Articoli) obj;
        if (!this.titolo.equals(other.titolo)) {
            return false;
        }
        
        if (!this.data.equals(other.data)) {
            return false;
        }
        
        return true;
    }
 
    @Override
    //Un articolo è più "piccolo" di un altro se il suo formato data è più piccolo,
    //cioè se è meno recente
    public int compareTo(Articoli obj){
        return obj.data.compareTo(this.data);
    }

    /**
     * @return the immagine
     */
    public URL getImmagine() {
        return immagine;
    }

    /**
     * @param immagine the immagine to set
     */
    public void setImmagine(URL immagine) {
        this.immagine = immagine;
    }
}
