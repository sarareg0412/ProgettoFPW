<%-- 
    Document   : scriviArticolo
    Created on : 25-apr-2019, 13.22.21
    Author     : Sara
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Scrivi un articolo</title>
        <!-- Inserimento dei metadati della pagina-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./M1/style.css" media="screen">
        <meta name="author" content="Sara Regali">
        <meta name="keywords" content="FPW, Milestone1, HTML, CSS, Java">
        <meta name="description" content="Pagina per scriverere un articolo; prima Milestone">

    </head>
    <body>
        <!-- Header incluso qui -->
        <jsp:include page="header.jsp"/>
        
        <main>
            <jsp:include page="aside.jsp"/>

            <section id="resto_pagina" class="col-8">
                <section id="sfondo_descrizioni">
                    <h1>Scrivi un Articolo</h1>
                </section>
                <section id="inserisci_titolo">
                    <form action="demo_form.asp" method="get">
                        <label class="col-3" for="corto">Titolo:</label>
                        <input class="col-7" type="text" name="corto" id="corto" value="${scelto.getTitolo()}" />
                    </form>
                </section>

                <section id="inserisci_autori">
                    <form action="demo_form.asp" method="get">
                        <label class="col-3" for="corto">Autori:</label>
                        <section  id="nomi" class="col-7">
                            <c:forEach items="${autori}" var="u">
                                <p>${u.getNome()} ${u.getCognome()}</p>
                            </c:forEach>
                            <select name="nome">
                                <option value="nome1">Anna Rossi</option>
                                <option value="nome2">Marco Neri</option>
                                <option value="nome3">Marta Verdi</option>
                            </select>
                        </section>
                    </form>
                </section>

                <section id="inserisci_categoria" >
                    <label class="col-3" for="corto">Categoria:</label>
                    <section id="categorie" class="col-7" >
                        <input type="checkbox" name="category" value="cat1">CSS
                        <input type="checkbox" name="category" value="cat2">HTML
                        <input type="checkbox" name="category" value="cat3">JSP
                        </br>
                        <input type="checkbox" name="category" value="cat4">AJAX
                        <input type="checkbox" name="category" value="cat5">JavaScript
                        <input type="checkbox" name="category" value="cat6">Servlet
                    </section>
                </section>

                <section id="inserisci_immagine">
                    <label class="col-3" for="immagine">Immagine:</label>
                    <input type="file" class="col-7" id="foto_scelta" name="immagine" accept="image/png, image/jpeg">
                </section>
                <section id="inserisci_data">
                    <label class="col-3" for="start">Data:</label>

                    <input class="col-7" type="date" id="start" name="trip-start"
                           value=${scelto.getFormatoData()}
                           min="2018-01-01" max="2020-12-31">
                </section>
                <form id="inserisci_testo" action="demo_form.asp" method="get" class="col-10">
                    <label for="lungo" class="col-3">Testo:</label>
                    <textarea class="col-7" name="lungo" id="lungo">${scelto.getTesto()}</textarea>
                </form>
                <section class="col-3" id="nascosta">
                    <p>Non deve essere visualizzato</p>
                </section>
                <form id="salva" class="col-7" action="scriviArticolo.html?pid=${u.getPid()}" method="post">
                    <button type="submit">Salva</button>
                </form>
            </section>
        </main>    
    </body>
</html>

