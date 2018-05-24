/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.fpw;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kekko
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
        
        /*Servlet che si occupa del login e del logout da parte di un utente*/
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            
            /*Se Viene passato il parametro logout viene effettuto il logout e 
            Invalidata la sessione.*/
            
            if (request.getParameter("logout") != null){
                session.invalidate();
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }
            /*Se l utente e' gia loggato viene reindirizzato alla pagina delle notizie*/
            if (session.getAttribute("loggedIn") != null &&
                session.getAttribute("loggedIn").equals(true)){
                    response.sendRedirect("notizie.html");
                    return;
            }
            else{
                /*Verifica dei parametri corretti nel login*/
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                UserFactory factory = UserFactory.getInstance();
                
                if (email != null && password != null && factory.login(email, password)){
                     //loggato con successo
                    int userId = factory.getUserByEmail(email).getId();
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("user", factory.getUserById(userId));
                    
                    //Settata la variabile di sessione
                    if(factory.getUserById(userId).getRuolo().equals(Ruolo.Autore))
                        session.setAttribute("autore", true);
                    
                    response.sendRedirect("notizie.html");
                    return;
                }
                /*Login senza successo*/
                else if(email != null && password != null){
                    request.setAttribute("invalidData", true);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    return;
                }
            }

            request.getRequestDispatcher("login.jsp").forward(request, response);
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
