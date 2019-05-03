/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Sara
 */
public class Articoli {
    private String titolo;
    private List<Utenti> autori = null;
    private String[] categorie = new String[6]; //Max 6 categorie
    private Integer[] data = new Integer[3]; //Le 3 celle contengono le cifre della data di creazione articolo
    private String testo;
    private String stato; //Aperto, in valutazione ecc 

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
        return autori;
    }

    /**
     * @param autori the autori to set
     */
    public void setAutore(Utenti autore) {
        this.autori.add(autore);
    }

    /**
     * @return the categorie
     */
    public String[] getCategorie() {
        return categorie;
    }

    /**
     * @param categorie the categorie to set
     */
    public void setCategorie(String[] categorie) {
        this.categorie = categorie;
    }

    /**
     * @return the data
     */
    public Integer[] getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int[] data) {
        this.data[0] = data[0];
        this.data[1] = data[1];
        this.data[2] = data[2];
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
    
}
