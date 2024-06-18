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
            <i class="fa-solid fa-bars" style="color: #ffffff;"></i>
            <div class="container-fluid">
                <a class="navbar-brand" href="./home"><i class="fa-solid fa-house"></i></a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <form class="d-flex" action="buscar-produtos" method="get">
                      
                      
                        <a href="./carrinhos"><i class="fa-solid fa-cart-shopping" style="color: #ffffff;"></i></a>
                    </form>
                    <div class="logo"><img src="assets/logo.png" alt="png"></div>
                </div>
            </div>
            <div class="container container-categorias">
                <c:forEach items="${categorias}" var="categoria">
                    <div class="categoria"><a href="./buscar-produtos?cat=${categoria.idCategoria}&busca=">${categoria.nome}</a></div>
                </c:forEach>
            </div>
        </nav>
        <nav class="navbar navbar-expand-lg bg-body">
    <div class="container-fluid">
        <input class="form-control me-2" name="busca" type="search" placeholder="Pesquisar" aria-label="Search">
          <button class="pesquisa" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
      <button
        data-mdb-collapse-init
        class="navbar-toggler"
        type="button"
        data-mdb-target="#navbarExample01"
        aria-controls="navbarExample01"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarExample01">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item active">
            <a class="nav-link" aria-current="page" href="./home">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="./buscar-produtos?cat=1&busca=">Descobrir</a>
          </li>
                 </ul>
      </div>
    </div>
  </nav>
  <!-- Navbar -->

  <!-- Jumbotron -->
  
  <!-- Jumbotron -->
    </header>
        <main>
       <div class="position-relative">
    <div class="horizontal-scroll-container" id="carousel">
        <div class="card card-custom">
            <div class="card-body">
                <div class="imagemProduto">
                    <img src="assets/carrida.jpg" alt="opa">
                    <p>Corrida</p>
                </div>
            </div>
        </div>
        <div class="card card-custom">
            <div class="card-body">
                <div class="imagemProduto">
                    <img src="assets/mainicreft.jpg" alt="opa">
                    <p>Xbox</p>
                </div>
            </div>
        </div>
        <div class="card card-custom">
            <div class="card-body">
                <div class="imagemProduto">
                    <img src="assets/carro3.jpg" alt="opa">
                    <p>PlayStation</p>
                </div>
            </div>
        </div>
        <div class="card card-custom">
            <div class="card-body">
                <div class="imagemProduto">
                    <img src="assets/marioj.jpg" alt="opa">
                    <p>Nintendo</p>
                </div>
            </div>
        </div>
        <div class="card card-custom">
            <div class="card-body">
                <div class="imagemProduto">
                    <img src="assets/carro3.jpg" alt="opa">
                    <p>Name 5</p>
                </div>
            </div>
        </div>
    </div>
    <button id="scrollLeft" class="scroll-button"><i class="fa-solid fa-chevron-left"></i></button>
    <button id="scrollRight" class="scroll-button"><i class="fa-solid fa-chevron-right"></i></button>
</div>

            <div class="product-container">
                <c:forEach var="produto" items="${produtos}">
                    <div class="card" style="width: 18rem;">
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
