<%-- 
    Document   : aside
    Created on : 24-apr-2018, 17.06.17
    Author     : kekko
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<aside>
    <h2>
        <label for="search">Cerca</label>
        <input type="text" name="ricerca" id="search" value="">
    </h2>
    <section>            
        <h2 class="mostra">Categorie</h2>
        <h2 class="nascondi"><a href="articoli.html">Categorie</a></h2>
        <ul class = "listaCategorie">
            <li><strong><a href="notizie.html">Tutte</a></strong></li>
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
        <ul class = "listaAutori">
            <li>Francesco Ligas</li>
        </ul>
    </section>
</aside>

