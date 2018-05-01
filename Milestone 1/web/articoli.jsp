<%-- 
    Document   : articoli
    Created on : 24-apr-2018, 17.12.41
    Author     : kekko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Articoli</title>
        <meta name="author" content="Francesco">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="moto,motogp,moto24h,articoli,Spagna,Dovizioso">
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    
    <body>
        
        <jsp:include page="header.jsp" />

        <jsp:include page="navbar.jsp" />

        <jsp:include page="aside.jsp" />

        <section id="content" class="articoli">
            <!--Il contenuto di questa pagina e' una tabella che 
            racchiude data e titolo degli articoli. Inoltre sara' possibile
            attuare delle modifiche e eliminare l' articolo.-->

            <h2 >Articoli</h2>
            <table>    
                <tr>
                    <th>Data</th>
                    <th>Titolo</th>
                    <th>Modifica</th>
                    <th>Cancella</th>
                </tr>
                <tr class="dispari">
                    <td>21/03/2018</td>
                    <td>Vittoria Del Dovi</td>
                    <td><input type="image" src="img/modifica.jpg" 
                               alt="modifica" height="15" width="15"></td>
                    <td><input type="image" src="img/cancella.jpg" 
                               alt="elimina" height="15" width="15"></td>
                </tr>
                <tr>
                    <td>22/03/2018</td>
                    <td>Prove per la Spagna</td>
                    <td><input type="image" src="img/modifica.jpg"
                               alt="modifica" height="15" width="15"></td>
                    <td><input type="image" src="img/cancella.jpg"
                               alt="elimina" height="15" width="15"></td>
                </tr>

                <tr class="dispari">
                    <td>23/03/2018</td>
                    <td>Le gomme non tengono piu'</td>
                    <td><input type="image" src="img/modifica.jpg"
                               alt="modifica" height="15" width="15"></td>
                    <td><input type="image" src="img/cancella.jpg"
                               alt="elimina" height="15" width="15"></td>
                </tr>
            </table>  
            <form action="scriviArticolo.jsp" method="post" >  
                <input type="submit" value="Nuovo articolo" id="pulsanteScrivi"/>
            </form>
        </section>
        
        <jsp:include page="footer.jsp" />

    </body>
</html>
