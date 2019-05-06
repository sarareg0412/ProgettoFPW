<%-- 
    Document   : login
    Created on : 25-apr-2019, 18.55.25
    Author     : Sara
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Logo</title>
        <!-- Inserimento dei metadati della pagina-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./M1/style.css" media="screen">
        <meta name="author" content="Sara Regali">
        <meta name="keywords" content="FPW, Milestone1, HTML, CSS, Java">
        <meta name="description" content="Pagina di Login prima Milestone">
        <!--<base href="M1/">-->
    </head>
    
    <body>
        <header id="sfondo_header">
            <div id="titolo" class="col-2">
                <h1 class="titolo">Free Peer revieW</h1>
            </div>
        </header>
        <main>
            <section id="login">
                
                <form action="login.html" method="post">
                    <label for="id_username">Username: </label>
                    <input type="text" name="userName" id="id_username" value="Inserisci username"/>
                    <br/> 

                    <label for="id_password">Password: </label>
                    <input type="password" name="password" id="id_password" value="oscurato"/>
                    
                    <br/>
                    <button type="submit" name="login">Login</button>
                    <br/>
                    <label>
                        <input type="checkbox" checked="checked" name="remember" />Ricordami
                    </label>
                   
                    <p class="val">Vai alla pagina di <a href="valutazione.html">valutazioni</a></p>
                   
                </form>
            </section>
        </main>
    </body>
</html>
