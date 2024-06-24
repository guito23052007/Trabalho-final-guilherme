    <%-- 
    Document   : header
    Created on : 04/05/2024, 09:25:41
    Author     : aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                
        <link rel="stylesheet" href="./styles/home.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    </head>
    <body>
         <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="logo"><img src="assets/logo.png" alt="png"></div>
                <div class="carrinho"><a href="./carrinhos"><i class="fa-solid fa-cart-shopping" style="color: #ffffff;"></i></a></div>
                <div class="perfil"><a href="./carrinhos"><i class="fa-solid fa-user" style="color: #ffffff;"></i></a></div>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <form class="d-flex" action="buscar-produtos" method="get">
                    <input class="form-control me-2" name="busca" type="search" placeholder="Search" aria-label="Pesquisar" required>
                    <a class="nav-link" href="#">Home</a>
                    <a class="nav-link" href="./buscar-produtos?cat=1&busca=">Descobrir</a>

                    <button class="btn btn-outline-success" type="submit">
                        <i class="fa-solid fa-magnifying-glass"></i>

                    </button>
                </form>

                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="#"><i class="fa-solid fa-star" style="color: #ffffff;"></i>Destaques <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#"><i class="fa-solid fa-laptop" style="color: #ffffff;"></i>Pc</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#"><i class="fa-solid fa-ghost" style="color: #ffffff;"></i>Outros</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fa-solid fa-gamepad" style="color: #ffffff;"></i>  Console
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="#">xbox</a>
                                <a class="dropdown-item" href="#">playStation</a>
                                <a class="dropdown-item" href="./Nintendos">Nintendo</a>

                            </div>


                        </li>

                    </ul>
                </div>

            </nav>
        </header>
    </body>
    <script src="https://kit.fontawesome.com/ffe7fbbd06.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</html>
