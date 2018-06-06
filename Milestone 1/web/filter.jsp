<%-- 
    Document   : filter
    Created on : 6-giu-2018, 16.31.49
    Author     : kekko
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<json:array>
    <c:forEach var="categorie" items="${categoryList}">
        <json:object>
            <json:property name="type" value="categoria"/>
            <json:property name="content" value="${categorie}"/>
        </json:object>
    </c:forEach>

    <c:forEach var="us" items="${userList}">
        <json:object>
            <json:property name="type" value="user"/>
            <json:property name="nome" value="${us.getName()}"/>
            <json:property name="cognome" value="${us.getSurname()}"/>
            <json:property name="profImg" value="${us.getUrlImagine()}"/>
        </json:object>
    </c:forEach>
</json:array>