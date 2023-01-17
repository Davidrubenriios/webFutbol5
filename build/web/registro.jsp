
<%@page import="modelo.Usuario"%>
<%@page import="controlador.UsuarioJpaController"%>

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
            int idUsuario = -1;
            // obtengo los datos que recibo por la url y los guardo en variables
            if (!Objects.isNull(request.getParameter("accion"))) {
                accion = request.getParameter("accion");
            }

            //antes de guardarlo en la variable lo convierto a entero
            if (!Objects.isNull(request.getParameter("idUsuario"))) {
                idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            }

//creo una instancia de Usuario y del ctrol de Usuario
            Usuario objUsuario = new Usuario();
            UsuarioJpaController objCtrolUsu = new UsuarioJpaController();
            String nom = "";
            String apel = "";
            String email = "";
            String pass = "";
            int cgoArea = 0;
            int tel = 15;
            if (idUsuario != 0) {
                //busco todos los datos de el Usuario por su id
                objUsuario = objCtrolUsu.findUsuario(idUsuario);
                // si encontro el objeto y sus datos no son nulos
                if (!Objects.isNull(objUsuario)) { //guardo los datos en variables para poder mostrarlos
                    //en el formulario
                    nom = objUsuario.getNombre();
                    apel = objUsuario.getApellido();
                    email = objUsuario.getEmailUsu();
                    pass = objUsuario.getClave();
                    cgoArea = objUsuario.getCodigoArea();
                    tel = objUsuario.getTelefono();

                }
            }

        %>
        <div  class=" container cuerpo py-4">

            <center>
                <h1 class="titulos py-4">INGRESE SUS DATOS</h1>
                <form class="row g-3" action="sRegistroUsu" method="GET">
                    <div class="col-md-6">
                        <input type="hidden" name="txtId" id="txtId"  value="<%=idUsuario%>" >
                        <input type="hidden" name="txtAccion" id="txtAccion"  value="<%=accion%>" >
                        <label for="txtNombre" class="form-label titulos">Nombre</label>
                        <input type="text" class="form-control" name="txtNombre" id="txtNombre" value="<%=nom%>" required>
                    </div>
                    <div class="col-md-6">
                        <label for="txtApellido" class="form-label titulos">Apellido</label>
                        <input type="text" class="form-control"  name="txtApellido" id="txtApellido" value="<%=apel%>" required>
                    </div>
                    <div class="col-md-6">
                        <label for="txtEmail" class="form-label titulos">Email</label>
                        <input type="email" class="form-control" id="inputEmail4" name="txtEmail" value="<%=email%>" required>
                    </div>
                    <div class="col-md-6">
                        <label for="txtPassword" class="form-label titulos">Contraseña</label>
                        <input type="password" class="form-control" id="inputPassword4" name="txtPassword" value="<%=pass%>" required>
                    </div>
                    <div class="col-md-4">
                        <label for="txtCgoArea" class="form-label titulos">Codigo de area</label>
                        <input type="number" class="form-control" id="inputCgoArea" name="txtCgoArea" value="<%=cgoArea%>" required>
                    </div>
                    <div class="col-md-8">
                        <label for="txtTel" class="form-label titulos">Telefono</label>
                        <input type="phone" class="form-control" id="inputTel" name="txtTel" value="<%=tel%>" required>
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