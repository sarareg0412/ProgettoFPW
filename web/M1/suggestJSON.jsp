<%-- 
    Document   : suggestJSON
    Created on : 9-giu-2019, 16.54.25
    Author     : Sara
--%>
<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>

<json:array>
    <c:forEach var="autore" items="${autoriList}">
        <json:object>
            <json:property name="autore" value="${autore.toString()}"/>
        </json:object>
    </c:forEach>
</json:array>