/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.net.URL;
import static javax.servlet.SessionTrackingMode.URL;


/**
 *
 * @author Sara
 */
public class Utenti {

    private String password;        //Password utente
    private String nome;            //Nome
    private String cognome;         //Cognome
    private String email;           //Email
    private URL ente;            //Ente
    private String status;          //Organizzatore o Autore
    private int id;                 //Ogni utente ha un id che lo contraddistingue
    private File path;             //Path per l'immagine

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the ente
     */
    public URL getEnte() {
        return ente;
    }

    /**
     * @param ente the ente to set
     */
    public void setEnte(URL ente) {
        this.ente = ente;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return the path
     */
    public File getFile() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setFile(File path) {
        this.path = path;
    }
    
    @Override
    //Due utenti sono uguali se il loro username e password sono uguali
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Utenti)) {
            return false;
        }
        Utenti other = (Utenti) obj;
        if (!this.email.equals(other.email)) {
            return false;
        }

        if (!this.password.equals(other.password)) {
            return false;
        }

        return true;
    }



}
