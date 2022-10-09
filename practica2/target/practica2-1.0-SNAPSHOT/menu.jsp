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
        <h1>Menú</h1>
        <div>
            <h2>Bienvenido ${user.username}</h2>
        </div>
        <div>
            <ul>
                <li><a href="imageRegister.jsp">Registrar imagen</a></li>
                <li><a href="/practica2/ImageList">Imágenes</a></li>
                <li><a href="/practica2/imageSearch.jsp">Buscar imágenes</a></li>
                <li><a href="error.jsp">Página de error</a></li>
            </ul>
        </div>
        <form action="Menu" method="POST">
            <input type="submit" name="logout" value="Logout"/>
        </form>
        
    </body>
</html>


