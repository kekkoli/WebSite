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
        <meta name="author" content="Francesco">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="moto,motogp,moto24h,Spagna,Dovizioso">
        <link href="style.css" rel="stylesheet" type="text/css">
        <title>Notizie</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <jsp:include page="navbar.jsp" />

        <jsp:include page="aside.jsp" />
        
        <section id="content" class="notizie">
        
            <c:forEach var="news" items="${listNews}" >
                <div class="singolaNotizia">
                <p><strong>Categoria :</strong>${news.getCategory()} -- 
                <strong>Data:</strong> ${news.getDate().toString()}
                Scritto da: <strong>${news.getUser().getName()} </strong></p>
                
                <a href="notizia.html?nid=${news.getId()}">
                    <h1>${news.getTitle()}</h1></a>
                <a href="notizia.html?nid=${news.getId()}">
                <img src="${news.getUrlImagine()}" width="400" height="200" 
                     class="imgNews" alt="foto"></a>
                
                <p>${news.getDescrizione()}</p>
                <p >${news.estraiCaratteri()}</p>
                <hr class="blocco">
                </div>
                
            </c:forEach>
        </section>   
        
        <jsp:include page="footer.jsp" />
    </body>
</html>
