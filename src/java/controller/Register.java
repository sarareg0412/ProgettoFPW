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

        HttpSession session = request.getSession();

        if (session.getAttribute("utenteId") != null) {//Utente già autenticato
            System.out.println("entrato utente con id" + session.getAttribute("utenteId"));
            int autoreId = (int) session.getAttribute("utenteId");
            Utenti user = UtentiFactory.getInstance().getUserById(autoreId);
            
            List<Articoli> articoli = ArticoliFactory.getInstance().getArticlesByAuthor(user);
            request.setAttribute("articoli", articoli);
            
            List<Valutazioni> valutazioni = ValutazioniFactory.getInstance().getValutazioniByValutatore(user);
            request.setAttribute("valutazioni", valutazioni);
            
            if (request.getParameter("modifica") != null) {
                System.out.println("modifico utente con id" + session.getAttribute("utenteId"));

                String nome = request.getParameter("nome");
                String cognome = request.getParameter("cognome");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String ente = request.getParameter("ente");

                user.setNome(nome);
                user.setCognome(cognome);
                user.setEmail(email);
                user.setPassword(password);
                user.setEnte(ente);

                System.out.println("nuovo nome: " + nome);
            }

            request.setAttribute("user", user);
            
            request.getRequestDispatcher("./M1/profilo.jsp").forward(request, response);
        } else {
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
