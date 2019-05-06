/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sara
 */
public class Articoli {
    private String titolo;
    private List<Utenti> autori;
    private List<String> categorie; //Max 6 categorie
    private String data; //Le 3 celle contengono le cifre della data di creazione articolo
    private String formatoData;
    private String testo;
    private String stato; //Aperto, in valutazione ecc 
    private String pid;

    public Articoli(){
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
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
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
    public String getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @return the formatoData
     */
    public String getFormatoData() {
        return formatoData;
    }

    /**
     * @param formatoData the formatoData to set
     */
    public void setFormatoData(String formatoData) {
        this.formatoData = formatoData;
    } 
    
    public boolean contieneCategoria (String categoria){
        return this.categorie.contains(categoria);       
    }
}
