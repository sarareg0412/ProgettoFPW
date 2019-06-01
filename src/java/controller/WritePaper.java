/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
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
public class WritePaper extends HttpServlet {

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
            //Se non viene passato un pid alla risposta, o se il pid non è valido, 
            // o se un utente cerca di accedere a un articolo che non ha scritto, 
            // o se si cerca di accedere a un atricolo che non ha lo stato "APERTO", si viene rimandati alla jsp errore
            if (request.getParameter("pid") == null 
                    || ArticoliFactory.getInstance().getArticleByPid(Integer.parseInt(request.getParameter("pid"))) == null
                    || ArticoliFactory.getInstance().getArticleByPid(Integer.parseInt(request.getParameter("pid"))).
                            getAutori().contains(UtentiFactory.getInstance().getUserById((int)session.getAttribute("utenteId"))) == false
                    || ArticoliFactory.getInstance().getArticleByPid(Integer.parseInt(request.getParameter("pid"))).getStato().equals("APERTO") == false) {  
                
                request.getRequestDispatcher("./M1/errore.jsp").forward(request, response);
            } else {
                //Setto l'utente
                int autoreId = (int) session.getAttribute("utenteId");
                Utenti user = UtentiFactory.getInstance().getUserById(autoreId);
                request.setAttribute("user", user);
                
                //Setto gli articoli dell'utente
                List<Articoli> articoli = ArticoliFactory.getInstance().getArticlesByAuthor(user.getId());
                request.setAttribute("articoli", articoli);
                
                //Setto le valutazioni dell'utente
                List<Valutazioni> valutazioni = ValutazioniFactory.getInstance().getValutazioniByValutatore(user.getId());
                request.setAttribute("valutazioni", valutazioni);

                int n = Integer.parseInt(request.getParameter("pid"));
                Articoli articoloScelto = ArticoliFactory.getInstance().getArticleByPid(n);
                List<Utenti> autori = articoloScelto.getAutori();
                request.setAttribute("autori", autori);
                
                if (request.getParameter("modifica") == null) {
                    request.setAttribute("modif", false);
                }
                if (request.getParameter("modifica") != null) {
                    request.setAttribute("modif", true);

                    ArticoliFactory.getInstance().updateArticle(n, request);
                }
                //Setto l'articolo scelto e invio alla jsp
                request.setAttribute("scelto", articoloScelto);
                request.getRequestDispatcher("./M1/scriviArticolo.jsp").forward(request, response);

            }
        } else { //utente non autenticato
            //Invio comunque alla jsp
            request.getRequestDispatcher("./M1/scriviArticolo.jsp").forward(request, response);

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
