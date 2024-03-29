/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.fpw;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author kekko
 */
public class Profilo extends HttpServlet {

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
        /*Questa Servlet si occupa della gestione della modifica del profilo.
        Sara' infatti possibile modificare i singoli campi dell' utente e 
        l' eventuale eliminazione*/
        
        
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            
            //Setto l attributo Ruolo con l array dei ruoli
            request.setAttribute("ruolo", Ruolo.values());
            /*Eliminazione del profilo. Se viene cliccato il bottone viene passato il parametro
            Delete e si procede all eliminazione.Vengono resettate le varabili di sessione.*/
            if (request.getParameter("delete")!=null && request.getParameter("delete").equals("true")) {
                User us = (User) session.getAttribute("user");
                UserFactory.getInstance().eliminaProfilo(us.getId());
                session.invalidate();
                request.getRequestDispatcher("login.html").forward(request, response);
            }
            
            /*Modifica effettiva del profilo.
            Vengono controllati i parametri e in caso siano non nulli viene aggiornato il profilo*/
        if (request.getParameter("nome") != null
                && request.getParameter("cognome") != null
                && request.getParameter("email") != null
                && request.getParameter("descrizione") != null
                && request.getParameter("urlImmagine") != null
                && request.getParameter("ruolo") != null
                && request.getParameter("data") != null) {
            
            
            //recupero i parametri
            String nome = request.getParameter("nome");
            String cognome = request.getParameter("cognome");
            String email = request.getParameter("email");
            String des = request.getParameter("descrizione");
            String url = request.getParameter("urlImmagine");
            String pass = request.getParameter("password");
            Ruolo r = Ruolo.valueOf(request.getParameter("ruolo"));
            LocalDate data = LocalDate.parse(request.getParameter("data"));
            
            if(r.equals(Ruolo.Autore))
                session.setAttribute("autore", true);
           
            
            //modifica effettiva
            UserFactory userFactory = UserFactory.getInstance();
            User us = (User) session.getAttribute("user");
            
            if(us.getRuolo().equals(Ruolo.Autore)&&!r.equals(Ruolo.Autore))
                session.setAttribute("autore", false);
            userFactory.updateUser(nome, cognome, email, url,des, r, data, us, pass);
            //Viene aggiornato lo user corrente
            session.setAttribute("user", userFactory.getUserById(us.getId()));
        }
        request.getRequestDispatcher("profilo.jsp").forward(request, response);
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
