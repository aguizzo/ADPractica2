<%-- 
    Document   : login
    Created on : 19-sep-2022, 15:27:44
    Author     : alumne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form 
            action = "Login" 
            method = "POST"
        >
            <label for="username">username:</label><br>
            <input type="text" id="username" name="username"><br>
            <label for="password">password:</label><br>
            <input type="password" id="password" name="password"><br>
            <input type="submit" value="Submit">
        </form>
        <br>
        <a href="/practica2/index.jsp">Index</a>
    </body>
</html>