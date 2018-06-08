/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.fpw;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kekko
 */
public class Filter extends HttpServlet {

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
            
            /*In questa servlet viene gestita la creazione dinamica dei contenuti.*/
            NewsFactory factory = NewsFactory.getInstance();

            String command = request.getParameter("cmd");
            /*Si verifica se viene digitato qualcge carattere e si fanno i confronti nel database*/
            if (command != null) {
                if (command.equals("search")) {
                    String toSearch = request.getParameter("q");
                    ArrayList<String> s = new ArrayList<>();
                    for (Categoria categoria : Categoria.values()) {
                        if (categoria.toString().contains(toSearch)) {
                            s.add(categoria.toString());
                        }
                    }

                    request.setAttribute("categoryList", s);

                    ArrayList<User> userList = new ArrayList<>();
                    UserFactory userFactory = UserFactory.getInstance();
                    for (User user : userFactory.getUsersByNameOrSurname(toSearch)) {
                        userList.add(user);
                    }
                    request.setAttribute("userList", userList);
                    /*Vengono settate le variabili che usera' il javascript*/
                    response.setContentType("application/json");
                    response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
                    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

                    request.getRequestDispatcher("filter.jsp").forward(request, response);
                }

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
