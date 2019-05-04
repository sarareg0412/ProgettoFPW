/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.util.List;
import model.Articoli;
import model.Utenti;
import model.UtentiFactory;

/**
 *
 * @author Sara
 */
public class Login extends HttpServlet {

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

        
        // inizializzo la sessione
        HttpSession session = request.getSession();

        // cerco prima l'utente in sessione
        Utenti user = (Utenti) session.getAttribute("utente");

        if (user == null) { //Utente non si è autenticato
            String username = request.getParameter("userName");
            String password = request.getParameter("password");
            
            System.out.println(username);

            //Controllo se per il dato username e pw c'è un utente nella factory
            user = UtentiFactory.getInstance().getUserByUP(username, password);

            if (user != null) {
                // ho autenticato l'utente, lo salvo in sessione
                session.setAttribute("utente", user);
                session.setAttribute("login", true);
            }
            else
            {
                request.getRequestDispatcher("./M1/login.jsp").forward(request,response);
            }
        } 
        
        if(user != null){//Utente già autenticato
            //Setto l'utente
            request.setAttribute("user", user);
            request.setAttribute("login", true);
            if (user.getStatus().equals("Autore")) {
                // devo riportare alla pagina con l'elenco degli articoli    
                request.getRequestDispatcher("/articoli.html").forward(request, response);
            } else { //riportare alla pagina gestione articoli
                request.getRequestDispatcher("/articoli.html").forward(request, response);
                
            }
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
