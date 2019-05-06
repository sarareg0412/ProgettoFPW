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

        HttpSession session = request.getSession();

        if (session.getAttribute("utenteId") != null) {//Utente già autenticato

            //Setto l'utente
            int autoreId = (int) session.getAttribute("utenteId");
            Utenti user = UtentiFactory.getInstance().getUserById(autoreId);
            request.setAttribute("user", user);

            List<Articoli> articoli = ArticoliFactory.getInstance().getArticlesByAuthor(user);
            request.setAttribute("articoli", articoli);

            if (request.getParameter("pid") == null) {
                //request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                String n = request.getParameter("pid");
                Articoli articoloScelto = ArticoliFactory.getInstance().getArticleByPid(n);
                List<Utenti> autori = articoloScelto.getAutori();
                request.setAttribute("autori", autori);
                
                
                if (request.getParameter("modifica") != null) {
                    System.out.println("ciao");
                    //Salvo le nuove info inserite
                    String titolo = request.getParameter("titolo");
                    String testo = request.getParameter("testo");
                    String formatoData = request.getParameter("start"); //Le 3 celle contengono le cifre della data di creazione articolo
                    
                    articoloScelto.setTitolo(titolo);
                    articoloScelto.setTesto(testo);
                    articoloScelto.setFormatoData(formatoData);
                }

                request.setAttribute("scelto", articoloScelto);                
                request.getRequestDispatcher("./M1/scriviArticolo.jsp").forward(request, response);

            }
        } else { //utente non autenticato
            Utenti user = null;
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
