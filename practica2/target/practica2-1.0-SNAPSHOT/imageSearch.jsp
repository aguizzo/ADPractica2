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
            <label for="keywords">
                Buscar por palabras clave
            </label
            <br>
            <input type="text" id="kewywords" name="keywords">
            <br>
            <label for="author">
                Buscar por autor
            </label
            <br>
            <input type="text" id="author" name="author">
            <br>
            <label for="captureDate">
                Capturada a partir de:
            </label>
            <input 
                   type="date"
                   name="captureDate">
            <input type="submit" value="Buscar imagen">
        </form>
    </body>
</html>
