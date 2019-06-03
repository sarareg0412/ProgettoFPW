<%-- 
    Document   : utenteFoundJSON
    Created on : 3-giu-2019, 9.35.29
    Author     : Sara
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>
<%--utentiList--%>
<json:array>
    
    <c:forEach var="utente" items="${utentiList}">
        <json:object>
            
        </json:object>
    </c:>
</json:array>>