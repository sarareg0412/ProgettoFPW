/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Sara
 */
public class ArticoliFactory {

    /**
     * Unica istanza che può restituire gli articoli
     */
    private static ArticoliFactory singleton;

    /**
     * Nessuno può creare altre ArticoliFactory
     */
    private ArticoliFactory() {

    }

    public static ArticoliFactory getInstance() {
        if (singleton == null) {
            singleton = new ArticoliFactory();
        }
        return singleton;
    }

    /* METODI D'ISTANZA 
     * Ritorna la lista degli articoli creati
     */
    public List<Articoli> getArticles() throws MalformedURLException {
        List<Articoli> articles = new ArrayList<>();
        long a = 2019;
        Date date = new Date(a);

        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            Statement stmt = conn.createStatement();

            String sql = "select articolo.*, utente_articolo.*, utente.id from utente inner join (articolo inner join utente_articolo on articolo.pid = utente_articolo.articolo_id) "
                    + "on utente.id = utente_articolo.utente_id";

            ResultSet set = stmt.executeQuery(sql);

            while (set.next()) {
                boolean flag = false;
                for (Articoli art : articles) {
                    /*Per ogni articolo, se c'è già l'articolo creato, si aggiunge il nuovo utente*/
                    if (art.getPid() == set.getInt("pid")) {
                        art.getAutori().add(UtentiFactory.getInstance().getUserById(set.getInt("id")));
                        flag = true;    //C'è già l'articolo nella colonna scelta
                    }
                }

                if (flag == false) {
                    Articoli articolo = new Articoli();

                    articolo.setPid(set.getInt("pid"));
                    articolo.setTitolo(set.getString("titolo"));
                    articolo.setData(set.getDate("data_creazione"));
                    articolo.setImmagine(new URL(set.getString("immagine")));
                    articolo.setTesto(set.getString("testo"));
                    articolo.setStato(set.getString("stato"));
                    String[] categorie = set.getString("categorie").split(" ");
                    articolo.setCategorie(Arrays.asList(categorie));
                    articolo.getAutori().add(UtentiFactory.getInstance().getUserById(set.getInt("id")));
                    articles.add(articolo);
                }

            }
            stmt.close();
            conn.close();
        } catch (SQLException exc) {
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, exc);
        }

        Collections.sort(articles);     //Ordina la lista secondo il compareTo() degli articoli
        return articles;
    }

    /**
     * @return lista di articoli che matchano l'autore inserito
     */
    public List<Articoli> getArticlesByAuthor(int id) throws MalformedURLException {

        List<Articoli> lista = new ArrayList<>();

        try {

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from utente_articolo where utente_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet set = stmt.executeQuery();

            while (set.next()) {
                Articoli articolo = ArticoliFactory.getInstance().getArticleByPid(set.getInt("articolo_id"));
                lista.add(articolo);
            }

            stmt.close();
            conn.close();
        } catch (SQLException exc) {
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, exc);
        }
        Collections.sort(lista);     //Ordina la lista secondo il compareTo() degli articoli
        return lista;
    }

    public Articoli getArticleByPid(int pid) throws MalformedURLException {
        try {
            Boolean esiste_articolo;

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select articolo.*, utente_articolo.*, utente.id from utente inner join (articolo inner join utente_articolo on articolo.pid = utente_articolo.articolo_id) "
                    + "on utente.id = utente_articolo.utente_id where pid = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, pid);

            ResultSet set = stmt.executeQuery();

            esiste_articolo = set.next();

            if (esiste_articolo == true) {
                Articoli articolo = new Articoli();
                long a = 12345;
                Date data = new Date(a);
                articolo.setPid(set.getInt("pid"));
                articolo.setTitolo(set.getString("titolo"));
                articolo.setData(set.getDate("data_creazione"));
                articolo.setImmagine(new URL(set.getString("immagine")));
                articolo.setTesto(set.getString("testo"));
                articolo.setStato(set.getString("stato"));
                String[] categorie = set.getString("categorie").split(" ");
                articolo.setCategorie(Arrays.asList(categorie));
                articolo.getAutori().add(UtentiFactory.getInstance().getUserById(set.getInt("id")));

                while (set.next()) {  //L'articolo ha più autori
                    articolo.getAutori().add(UtentiFactory.getInstance().getUserById(set.getInt("id")));
                }

                stmt.close();
                conn.close();
                return articolo;
            } else {
                return null;
            }
        } catch (SQLException exc) {
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, exc);
        }

        return null;
    }

    public Articoli updateArticle(HttpServletRequest request, int pid) throws MalformedURLException {
        try {
            Boolean esiste_articolo;
            long a = 1234;
            Date data = new Date(a);
            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "update articolo set titolo = ?, categorie = ?, immagine = ?, data_creazione = ?, testo = ? where pid = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, request.getParameter("titolo"));
            String[] categorie = request.getParameterValues("category");
            String categ_nuove = "";

            for (String s : categorie) {
                categ_nuove += s + " ";
            }
            categ_nuove = categ_nuove.substring(0, categ_nuove.length() - 1);
            stmt.setString(2, categ_nuove);
            stmt.setString(3, request.getParameter("immagine"));
            stmt.setDate(4, data.valueOf(request.getParameter("start")));
            stmt.setString(5, request.getParameter("testo"));
            stmt.setInt(6, pid);

            int res = stmt.executeUpdate();

            if (res > 0) {  //modificata almeno una riga
                String[] nome_cognome = request.getParameter("nome_autore").split(" ");
                Articoli art = ArticoliFactory.getInstance().updateAutori(nome_cognome[0], nome_cognome[1], pid);
                stmt.close();
                conn.close();
                return art;
            } else {
                return null;
            }
        } catch (SQLException exc) {
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, exc);
        }
        return null;
    }

    public Articoli updateAutori(String nome, String cognome, int pid) throws MalformedURLException {
        try {

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "insert into utente_articolo values (?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            int id = UtentiFactory.getInstance().getPidByNS(nome, cognome);
            if (id != 0) {
                stmt.setInt(1, id);
                stmt.setInt(2, pid);

                int res = stmt.executeUpdate();

                if (res > 0) {  //modificata almeno una riga
                    Articoli articolo = ArticoliFactory.getInstance().getArticleByPid(pid);
                    Utenti user = UtentiFactory.getInstance().getUserById(id);
                    articolo.getAutori().add(user);
                    stmt.close();
                    conn.close();
                    return articolo;
                } else {
                    return null;
                }
            }
        } catch (SQLException exc) {
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, exc);
        }
        return null;
    }

    public Articoli createArticle() throws MalformedURLException {
        try {
            Boolean crea_articolo;

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "insert into articolo values (default, 'Inserisci titolo', default, 'https://studio99.sm/wp-content/uploads/2018/03/informatica-1030x580.jpg', '2019-01-01', 'Inserire testo qui', 'APERTO')";
            PreparedStatement stmt = conn.prepareStatement(sql);

            int i = stmt.executeUpdate();

            if (i > 0) {
                int pid = ArticoliFactory.getInstance().getPidByNome("Inserisci titolo");
                Articoli articolo = ArticoliFactory.getInstance().getNuovoArticolo(pid);
                stmt.close();
                conn.close();
                return articolo;
            }
        } catch (SQLException exc) {
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, exc);
        }

        return null;
    }

    public Articoli getNuovoArticolo(int pid) throws MalformedURLException {
        try {
            Boolean esiste_articolo;

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from articolo where pid = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, pid);

            ResultSet set = stmt.executeQuery();

            esiste_articolo = set.next();

            if (esiste_articolo == true) {
                Articoli articolo = new Articoli();
                long a = 12345;
                Date data = new Date(a);
                articolo.setPid(set.getInt("pid"));
                articolo.setTitolo(set.getString("titolo"));
                articolo.setData(set.getDate("data_creazione"));
                articolo.setImmagine(new URL(set.getString("immagine")));
                articolo.setTesto(set.getString("testo"));
                articolo.setStato(set.getString("stato"));
                String[] categorie = set.getString("categorie").split(" ");
                articolo.setCategorie(Arrays.asList(categorie));

                stmt.close();
                conn.close();
                return articolo;
            } else {
                return null;
            }
        } catch (SQLException exc) {
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, exc);
        }

        return null;
    }

    public int getPidByNome(String titolo) {
        try {
            Boolean loggedIn;

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from articolo where titolo = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, titolo);
            ResultSet set = stmt.executeQuery();

            loggedIn = set.next();

            if (loggedIn == true) {
                return set.getInt("pid");
            } else {
                return 0;
            }
        } catch (SQLException exc) {
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, exc);
        }

        return 0;
    }

}
