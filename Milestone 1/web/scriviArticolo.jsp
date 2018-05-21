<%-- 
    Document   : scriviArticolo
    Created on : 24-apr-2018, 16.56.24
    Author     : kekko
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="author" content="Francesco">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="keywords" content="moto,motogp,scriviarticolo,nuovo,articolo,moto24h">
        <link href="style.css" rel="stylesheet" type="text/css">

        <title>Scrivi nuovo articolo</title>
    </head>

    <body>
        <jsp:include page="header.jsp" />

        <jsp:include page="navbar.jsp" />

        <jsp:include page="aside.jsp" />


        <section id="content" class="scriviArticolo">
            <!--Questo form consente ad un autore di scivere un nuovo 
            articolo.I campi prevedono l inserimento di titolo,data,
            immagine,didascalia,testo e categoria-->
            <c:if test="${autore == false}">
                <h2>Acceso negato. Non sei un autore.</h2>
            </c:if>
            <c:if test="${autore == true}">
                <form action="scriviArticolo.html?nid=${news.getId()}" method="post">  
                    <h2><strong>Scrivi un Articolo</strong></h2>

                    <label for="titoloArticolo">Titolo</label>
                    <input type="text" name="titolo" id="titoloArticolo" value="${news.getTitle()}">

                    <label for="data">Data</label>
                    <input type="date" name="data" id="data" value="${news.getDate().toString()}">

                    <label for="urlImmagine">Url Immagine</label>
                    <input type="text" name="urlImmagine" id="urlImmagine" value="${news.getUrlImagine()}">

                    <label for="didascalia">Inserire didascalia</label>
                    <input type="text" name="didascalia" id="didascalia" value="${news.getDescrizione()}">


                    <label for="testo">Inserire Testo</label>             
                    <textarea rows="4" cols="32" name="testo" 
                              id="testo">${news.getTesto()}</textarea>



                    <label for="categoria">Categoria</label>
                    <select name="categoria" class="ruolo" id="categoria">
                        <c:if test="${news.getTitle() != null}">
                            <option class="ruolo" value="null">Scegli...(Attualmente
                                ${news.getCategory().toString()}) </option>
                        </c:if>

                        <c:if test="${news.getTitle() == null}">
                            <option class="ruolo" value="null">Scegli... </option>
                        </c:if>


                        <c:forEach var="val" items="${categorie}">

                        <option class="ruolo" value="${val.toString()}">
                            ${val.toString()}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Salva" id="pulsanteSalva"/>

                </form>        
            </c:if>
        </section>

        <jsp:include page="footer.jsp" />

    </body>
</html>

