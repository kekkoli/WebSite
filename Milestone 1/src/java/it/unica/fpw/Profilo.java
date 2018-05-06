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
        try (PrintWriter out = response.getWriter()) {
            ArrayList<String> cambiati = new ArrayList<>();
            
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            String s = request.getParameter("nome");
            if(s!=null && !s.equals(user.getName())){
                user.setName(s);
                cambiati.add("Nome");
            }
            
            s = request.getParameter("cognome");
            if(s!=null && !s.equals(user.getSurname())){
                user.setSurname(s);
                cambiati.add("Cognome");
            }
            
            s = request.getParameter("data");
            if(s!=null && !s.equals(user.getDate().toString())){
                user.setDate(LocalDate.parse(s));
                cambiati.add("Data");
            }
            
            s = request.getParameter("urlImmagine");
            if(s!=null && !s.equals(user.getUrlImagine())){
                user.setUrlImagine(s);
                cambiati.add("Url Immagine");
            }
            
            s = request.getParameter("descrizione");
            if(s!=null && !s.equals(user.getDescription())){
                user.setDescription(s);
                cambiati.add("Descrizione");
            }
            
            s = request.getParameter("password");
            if(s!=null && !s.equals(user.getPassword()))
                if(!s.isEmpty()){
                    user.setPassword(s);
                    cambiati.add("Password");
            }
            
            s = request.getParameter("email");
            if(s!=null && !s.equals(user.getEmail())){
                user.setEmail(s);
                cambiati.add("Email");
            }
            
            s = request.getParameter("ruolo");
            if(s!=null && !s.equals(user.getRuolo().toString())){
                for(Ruolo ruolo : Ruolo.values())
                    if(ruolo.toString( ).equals(s)){
                        user.setRuolo(ruolo);
                        cambiati.add("Ruolo");
                    }
            }
            
            request.setAttribute("parametriCambiati", cambiati);
            
            
            
            request.setAttribute("ruolo", Ruolo.values());
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
