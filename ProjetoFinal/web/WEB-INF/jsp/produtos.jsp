<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./styles/prods.css">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>Produtos</title>
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
        <main>
        <div class="position-relative">
        <div class="horizontal-scroll-container" id="carousel">
            <div class="card card-custom">
                <div class="card-body">
                    <div class="imagemProduto">
                        <a href="https://example.com/corrida" target="_blank">
                            <img src="assets/yasuke.jpeg" alt="Corrida">
                        </a>
                        <p>Corrida</p>
                    </div>
                </div>
            </div>
            <div class="card card-custom">
                <div class="card-body">
                    <div class="imagemProduto">
                        <a href="https://example.com/xbox" target="_blank">
                            <img src="assets/mainicreft.jpg" alt="Xbox">
                        </a>
                        <p>Xbox</p>
                    </div>
                </div>
            </div>
            <div class="card card-custom">
                <div class="card-body">
                    <div class="imagemProduto">
                        <a href="https://example.com/playstation" target="_blank">
                            <img src="assets/carro3.jpg" alt="PlayStation">
                        </a>
                        <p>PlayStation</p>
                    </div>
                </div>
            </div>
            <div class="card card-custom">
                <div class="card-body">
                    <div class="imagemProduto">
                        <a href="https://example.com/nintendo" target="_blank">
                            <img src="assets/marioj.jpg" alt="Nintendo">
                        </a>
                        <p>Nintendo</p>
                    </div>
                </div>
            </div>
            <div class="card card-custom">
                <div class="card-body">
                    <div class="imagemProduto">
                        <a href="https://example.com/name5" target="_blank">
                            <img src="assets/carro3.jpg" alt="Name 5">
                        </a>
                        <p>Name 5</p>
                    </div>
                </div>
            </div>
        </div>
        <button id="scrollLeft" class="scroll-button"><i class="fas fa-chevron-left"></i></button>
        <button id="scrollRight" class="scroll-button"><i class="fas fa-chevron-right"></i></button>
    </div>

            <div class="product-container">
                <c:forEach var="produto" items="${produtos}">
                    <div class="card" style="width: 14rem;">
                        <div class="card-body">
                            <img src="${produto.imagem}" class="product-image" alt="${produto.nome}">
                            <h5 class="card-title">${produto.nome}</h5>
                            <p class="card-text">Valor: R$ ${produto.valor}</p>
                            <a href="./ProdutoUnico?id=${produto.idProduto}" class="btn btn-primary">Comprar</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </main>
    </body>
        <script src="./js/cardsHome.js"></script>

    <script src="https://kit.fontawesome.com/ffe7fbbd06.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-cj/ywqPYmK8wLLIb84hxEXfKJ0WnLRE4AE3v5I4GA7A2GFSHbF5g9MuqUR2sOtv1" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/js/all.min.js" crossorigin="anonymous"></script>
</html>
