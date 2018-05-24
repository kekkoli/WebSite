<%-- 
    Document   : notizia
    Created on : 1-mag-2018, 10.06.52
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
        <meta name="keywords" content="moto,motogp,moto24h,Dovizioso,vittoria,notizia">
        <link href="style.css" rel="stylesheet" type="text/css">
        <title>Notizia</title>
    </head>

    <body>

        <jsp:include page="header.jsp" />

        <jsp:include page="navbar.jsp" />

        <jsp:include page="aside.jsp" />

        <section id="content" class="notizia">
            <p><strong>Categoria :</strong>${news.getCategory()} -- 
                <strong>Data:</strong> ${news.getDate().toString()}</p>
            <p>Scritto da: <strong>${news.getUser().getName()} </strong></p>
            <div>${news.getTitle()}</div>
            <h3><img src="${news.getUrlImagine()}" width="400" height="200" alt="foto"></h3>
            <p>${news.getDescrizione()}</p>
            <p>${news.getTesto()}</p>
            <hr>
            <h2>Commenti</h2>
            <c:if test="${nComm > 0}">
                <div id="Commenti"> 

                    <c:forEach var="commento" items="${commenti}" >
                        <h3>${commento.getUser().getName()}:</h3>
                        <p>${commento.getContenuto()}</p>
                    </c:forEach>
                </div>
            </c:if>
            <textarea rows="4" cols="32" name="testo" 
                      >Scrivi un commento</textarea>
            <input type="submit" value="Commenta" id="pulsanteCommenti"/>
        </section>   

        <jsp:include page="footer.jsp" />


    </body>
</html>
