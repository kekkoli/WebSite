<%-- 
    Document   : notizie.jsp
    Created on : 5-mag-2018, 9.57.15
    Author     : kekko
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notizie</title>
    </head>
    <body>
         <c:forEach var="news" items="${listNews}">
            <div>
                Notizia di: ${news.getAutore().getName()}
                <br>
                ${news.getContent()}
            </div>
        </c:forEach>
    </body>
</html>
