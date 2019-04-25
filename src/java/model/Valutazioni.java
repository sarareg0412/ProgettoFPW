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
    private String autore;
    private int voto;
    private String commento;

    /**
     * @return the autore
     */
    public String getAutore() {
        return autore;
    }

    /**
     * @param autore the autore to set
     */
    public void setAutore(String autore) {
        this.autore = autore;
    }

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
    
}
