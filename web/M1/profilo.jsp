<%-- 
    Document   : profilo
    Created on : 25-apr-2019, 13.11.43
    Author     : Sara
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Il tuo profilo</title>
        <!-- Inserimento dei metadati della pagina-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" type="text/css" href="./M1/style.css" media="screen">

        <meta name="author" content="Sara Regali">
        <meta name="keywords" content="FPW, Milestone1, HTML, CSS, Java">
        <meta name="description" content="Pagina del profilo; prima Milestone">            

    </head>
    <body>

        <!-- Header incluso qui -->
        <jsp:include page="header.jsp"/>

        <main>
            <jsp:include page="aside.jsp"/>

            <section id="resto_pagina" class="col-8">

                <section id="sfondo_descrizioni" class="profilo">
                    <section id="immagine_profilo" class="col-3">
                        <img  title="Foto profilo" alt="Immagine del profilo" src='./M1/images/picture.jpg' width="120" height="120">
                    </section>
                    <c:if test="${user != null}">
                        <h1 class="col-3">Profilo</h1>
                    </c:if>
                    <c:if test="${user == null}" >
                        <h1 class="col-3">Registrazione</h1>

                    </c:if>    
                </section>
                <form id="salva_profilo" class="col-10" action="registrazione.html" method="post">
                    <section id="inserisci_titolo" class="col-10">
                        <label class="col-3" for="nome">Nome:</label>
                        <input class="col-7" type="text" name="nome" id="corto" value="${user.getNome()}" />
                    </section>

                    <section id="inserisci_titolo" class="col-10">
                        <label class="col-3" for="cognome">Cognome:</label>
                        <input class="col-7" type="text" name="cognome" id="corto" value="${user.getCognome()}" />
                    </section>

                    <section id="inserisci_immagine" class="col-10">
                        <label class="col-3" for="immagine">Foto:</label>
                        <input type="file" class="col-7" id="foto_scelta" name="immagine" accept="image/png, image/jpeg" value="${uset.getUrl()}">
                    </section>

                    <section id="inserisci_email" class="col-10">
                        <label class="col-3" for="email">Email:</label>
                        <input class="col-7" type="email" name="email" id="email" value="${user.getEmail()}" size="30" required>
                    </section>

                    <section id="inserisci_password" class="col-10">
                        <label class="col-3" for="id_pass">Password: </label>
                        <input class="col-7" type="password" name="password" id="id_pass" value="${user.getPassword()}"/>
                    </section>
                    <section id="inserisci_titolo" class="col-10">
                        <label class="col-3" for="ente">Ente:</label>
                        <input class="col-7" type="text" name="ente" id="corto" value="${user.getEnte()}" />
                    </section>  

                    <section class="col-3" id="nascosta">
                        <p>Non deve essere visualizzato</p>
                    </section>

                    <c:if test="${user != null}">
                        <input type="hidden"><br/>
                        <button class="col-7" type="submit" name="modifica" id="save">Salva</button>
                    </c:if>
                    <c:if test="${user == null}">
                        <input type="hidden"><br/>
                        <button class="col-7" type="submit" name="modifica" id="save">Registrazione</button>
                    </c:if>

                </form>

                <section class="col-3" id="nascosta">
                    <p>Non deve essere visualizzato</p>
                </section>

                <section class="col-7" id="cancel">
                    <a   href="">Cancella il tuo profilo</a>
                </section>
            </section>
        </main>

    </body>

</html>
