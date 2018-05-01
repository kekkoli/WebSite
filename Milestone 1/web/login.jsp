<%-- 
    Document   : login
    Created on : 24-apr-2018, 17.18.43
    Author     : kekko
--%>

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
            <form action="articoli.jsp" method="post" > 
               <a href="articoli.jsp" ><img src="img/logo.png" title="moto"
               alt="Logo" height="70"></a>
                <h3><strong>Login</strong></h3>
                <label for="username">Username</label>
                <input type="text" name="username" id="username" value=" ">

                <label for="username">Password<br></label>
                <input type="password" name="password" id="password" value="">

                <input type="submit" value="Accedi" id="pulsanteLogin"/>
            </form>
        </div>
        
        <jsp:include page="footer.jsp" />

       
    </body>
</html>
