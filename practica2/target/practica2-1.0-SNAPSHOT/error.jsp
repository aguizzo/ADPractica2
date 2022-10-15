<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Error!</h1>
        <p>${Msg}</p> 
        <c:choose>
            <c:when test="${user == null}">
                <a href="/practica2">Inicio</a>
            </c:when>
            <c:otherwise>
                <a href="/practica2/menu.jsp">Menú</a>
            </c:otherwise>
        </c:choose>
    </body>
</html>
