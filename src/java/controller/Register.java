/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
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
public class Register extends HttpServlet {

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
            //Setto l'utente
            int autoreId = (int) session.getAttribute("utenteId");
            Utenti user = UtentiFactory.getInstance().getUserById(autoreId);
            
            //Setto gli articoli dell'utente
            List<Articoli> articoli = ArticoliFactory.getInstance().getArticlesByAuthor(user.getId());
            request.setAttribute("articoli", articoli);
            
            //Setto le valutazioni dell'utente
            List<Valutazioni> valutazioni = ValutazioniFactory.getInstance().getValutazioniByValutatore(user.getId());
            request.setAttribute("valutazioni", valutazioni);
            
            //Se è stato premuto il pulsante salva setto tutti i nuovi parametri dell'utente
            if (request.getParameter("modifica") != null) {
               user = UtentiFactory.getInstance().updateUtente(request, autoreId);

            }
            //Setto l'utente
            request.setAttribute("user", user);
            //Chiamo la jsp
            request.getRequestDispatcher("./M1/profilo.jsp").forward(request, response);
        } else {
            //Chiamo comunque la jsp
            request.getRequestDispatcher("./M1/profilo.jsp").forward(request, response);
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
