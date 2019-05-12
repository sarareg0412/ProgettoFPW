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

        if (request.getParameter("login") != null ) { //Utente non si è autenticato
            String username = request.getParameter("userName");     //Prelevo dalla richiesta username e password
            String password = request.getParameter("password");
            
            //Controllo se per il dato username e pw c'è un utente nella factory
            Utenti user = UtentiFactory.getInstance().getUserByUP(username, password);

            if (user != null) {
                // ho autenticato l'utente, lo salvo in sessione
                session.setAttribute("utenteId", user.getId());
            }
            else
            {   //Riporto alla pagina di login
                request.getRequestDispatcher("./M1/login.jsp").forward(request,response);
            }
        } 
        
        if(session.getAttribute("utenteId")!= null){//Utente già autenticato
            
            int id = (int) session.getAttribute("utenteId");            //Salvo l'id
            Utenti user = UtentiFactory.getInstance().getUserById(id);  //Cerco l'utente tramite il suo id
            
            //Setto i parametri della richiesta
            request.setAttribute("id",id);
            request.setAttribute("autore", user);
            
            //In base allo status dell'autore lo riporto alle diverse pagine
            if (user.getStatus().equals("Autore")) {
                // devo riportare alla pagina con l'elenco degli articoli  
                request.getRequestDispatcher("/articoli.html").forward(request, response);
            } else { //utente è organizzatore
                //Riporto alla pagina di gestione
                request.getRequestDispatcher("/gestione.html").forward(request, response);
            }
            
        } else { //utente non autenticato, lo riporto alla pagina di login
                request.getRequestDispatcher("./M1/login.jsp").forward(request, response);
                
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
