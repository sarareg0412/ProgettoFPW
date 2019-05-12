/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Sara
 */
public class UtentiFactory {
    /** Unica istanza che può restituire gli utenti*/
    private static UtentiFactory singleton;
    
    /** Nessuno può creare altre UtentiFactory*/
    private UtentiFactory(){}
    
    public static UtentiFactory getInstance(){
        if(singleton == null) {
            singleton = new UtentiFactory();
        }
        return singleton;
    }
    
    /** Ritorna la lista degli utenti loggati*/
    public List<Utenti> getUsers(){
        List<Utenti> users = new ArrayList<>();
        File file = null;
        
        Utenti u1 = new Utenti();
        u1.setId(1);
        u1.setUsername("sarareg98");
        u1.setNome("Sara");
        u1.setCognome("Regali");
        u1.setEmail("sara98.regali@gmail.it");
        u1.setPassword("sara");
        u1.setEnte("universita di Cagliari");
        u1.setStatus("Autore");
        u1.setFile(file);
        users.add(u1);
        
        Utenti u2 = new Utenti();
        u2.setId(2);
        u2.setUsername("bianchigiann81");
        u2.setNome("Gianni");
        u2.setCognome("Bianchi");
        u2.setEmail("gianni.bianchi@gmail.it");
        u2.setPassword("gianni");
        u2.setEnte("universita di Cagliari");
        u2.setStatus("Organizzatore");
        u2.setFile(file);
        users.add(u2);
        
        Utenti u3 = new Utenti();
        u3.setId(3);
        u3.setUsername("mariorossi2");
        u3.setNome("Mario");
        u3.setCognome("Rossi");
        u3.setEmail("mario.rossi@gmail.it");
        u3.setPassword("mario");
        u3.setEnte("universita di Cagliari");
        u3.setStatus("Autore");
        u3.setFile(file);
        users.add(u3);
        return users;
    }
    
    /** Ritorna un utente in base al suo username e password
     * @return user*/
    
    public Utenti getUserByUP(String username, String password){
        List<Utenti> users = this.getUsers();
        
        for(Utenti u : users){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                return u;
            }
        }
        
        return null; 
    }
    
     /** Ritorna un utente in base al suo nome e cognome
     * @return user*/
    
    public Utenti getUserByNS(String nome, String cognome){
        List<Utenti> users = this.getUsers();
        
        for(Utenti u : users){
            if(u.getNome().equals(nome) && u.getCognome().equals(cognome)){
                return u;
            }
        }
        
        return null; 
    }
    
     /** Ritorna un utente in base alla sua mail
     * @return user*/
    
    public Utenti getUserByEmail(String email){
        List<Utenti> users = this.getUsers();
        
        for(Utenti u : users){
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        
        return null; 
    }
    
    /** Ritorna un utente in base al suo id
     * @return user*/
    
    public Utenti getUserById(int id){
        List<Utenti> users = this.getUsers();
        
        for(Utenti u : users){
            if(u.getId() == id ){
                return u;
            }
        }
        
        return null; 
    }
    
    /**
     *
     * @param ente
     * @return Lista utenti
     */
    
    /** Ritorna una lista di utenti appartenenti a quell'ente*/
    public List<Utenti> getUsersByEnte(String ente) {

        List<Utenti> users = this.getUsers();
        List<Utenti> lista = null;    //Lista da restituire

        /* Per ogni utente, controllo se appartiene all'ente
        inserito,e lo aggiungo alla lista da restituire */
        for (Utenti u : users) {
            String s = u.getEnte();

            if (s.equals(ente)) {
                lista.add(u);
            }
        }

        return lista;
    }
    
    
}
