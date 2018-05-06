<%-- 
    Document   : scriviArticolo
    Created on : 24-apr-2018, 16.56.24
    Author     : kekko
--%>

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

            <form action="articoli.jsp" method="post">  
                <h2><strong>Modifica profilo</strong></h2>

               
                <label for="didascalia">Inserire didascalia</label>
                <input type="text" name="didascalia" id="didascalia" value="">


                <label for="descrizione">Inserire descrizione</label>             
                <textarea rows="4" cols="32" name="descrizione" 
                          id="descrizione">${news.getDescrizione()}</textarea>

                <div>
                    <h2>Categorie</h2>
                    <input type="checkbox" name="scelta" value="true">${scelta}<br>
                    <input type="checkbox" name="scelta" value="piloti">Piloti<br>
                    <input type="checkbox" name="scelta" value="scuderie">Scuderie<br>
                    <input type="checkbox" name="scelta" value="staff">Staff<br>
                </div>
                <input type="submit" value="Salva" id="pulsanteSalva"/>

            </form>
        </section>
        
        <jsp:include page="footer.jsp" />
        
    </body>
</html>

