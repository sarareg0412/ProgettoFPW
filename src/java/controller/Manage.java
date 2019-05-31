/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Articoli;
import model.ArticoliFactory;
import model.Utenti;
import model.UtentiFactory;
import model.Valutazioni;
import model.ValutazioniFactory;

/**
 *
 * @author Sara
 */
public class Manage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Setto la sessione
        HttpSession session = request.getSession();

        if (session.getAttribute("utenteId") != null) {//Utente già autenticato
            int autoreId = (int) session.getAttribute("utenteId");
            //Cerco l'utente nel sistema e lo setto nella risposta
            Utenti user = UtentiFactory.getInstance().getUserById(autoreId);
            request.setAttribute("user", user);
            
            if(user.getStatus().equals("Autore")){  //L'utente Autore non può entrare in questa pagina, 
                                                    //ma setto comunque gli attributi fondamentali per la richiesta
                
            
                List<Valutazioni> valutazioni = ValutazioniFactory.getInstance().getValutazioniByValutatore(user);
                request.setAttribute("valutazioni", valutazioni);   //Valutazioni dell'utente
                
                List<Articoli> articoli = ArticoliFactory.getInstance().getArticlesByAuthor(user.getId());
                request.setAttribute("articoli", articoli);         //Articoli dell'utente
            }else{
                //Cerco tutti gli articoli nel sistema e li setto
                List<Valutazioni> valutazioni = ValutazioniFactory.getInstance().getValutazioni();
                request.setAttribute("valutazionitot", valutazioni);
            }
            //Riporto alla jsp gestion
            request.getRequestDispatcher("./M1/gestione.jsp").forward(request, response);
        
        } else {    //Utente non autenticato
            //Riporto comunque alla jsp gestione
            request.getRequestDispatcher("./M1/gestione.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
