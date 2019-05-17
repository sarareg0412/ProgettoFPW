/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
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
    
    public List<Valutazioni> getValutazioni() throws MalformedURLException {
        List<Valutazioni> valutazioni = new ArrayList<>();
        
        Utenti sara = UtentiFactory.getInstance().getUserById(1);
        Utenti gianni = UtentiFactory.getInstance().getUserById(2);
        Utenti mario = UtentiFactory.getInstance().getUserById(3);
        
        Articoli a1 = ArticoliFactory.getInstance().getArticleByPid("1");
        Articoli a2 = ArticoliFactory.getInstance().getArticleByPid("2");
        Articoli a3 = ArticoliFactory.getInstance().getArticleByPid("3");
        Articoli a4 = ArticoliFactory.getInstance().getArticleByPid("4");
        Articoli a5 = ArticoliFactory.getInstance().getArticleByPid("5");
        Articoli a6 = ArticoliFactory.getInstance().getArticleByPid("6");
        Articoli a7 = ArticoliFactory.getInstance().getArticleByPid("7");
        
        Valutazioni v1 = new Valutazioni();
        v1.getValutatori().add(mario);
        v1.getValutatori().add(sara);
        v1.setArticolo(a1);
        v1.setVoto(4);
        v1.setCommento("Articolo scritto molto bene");
        v1.setDecisione("Decidi");
        valutazioni.add(v1);
        
        Valutazioni v2 = new Valutazioni();
        v2.getValutatori().add(sara);
        v2.setArticolo(a2);
        v2.setVoto(2);
        v2.setCommento("Articolo scritto molto male");
        v2.setDecisione("Decidi");
        valutazioni.add(v2);
        
        Valutazioni v3 = new Valutazioni();
        v3.getValutatori().add(sara);
        v3.setArticolo(a3);
        v3.setVoto(0);
        v3.setCommento("Articolo non ancora valutato");
        v3.setDecisione("Attesa Valutazioni");
        valutazioni.add(v3);
        
        Valutazioni v4 = new Valutazioni();
        v4.getValutatori().add(mario);
        v4.setArticolo(a4);
        v4.setVoto(0);
        v4.setCommento("Articolo scritto abbastanza bene");
        v4.setDecisione("Attesa Valutazioni");
        valutazioni.add(v4);
        
        Valutazioni v5 = new Valutazioni();
        v5.setArticolo(a5);
        v5.setVoto(3);
        v5.setCommento("Articolo scritto abbastanza bene");
        v5.setDecisione("Accettato");
        valutazioni.add(v5);
        
        Valutazioni v6 = new Valutazioni();
        v6.setArticolo(a6);
        v6.setVoto(0);
        v6.setCommento("Articolo scritto malissimo");
        v6.setDecisione("Rifiutato");
        valutazioni.add(v6);
        
        Valutazioni v7 = new Valutazioni();
        v7.setArticolo(a7);
        v7.setVoto(1);
        v7.setCommento("Articolo scritto male");
        v7.setDecisione("Rifiutato");
        valutazioni.add(v7);
        
        Collections.sort(valutazioni);      //
        return valutazioni;
    }

    /**
     * Ritorna una lista di valutazioni in base all'autore
     *
     * @param titolo
     */
    public List<Valutazioni> getValutazioniByArticle(Articoli articolo ) throws MalformedURLException {
        List<Valutazioni> valutazioni = this.getValutazioni();
        List<Valutazioni> lista = new ArrayList<>();
        
        for (Valutazioni u : valutazioni) {
            if (u.getArticolo().equals(articolo)) {
                lista.add(u);
            }
        }

        return lista;
    }
 /**
     * Ritorna una lista di valutazioni in base al valutatore
     *
     * @param titolo
     */
    public List<Valutazioni> getValutazioniByValutatore(Utenti valutatore ) throws MalformedURLException {
        List<Valutazioni> valutazioni = this.getValutazioni();
        List<Valutazioni> lista = new ArrayList<>();
        
        for (Valutazioni u : valutazioni) {
            if (u.getValutatori().contains(valutatore)) {
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
    public List<Valutazioni> getValutazioniByMark(int voto) throws MalformedURLException {
        List<Valutazioni> valutazioni = this.getValutazioni();
        List<Valutazioni> lista = new ArrayList<>();
        
        for (Valutazioni u : valutazioni) {
            if (u.getVoto() == voto) {
                lista.add(u);
            }
        }

        return lista;
    }
    
}
