<%-- 
    Document   : aside
    Created on : 24-apr-2018, 17.06.17
    Author     : kekko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>aside</title>
    </head>
    <body>
        <aside>
            <h2>
                <label for="search">Cerca</label>
                <input type="text" name="ricerca" id="search" value="">
            </h2>
            <section>            
                <h2 class="mostra">Categorie</h2>
                <h2 class="nascondi"><a href="articoli.html">Categorie</a></h2>
                <ul>
                    <li><strong><a href="notizie.html?category=News">News</a></strong></li>
                    <li><strong><a href="notizie.html?category=Prove">Prove</a></strong></li>
                    <li><strong><a href="notizie.html?category=Ruote">Ruote</a></strong></li>
                    <li><strong><a href="notizie.html?category=Scuderie">Scuderie</a></strong></li>
                    <li><strong><a href="notizie.html?category=Piloti">Piloti</a></strong></li>
                </ul>   
            </section>
            <section id="section2">
                <h2 class="mostra">Autori</h2>
                <h2 class="nascondi"><a class="nascondi" href="articoli.html">Autori</a></h2>
                <h4 ><strong>Francesco Ligas</strong></h4>
            </section>
        </aside>
    </body>
</html>
