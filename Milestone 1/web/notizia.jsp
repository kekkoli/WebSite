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
            <strong>Data:</strong> ${news.printDate()}</p>
            <p>Scritto da: <strong>${news.getUser().getName()} </strong></p>
            <div>${news.getTitle()}</div>
            <h3><img src="${news.getUrlImagine()}"width="400" height="200"></h3>
            <p>${news.getDescrizione()}</p>

            
            
                 
            
            
            <!--
        -- 

            Il contenuto di questa pagina e' una notizia di motoGp
            All' interno e' presente un immagine e una sezione di testo 
            descrittiva.-->
             <!--
            <p>Categoria: <strong>Sport </strong> -- Data: 23/03/2018 
               -- Scritto da: <strong>Francesco Ligas </strong></p>
            <h2>Vittoria di Dovizioso a Loasil</h2>
            <h3>
            <img title="moto" alt="Dovisioso"
                 src="img/dovizioso.jpeg"
                 width="400" height="200">
            </h3>
            <p><strong>Dopo tre secondi posti di fila </strong> 
               finalmente <strong>Dovizioso </strong> riesce a domare la pista di Losail e 
               conquistare la vittoria nel GP inaugurale della stagione.
            </p>
            <p><strong>DesmoDovi </strong> si impone in rimonta dal 5° posto in griglia, piegando
            in volata Marquez che ci ha provato fino in fondo, ma come in Austria 
            e Giappone l'anno scorso si è dovuto arrendere sul filo di lana 
            dell'ultima curva: secondo, ma che show.     
            </p>
             -->
        </section>   
        
        <jsp:include page="footer.jsp" />

        
    </body>
</html>
