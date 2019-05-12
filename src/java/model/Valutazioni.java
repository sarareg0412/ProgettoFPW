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
public class Valutazioni implements Comparable<Valutazioni>{
    private List<Utenti> valutatori = new ArrayList<>();        //Chi ha creato la valutazione
    private Articoli articolo;          //Articolo valutato
    private int voto;                   //Voto per l'articolo    
    private String commento;            //Commento
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
     * @return the commento
     */
    public String getCommento() {
        return commento;
    }

    /**
     * @param commento the commento to set
     */
    public void setCommento(String commento) {
        this.commento = commento;
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

    /**
     * @return the valutatore
     */
    public List<Utenti> getValutatori() {
        return valutatori;
    }

    /**
     * @param valutatore the valutatore to set
     */
    public void setValutatori(List<Utenti> valutatori) {
        this.valutatori = valutatori;
    }
    
    @Override
    //Una valutazione è più piccola di un'altra se il formato data dell'articolo
    //valutato è minore (meno recente) di un altro.
    public int compareTo(Valutazioni other){
        return other.getArticolo().getFormatoData().compareTo(this.getArticolo().getFormatoData());
    }
}
