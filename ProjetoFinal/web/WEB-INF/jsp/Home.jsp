<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles/home.css">
    <link rel="stylesheet" href="./styles/header.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <title>Home</title>
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
              <input type="text" value="${cookie.userId.value}">
          </li>
                 </ul>
      </div>
    </div>
  </nav>
  <!-- Navbar -->

  <!-- Jumbotron -->
  
  <!-- Jumbotron -->
    </header>
      
    <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="assets/carro3.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="assets/carro3.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="assets/carro2.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
    
   <div class="position-relative">
    <div class="horizontal-scroll-container" id="carousel">
        <c:forEach var="xboxs" items="${xbox}">
            <div class="card card-custom">
                <div class="card-body">
                    <div class="imagemProduto">
                        <img src="${xboxs.imagem}" alt="${xboxs.nome}">
                    </div>
                    <h5 class="card-title">${xboxs.nome}</h5>
                    <p class="card-text">Valor: R$ ${xboxs.valor}</p>
                    <a href="./ProdutoUnico?id=${xboxs.idProduto}" class="btn btn-primary">Comprar</a>
                </div>
                
            </div>
        </c:forEach>
    </div>
    <button id="scrollRight" class="scroll-button"><i class="fa-solid fa-chevron-right"></i></button>
     <button id="scrollLeft" class="scroll-button"><i class="fa-solid fa-chevron-left"></i></button>
</div>


     <div class="nintendo">
    <div class="horizontal-scroll-container" id="carousel">
        
        <c:forEach var="nintendos" items="${nintendo}">
            <div class="card card-custom">
                <div class="card-body">
                    <div class="imagemProduto">
                        <img src="${nintendos.imagem}" alt="${nintendos.nome}">
                    </div>
                    <h5 class="card-title">${nintendos.nome}</h5>
                    <p class="card-text">Valor: R$ ${nintendos.valor}</p>
                    <a href="./ProdutoUnico?id=${nintendos.idProduto}" class="btn btn-primary">Comprar</a>
                </div>
                
            </div>
                 <button id="scrollRight" class="scroll-button"><i class="fa-solid fa-chevron-right"></i></button>
     <button id="scrollLeft" class="scroll-button"><i class="fa-solid fa-chevron-left"></i></button>
        </c:forEach>
    </div>
    
</div>

    
    <div class="playstation">
    
        
        <c:forEach var="playStation" items="${playStation}">
            <div class="card card-custom">
                <div class="card-body">
                    <div class="imagemProduto">
                        <img src="${playStation.imagem}" alt="${playStation.nome}">
                    </div>
                    <h5 class="card-title">${playStation.nome}</h5>
                    <p class="card-text">Valor: R$ ${playStation.valor}</p>
                    <a href="./ProdutoUnico?id=${playStation.idProduto}" class="btn btn-primary">Comprar</a>
                </div>
                
            </div>
        </c:forEach>
    
    
</div>
    
     <div class="rpg">
    
        
        <c:forEach var="rpg" items="${rpg}">
            <div class="card card-custom">
                <div class="card-body">
                    <div class="imagemProduto">
                        <img src="${rpg.imagem}" alt="${rpg.nome}">
                    </div>
                    <h5 class="card-title">${rpg.nome}</h5>
                    <p class="card-text">Valor: R$ ${rpg.valor}</p>
                    <a href="./ProdutoUnico?id=${rpg.idProduto}" class="btn">Comprar</a>
                </div>
                
            </div>
        </c:forEach>
    
    
</div>


    <footer class="text-center text-lg-start bg-body-tertiary text-muted">
        <section class="">
            <div class="container text-center text-md-start mt-5">
                <div class="row mt-3">
                    <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                        <h6 class="text-uppercase fw-bold mb-4"><i class="fas fa-gem me-3"></i>Company name</h6>
                        <p>Here you can use rows and columns to organize your footer content. Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                    </div>
                    <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                        <h6 class="text-uppercase fw-bold mb-4">Products</h6>
                        <p><a href="#!" class="text-reset">Angular</a></p>
                        <p><a href="#!" class="text-reset">React</a></p>
                        <p><a href="#!" class="text-reset">Vue</a></p>
                        <p><a href="#!" class="text-reset">Laravel</a></p>
                    </div>
                    <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                        <h6 class="text-uppercase fw-bold mb-4">Useful links</h6>
                        <p><a href="#!" class="text-reset">Pricing</a></p>
                        <p><a href="#!" class="text-reset">Settings</a></p>
                        <p><a href="#!" class="text-reset">Orders</a></p>
                        <p><a href="#!" class="text-reset">Help</a></p>
                    </div>
                    <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                        <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
                        <p><i class="fas fa-home me-3"></i> Brasil, Londrina, BR</p>
                        <p><i class="fas fa-envelope me-3"></i> guiguiaraujosantos2007</p>
                        <p><i class="fas fa-phone me-3"></i> 55 43 988501254</p>
                        <p><i class="fas fa-print me-3"></i> 33385400</p>
                    </div>
                </div>
            </div>
        </section>
        <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
            <!-- Facebook -->
<a class="btn text-white" data-mdb-ripple-init style="background-color: #3b5998;" href="#!" role="button">
  <i class="fab fa-facebook-f"></i>
</a>


<!-- Instagram -->
<a class="btn text-white" data-mdb-ripple-init style="background-color: #ac2bac;" href="#!" role="button">
  <i class="fab fa-instagram"></i>
</a>

<!-- Linkedin -->
<a class="btn text-white" data-mdb-ripple-init style="background-color: #0082ca;" href="#!" role="button">
  <i class="fab fa-linkedin-in"></i>
</a>



<!-- Github -->
<a class="btn text-white" data-mdb-ripple-init style="background-color: #333333;" href="#!" role="button">
  <i class="fab fa-github"></i>
</a>




            © 2024 Copyright: <a class="text-reset fw-bold" href="https://mdbootstrap.com/">guiguiaraujosanto2007@gmail.com</a>
        </div>
    </footer>
    
    <script src="./js/cardsHome.js"></script>
    <script src="https://kit.fontawesome.com/ffe7fbbd06.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-cj/ywqPYmK8wLLIb84hxEXfKJ0WnLRE4AE3v5I4GA7A2GFSHbF5g9MuqUR2sOtv1" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/js/all.min.js" crossorigin="anonymous"></script>
</body>
</html>
