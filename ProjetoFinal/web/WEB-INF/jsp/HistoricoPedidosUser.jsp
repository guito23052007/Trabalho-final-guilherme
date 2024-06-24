<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Histórico de Pedidos do Usuário</title>
        <!-- Adicione o link para o Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
            <link rel="stylesheet" href="./styles/home.css">

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

        <div class="container">
            <h1>Histórico de Pedidos do Usuário</h1>

            <!-- Tabela Bootstrap -->
            <table class="table table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">imagem</th>
                        <th scope="col">Produto</th>
                        <th scope="col">Valor</th>
                        <th scope="col">forma_pagamento</th>
                        <th scope="col">Data e Hora</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Iteração sobre os pedidos usando JSTL -->
                    <c:forEach items="${pedidos}" var="pedido">
                        <tr>
                            <td>${pedido.imagem_produto}</td>
                            <td>${pedido.nome_produto}</td>
                            <td>R$ ${pedido.valor_produto}</td>
                            <td>${pedido.forma_pagamento}</td>

                            <td>${pedido.datahora}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- Adicione o link para o jQuery e Bootstrap JS no final do body -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js" integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl7+wpNuEH6d3Ao+1gfiB/x+2L4yMhIbxZ5Y+td/eB" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </body>
</html>
