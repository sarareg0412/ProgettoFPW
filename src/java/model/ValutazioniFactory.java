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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            Statement stmt = conn.createStatement();

            String sql = "select valutazione.*, utente.id, articolo.pid from valutazione"
                    + " inner join utente on valutazione.id_utente = utente.id"
                    + " inner join articolo on valutazione.id_articolo = articolo.pid";
            ResultSet set = stmt.executeQuery(sql);
            
            while (set.next()) {
                Valutazioni val = new Valutazioni();
                
                val.setVid(set.getInt("id_valutazione"));
                val.setCommento_autore(set.getString("comm_autori"));
                val.setCommento_organizzatore(set.getString("comm_org"));
                val.setVoto(set.getInt("voto"));
                val.setDecisione(set.getString("decisione"));
                Utenti user = UtentiFactory.getInstance().getUserById(set.getInt("id"));
                val.setValutatore(user);
                Articoli art = ArticoliFactory.getInstance().getArticleByPid(set.getInt("pid"));
                val.setArticolo(art);
                
                valutazioni.add(val);
            }
        
            stmt.close();
            conn.close();
        }catch (SQLException exc) {
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, exc);
        }

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
            if (u.getValutatore().equals(valutatore)) {
                lista.add(u);
            }
        }

        return lista;
    }
    
}
