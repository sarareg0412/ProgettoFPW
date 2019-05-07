/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sara
 */
public class Valutazioni {
    private Articoli articolo;
    private int voto;
    private String commento;
    private String decisione;
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
    
}
