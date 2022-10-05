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
        <h1>Registrar Imagen</h1>
            <form 
                action="ImageRegister" 
                method="POST"
                enctype="multipart/form-data"
            >
                <label for="title">Título:</label><br>
                <input type="text" name="title" required><br>
                <label for="description">Descripción:</label><br>
                <input type="text" name="description" required><br>
                <label for="keywords">Palabras clave:</label><br>
                <input type="text" name="keywords" required><br>
                <label for="author">Autor:</label><br>
                <input type="text" name="author" value="${user.username}" required><br>
                <label for="captureDate">Fecha de captura:</label><br>
                <input type="date" name="captureDate" required><br>
                <input type="file" id="image" name="image" required><br>
                <input type="submit" value="Submit">
            </form>
    </body>
</html>
