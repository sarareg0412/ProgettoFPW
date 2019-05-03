<%-- 
    Document   : aside
    Created on : 3-mag-2019, 19.03.10
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<aside id="barra_laterale" class="col-2">

    <h1>Ciao, ${user.getNome()}! </h1>
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