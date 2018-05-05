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
        <link href="style.css" rel="stylesheet" type="text/css">
        <title>Notizie</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <jsp:include page="navbar.jsp" />

        <jsp:include page="aside.jsp" />
        
        <section id="content" class="notizia">
        
            <c:forEach var="news" items="${listNews}">
                <p><strong>Categoria :</strong>${news.getCategory()} -- 
                <strong>Data:</strong> ${news.printDate()}</p>
                <p>Scritto da: <strong>${news.getUser().getName()} </strong></p>
                <div>${news.getTitle()}</div>
                <h3><img src="${news.getUrlImagine()}"width="400" height="200"></h3>
                <p>${news.estraiCaratteri()}</p>
            </c:forEach>
        </section>   
        
        <jsp:include page="footer.jsp" />
    </body>
</html>
