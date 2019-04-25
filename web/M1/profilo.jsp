<%-- 
    Document   : profilo
    Created on : 25-apr-2019, 13.11.43
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Il tuo profilo</title>
        <!-- Inserimento dei metadati della pagina-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <meta name="author" content="Sara Regali">
        <meta name="keywords" content="FPW, Milestone1, HTML, CSS, Java">
        <meta name="description" content="Pagina del profilo; prima Milestone">            

    </head>
    <body>

        <!-- Header incluso qui -->
        <jsp:include page="header.jsp"/>
        
        <main>
            <aside id="barra_laterale" class="col-2" >
                <h1>Ciao, Sara! </h1>
                <form action="login.html" method="post">
                    <button type="submit">Logout</button>
                </form>
                <section id="sottobox">
                    <h1>I miei articoli: </h1>
                    <ul>
                        <li><a href="">Le classi in Java</a></li>
                        <li><a href="">Progammazione Server-Side</a></li>
                        <li><a href="">Utilizzi di Javascript</a></li>
                    </ul>
                </section>
                <section id="sottobox">
                    <h1>Da valutare: </h1>
                    <ul>
                        <li><a href="">Il Sistema Operativo Linux</a></li>
                        <li><a href="">HTML 6</a></li>
                        <li><a href="">La SQL Injection</a></li>
                    </ul>
                </section>

            </aside>

            <section id="resto_pagina" class="col-8">

                <section id="sfondo_descrizioni" class="profilo">
                    <section id="immagine_profilo" class="col-3">
                        <img  title="Foto profilo" alt="Immagine del profilo" src='images/picture.jpg' width="120" height="120">
                    </section>
                    <h1 class="col-3">Profilo</h1>
                </section>

                <section id="inserisci_titolo" class="col-10">
                    <form action="demo_form.asp" method="get">
                        <label class="col-3" for="corto">Nome:</label>
                        <input class="col-7" type="text" name="corto" id="corto" value="Inserisci il tuo nome" />
                    </form>
                </section>

                <section id="inserisci_titolo" class="col-10">
                    <form action="demo_form.asp" method="get">
                        <label class="col-3" for="corto">Cognome:</label>
                        <input class="col-7" type="text" name="corto" id="corto" value="Inserisci il tuo cognome" />
                    </form>
                </section>

                <section id="inserisci_immagine" class="col-10">
                    <label class="col-3" for="immagine">Foto:</label>
                    <input type="file" class="col-7" id="foto_scelta" name="immagine" accept="image/png, image/jpeg">
                </section>

                <section id="inserisci_email" class="col-10">
                    <label class="col-3" for="email">Email:</label>
                    <input class="col-7" type="email" id="email" size="30" required>
                </section>

                <section id="inserisci_password" class="col-10">
                    <label class="col-3" for="id_pass">Password: </label>
                    <input class="col-7" type="password" name="password" id="id_pass" value="oscurato"/>
                </section>
                <section id="inserisci_titolo" class="col-10">
                    <form action="demo_form.asp" method="get">
                        <label class="col-3" for="corto">Ente:</label>
                        <input class="col-7" type="text" name="corto" id="corto" value="" />
                    </form>
                </section>  
                
                <section class="col-3" id="nascosta">
                    <p>Non deve essere visualizzato</p>
                </section>
                
                <form id="salva" class="col-7" action="articoli.html" method="post">
                    <button type="submit">Salva</button>
                </form>
                
                <section class="col-3" id="nascosta">
                    <p>Non deve essere visualizzato</p>
                </section>
                <section class="col-7" id="cancel">
                <a   href="../index.html">Cancella il tuo profilo</a>
                </section>
            </section>
        </main>

    </body>

</html>
