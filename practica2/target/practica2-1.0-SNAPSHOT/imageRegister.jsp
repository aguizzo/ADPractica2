<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="models.User"%>
        
<%
    User user = (User)session.getAttribute("user");
    if (user == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }    
%>
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
                <input type="text" name="title"><br>
                <label for="description">Descripción:</label><br>
                <input type="text" name="description"><br>
                <label for="keywords">Palabras clave:</label><br>
                <input type="text" name="keywords"><br>
                <label for="author">Autor:</label><br>
                <input type="text" name="author"><br>
                <label for="captureDate">Fecha de captura:</label><br>
                <input type="date" name="captureDate"><br>
                <input type="file" id="image" name="image"><br>
                <input type="submit" value="Submit">
            </form>
    </body>
</html>
