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

        HttpSession session = request.getSession(false);
        
        if(session.getAttribute("login").equals(false)){  //Non c'era una sessione attiva, torniamo al login
            response.sendRedirect(request.getContextPath() + "/login.html");
        }
        // cerco l'utente nella sessione
        Utenti user = (Utenti) session.getAttribute("utente");
        request.setAttribute("user", user);
        
        if(user == null){ //Torniamo al login
           response.sendRedirect(request.getContextPath() + "/login.html");
        }
         
        
        String n = request.getParameter("pid");
         
        Articoli articoloScelto = ArticoliFactory.getInstance().getArticleByPid(n);
        
        if(articoloScelto == null){
            System.out.println("Articolo non trovato");
        }else{
            request.setAttribute("scelto" , articoloScelto );
            
            List<Utenti> autori = articoloScelto.getAutori();
            request.setAttribute("autori", autori);
            request.getRequestDispatcher("./M1/scriviArticolo.jsp").forward(request,response);
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
