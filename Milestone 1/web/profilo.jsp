<%-- 
    Document   : profilo
    Created on : 5-mag-2018, 15.07.11
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
        <title>Profilo</title>
    </head>
    <body>

        <jsp:include page="header.jsp" />

        <jsp:include page="navbar.jsp" />

        <jsp:include page="aside.jsp" />

        <section id="content" class = "modificaProfilo">
            <c:if test="${loggedIn == false || loggedIn ==null }">
                <h2>Acceso negato. Non sei Loggato.</h2>
            </c:if> 

            <c:if test="${loggedIn == true}">

                <form action="profilo.html" method="post">  
                    <h1><strong>Modifica Profilo</strong></h1>

                    <label for="nome">Nome</label>
                    <input type="text" name="nome" id="nome" value="${user.getName()}">

                    <label for="cognome">Cognome</label>
                    <input type="text" name="cognome" id="cognome" value="${user.getSurname()}">

                    <label for="urlImmagine">Url Immagine</label>
                    <input type="url" name="urlImmagine" id="urlImmagine" value="${user.getUrlImagine()}">

                    <label for="data">Data</label>
                    <input type="date" name="data" id="data" value="${user.getDate().toString()}">

                    <label for="descrizione">Descriviti</label>
                    <input type="text" name="descrizione" id="descrizione" value="${user.getDescription()}">

                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" value="">

                    <label for="email">Email</label>
                    <input type="text" name="email" id="email" value="${user.getEmail()}">

                    <label for="ruolo">Ruolo</label>
                    <select name="ruolo" class="ruolo" id="ruolo">
                        <option class="ruolo" value="${user.getRuolo().toString()}">
                            Scegli...(Attualmente
                            ${user.getRuolo().toString()}) </option>

                        <c:forEach var="val" items="${ruolo}">
                            <option class="ruolo" value="${val.toString()}">
                                ${val.toString()}</option>
                            </c:forEach>
                    </select>
                    <input type="submit" value="Salva" name="invio" id="pulsanteSalva"/>


                </form>
                <form action="profilo.html?delete=true" method="post" >                       
                    <input type="submit" id="pulsanteELimina" value="Elimina Profilo">
                </form>
            </c:if>



        </section>
        <jsp:include page="footer.jsp" />

    </body>
</html>
