<%-- 
    Document   : navbar
    Created on : 24-apr-2018, 17.01.11
    Author     : kekko
--%>

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
                <c:if test="${ session.getAttribute("loggedIn").equals(true)}">
                    <li><h3>Ciao, ${user.getName()}<form action="login.html">
                                                      <input type="submit"
                                                      value="Logout"
                                                      href="login.jsp">
                                                    </form>
                    </h3>
                    </li>
                </c:if>
                <li><a href="login.html">Profilo</a></li>
                <li><a href="articoli.html">I miei articoli</a></li>
                <li><a href="Notizia">Notizie</a></li>
                <li><a href="index.html">Home</a></li>
            </ul>
        </nav>
    </body>
</html>
