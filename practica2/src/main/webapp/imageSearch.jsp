<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${user == null}">
    <c:redirect url="login.jsp"/> 
</c:if>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Búsqueda de imágenes</h1>
        <form action="ImageSearch" method="GET">
            <label for="title">
                Buscar por título
            </label
            <br>
            <input type="text" id="title" name="title">
            <br>
            <input type="submit" value="Buscar imagen">
        </form>
    </body>
</html>