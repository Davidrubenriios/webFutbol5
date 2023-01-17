<%-- 
    Document   : login
    Created on : 29/11/2022, 00:37:45
    Author     : DAVID
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <img class="LOGO" src="IMG/images.png" alt=""/>
                <a class="navbar-brand" href="#">FUTBOL 5</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="registro.jsp">REGISTRO</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">INICIO</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="loginAd.jsp">ADMINISTRADOR</a>
                        </li>
                        
                    </ul>
                </div>
            </div>
        </nav>
        <div  class=" container cuerpo py-2">
            <center>
                <div class="container mt-5 mb-3">
                    <form method="post" action="sLogin">
                        <div class="card" style="width: 20rem">
                            <div class="card-body">
                                <h3>Iniciar Sesion</h3>
                                <input type="text" name="txtUsuario" class="form-control mt-4" placeholder="Ingresa Email" required>
                                <input type="password" name="txtClave" class="form-control mt-4" placeholder="Ingresa clave" required>
                                <input type="submit" name="btnLogin" class="btn btn-success mt-4" value="Ingresar"> <br><br>
                                <a href="registro.jsp?accion=N">- Crear cuenta - </a>
                            </div>
                        </div>
                    </form>
                </div>
            </center>

        </div>
        <footer>
            <p>© DAVID RIOS</p>
        </footer>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>