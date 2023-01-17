
<%@page import="modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Turnos</title>
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
                            <a class="nav-link" <a href="index.jsp">INICIO</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="contactos.jsp">CONTACTOS</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="loginAd.jsp">ADMINISTRADOR</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <%
         String nom = (String)session.getAttribute("Nombre");
         String ape = (String) session.getAttribute("Apellido");
         int tele = (int)session.getAttribute("Telefono");
        %>
        <div class="row">
        <div class=" col-sm-3">
            <h2 class="titulos my-4">Sacar turno</h2>

            <form class=" row-cols-3 my-3 m-3" action="">
                <select class="form-select my-2" aria-label="Default select example">
                    <option selected>Seleccione el horario</option>
                    <option value="1">20:00</option>
                    <option value="2">21:00</option>
                    <option value="3">22:00</option>
                    <option value="3">23:00</option>
                </select>
                <label for="txtNombre" class="titulos">Nombre</label>
                <input type="text" id="txtNombre" name="txtNombre" class=" col-7 mx-aut my-2" value="<%= nom%>" required>
                <label for="txtApellido" class="titulos">Apellido</label>
                <input type="text" id="txtApellido" name="txtApellido" class=" col-7 mx-aut my-2" value="<%= ape%>"required>
                <label for="txtTelelfono" class="titulos">Telefono</label>
                <input type="phone" id="txtTelefono" name="txtTelefono" class=" col-7 mx-aut my-2" value="<%= tele%>"required>                   
                <input type="submit" class="btn btn-success m-3  col-12 mx-auto"value="GUARDAR">                       
            </form>
        </div>
        <div class=" col-sm-8">
             <h2 class="titulos my-4">Planilla de turnos</h2>
             
             
        </div>
    </div>
        <footer>
            <p>© DAVID RIOS</p>
        </footer>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>