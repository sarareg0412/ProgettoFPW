<%-- 
    Document   : valutazione
    Created on : 25-apr-2019, 13.25.33
    Author     : Sara
--%>

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
            
            <aside id="barra_laterale" class="col-2">
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
                <section id="sfondo_descrizioni">
                  
                    <h1>La SQL Injection</h1>
                    <section id="sottotitoli" class="col-10">
                        <h2 class="col-3">Autori: Vari</h2>
                        <h2 class="col-3">Categoria: HTML, CSS</h3> 
                        <h3 class="col-4">Data: 31 Marzo 2018</h3>
                    </section>
                    
                </section>

                <section id="immagine">
                    <img  title="Foto aticolo" alt="La sql injection" src='images/sql.jpg'>
                </section>
                <section id="contenuto">
                    <p>
                      SQL injection è una tecnica di code injection, usata per attaccare applicazioni di gestione dati, 
                      con la quale vengono inserite delle stringhe di codice SQL malevole all'interno di campi di input 
                      in modo che queste ultime vengano poi eseguite (ad esempio per fare inviare il contenuto del database all'attaccante).  
                      SQL è un linguaggio per interrogare e gestire basi di dati mediante l'utilizzo di costrutti di programmazione denominati query. 
                      Con SQL si leggono, modificano, cancellano dati e si esercitano funzioni gestionali ed amministrative sul sistema dei database. 
                    </p>
                </section>
                
                <section id="valutazione">
                    <h2>Le tue valutazioni:</h2>
                    <form action="articoli.html" method="post">
                        <p id="valuta" class="col-4">La tua valutazione: </p>
                        <div id="scelta_voto" class="col-6">
                            <label for="1">1</label>
                            <input type="radio" name="voto" id="voto-1" value="1">
                            <label for="2">2</label>
                            <input type="radio" name="voto" id="voto-2" value="2">
                            <label for="3">3</label>
                            <input type="radio" name="voto" id="voto-3" value="3">
                             <label for="4">4</label>
                            <input type="radio" name="voto" id="voto-4" value="4">
                             <label for="5">5</label>
                            <input type="radio" name="voto" id="voto-5" value="5">
                        </div>
                    </form>
                    <form action="demo_form.asp" method="get" class="col-10">
                        <label for="lungo">Se sei un autore inserisci un commento:</label>
                        <textarea name="lungo" id="lungo"></textarea>
                        <label for="lungo">Se sei un organizzatore inserisci un commento:</label>
                        <textarea name="lungo" id="lungo"></textarea>
                    </form>
                    <form action="articoli.html" method="post">
                        <button type="submit">Invia</button>
                    </form>
                </section>
            </section>
        </main>
    </body>
</html>