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
        
        int[] data = new int[3];
        data[0] = 22;
        data[1] = 5;
        data[2] = 2019;

        Articoli a1 = new Articoli();
        a1.setTitolo("La SQL injection");
   
        s[0] = "CSS";
        s[1] = "HTML";
        a1.setCategorie(s);
        a1.setData(data);
        a1.setTesto("La Sql injection è una pratica che consente...");
        a1.setStato("In valutazione");
        a1.setAutore(autore1);
        articles.add(a1);

        Articoli a2 = new Articoli();
        a2.setTitolo("Le Servlet");
        a2.setAutore(autore2);
        s[0] = "JSP";
        s[1] = "HTML";
        a2.setCategorie(s);
        a2.setData(data);
        a2.setTesto("La Servlet vengono utilizzate nella programmazione web...");
        a2.setStato("Modificato");
        articles.add(a2);;

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
        List<Articoli> lista = null;    //Lista da restituire

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
    public List<Articoli> getArticlesByDate(int[] data) {

        List<Articoli> articles = this.getArticles();
        List<Articoli> lista = null;    //Lista da restituire

        /* Per ogni articolo, controllo se contiene la data 
        inserita,e lo aggiungo alla lista da restituire */
        for (Articoli u : articles) {
            Integer[] s = u.getData();

            if (s[0] == data[0] && s[1] == data[1] && s[2] == data[2]) {
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
