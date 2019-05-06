<%-- 
    Document   : aside
    Created on : 3-mag-2019, 19.03.10
    Author     : Sara
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<aside id="barra_laterale" class="col-2">
    <c:if test="${user == null}">
        <h1>Ciao, non ti sei ancora loggato </h1>
        <form action="login.html" method="post">
            <button type="submit">Login</button>
        </form>
        </c:if>
        <c:if test="${user != null}">
        <h1>Ciao, ${user.getNome()}! </h1>
        <form action="logout.html?logout=true" method="post">
            <button type="submit">Logout</button>
        </form>
        <section id="sottobox">
            <h1>I miei articoli: </h1>
            <ul>
                <c:forEach items="${articoli}" var="u">
                    <li><a href="">${u.getTitolo()}</a></li>
                    </c:forEach>

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
    </c:if>
</aside>