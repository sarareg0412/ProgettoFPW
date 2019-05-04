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

    /**
     * Ritorna la lista degli articoli creati
     */
    public List<Articoli> getArticles() {
        List<Articoli> articles = new ArrayList<>();
        String[] s = new String[3];
        
        Utenti autore1 = new Utenti();
        autore1.setUsername("sarareg98");
        autore1.setPassword("sara");
         
        Utenti autore2 = new Utenti();
        autore2.setUsername("bianchigiann81");
        autore2.setPassword("gianni"); 
        

        Articoli a1 = new Articoli();
        a1.setTitolo("La SQL injection");
   
        s[0] = "CSS";
        s[1] = "HTML";
        a1.setCategorie(s);
        a1.setData("24/3/19");
        a1.setTesto("La Sql injection è una pratica che consente...");
        a1.setStato("IN VALUTAZIONE");
        a1.setAutore(autore1);
        articles.add(a1);
        
        Articoli a2 = new Articoli();
        a2.setTitolo("Le Servlet");
   
        s[0] = "CSS";
        s[1] = "SERVLET";
        a2.setCategorie(s);
        a2.setData("2/4/19");
        a2.setTesto("Le Servlet consentono di...");
        a2.setStato("APERTO");
        a2.setAutore(autore1);
        articles.add(a2);
        
        Articoli a3 = new Articoli();
        a3.setTitolo("Il DataBase");
   
        s[0] = "JSP";
        a3.setCategorie(s);
        a3.setData("4/5/19");
        a3.setTesto("Il DataBase è...");
        a3.setStato("RIFIUTATO");
        a3.setAutore(autore1);
        articles.add(a3);
        
        Articoli a4 = new Articoli();
        a4.setTitolo("Le Classi Java");
        a4.setAutore(autore2);
        s[0] = "JSP";
        s[1] = "HTML";
        a4.setCategorie(s);
        a4.setData("2/4/19");
        a4.setTesto("La Servlet vengono utilizzate nella programmazione web...");
        a4.setStato("RIFIUTATO");
        articles.add(a4);;

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
        List<Articoli> lista = null;    //Lista da restituire

        /* Per ogni articolo, controllo se contiene la categoria 
        inserita,e lo aggiungo alla lista da restituire */
        for (Articoli u : articles) {
            String[] s = u.getCategorie();

            for (int i = 0; i < s.length; i++) {
                if (s[i].equals(categoria)) {
                    lista.add(u);
                }
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

            for (Utenti autori : u.getAutori()) {
                if (autori.equals(autore)) {
                    lista.add(u);
                }
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
    
}
