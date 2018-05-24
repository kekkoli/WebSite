<%-- 
    Document   : articoli
    Created on : 24-apr-2018, 17.12.41
    Author     : kekko
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Articoli</title>
        <meta name="author" content="Francesco">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="moto,motogp,moto24h,Spagna,Dovizioso">
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>

    <body>

        <jsp:include page="header.jsp" />

        <jsp:include page="navbar.jsp" />

        <jsp:include page="aside.jsp" />

        <section id="content" class="articoli">

            <c:if test="${autore == false}">
                <h2>Acceso negato. Non sei un autore.</h2>
            </c:if>

            <c:if test="${autore == true}">
                <c:if test="${listNews}!=null">
                    <h2 >Articoli</h2>
                    <table>    
                        <tr>
                            <th>Data</th>
                            <th>Titolo</th>
                            <th>Modifica</th>
                            <th>Cancella</th>
                        </tr>
                        <c:forEach var="news" items="${listNews}">
                            <tr>
                                <td>${news.getDate().toString()}</td>
                                <td>${news.getTitle()}</td>
                                <td><form action="scriviArticolo.html?nid=${news.getId()}"
                                          method="post">
                                        <button type="submit">
                                            <img src="img/modifica.jpg" 
                                                 alt="modifica" height="15" width="15" >
                                        </button>
                                    </form></td>
                                <td><input type="image" src="img/cancella.jpg"
                                           alt="elimina" height="15" width="15"></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
                <form action="scriviArticolo.html?new=1"
                      method="post">
                    <button type="submit">
                        <img src="img/modifica.jpg" 
                             alt="modifica" height="15" width="15" >
                    </button>
                </form>
            </c:if>

        </section>

        <jsp:include page="footer.jsp" />

    </body>
</html>