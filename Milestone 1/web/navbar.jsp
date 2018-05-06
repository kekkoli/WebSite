<%-- 
    Document   : navbar
    Created on : 24-apr-2018, 17.01.11
    Author     : kekko
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>navbar</title>
    </head>
    <body>
        <nav> 
            <ul>
                <li><a href="notizie.html">Home</a></li>
                <c:if test="${loggedIn == true }">
                    <li>Ciao, ${user.getName()}
                        <a href="login.html?logout=true">Logout</a></li>
                </c:if>
                    
                <c:if test="${loggedIn == false || loggedIn ==null }">
                    <li><a href="login.html">Login</a></li>
                </c:if>
                    
                <c:if test="${autore == true}">
                    <li><a href="articoli.html">I miei articoli</a></li>
                </c:if>
                <li><a href="profilo.html">Profilo</a></li>
                <li><a href="notizie.html">Notizie</a></li>
                 
            </ul>
        </nav>
    </body>
</html>
