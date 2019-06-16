/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.net.MalformedURLException;
import java.util.ArrayList;
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

            String sql = "select valutazione_.*, utente.id, articolo.pid, articolo.data_creazione from valutazione_"
                    + " inner join utente on valutazione_.id_utente = utente.id"
                    + " inner join articolo on valutazione_.id_articolo = articolo.pid order by data_creazione desc";
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
        } catch (SQLException exc) {
            Logger.getLogger(ValutazioniFactory.class.getName()).log(Level.SEVERE, null, exc);
        }

        return valutazioni;
    }

    public Valutazioni getValutazioneByVid(int vid) throws MalformedURLException {
        try {
            Boolean esiste_val;

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from valutazione_ where id_valutazione = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, vid);

            ResultSet set = stmt.executeQuery();

            esiste_val = set.next();

            if (esiste_val == true) {
                Valutazioni valutazione = new Valutazioni();

                valutazione.setVid(set.getInt("id_valutazione"));
                valutazione.setCommento_autore(set.getString("comm_autori"));
                valutazione.setCommento_organizzatore(set.getString("comm_org"));
                valutazione.setVoto(set.getInt("voto"));
                valutazione.setDecisione(set.getString("decisione"));
                Utenti user = UtentiFactory.getInstance().getUserById(set.getInt("id_utente"));
                valutazione.setValutatore(user);
                Articoli art = ArticoliFactory.getInstance().getArticleByPid(set.getInt("id_articolo"));
                valutazione.setArticolo(art);

                stmt.close();
                conn.close();
                return valutazione;
            } else {
                return null;
            }
        } catch (SQLException exc) {
            Logger.getLogger(ValutazioniFactory.class.getName()).log(Level.SEVERE, null, exc);
        }

        return null;

    }

    /**
     * Ritorna una lista di valutazioni in base all'autore
     *
     * @param titolo
     */ 
    
    public List<Valutazioni> getValutazioniByArticle(int pid) throws MalformedURLException {
        List<Valutazioni> lista = new ArrayList<>();
        try {

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select valutazione_.* , articolo.data_creazione from valutazione_ join articolo on articolo.pid = valutazione_.id_articolo  where id_articolo = ? order by data_creazione desc";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, pid);

            ResultSet set = stmt.executeQuery();

            while (set.next()) {
                Valutazioni valutazione = ValutazioniFactory.getInstance().getValutazioneByVid(set.getInt("id_valutazione"));
                lista.add(valutazione);
            }

            stmt.close();
            conn.close();
        } catch (SQLException exc) {
            Logger.getLogger(ValutazioniFactory.class.getName()).log(Level.SEVERE, null, exc);
        }

        return lista;
    }

    /**
     * Ritorna una lista di valutazioni in base al valutatore
     *
     * @param titolo
     */
    public List<Valutazioni> getValutazioniByValutatore(int id) throws MalformedURLException {
        List<Valutazioni> lista = new ArrayList<>();
        try {

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select valutazione_.*, articolo.data_creazione from valutazione_ join articolo on articolo.pid = valutazione_.id_articolo where id_utente = ? order by data_creazione desc";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet set = stmt.executeQuery();

            while (set.next()) {
                Valutazioni valutazione = ValutazioniFactory.getInstance().getValutazioneByVid(set.getInt("id_valutazione"));
                lista.add(valutazione);
            }

            stmt.close();
            conn.close();
        } catch (SQLException exc) {
            Logger.getLogger(ValutazioniFactory.class.getName()).log(Level.SEVERE, null, exc);
        }
        
        return lista;
    }

    public List<Valutazioni> getValutazioniSenzaRipetizioni() throws MalformedURLException {
        List<Valutazioni> valutazioni = new ArrayList<>();
        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            Statement stmt = conn.createStatement();

            String sql = "select valutazione_.*, articolo.data_creazione  from valutazione_ join articolo on articolo.pid = valutazione_.id_articolo order by data_creazione desc";

            ResultSet set = stmt.executeQuery(sql);

            while (set.next()) {
                boolean flag = false;
                for (Valutazioni val : valutazioni) {
                    /*Per ogni valutazione, se c'è già l'articolo valutato, si salta la valutazione*/
                    if (val.getArticolo().getPid() == set.getInt("id_articolo")) {
                        flag = true;    //C'è già l'articolo nella colonna scelta
                    }
                }
                if (flag == false) {
                    valutazioni.add(ValutazioniFactory.getInstance().getValutazioneByVid(set.getInt("id_valutazione")));
                }
            }

            stmt.close();
            conn.close();
        } catch (SQLException exc) {
            Logger.getLogger(ValutazioniFactory.class.getName()).log(Level.SEVERE, null, exc);
        }

        return valutazioni;

    }

    public Valutazioni getValutazioneByPI(int pid, int id) throws MalformedURLException {
        Valutazioni valutazione = null;
        try {

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from valutazione_ where id_articolo = ? and id_utente = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, pid);
            stmt.setInt(2, id);

            ResultSet set = stmt.executeQuery();

            while (set.next()) {
                valutazione = ValutazioniFactory.getInstance().getValutazioneByVid(set.getInt("id_valutazione"));
            }

            stmt.close();
            conn.close();

        } catch (SQLException exc) {
            Logger.getLogger(ValutazioniFactory.class.getName()).log(Level.SEVERE, null, exc);
        }

        return valutazione;

    }
    
    public void createValutazione(int pid){
         try {
            Boolean crea_valutazione;

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "insert into valutazione_ values (default, default, default, default, 'Attesa Valutazioni', 1, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,pid);
            
            int i = stmt.executeUpdate();

            if (i > 0) {
                stmt.close();
                conn.close();
            }
        } catch (SQLException exc) {
            Logger.getLogger(ValutazioniFactory.class.getName()).log(Level.SEVERE, null, exc);
        }
    
    }
}
