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
    
    /* METODI D'ISTANZA */

    /**
     * Ritorna la lista degli articoli creati
     */
    public List<Articoli> getArticles() {
        List<Articoli> articles = new ArrayList<>();
        
        String s1,s2,s3;
        s1 = "CSS";
        s2 = "HTML";
        s3 = "Servlet";
        
        Utenti sara = UtentiFactory.getInstance().getUserById(1);
        Utenti gianni = UtentiFactory.getInstance().getUserById(2);
        Utenti mario = UtentiFactory.getInstance().getUserById(3);
        
        Articoli a1 = new Articoli();
        a1.setTitolo("La SQL injection");
        a1.getCategorie().add(s1);
        a1.getCategorie().add(s2);
        a1.setData("24/3/19");
        a1.setFormatoData("2019-03-24");
        a1.setTesto("La Sql injection è una pratica che consente...");
        a1.setStato("APERTO");
        a1.getAutori().add(sara);
        a1.setPid("1");
        articles.add(a1);

        Articoli a2 = new Articoli();
        a2.setTitolo("Le Servlet");

        a2.getCategorie().add(s1);
        a2.getCategorie().add(s3);
        a2.setData("2/4/19");
        a2.setFormatoData("2019-04-02");
        a2.setTesto("Le Servlet consentono di...");
        a2.setStato("APERTO");
        a2.getAutori().add(sara);
        a2.getAutori().add(mario);
        a2.setPid("2");
        articles.add(a2);

        Articoli a3 = new Articoli();
        a3.setTitolo("Il DataBase");

        s1 = "JSP";
        a3.getCategorie().add(s1);
        a3.setData("4/5/19");
        a3.setFormatoData("2019-05-04");
        a3.setTesto("Il DataBase è...");
        a3.setStato("APERTO");
        a3.getAutori().add(sara);
        a3.setPid("3");

        articles.add(a3);

        Articoli a4 = new Articoli();
        a4.setTitolo("Le Classi Java");
        a4.getAutori().add(sara);
        a4.getAutori().add(mario);
        a4.getCategorie().add(s1);
        a4.getCategorie().add(s2);
        a4.setData("2/4/19");
        a4.setFormatoData("2019-04-02");
        a4.setTesto("La Servlet vengono utilizzate nella programmazione web...");
        a4.setStato("RIFIUTATO");
        a4.setPid("4");

        articles.add(a4);

        Articoli a5 = new Articoli();
        a5.setTitolo("Il tag br");
        a5.getAutori().add(mario);
        a5.getCategorie().add(s1);
        a5.getCategorie().add(s3);
        a5.setData("2/4/19");
        a5.setFormatoData("2019-04-02");
        a5.setTesto("Il tag br viene utilizzato nel linguaggio html...");
        a5.setStato("IN VALUTAZIONE");
        a5.setPid("5");

        articles.add(a5);

        Articoli a6 = new Articoli();
        a6.setTitolo("Il ServletContainer");
        s2 = "Servlet";
        a6.getCategorie().add(s2);
        a6.setData("4/5/19");
        a6.setFormatoData("2019-05-04");
        a6.setTesto("Il Servlet Container è...");
        a6.setStato("RIFIUTATO");
        a6.getAutori().add(sara);
        a6.setPid("6");
        articles.add(a6);

        Articoli a7 = new Articoli();
        a7.setTitolo("HTML 6");
        s1 = "HTML";
        a7.getCategorie().add(s1);
        a7.setData("4/5/19");
        a7.setFormatoData("2019-05-04");
        a7.setTesto("HTML 6...");
        a7.setStato("IN VALUTAZIONE");
        a7.getAutori().add(mario);
        a7.setPid("7");
        articles.add(a7);
        
        
        return articles;
    }

    /**
     * Ritorna un articolo in base al titolo
     *
     * @param titolo
     */
    public Articoli getArticleByTitle(String titolo) {
        List<Articoli> articles = this.getArticles();

        for (Articoli u : articles) {
            if (u.getTitolo().equals(titolo)) {
                return u;
            }
        }

        return null;
    }

    /**
     * @return lista di articoli che matchano la categoria inserita
     */
    public List<Articoli> getArticlesByCategory(String categoria) {

        List<Articoli> articles = this.getArticles();
        List<Articoli> lista = new ArrayList<>();    //Lista da restituire

        /* Per ogni articolo, controllo se contiene la categoria 
        inserita,e lo aggiungo alla lista da restituire */
        for (Articoli u : articles) {

            if (u.getCategorie().contains(categoria)) {
                lista.add(u);
            }
        }

        return lista;
    }

    /**
     * @return lista di articoli che matchano l'autore inserito
     */
    public List<Articoli> getArticlesByAuthor(Utenti autore) {

        List<Articoli> articles = this.getArticles();
        List<Articoli> lista = new ArrayList<>();    //Lista da restituire

        /* Per ogni articolo, controllo se contiene l'autore
        inserito,e lo aggiungo alla lista da restituire */
        for (Articoli u : articles) {

            if (u.getAutori().contains(autore)) {
                lista.add(u);
            }
        }

        return lista;
    }

    /**
     * @param data
     * @return lista di articoli che matchano la data inserita
     */
    public List<Articoli> getArticlesByDate(String data) {

        List<Articoli> articles = this.getArticles();
        List<Articoli> lista = null;    //Lista da restituire

        /* Per ogni articolo, controllo se contiene la data 
        inserita,e lo aggiungo alla lista da restituire */
        for (Articoli u : articles) {
            String s = u.getData();

            if (s.equals(data)) {
                lista.add(u);
            }

        }

        return lista;
    }

    /**
     * @param stato
     * @return lista di articoli che matchano lo stato inserito
     */
    public List<Articoli> getArticlesByStatus(String stato) {

        List<Articoli> articles = this.getArticles();
        List<Articoli> lista = null;    //Lista da restituire

        /* Per ogni articolo, controllo se ha lo stato
        inserito,e lo aggiungo alla lista da restituire */
        for (Articoli u : articles) {
            String s = u.getStato();

            if (s.equals(stato)) {
                lista.add(u);
            }

        }

        return lista;
    }

    public Articoli getArticleByPid(String pid) {
        List<Articoli> articles = this.getArticles();

        for (Articoli u : articles) {
            String s = u.getPid();

            if (s.equals(pid)) {
                return u;
            }
        }
        return null;
    }
}
