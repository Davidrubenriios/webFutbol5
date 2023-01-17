
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Administracion</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            String nomAd = (String) session.getAttribute("NombreAd");
            String apeAd = (String) session.getAttribute("ApellidoAd");
            int Dni = (int) session.getAttribute("DNI");
        %>
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
                            <a class="nav-link" <a href="login.jsp">TURNOS</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="contactos.jsp">CONTACTOS</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">INICIO</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    <center>
        <div  class="container cuerpo py-4">
            <h1 class="titulos">BIENVENIDO ADMINISTRADOR:<br> <%=apeAd%> <%=nomAd%> DNI: <%=Dni%>  </h1>
            <br>
            <div class="row">
                <div class="col-sm-4">
                    <div class="card mx-auto border border-5 text-bg-dark" style="width: 18rem;">
                        <img src="IMG/imgCan.png" alt=""/>
                        <div class="card-body">
                            <a href="" class="btn btn-success"> Lista de turnos</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <a href="listaUsu.jsp">
                        <div class="card mx-auto border border-5 text-bg-dark" style="width: 15rem;">
                            <img src="IMG/imgClie.png" alt="" class="my-2"/>
                            <div class="card-body">
                                <a href="listaUsu.jsp" class="btn btn-success"> Lista de clientes</a>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-sm-4">
                    <a href="listaAd.jsp">
                        <div class="card mx-auto border border-5 text-bg-dark" style="width: 15rem;">
                            <img src="IMG/imgAdm.png" alt="" class="my-2"/>
                            <div class="card-body">
                                <a href="listaAd.jsp" class="btn btn-success">Lista de empleados</a>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
    </center>
    <footer>
        <p>© DAVID RIOS</p>
    </footer>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>