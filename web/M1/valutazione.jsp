<%-- 
    Document   : valutazione
    Created on : 25-apr-2019, 13.25.33
    Author     : Sara
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Valuta un articolo</title>
        <!-- Inserimento dei metadati della pagina-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <meta name="author" content="Sara Regali">
        <meta name="keywords" content="FPW, Milestone1, HTML, CSS, Java">
        <meta name="description" content="Pagina di valutazione; prima Milestone">            

    </head>
    <body>
        <!-- Header incluso qui -->
        <jsp:include page="header.jsp"/>

        <main>

            <!--<jsp:include page="aside.jsp"/>-->

            <section id="resto_pagina" class="col-8">
                <section id="sfondo_descrizioni">

                    <h1>${scelto.getTitolo()}</h1>
                    <h2 class="col-3" >Autori:</h2>
                    <ol class="col-7">
                        <c:forEach items="${scelto.getAutori()}" var="u">
                            <li >${u.getNome()}, ${u.getCognome()} (${u.getId()})</li>
                            </c:forEach>
                    </ol>

                </section>

                <section id="immagine">
                    <img  title="Foto aticolo" alt="${scelto.getTitolo()}" src='${scelto.getImmagine()}'>
                </section> 
                <section id="sottotitoli" class="col-10 valutazione">
                    <h3 class="col-3">Categoria: </h3> 
                    <ol class="col-7">
                        <c:forEach items="${scelto.getCategorie()}" var="u">
                            <li >${u}</li>
                            </c:forEach>
                    </ol>
                    <h3>Data: ${scelto.getData().toString()} </h3>
                </section>
                <section id="contenuto">
                    <p> ${scelto.getTesto()}</p>
                </section>

                <section id="valutazione">
                    <h2>Le tue valutazioni:</h2>
                    <form action="articoli.html" method="post">
                        <p id="valuta" class="col-4">La tua valutazione: </p>
                        <div id="scelta_voto" class="col-6">
                            <label for="1">1</label>
                            <input type="radio" name="voto1" id="voto-1" value="1">
                            <label for="2">2</label>
                            <input type="radio" name="voto2" id="voto-2" value="2">
                            <label for="3">3</label>
                            <input type="radio" name="voto3" id="voto-3" value="3">
                            <label for="4">4</label>
                            <input type="radio" name="voto4" id="voto-4" value="4">
                            <label for="5">5</label>
                            <input type="radio" name="voto5" id="voto-5" value="5">
                        </div>

                        <c:if test="${user.getStatus() == 'Autore'}">
                            <label for="lungo">Il tuo commento:</label>
                            <textarea name="lungo" class="lungo"></textarea>
                        </c:if>

                        <c:if test="${user.getStatus() == 'Organizzatore'}">
                            <label for="lungo">Commento organizzatore:</label>
                            <textarea name="lungo" class="lungo"></textarea>
                        </c:if>
                            
                        <button type="submit">Invia</button>
                    </form>
                </section>
            </section>
        </main>
    </body>
</html>
