<%-- 
                               <div class="carrinho"><button>Adicionar Carrinho</button></div>
    Document   : produtoUnico
    Created on : 13/05/2024, 15:11:14
    Author     : Senai
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="model.bean.Produtos" %>
<%@ page import="model.dao.ProdutosDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./styles/unico.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">



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

            <div class="container">
                <c:forEach var="produto" items="${produtos}">
                    <img src="${produto.imagem8}" class="fund" alt="Thumbnail 1">
                    <div id="produto${produto.idProduto}" class="produto">
                        <h2>${produto.nome}</h2>
                        <div class="image-container">
                            <div class="imagemP"><img id="imagemP${produto.idProduto}" src="${produto.imagem7}" alt="Imagem Principal"></div>
                             
                            <img id="mainImage${produto.idProduto}" src="${produto.imagem2}" class="main-image" alt="Imagem Principal">

                            <div class="thumbnails">
                                <img src="${produto.imagem2}" class="thumbnail" alt="Thumbnail 1">
                                <img src="${produto.imagem3}" class="thumbnail" alt="Thumbnail 2">
                                <img src="${produto.imagem4}" class="thumbnail" alt="Thumbnail 3">
                                <img src="${produto.imagem5}" class="thumbnail" alt="Thumbnail 4">
                                <img src="${produto.imagem6}" class="thumbnail" alt="Thumbnail 5">
                            </div>
                        </div>
                        <p id="preco"> ${produto.descricao}</p>
                       <p class="valor">R$ ${produto.valor} </p>

                        <button type="submit" class="btn-comprar" idProduto="${produto.idProduto}" nome="${produto.nome}" valor="${produto.valor}" imagem="${produto.imagem}" quantidade="1" id="comprar">
                            <i class="fa-solid fa-cart-shopping" style="color: #ffffff;"></i> Comprar
                        </button>
                    </div>
                </c:forEach>
            </div>
        </main>

        <form id="form-comprar" action="carrinho" method="post" enctype="multipart/form-data" style="display: none;">
            <input type="hidden" name="idProduto" id="idProduto">
            <input type="hidden" name="descricao" id="descricao">
            <input type="hidden" name="nome" id="nome">
            <input type="hidden" name="valor" id="valor">
            <input type="hidden" name="imagem" id="imagem">
            <input type="hidden" name="quantidade" id="quantidade">

        </form>
    </body>
    <script src="./js/produtoUnico.js"></script>
    <script src="https://kit.fontawesome.com/ffe7fbbd06.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-cj/ywqPYmK8wLLIb84hxEXfKJ0WnLRE4AE3v5I4GA7A2GFSHbF5g9MuqUR2sOtv1" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/js/all.min.js" crossorigin="anonymous"></script>
    <script src="./js/carrinho.js"></script>    
</html>
