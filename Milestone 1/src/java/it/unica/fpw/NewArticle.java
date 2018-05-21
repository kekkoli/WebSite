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
            
            if((request.getParameter("new")) != null ){
                news.setTitle(null);
                news.setCategory(null);
                news.setDate(null);
                news.setDescrizione(null);
                news.setUrlImagine(null);
                news.setCategory(null);
                request.setAttribute("news", news);
                
                request.getRequestDispatcher("scriviArticolo.jsp").forward(request, response);
            }
                
           
           int idNews = Integer.parseInt(request.getParameter("nid"));
            
           if (idNews == -1) {
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
                    
                    newsFactory.addNews(tit, tes, url, descr, cat, data, (User)session.getAttribute("user"));

                
                }
            }else{
       
                       
           
           
           news = newsFactory.getNewsById(idNews);
           
           request.setAttribute("news", newsFactory.getNewsById(idNews));
           
           String s = request.getParameter("titolo");
           if(s!=null && !s.equals(news.getTitle()))
               news.setTitle(s);
           
            s = request.getParameter("data");
            if(s!=null && !s.equals(news.getDate().toString()))
                news.setDate(LocalDate.parse(s));
            
           
           s = request.getParameter("urlImmagine");
           if(s!=null && !s.equals(news.getUrlImagine()))
               news.setUrlImagine(s);
           
           s = request.getParameter("didascalia");
           if(s!=null && !s.equals(news.getDescrizione()))
               news.setDescrizione(s);
           
           s = request.getParameter("testo");
           if(s!=null && !s.equals(news.getTesto()))
               news.setTesto(s);
           
           s = request.getParameter("categoria");
            if(s!=null && !s.equals(news.getCategory().toString())){
                for(Categoria cat : Categoria.values())
                    if(cat.toString( ).equals(s)){
                        news.setCategory(cat);
                    }
            }
           
           request.getRequestDispatcher("scriviArticolo.jsp").forward(request, response);
           
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
