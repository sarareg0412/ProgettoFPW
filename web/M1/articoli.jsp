<%-- 
    Document   : articoli
    Created on : 25-apr-2019, 12.59.43
    Author     : Sara
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Articoli</title>
        <!-- Inserimento dei metadati della pagina-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./M1/style.css" media="screen">

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

        <meta name="author" content="Sara Regali">
        <meta name="keywords" content="FPW, Milestone1, HTML, CSS, Java">
        <meta name="description" content="Pagina contenente gli articoli; prima Milestone">            

    </head>
    <body>
        <!-- Header incluso qui -->
        <jsp:include page="header.jsp"/>
        <main>

            <jsp:include page="aside.jsp"/>

            <section id="resto_pagina" class="col-8">

                <section id="sfondo_descrizioni">
                    <h1>I Miei Articoli</h1>
                </section>

                <section id="tabella" class="col-10">
                    <table class="col-10">
                        <tr id="prima_riga">
                            <th>Data</th>
                            <th>Titolo</th>
                            <th>Stato</th>
                            <th>Button</th>    
                        </tr>
                        <c:forEach items="${articoli}" var="u">
                            <td>${u.getData()} </td>
                            <td>${u.getTitolo()} </td>
                            <td>${u.getStato()} </td>
                            <td> Prova </td>
                        </c:forEach>
                        <tr>
                            <td>13/03/19</td>
                            <td>Le classi in Java</td>
                            <td>APERTO</td>
                            <td><a href="scriviArticolo.html"><i class="fas fa-pencil-alt"> </i></a><a><i class="far fa-trash-alt"></i></a></td>
                        </tr>
                        
                    </table>

                    <form action="../M1/scriviArticolo.html" method="post">
                        <button type="submit">Nuovo Articolo</button>
                    </form>
                </section>

            </section>
        </main>    
    </body>
</html>
