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
                
                <c:if test="${user.getStatus() == 'Organizzatore' }">
                    <section id="sfondo_descrizioni">
                        <h1>Ciao ${user.getNome()},</h1> 
                        <h3>purtroppo non hai i permessi
                            per entrare in questa pagina</h3>
                    </section>
                </c:if>

                <c:if test="${user.getStatus() == 'Autore' }">        
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
                                <tr>
                                    <td>${u.getData().toString()} </td>
                                    <td>${u.getTitolo()} </td>
                                    <td>${u.getStato()} </td>
                                    <c:choose>
                                        <c:when test="${u.getStato() == 'APERTO'}">
                                            <td><a href="scriviArticolo.html?pid=${u.getPid()}"> <i class="fas fa-pencil-alt"></i> </a> <a href="#"><i class="far fa-trash-alt"></i></a></td>
                                                </c:when>
                                                <c:when test="${u.getStato() == 'IN VALUTAZIONE'}">
                                            <td><a href=""><i class="far fa-trash-alt"></i></a></td>
                                                    </c:when>
                                                    <c:when test="${u.getStato() == 'ACCETTATO'}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><i class="fas fa-times"></i></td>
                                            </c:otherwise>
                                    </c:choose>

                                </tr>
                            </c:forEach>

                        </table>
                        
                        <form action="nuovoArticolo.html" method="post">
                            <button name="nuovo" type="submit">Nuovo Articolo</button>
                        </form>
                    </section>
                </c:if>
            </section>
        </main>    
    </body>
</html>
