<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${user == null}">
    <c:redirect url="login.jsp"/> 
</c:if>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Búsqueda de imágenes</title>
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <script src="./scripts/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="./css/styles.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <a class="nav-link" aria-current="page" href="menu.jsp">
                      Menú
                  </a>
                </li>                  
                <li class="nav-item">
                  <a class="nav-link" aria-current="page" href="ImageList">
                      Lista de imágenes
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="imageRegister.jsp">
                      Registrar imagen
                  </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="imageSearch.jsp">
                        Buscar imágenes
                    </a>
                </li>
              </ul>
              <form class="d-flex" action="Logout" method="POST"">
                <input class="btn btn-outline-success"
                    type="submit" name="logout" value="Logout"/>
              </form>
            </div>
        </div>
        </nav>
        <div class="login">
            <h1>Búsqueda de imágenes</h1>
            <form action="ImageSearch" method="GET">
                <div class="form-group">
                    <label class="form-label" for="title">
                        Buscar por título
                    </label>
                    <input class="form-control"
                           type="text"
                           name="title">
                </div>
                <div class="form-group">
                    <label class="form-label" for="keywords">
                        Buscar por palabras clave
                    </label>
                    <input class="form-control"
                           type="text"
                           name="keywords">
                </div>
                <div class="form-group">
                    <label class="form-label" for="author">
                        Buscar por autor
                    </label>
                    <input class="form-control"
                           type="text"
                           name="author">
                </div>
                <div class="form-group">
                    <label class="form-label" for="captureDate">
                        Capturada a partir de:
                    </label>
                    <input class="form-control"
                           type="date"
                           name="captureDate">
                </div>
                <input class="btn btn-primary"
                       type="submit" value="Buscar imagen">
            </form>
            <br>
            <a class="back" href="/practica2/menu.jsp">Volver al menú</a>
        </div>
    </body>
</html>
