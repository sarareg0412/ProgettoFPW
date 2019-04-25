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
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        
        <meta name="author" content="Sara Regali">
        <meta name="keywords" content="FPW, Milestone1, HTML, CSS, Java">
        <meta name="description" content="Pagina contenente gli articoli; prima Milestone">            

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
                        <tr>
                            <td>13/03/19</td>
                            <td>Le classi in Java</td>
                            <td>APERTO</td>
                            <td><a><i class="fas fa-pencil-alt"> </i></a><a><i class="far fa-trash-alt"></i></a></td>
                        </tr>
                        <tr id="righe_pari">
                            <td>15/03/19</td>
                            <td>Programmazione Server-Side</td>
                            <td>IN VALUTAZIONE</td>
                            <td><a><i class="fas fa-pencil-alt"></i></a></td>
                        </tr>
                        <tr>
                            <td>29/03/19</td>
                            <td>Utilizzi di Javascript</td>
                            <td>ACCETTATO</td>
                            <td><i class="fas fa-check"></i></td>
                        </tr>
                        <tr id="righe_pari">
                            <td>30/03/19</td>
                            <td>Le LAN cablate</td>
                            <td>RIFIUTATO</td>
                            <td><i class="fas fa-times"></i></td>
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
