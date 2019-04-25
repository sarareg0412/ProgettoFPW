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
        int[] data = new int[3];
        data[0] = 22;
        data[1] = 5;
        data[2] = 2019;
        s[0] = "autore1";
        s[1] = "autore2";
        s[2] = "autore3";

        Articoli a1 = new Articoli();
        a1.setTitolo("La SQL injection");
        a1.setAutori(s);
        s[0] = "CSS";
        s[1] = "HTML";
        a1.setCategorie(s);
        a1.setData(data);
        a1.setTesto("La Sql injection è una pratica che consente...");
        a1.setStato("In valutazione");
        articles.add(a1);

        Articoli a2 = new Articoli();
        a2.setTitolo("Le Servlet");
        a2.setAutori(s);
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
    public List<Articoli> getArticlesByAuthor(String autore) {

        List<Articoli> articles = this.getArticles();
        List<Articoli> lista = null;    //Lista da restituire

        /* Per ogni articolo, controllo se contiene l'autore
        inserito,e lo aggiungo alla lista da restituire */
        for (Articoli u : articles) {
            String[] s = u.getAutori();

            for (int i = 0; i < s.length; i++) {
                if (s[i].equals(autore)) {
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
            int[] s = u.getData();

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
