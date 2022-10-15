<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Image"%>
<%@page import="models.User"%>
<%@page import="models.ImageService"%>

<c:if test="${user == null}">
    <c:redirect url="login.jsp"/> 
</c:if>

<%
    final ImageService iS = ImageService.getInstance();
    String id = request.getParameter("ID");
    int ID = Integer.parseInt(id);
    Image im = iS.getImage(ID);
    if (im == null) {
        response.sendRedirect("Error?code=20");
    }
    else {
        User user = (User)session.getAttribute("user");
        if (!user.getUsername().equals(im.getUploader())) {
            response.sendRedirect("Error?code=403");
        }
    }
%>

    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar imagen</title>
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <script src="./scripts/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <h1>¿Quieres eliminar la imagen? </h1>
        <form 
                action="ImageDelete" 
                method="POST"
         >
                <input name="ID" value="${param.ID}" hidden>
                <input class="btn btn-primary"
                               type="submit" value="Sí">
        </form>
        <form 
                action="menu.jsp" 
                method="POST"
         >
                <input class="btn btn-primary"
                               type="submit" value="No">
        </form>
    </body>
</html>
