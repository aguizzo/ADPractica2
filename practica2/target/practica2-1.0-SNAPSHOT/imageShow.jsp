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
            <c:if test="${user.username == image.uploader}">
                <p>Mi imagen</p>
            </c:if>
            <img src="./images/${image.fileName}" alt="error">
        </div>
    </body>
</html>
