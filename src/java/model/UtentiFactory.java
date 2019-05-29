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
            String sql = "select * from utente where email = ? and password = ?";
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
                utente.setPassword(set.getString("password"));
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
            String sql = "select * from utenti where id = ?";
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
                utente.setPassword(set.getString("password"));
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
        try {
            String autore = "DELETE FROM autori WHERE id_autore = ?";

            stmt.setInt(1, id);
            stmt.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true); //Per completezza
            stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            Logger.getLogger(AutoreFactory.class.getName()).log(Level.SEVERE, null, e);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(AutoreFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return false;

        }
        return null;

    }
     */
    
    public Boolean deleteUtente(int id) {
        Connection conn = null;
        
        try {
            conn = DbManager.getInstance().getDbConnection();
            conn.setAutoCommit(false);

            String articolo = "delete from utenti_articoli where utente_id = ?";
            PreparedStatement stmt = conn.prepareStatement(articolo);
            
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
}
