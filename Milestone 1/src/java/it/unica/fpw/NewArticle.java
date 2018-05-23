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

/**
 *
 * @author kekko
 */
public class NewArticle extends HttpServlet {

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
            HttpSession session = request.getSession();
            request.setAttribute("categorie", Categoria.values());

            NewsFactory newsFactory = NewsFactory.getInstance();
            News news = new News();

            if (request.getParameter("new") != null) {
                request.setAttribute("news", news);
                request.getRequestDispatcher("scriviArticolo.jsp").forward(request, response);
            }

            if (request.getParameter("nid").equals("")) {
                if (request.getParameter("titolo") != null
                        && request.getParameter("data") != null
                        && request.getParameter("urlImmagine") != null
                        && request.getParameter("didascalia") != null
                        && request.getParameter("testo") != null
                        && request.getParameter("categoria") != null) {

                    String tit = request.getParameter("titolo");
                    String tes = request.getParameter("testo");
                    String descr = request.getParameter("didascalia");
                    LocalDate data = LocalDate.parse(request.getParameter("data"));
                    String url = request.getParameter("urlImmagine");
                    Categoria cat = Categoria.valueOf(request.getParameter("categoria"));

                    int idNews = newsFactory.addNews(tit, tes, url, descr, cat, data, (User) session.getAttribute("user"));

                    news = newsFactory.getNewsById(idNews);
                    request.setAttribute("news", news);
                    request.setAttribute("nid", idNews);

                    request.getRequestDispatcher("scriviArticolo.jsp").forward(request, response);
                }
            }//Edita news
            else
                if (request.getParameter("titolo") != null
                    && request.getParameter("data") != null
                    && request.getParameter("urlImmagine") != null
                    && request.getParameter("didascalia") != null
                    && request.getParameter("testo") != null
                    && request.getParameter("categoria") != null) {

                String tit = request.getParameter("titolo");
                String tes = request.getParameter("testo");
                String descr = request.getParameter("didascalia");
                LocalDate data = LocalDate.parse(request.getParameter("data"));
                String url = request.getParameter("urlImmagine");
                Categoria cat = Categoria.valueOf(request.getParameter("categoria"));

                int idNews = Integer.parseInt(request.getParameter("nid"));

                newsFactory.updateNews(tit, tes, url, descr, cat, data, (User) session.getAttribute("user"), idNews);

                request.setAttribute("news", newsFactory.getNewsById(idNews));
                request.setAttribute("nid", idNews);
                
                request.getRequestDispatcher("scriviArticolo.jsp").forward(request, response);
            }       
            request.setAttribute("news", newsFactory.getNewsById(Integer.parseInt(request.getParameter("nid"))));
            request.setAttribute("nid", Integer.parseInt(request.getParameter("nid")));
            request.getRequestDispatcher("scriviArticolo.jsp").forward(request, response);

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
