<%-- 
    Document   : listaAd
    Created on : 18/12/2022, 23:29:22
    Author     : DAVID
--%>

<%@page import="java.util.List"%>
<%@page import="controlador.AdministradorJpaController"%>
<%@page import="modelo.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Lista de clientes</title>
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
                            <a class="nav-link" <a href="login.jsp">SACAR TURNO</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="contactos.jsp">CONTACTOS</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">INICIO</a>
                        </li>
                        </li>
                        <li class="nav-item" >
                            <a class="nav-link" href="loginAd.jsp">ADMINISTRADOR</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

    <center>
        <h1 class="titulos py-3">Lista de Empleados</h1>


        <%
            Administrador objAdm = new Administrador();
            AdministradorJpaController objCtrolAdm = new AdministradorJpaController();

            List<Administrador> lista = objCtrolAdm.findAdministradorEntities();
                    
            out.println("<a href='registro.jsp?accion=N'class='btn btn-primary'>Nuevo</a> ");

            out.println("<table class='table table-hover table my-3'>");
            out.println("<thead>");
            out.println("<tr class='table-dark'>");
            out.println("<th scope='col'>DNI</th>");
            out.println("<th scope='col'>APELLIDO Y NOMBRE</th>");
            out.println("<th scope='col'>DOMICILIO</th>");
            out.println("<th scope='col'>TELEFONO</th>");
            out.println("<th scope='col'></th>");
            out.println("<th scope='col'></th>");
            out.println("</tr>");
            out.println("</thead>");
            /*PREGUNTO SI LA LISTA NO ESTA VACIA*/
            if (!lista.isEmpty()) {   //recorro la lista de administradores
                for (int i = 0; i < lista.size(); i++) { //obtengo una persona en particular para mostrar los datos
                    out.println("<tbody>");
                    objAdm = lista.get(i);
                    out.println("<tr scope='row'class='table-success'>");
                    out.println("<td>" + objAdm.getDni()+ "</td>");
                    out.println("<td>" + objAdm.getApellido() + " " + objAdm.getNombre() + "</td>");
                    out.println("<td>" + objAdm.getDomicilio()+ "</td>");
                    out.println("<td>" + objAdm.getCodigoArea() + " " + objAdm.getTelefono() + "</td>");
                    out.println("<td><a class='btn btn-danger' href='?accion="+ objAdm.getIdAdministrador() +"'</a>Borrar  </td>");
                    out.println("<td><a class='btn btn-warning' href='registroAd.jsp?accion&idAdministrador="+ objAdm.getIdAdministrador() +"'</a>Edita</td>");
                    out.println("</tr>");
                }

            }
            out.println("</tbody>");
            out.println("</table>");

        %>

        <a href="administrador.jsp" class="btn btn-success"> VOLVER </a>
    </center>


    <footer>
        <p>© DAVID RIOS</p>
    </footer>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
