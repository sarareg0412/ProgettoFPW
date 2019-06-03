/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
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
public class UtentiFactory {

    /**
     * Unica istanza che può restituire gli utenti
     */
    private static UtentiFactory singleton;

    /**
     * Nessuno può creare altre UtentiFactory
     */
    private UtentiFactory() {
    }

    public static UtentiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiFactory();
        }
        return singleton;
    }

    /**
     * Ritorna la lista degli utenti loggati
     */
    public List<Utenti> getUsers() throws MalformedURLException {
        List<Utenti> users = new ArrayList<>();

        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            Statement stmt = conn.createStatement();

            String sql = "select * from utente";
            ResultSet set = stmt.executeQuery(sql);

            while (set.next()) {
                Utenti utente = new Utenti();

                utente.setId(set.getInt("id"));
                utente.setNome(set.getString("nome"));
                utente.setCognome(set.getString("cognome"));
                utente.setImmagine(new URL(set.getString("foto")));
                utente.setEmail(set.getString("email"));
                utente.setPassword(set.getString("password"));
                utente.setStatus(set.getString("status"));
                utente.setEnte(new URL(set.getString("ente")));
                users.add(utente);
            }

            stmt.close();
            conn.close();

        } catch (SQLException exc) {
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, exc);
        }

        return users;
    }

    /**
     * Ritorna un utente in base al suo username e password
     *
     * @return user
     */
    public Utenti getUserByUP(String email, String password) throws MalformedURLException {

        try {
            Boolean loggedIn;

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from utente where email = ? and pw = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet set = stmt.executeQuery();

            loggedIn = set.next();  //C'è almeno una riga?

            if (loggedIn == true) {
                Utenti utente = new Utenti();

                utente.setId(set.getInt("id"));
                utente.setNome(set.getString("nome"));
                utente.setCognome(set.getString("cognome"));
                utente.setImmagine(new URL(set.getString("foto")));
                utente.setEmail(set.getString("email"));
                utente.setPassword(set.getString("pw"));
                utente.setStatus(set.getString("status"));
                utente.setEnte(new URL(set.getString("ente")));

                stmt.close();
                conn.close();
                return utente;
            } else {
                return null;
            }
        } catch (SQLException exc) {
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, exc);
        }

        return null;
    }

    /**
     * Ritorna un utente in base al suo id
     *
     * @return user
     */
    public Utenti getUserById(int id) throws MalformedURLException {
        try {
            Boolean loggedIn;

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from utente where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet set = stmt.executeQuery();

            loggedIn = set.next();

            if (loggedIn == true) {
                Utenti utente = new Utenti();

                utente.setId(set.getInt("id"));
                utente.setNome(set.getString("nome"));
                utente.setCognome(set.getString("cognome"));
                utente.setImmagine(new URL(set.getString("foto")));
                utente.setEmail(set.getString("email"));
                utente.setPassword(set.getString("pw"));
                utente.setStatus(set.getString("status"));
                utente.setEnte(new URL(set.getString("ente")));

                stmt.close();
                conn.close();
                return utente;
            } else {
                return null;
            }
        } catch (SQLException exc) {
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, exc);
        }

        return null;
    }

    public Boolean deleteUtente(int id) {
        Connection conn = null;

        try {
            conn = DbManager.getInstance().getDbConnection();
            conn.setAutoCommit(false);

            String sql = "select articolo_id from utente_articolo where utente_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet set = stmt.executeQuery(sql);

            stmt.setInt(1, id);

            List<Integer> articoli = new ArrayList<>();

            while (set.next()) {
                articoli.add(set.getInt("articolo_id"));
            }

            for (int i = 0; i < articoli.size(); i++) {
                String art = "delete from articolo where pid = ?";
                stmt.setInt(1, articoli.get(i).intValue());
                stmt.executeUpdate();
            }

            String articolo = "delete from utente_articolo where utente_id = ?";

            stmt.setInt(1, id);
            stmt.executeUpdate();

            String valutazioni = "delete from valutazione where id_utente = ?";
            stmt.setInt(1, id);

            stmt.executeUpdate();

            String utente = "delete from utenti where id= ?";
            stmt.setInt(1, id);
            stmt.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);
            stmt.close();
            conn.close();

        } catch (SQLException exc) {
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, exc);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ec) {
                    Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, ec);
                }
            }
            return false;
        }

        return false;
    }

    public int getPidByNS(String nome, String cognome) {
        try {
            Boolean loggedIn;

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from utente where nome = ? and cognome = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            ResultSet set = stmt.executeQuery();

            loggedIn = set.next();

            if (loggedIn == true) {
                return set.getInt("id");
            } else {
                return 0;
            }
        } catch (SQLException exc) {
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, exc);
        }

        return 0;
    }
    
    public List<Utenti> searchUtenti(String toSearch) throws MalformedURLException{
        List<Utenti> listToReturn = new ArrayList<>();
        
        for(Utenti u: getUsers()){
            if(u.getNome().contains(toSearch))
                listToReturn.add(u);
        }
        
        return listToReturn;
    }
}
