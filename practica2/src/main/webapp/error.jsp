<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="models.User"%>
        
<%
    String param = (String)request.getAttribute("code");
    int code = 0;
    if (param != null) {
        code = Integer.parseInt(param);
    }
    String errorMsg = "vacio";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${code}
        <h1>Error!</h1>
        <%
        switch(code) {
            case 20:
                errorMsg = "La imagen no existe.";
                break;
            default: 
                errorMsg = "Ha ocurrido algo inesperado.";
        }
        if (param == null) {
            errorMsg = "no params";
        }
        %>
        <p><%= errorMsg %></p> 
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
