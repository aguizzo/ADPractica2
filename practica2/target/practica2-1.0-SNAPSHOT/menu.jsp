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
        <h1>Menú</h1>
        <div>
            <%
                if (user != null)
                    out.println("<h2>Bievenido " + user.getUsername() + "</h2>"); 
            %>
        </div>
        <div>
            <ul>
                <li><a href="imageRegister.jsp">Registrar imagen</a></li>
                <li><a href="/practica2/ImageList">Imagenes</a></li>
                <li><a href="error.jsp">Página de error</a></li>
            </ul>
        </div>
        <form action="Menu">
            <input type="submit" name="logout" value="Logout"/>
        </form>
    </body>
</html>


