<%-- 
    Document   : login
    Created on : 24-apr-2018, 17.18.43
    Author     : kekko
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Login</title>
        <meta name="author" content="Francesco">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="moto,motogp,login,moto24h">
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        
        <jsp:include page="header.jsp" />

        <jsp:include page="navbar.jsp" />

        <jsp:include page="aside.jsp" />
        
        <div id="content" class="login" >     
        <!--Questo form richiede le credenziali per l accesso alla pagina-->
          
            <form action="#" method="post">
               <img src="img/logo.png" title="moto"
               alt="Logo" height="70"></a>
            <h3>Login:</h3>
            
            <c:if test="${invalidData == true}">
                <p> Dati errati </p>
            </c:if>
            
                <div>
                    <label for="email">Email</label>
                    <input type="text" name="email" id="email">
                </div>
                <div>
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password">
                    <input type="submit" value="Accedi" id="pulsanteLogin"/>  
                </div>
             </form>
        </div>
        
        <jsp:include page="footer.jsp" />


    </body>
</html>
