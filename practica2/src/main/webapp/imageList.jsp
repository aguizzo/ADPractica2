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
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <script src="./scripts/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="./css/styles.css">
    </head>
    <body>
        <h1>Lista de Imágenes</h1>
        <c:if test="${imageList.size() == 0}">
            <p>No hay imágenes.</p>
        </c:if>
        <c:forEach items="${imageList}" var="im">
            <c:url var="link" value="ImageShow">
                <c:param name="ID" value="${im.id}"></c:param>
            </c:url>
            <c:url var="link1" value="imageDelete.jsp">
                <c:param name="ID" value="${im.id}"></c:param>
            </c:url>
            <c:url var="link2" value="imageModify.jsp">
                <c:param name="ID" value="${im.id}"></c:param>
                <c:param name="title" value="${im.title}"></c:param>
                <c:param name="description" value="${im.description}"></c:param>
                <c:param name="keywords" value="${im.keywords}"></c:param>
                <c:param name="capturedate" value="${im.captureDate}"></c:param>
            </c:url>
            <div class="container border mt-3">
                <h3>${im.title}</h3>
                <div class="d-flex p-3">
                    <a href="${link}">
                        <img src="./images/${im.fileName}" alt="error"
                             class="flex-shrink-0 me-3 border rounded-circle Imlist"
                        >
                    </a>
                    <div>
                        <h4>Subida por: ${im.uploader}</h4>
                        <small>${im.storageDate}</small>
                        <c:if test="${user.username == im.uploader}">
                            <a href="${link1}">
                                Eliminar Imagen
                            </a>
                            <a href="${link2}">
                                <br>Modificar Imagen
                            </a>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:forEach> 
    </body>
</html>
