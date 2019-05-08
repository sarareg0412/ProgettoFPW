<%-- 
    Document   : header
    Created on : 25-apr-2019, 13.05.11
    Author     : Sara
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Questa jsp contiene il codice dell'header s-->

<!DOCTYPE html>
<header id="sfondo_header" class="col-10">
    <div id="titolo" class="col-2">
        <h1 class="titolo">Free Peer revieW</h1>
            
    </div>
    <nav id="sfondo_menu" >
        <ul id="menu_pagine" class="col-8">
            <c:if test="${user == null}">
                <li><a  class="col-3" href="login.html">Login</a></li>
            </c:if>
            
            <c:if test="${user.getStatus() == 'Autore'}">
                <li><a  class="col-3" href="articoli.html">Articoli</a></li>
                <li><a class="col-3" href="gestione.html">Valutazioni</a></li>
                <li><a class="col-3" href="registrazione.html">Profilo</a></li>
            </c:if>
                
            <c:if test="${user.getStatus() == 'Organizzatore'}">
                <li><a  class="col-3" href="gestione.html">Gestione</a></li>
                <li><a class="col-3" href="registrazione.html">Profilo</a></li>

            </c:if>
        </ul>
    </nav>
</header>
