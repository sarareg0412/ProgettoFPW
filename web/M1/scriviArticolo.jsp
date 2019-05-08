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
                            <input class="col-7" type="text" name="titolo" id="corto" value="${scelto.getTitolo()}" />
                        </section>

                        <section id="inserisci_autori">
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

                        </section>

                        <section id="inserisci_categoria" >
                            <label class="col-3" for="category">Categoria:</label>
                            <section id="categorie" class="col-7" >
                                
                                <c:forEach items="${scelto.getCategorie()}" var="c">
                                    <c:if test="${c=='CSS'}">
                                        <input type="checkbox" name="category" value="css" checked="true" >CSS
                                    </c:if>
                                    <c:if test="${c!='CSS'}">
                                        <input type="checkbox" name="category" value="css">CSS
                                    </c:if>
                                    <c:if test="${c=='HTML'}">
                                        <input type="checkbox" name="category" value="html" checked="true" >HTML
                                    </c:if>
                                    <c:if test="${c!='HTML'}">
                                        <input type="checkbox" name="category" value="html">HTML
                                    </c:if>
                                    <c:if test="${c=='JSP'}">
                                        <input type="checkbox" name="category" value="jsp" checked="true" >JSP
                                    </c:if>
                                    <c:if test="${c!='JSP'}">
                                        <input type="checkbox" name="category" value="jsp">JSP
                                    </c:if>                                
                                    </br>
                                    <c:if test="${c=='AJAX'}">
                                        <input type="checkbox" name="category" value="ajax" checked="true" >AJAX
                                    </c:if>
                                    <c:if test="${c!='AJAX'}">
                                        <input type="checkbox" name="category" value="ajax">AJAX
                                    </c:if>   
                                    <c:if test="${c=='JavaScript'}">
                                        <input type="checkbox" name="category" value="javascript" checked="true" >JavaScript
                                    </c:if>
                                    <c:if test="${c!='JavaScript'}">
                                        <input type="checkbox" name="category" value="javascript">JavaScript
                                    </c:if>    
                                    <c:if test="${c=='Servlet'}">
                                        <input type="checkbox" name="category" value="servlet" checked="true" >Servlet
                                    </c:if>
                                    <c:if test="${c!='Servlet'}">
                                        <input type="checkbox" name="category" value="servlet">Servlet
                                    </c:if>    
                                </c:forEach>

                            </section>
                        </section>

                        <section id="inserisci_immagine">
                            <label class="col-3" for="immagine">Immagine:</label>
                            <input type="file" class="col-7" id="foto_scelta" name="immagine" accept="image/png, image/jpeg">
                        </section>
                        <section id="inserisci_data">
                            <label class="col-3" for="start">Data:</label>
                            <input class="col-7" type="date" id="start" name="start"
                                   value="${scelto.getFormatoData()}" 
                                   min="2018-01-01" max="2020-12-31">
                        </section>
                        <section id="inserisci_testo" class="col-10">
                            <label for="testo" class="col-3">Testo:</label>
                            <textarea class="col-7" name="testo" id="lungo">${scelto.getTesto()}</textarea>
                        </section>
                        <section class="col-3" id="nascosta">
                            <p>Non deve essere visualizzato</p>
                        </section>

                        <input type="hidden" name="pid" value="${scelto.getPid()}"><br/>
                        <button class="col-7" type="submit" name="modifica" id="save_articolo">Salva</button>
                    </form>
                </section>
            </c:if>
        </main>    
    </body>
</html>

