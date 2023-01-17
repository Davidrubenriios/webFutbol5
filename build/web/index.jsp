<%-- 
    Document   : index
    Created on : 28/11/2022, 12:54:12
    Author     : DAVID
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>FUTBOL 5</title>
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
                            <a class="nav-link" href="loginAd.jsp">ADMINISTRADOR</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <h2 class="titulos py-2">¿Te gusta jugar al futbol y devertirte?</h2>
        <h3 class="titulos py-2">Esto es para vos.</h3>
        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3" aria-label="Slide 4"></button>
            </div>
            <div class="carousel-inner" >
                <div class="carousel-item active">
                    <img src="IMG/futbol5_1.png" width="50%" height="auto" class="d-block mx-auto " alt="banner1">
                    <div class="carousel-caption d-none d-md-block">
                        <p>Contamos con la mejor cancha de la ciudad.</p></div>
                </div>
                <div class="carousel-item">
                    <img src="IMG/futbo5_4.png" width="50%" height="auto" class="d-block mx-auto" alt="bammer2">
                    <div class="carousel-caption d-none d-md-block">
                        <p>La mejor iluminación led y césped artificial.</p></div>
                </div>
                <div class="carousel-item">
                    <img src="IMG/futbol5_3.png" width="50%" height="auto" class="d-block mx-auto" alt="banner3">
                    <div class="carousel-caption d-none d-md-block">
                        <p>Y un lugar para despejarte y disfrutar antes </br> y después de cada partido. </p></div>
                </div>
                <div class="carousel-item">
                    <img src="IMG/futbol5_2.png" width="50%" height="auto" class="d-block mx-auto" alt="banner4">
                    <div class="carousel-caption d-none d-md-block">
                        <p>Saca tu turno ya. Haciendo clic en TURNOS.</p>
                    </div>

                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>
    <div class="text-center my-5 py-5" style="background-color: wheat">
        <h4>SOLICITA TU TURNO.</h4>
        <h6>Solicita un turno de tu deporte faborito haciendo clic en este boton.</br>
            Registrate y obtene beneficios unicos para cliente esclusivo como vos.
        </h6>
        <a class="btn btn-success" href="login.jsp">Sacar turno</a>
    </div>

    <div class="container border border-5 my-5">
        <div>
            <h4  class="titulos py-2" style="text-align: center">Seccion de entretenimiento</h4> 
            <p style="color: white" class="text-center my-3">Aqui te traemos algunos canales de entretenimiento para que lo veas en tu tiempo libre.</p>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <div class="card mx-auto" style="width: 18rem;">
                    <img src="IMG/futbol-libre-tv.png" class="card-img-top b" alt="...">
                    <div class="card-body">
                        <p class="card-text">Queres mirar partidos online de tu equipo faborito. hace clic aqui y disfruta.</p>
                        <a class="btn btn-primary" href="https://librefutbol.com/">Ver</a>
                    </div>
                </div>
            </div>

            <div class="col-sm-6 ">
                <div class="card mx-auto" style="width: 18rem;">
                    <img src="IMG/bloopers-futbol.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <p class="card-text">Disfruta de momentos graciosos de nuestro querido deporte, de la plataforma mas usados YouTube.</p>
                        <a class="btn btn-primary" href="https://www.youtube.com/watch?v=ZKtX7PWJf5Y">Ver</a>
                    </div>
                </div>
            </div>
        </div>
        <br>
    </div>
    <br>
    <br>
    <footer>
        <p>© DAVID RIOS</p>
    </footer>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>