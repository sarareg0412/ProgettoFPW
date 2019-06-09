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
import javax.servlet.http.HttpServletRequest;
import utils.AuthorTokenizer;

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

    public Utenti getUserByNS(String nome, String cognome) throws MalformedURLException {

        try {
            Boolean loggedIn;

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from utente where nome = ? and cognome = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2, cognome);

            ResultSet set = stmt.executeQuery();

            loggedIn = set.next();  //C'è almeno una riga?

            if (loggedIn == true) {
                Utenti utente = UtentiFactory.getInstance().getUserById(set.getInt("id"));

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

    public Utenti updateUtente(HttpServletRequest request, int id) throws MalformedURLException {
        try {
            Boolean esiste_utente;

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "update utente set nome = ?, cognome = ?, foto = ?, ente = ?, email = ?, pw = ? where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, request.getParameter("nome"));
            stmt.setString(2, request.getParameter("cognome"));
            stmt.setString(3, request.getParameter("immagine"));
            stmt.setString(4, request.getParameter("ente"));
            stmt.setString(5, request.getParameter("email"));
            stmt.setString(6, request.getParameter("password"));
            stmt.setInt(7, id);

            int res = stmt.executeUpdate();

            if (res > 0) {  //modificata almeno una riga
                //Modifica automaticamente tutti i campi
                Utenti user = UtentiFactory.getInstance().getUserById(id);

                stmt.close();
                conn.close();
                return user;
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
            stmt.setInt(1, id);

            ResultSet set = stmt.executeQuery();
            List<Integer> articoli = new ArrayList<>();

            while (set.next()) {
                articoli.add(set.getInt("articolo_id"));
            }

            for (int i = 0; i < articoli.size(); i++) {
                String art = "delete from articolo where pid = ?";
                PreparedStatement articolo = conn.prepareStatement(art);
                articolo.setInt(1, articoli.get(i));
                articolo.executeUpdate();
            }

            String utente_id = "delete from utente_articolo where utente_id = ?";
            PreparedStatement id_utente = conn.prepareStatement(utente_id);
            id_utente.setInt(1, id);
            id_utente.executeUpdate();

            String valutazioni = "delete from valutazioni where id_utente = ?";
            PreparedStatement val = conn.prepareStatement(valutazioni);
            id_utente.setInt(1, id);

            id_utente.executeUpdate();

            String utente = "delete from utente where id = ?";
            PreparedStatement user = conn.prepareStatement(utente);
            user.setInt(1, id);
            user.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);
            stmt.close();
            id_utente.close();
            user.close();
            conn.close();
            return true;
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

    }

    public List<AuthorTokenizer> searchUtenti(String toSearch) {
        List<AuthorTokenizer> users = new ArrayList<>();

        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            Statement stmt = conn.createStatement();

            String sql = "select * from utente";
            ResultSet set = stmt.executeQuery(sql);

            while (set.next()) {
                AuthorTokenizer utente = new AuthorTokenizer(set.getString("nome"), set.getString("cognome"), set.getInt("id"));
                if (utente.getName().contains(toSearch) || utente.getSurname().contains(toSearch)) {
                    users.add(utente);
                }
            }

            stmt.close();
            conn.close();

        } catch (SQLException exc) {
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, exc);
        }

        return users;
        
    }
}
