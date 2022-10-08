<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div class="login">
            <h1>Login</h1>
            <form 
                action="Login" 
                method="POST"
            >
                <div class="form-group">
                    <label class="form-label" for="username">Nombre de usuario:</label>
                    <input class="form-control"
                           type="text"
                           id="username"
                           name="username" required>
                </div>
                <div class="form-group">
                    <label class="form-label" for="password">Contraseña:</label>
                    <input class="form-control"
                           type="password"
                           id="password"
                           name="password" required>
                </div>
                <input class="btn btn-primary"
                       type="submit" value="Login">           
            </form>
            <br>
            <a href="/practica2/userRegister.jsp">Registrarse</a>
        </div>
        
    </body>
</html>
