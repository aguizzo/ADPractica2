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
        <c:forEach items="${imageList}" var="im">
            <c:url var="link" value="ImageShow">
                <c:param name="ID" value="${im.id}"></c:param>
            </c:url>
            <p>${im.title}</p>
            <c:if test="${user.username == im.uploader}">
                <p>Mi imagen</p>
            </c:if>
            <a href="${link}">
                <img src="./images/${im.fileName}" alt="error">
            </a>
        </c:forEach> 
    </body>
</html>
