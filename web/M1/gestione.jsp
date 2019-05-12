<%-- 
    Document   : gestione
    Created on : 7-mag-2019, 13.31.14
    Author     : Sara
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Gestione</title>
        <!-- Inserimento dei metadati della pagina-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./M1/style.css" media="screen">

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

        <meta name="author" content="Sara Regali">
        <meta name="keywords" content="FPW, Milestone1, HTML, CSS, Java">
        <meta name="description" content="Pagina della gestione; seconda milestone">            

    </head>
    <body>
        <!-- Header incluso qui -->
        <jsp:include page="header.jsp"/>
        <main>

            <jsp:include page="aside.jsp"/>

            <section id="resto_pagina" class="col-8">

                <c:if test="${user.getStatus() == 'Autore' }">
                    <section id="sfondo_descrizioni">
                        <h1>Ciao ${user.getNome()},</h1> 
                        <h3>purtroppo non hai i permessi
                            per entrare in questa pagina</h3>
                    </section>
                </c:if>

                <c:if test="${user.getStatus() == 'Organizzatore' }">        
                    <section id="sfondo_descrizioni">
                        <h1>Articoli</h1>
                    </section>

                    <section id="tabella" class="col-10">
                        <table class="col-10">
                            <tr id="prima_riga">
                                <th>Data</th>
                                <th>Titolo</th>
                                <th>Valutazione</th>
                                <th>Decidi</th>    
                            </tr>
                            <c:forEach items="${valutazionitot}" var="u">
                                <tr>
                                    <td>${u.getArticolo().getData().toString()} </td>
                                    <td>${u.getArticolo().getTitolo()} </td>
                                    <c:if test="${u.getDecisione() == 'Attesa Valutazioni'}">
                                        <td><a href="">Scegli valutatori</a></td> 
                                    </c:if>
                                    <c:if test="${u.getDecisione() != 'Attesa Valutazioni'}">
                                        <td>${u.getVoto().toString()} </td> 
                                    </c:if>
                                    
                                    <c:choose>
                                        <c:when test="${u.getDecisione() == 'Decidi'}">
                                            <td><a href="gestione.html">${u.getDecisione()}</a></td>
                                        </c:when>
                                        <c:when test="${u.getDecisione() == 'Attesa Valutazioni'}">
                                            <td><a href="gestione.html">${u.getDecisione()}</a></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${u.getDecisione()}</td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>
                            </c:forEach>

                        </table>

                        <form action="" method="post">
                            <button type="submit">Nuovo Articolo</button>
                        </form>
                    </section>
                </c:if>
            </section>
        </main>    
    </body>
</html>
