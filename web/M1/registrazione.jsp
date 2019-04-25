<%-- 
    Document   : registrazioni
    Created on : 25-apr-2019, 13.18.14
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registra un articolo</title>
        <!-- Inserimento dei metadati della pagina-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <meta name="author" content="Sara Regali">
        <meta name="keywords" content="FPW, Milestone1, HTML, CSS, Java">
        <meta name="description" content="Pagina di Registrazioni prima Milestone">      
   
    </head>
   
    <body>
        <!-- Header incluso qui -->
        <jsp:include page="header.jsp"/>
        
        <main>
            <aside id="barra_laterale" class="col-2">
                <h1>Ciao, Sara! </h1>
                <form action="login.html" method="post">
                    <button type="submit">Logout</button>
                </form>
                <section id="sottobox">
                    
                </section>
  
            </aside>
        </main>
        
        <section id="resto_pagina" class="col-8">
            <section id="sfondo_descrizioni">
                <h1>Registrati</h1>
            </section>
        </section>
        
    </body>
</html>
