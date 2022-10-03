<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.List"%>
<%@page import="models.Image"%>
<%@page import="models.User"%>

<%  User user = (User)session.getAttribute("user");
    List<Image> list = null;
    if (user == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
    else {
        list = (List<Image>)request.getAttribute("imageList");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% for(Image im : list) { %>
        <c:url var="link" value="ImageList">
            <c:param name="ID" value="<%= Integer.toString(im.getId())%>"></c:param>
        </c:url>
        
        <div>
            <p><%= im.getTitle()%></p><br>
            <br>
            <a href="${link}">
                <img src="./images/<%= im.getFileName()%>" alt="error">
            </a>
        </div>
        
        
        <% } %>
        
    </body>
</html>
