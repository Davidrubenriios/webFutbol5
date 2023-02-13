

<%@page import="controlador.AdministradorJpaController"%>
<%@page import="modelo.Administrador"%>
<%@page import="java.util.Objects"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Contactos</title>
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
                            <a class="nav-link" <a href="turnos.jsp">TURNOS</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">INICIO</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="administrador.jsp">ADMINISTRADOR</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <%
            String accion = "";
            int idAdministrador = -1;
            // obtengo los datos que recibo por la url y los guardo en variables
            if (!Objects.isNull(request.getParameter("accion"))) {
                accion = request.getParameter("accion");
            }

            //antes de guardarlo en la variable lo convierto a entero
            if (!Objects.isNull(request.getParameter("idAdministrador"))) {
                idAdministrador = Integer.parseInt(request.getParameter("idAdministrador"));
            }

//creo una instancia de Administrador y del ctrol de Administrador
            Administrador objAdministrador = new Administrador();
           AdministradorJpaController objCtrolAdm = new AdministradorJpaController();
            String nomAd = "";
            String apeAd = "";
          
            if ( idAdministrador!= 0) {
                //busco todos los datos de el Administrador por su id
                objAdministrador = objCtrolAdm.findAdministrador(idAdministrador);
                // si encontro el objeto y sus datos no son nulos
                if (!Objects.isNull(objAdministrador)) { //guardo los datos en variables para poder mostrarlos
                    //en el formulario
                    nomAd = objAdministrador.getNombre();
                    apeAd = objAdministrador.getApellido();
  
                }
            }

        %>

        <div  class=" container cuerpo py-4">

            <center>
                <h1 class="titulos py-4">Seguro que desea ELIMINAR a:</h1>
                <form class="row g-3" action="sRegistroAdm" method="GET">
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <input type="hidden" name="txtIdAdm" id="txtIdAdm"  value="<%=idAdministrador%>" >
                        <input type="hidden" name="txtAccion" id="txtAccion"  value="<%=accion%>" >
                        <label for="txtNombre" class="form-label titulos">Apellido y Nombre</label>
                        <input type="text" class="form-control" style="text-align-last: center" name="txtNomAd" id="txtNomAd" value="<%=apeAd%>  <%=nomAd%>" required>
                    </div>     
                    <div class="col-md-4"></div>
                    <div class="col-12">
                        <button type="submit" class="btn btn-success " name="btnEnviar">Eliminar</button>
                        <a href="listaAd.jsp" class="btn btn-primary">Canselar</a>
                    </div>
                </form>
            </center>
        </div>
        <footer>
            <p>© DAVID RIOS</p>
        </footer>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>