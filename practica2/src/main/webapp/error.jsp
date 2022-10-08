<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="models.User"%>
        
<%
    User user = (User)session.getAttribute("user");
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
        <%   
        if (user == null)
            out.println("<a href=\"/practica2\">Inicio</a>");
        else 
            out.println("<a href=\"/practica2/menu.jsp\">Menú</a>");
        %>
    </body>
</html>
