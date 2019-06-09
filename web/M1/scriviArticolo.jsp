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
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

        <meta name="author" content="Sara Regali">
        <meta name="keywords" content="FPW, Milestone1, HTML, CSS, Java">
        <meta name="description" content="Pagina per scriverere un articolo; prima Milestone">

        <script src="./js/jquery.js"></script> 
    </head>
    <body>
        <!-- Header incluso qui -->
        <jsp:include page="header.jsp"/>
        <script src="./js/suggest.js"></script>
        <main>
            <jsp:include page="aside.jsp"/>

            <section id="resto_pagina" class="col-8">
                <c:if test="${user.getStatus() == 'Organizzatore'}">
                    <section id="sfondo_descrizioni">
                        <h1>Ciao ${user.getNome()},</h1> 
                        <h3>purtroppo non hai i permessi
                            per entrare in questa pagina</h3>
                    </section>
                </c:if>
                <c:if test="${user.getStatus() == 'Autore'}">
                    <section id="sfondo_descrizioni">
                        <h1>Scrivi un Articolo</h1>
                        <c:if test="${modif != false}">
                            <h3>Stai modificando l'articolo ${scelto.getPid()}</h3>
                        </c:if>
                    </section>

                    <form id="salva_articolo" class="col-10" action="scriviArticolo.html" method="post">
                        <section id="inserisci_titolo">
                            <label class="col-3" for="titolo">Titolo:</label>
                            <input class="col-7 corto" type="text" name="titolo" value="${scelto.getTitolo()}" />
                        </section>

                        <section id="inserisci_autori">
                            <label class="col-3" for="corto">Autori:</label>

                            <section  id="nomi" class="col-7">
                                <ul id="lista_autori">
                                    <c:forEach items="${scelto.getAutori()}" var="u">
                                        <li >${u.getNome()}, ${u.getCognome()} (${u.getId()})</li>
                                    </c:forEach>
                                </ul>
                                <input id="nuovo_autore" class="col-8" type="text" name="author" />
                                <button id="plus" name="addAuthor" type="submit">
                                    <img src="./M1/images/plus.jpg" height="28" width="28"/>
                                </button>


                            </section>

                        </section>

                        <section id="inserisci_categoria" >
                            <label class="col-3" for="category">Categoria:</label>
                            <section id="categorie" class="col-7" >

                                <input type="checkbox" name="category" value="CSS" <c:if test="${scelto.getCategorie().contains('CSS')}"> checked  </c:if>>CSS

                                    <input type="checkbox" name="category" value="HTML"  <c:if test="${scelto.getCategorie().contains('HTML')}" > checked </c:if>>HTML

                                    <input type="checkbox" name="category" value="JSP" <c:if test="${scelto.getCategorie().contains('JSP')}" > checked </c:if> >JSP

                                    </br>

                                    <input type="checkbox" name="category" value="AJAX" <c:if test="${scelto.getCategorie().contains('AJAX')}"> checked </c:if> >AJAX

                                    <input type="checkbox" name="category" value="JavaScript" <c:if test="${scelto.getCategorie().contains('JavaScript')}"> checked </c:if> >JavaScript

                                    <input type="checkbox" name="category" value="Servlet" <c:if test="${scelto.getCategorie().contains('Servlet')}"> checked </c:if> >Servlet



                                </section>
                            </section>

                            <section id="inserisci_immagine">
                                <label class="col-3" for="immagine">Foto:</label>
                                <input class="col-7 corto" type="text" name="immagine" value="${scelto.getImmagine()}" />
                        </section>
                        <section id="inserisci_data">
                            <label class="col-3" for="start">Data:</label>
                            <input class="col-7" type="date" id="start" name="start"
                                   value="${scelto.getData()}" 
                                   min="2018-01-01" max="2020-12-31">
                        </section>
                        <section id="inserisci_testo" class="col-10">
                            <label for="testo" class="col-3">Testo:</label>
                            <textarea class="col-7" name="testo" id="lungo">${scelto.getTesto()}</textarea>
                        </section>
                        <section class="col-3 nascosta">
                            <p>Non deve essere visualizzato</p>
                        </section>

                        <input type="hidden" name="pid" value="${scelto.getPid()}">
                        <button class="col-7" type="submit" name="modifica" id="save_articolo">Salva</button>
                    </form>
                </section>
            </c:if>
        </main>    
    </body>
</html>

