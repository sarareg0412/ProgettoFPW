/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sara
 */
public class Valutazioni implements Comparable<Valutazioni>{
    private int vid;
    private Utenti valutatore;        //Chi ha creato la valutazione
    private Articoli articolo;          //Articolo valutato
    private int voto;                   //Voto per l'articolo    
    private String commento_autore;            //Commento
    private String commento_organizzatore;
    private String decisione;           //Decisione
    
    /**
     * @return the valutazione
     */
    public int getVoto() {
        return voto;
    }

    /**
     * @param valutazione the valutazione to set
     */
    public void setVoto(int voto) {
        this.voto = voto;
    }

    /**
     * @return the articolo
     */
    public Articoli getArticolo() {
        return articolo;
    }

    /**
     * @param articolo the articolo to set
     */
    public void setArticolo(Articoli articolo) {
        this.articolo = articolo;
    }

    /**
     * @return the decisione
     */
    public String getDecisione() {
        return decisione;
    }

    /**
     * @param decisione the decisione to set
     */
    public void setDecisione(String decisione) {
        this.decisione = decisione;
    }
    
    @Override
    //Una valutazione è più piccola di un'altra se l'articolo
    //valutato è minore (meno recente) di un altro.
    public int compareTo(Valutazioni other){
        return -other.getArticolo().compareTo(this.getArticolo());
    }

    /**
     * @return the vid
     */
    public int getVid() {
        return vid;
    }

    /**
     * @param vid the vid to set
     */
    public void setVid(int vid) {
        this.vid = vid;
    }

    /**
     * @return the valutatore
     */
    public Utenti getValutatore() {
        return valutatore;
    }

    /**
     * @param valutatore the valutatore to set
     */
    public void setValutatore(Utenti valutatore) {
        this.valutatore = valutatore;
    }

    /**
     * @return the commento_autore
     */
    public String getCommento_autore() {
        return commento_autore;
    }

    /**
     * @param commento_autore the commento_autore to set
     */
    public void setCommento_autore(String commento_autore) {
        this.commento_autore = commento_autore;
    }

    /**
     * @return the commento_organizzatore
     */
    public String getCommento_organizzatore() {
        return commento_organizzatore;
    }

    /**
     * @param commento_organizzatore the commento_organizzatore to set
     */
    public void setCommento_organizzatore(String commento_organizzatore) {
        this.commento_organizzatore = commento_organizzatore;
    }
    
    public int getNValutazioni(int pid) throws MalformedURLException{
        return ValutazioniFactory.getInstance().getValutazioniByArticle(pid).size();
    }
}
