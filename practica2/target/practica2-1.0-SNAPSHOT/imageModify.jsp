<%-- 
    Document   : imageModify
    Created on : 12-oct-2022, 13:30:21
    Author     : alumne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${user == null}">
    <c:redirect url="login.jsp"/> 
</c:if>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <script src="./scripts/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="./css/forms.css">
    </head>
    <body>
        <div class="modify">
        <h1>Modificar Imagen</h1>
            <form 
                action="ImageModify" 
                method="POST" 
            >
                <div class="form-group">
                    <label class="form-label" for="title">
                        Título:
                    </label>
                    <input class="form-control"
                           type="text"
                           name="title"
                           value="${param.title}" required>
                </div>
                <div class="form-group">
                    <label class="form-label" for="description">
                        Descripción:
                    </label>
                    <input class="form-control"
                           type="text"
                           name="description" 
                           value="${param.description}" required>
                </div>
                <div class="form-group">
                    <label class="form-label" for="keywords">
                        Palabras clave:
                    </label>
                    <input class="form-control"
                           type="text"
                           name="keywords"
                           value="${param.keywords}" required>
                </div>
                <div class="form-group">
                    <label class="form-label" for="author">
                        Autor:
                    </label>
                    <input class="form-control"
                           type="text"
                           name="author"
                           value="${user.username}" required>
                </div>
                <div class="form-group">
                    <label class="form-label" for="captureDate">
                        Fecha de captura:
                    </label>
                    <input class="form-control"
                           type="date"
                           name="captureDate"
                           value="${param.capturedate}"
                           required>
                </div>
                <input name="ID" value="${param.ID}" hidden>
                <input class="btn btn-primary"
                       type="submit" value="Subir imagen">
            </form>
            <br>
            <a href="/practica2/menu.jsp">Volver al menú</a>
        </div>
    </body>
</html>

