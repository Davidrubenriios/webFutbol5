


<%@page import="controlador.AdministradorJpaController"%>
<%@page import="modelo.Administrador"%>
<%@page import="java.util.Objects"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Registro</title>
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
                            <a class="nav-link" href="login.jsp">SACAR TURNO</a>
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

//creo una instancia de aministrador y del ctrol de aministrador
            Administrador objAdministrador = new Administrador();
            AdministradorJpaController objCtrolAdm = new AdministradorJpaController();

            String nomAd = "";
            String apeAd = "";
            String emailAd = "";
            String passAd = "";
            String domAd = "";
            int dniAd = 0;
            int cgoAreaAd = 0;
            int telAd = 15;

            if (idAdministrador != 0) {
                //busco todos los datos de el aministrador por su id
                objAdministrador = objCtrolAdm.findAdministrador(idAdministrador);
                // si encontro el objeto y sus datos no son nulos
                if (!Objects.isNull(objAdministrador)) { //guardo los datos en variables para poder mostrarlos
                    //en el formulario
                    nomAd = objAdministrador.getNombre();
                    apeAd = objAdministrador.getApellido();
                    emailAd = objAdministrador.getEmailAdm();
                    passAd = objAdministrador.getClave();
                    domAd = objAdministrador.getDomicilio();
                    dniAd = objAdministrador.getDni();
                    cgoAreaAd = objAdministrador.getCodigoArea();
                    telAd = objAdministrador.getTelefono();

                }
            }

        %>
        <div  class=" container cuerpo py-4">

            <center>
                <h1 class="titulos py-4">INGRESE LOS DATOS DEL NUEVO ADMINISTRADOR</h1>
                <form class="row g-3" action="sRegistroAdm" method="GET">
                    <div class="col-md-6">
                        <input type="hidden" name="txtIdAd" id="txtIdAdm"  value="<%=idAdministrador%>" >
                        <input type="hidden" name="txtAccion" id="txtAccion"  value="<%=accion%>" >
                        <label for="txtNomAd" class="form-label titulos">Nombre</label>
                        <input type="text" class="form-control" name="txtNomAd" id="txtNomAd" value="<%=nomAd%>" required>
                    </div>
                    <div class="col-md-6">
                        <label for="txtApeAd" class="form-label titulos">Apellido</label>
                        <input type="text" class="form-control"  name="txtApeAd" id="txtApeAd" value="<%=apeAd%>" required>
                    </div>
                    <div class="col-md-6">
                        <label for="txtEmailAd" class="form-label titulos">Email</label>
                        <input type="email" class="form-control" id="txtEmailAd" name="txtEmailAd" value="<%=emailAd%>" required>
                    </div>
                    <div class="col-md-6">
                        <label for="txtPassAd" class="form-label titulos">Contraseña</label>
                        <input type="password" class="form-control" id="txtPassAd" name="txtPassAd" value="<%=passAd%>" required>
                    </div>
                    <div class="col-md-6">
                        <label for="txtDniAdm" class="form-label titulos">DNI:</label>
                        <input type="number" class="form-control" id="txtDniAdm" name="txtDniAdm" value="<%=dniAd%>" required>
                    </div>
                    <div class="col-md-6">
                        <label for="txtDomAd" class="form-label titulos">Domicilio</label>
                        <input type="text" class="form-control" id="txtDomAd" name="txtDomAd" value="<%=domAd%>" required>
                    </div>
                    <div class="col-md-4">
                        <label for="txtCgoAreaAdm" class="form-label titulos">Codigo de area</label>
                        <input type="number" class="form-control" id="txtCgoAreaAdm" name="txtCgoAreaAdm" value="<%=cgoAreaAd%>" required>
                    </div>
                    <div class="col-md-8">
                        <label for="txttelAdm" class="form-label titulos">Telefono</label>
                        <input type="phone" class="form-control" id="txttelAdm" name="txttelAdm" value="<%=telAd%>" required>
                    </div>  
                    <div class="col-6">
                        <button type="reset" class="btn btn-primary" name="acction">Canselar</button>
                    </div>              
                    <div class="col-6">
                        <button type="submit" class="btn btn-success " name="btnEnviar">Guardar</button>
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