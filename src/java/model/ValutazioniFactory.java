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
public class ValutazioniFactory {
     /**
     * Unica istanza che può restituire le valutazioni
     */
    private static ValutazioniFactory singleton;

    /**
     * Nessuno può creare altre ValutazioniFactory
     */
    private ValutazioniFactory() {
    }

    public static ValutazioniFactory getInstance() {
        if (singleton == null) {
            singleton = new ValutazioniFactory();
        }
        return singleton;
    }
    
    public List<Valutazioni> getValutazioni() {
        List<Valutazioni> valutazioni = new ArrayList<>();
        
        Valutazioni v1 = new Valutazioni();
        v1.setAutore("Sara Regali");
        v1.setVoto(4);
        v1.setCommento("Articolo scritto molto bene");
        valutazioni.add(v1);
        
        Valutazioni v2 = new Valutazioni();
        v2.setAutore("Gianni Bianchi");
        v2.setVoto(2);
        v2.setCommento("Articolo scritto molto male");
        valutazioni.add(v2);
        
        Valutazioni v3 = new Valutazioni();
        v3.setAutore("Mario Neri");
        v3.setVoto(3);
        v3.setCommento("Articolo scritto abbastanza bene");
        valutazioni.add(v3);
        
        return valutazioni;
    }

    /**
     * Ritorna una lista di valutazioni in base all'autore
     *
     * @param titolo
     */
    public List<Valutazioni> getValutazioniByAuthor(String autore) {
        List<Valutazioni> valutazioni = this.getValutazioni();
        List<Valutazioni> lista = null;
        
        for (Valutazioni u : valutazioni) {
            if (u.getAutore().equals(autore)) {
                lista.add(u);
            }
        }

        return lista;
    }

    /**
     * Ritorna una lista di valutazioni in base al voto
     *
     * @param titolo
     */
    public List<Valutazioni> getValutazioniByMark(int voto) {
        List<Valutazioni> valutazioni = this.getValutazioni();
        List<Valutazioni> lista = null;
        
        for (Valutazioni u : valutazioni) {
            if (u.getVoto() == voto) {
                lista.add(u);
            }
        }

        return lista;
    }
    
}
