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
        <div>
           <p>${image.title}</p>
           <p>Subida por ${image.uploader} en ${image.storageDate}</p>
            <c:if test="${user.username == image.uploader}">
                <p>Mi imagen</p>
            </c:if>
            <img src="./images/${image.fileName}" alt="error">
            <p>Descripción: ${image.description}</p>
            <p>Autor de la imagen: ${image.author}</p>
            <p>Fecha de captura: ${image.captureDate}</p>
            <p>Palabras clave: ${image.keywords}</p>
        </div>
    </body>
</html>
