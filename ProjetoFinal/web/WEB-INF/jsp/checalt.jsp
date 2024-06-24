<%-- 
    Document   : suporte
    Created on : 03/06/2024, 17:02:42
    Author     : Senai
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/b321e58993.js" crossorigin="anonymous"></script>


        <title>JSP Page</title>
        <link rel="stylesheet" href="styles/checkout.css">

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

            <main class="main-content">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4 order-md-2 mb-4">

                            <ul class="list-group carrinho-list">
                            <c:forEach items="${carrinho}" var="item">
                                <div id="${item.idProdutos}" class="produto">
                                    <img src="${item.imagemCarrinho}" alt="${item.nomeCarrinho}">
                                    <h2>${item.nomeCarrinho}</h2>
                                    <p class="preco">Preço: R$ ${item.precoCarrinho}</p>
                                </div>
                            </c:forEach>
                            
                            <c:forEach items="${totalPreco}" var="totalPreco">
                                <div class="content">
                                    <h2 class="text">Preço Total:</h2>
                                    <p class="preco" id="preco">R$ ${totalPreco.total}</p>
                                </div>
                            </c:forEach>
                        </ul>
                    </div>
                    </ul>


                </div>
                <div class="col-md-8 order-md-1">


                    <form action="checkouto" method="POST">
                        <div class="form-group">
                            <label for="nome_sobrenome">Nome e Sobrenome:</label>
                            <input type="text" class="form-control" id="nome_sobrenome" name="nome_sobrenome" required>
                        </div>
                        <div class="form-group">
                            <label for="tipo_pagamento">Tipo de Pagamento:</label>
                            <input type="text" class="form-control" id="tipo_pagamento" name="tipo_pagamento" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Cadastrar</button>
                    </form>

                    <div class="mb-3">
                        <label for="username">Email</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text">@</span>
                            </div>
                            <input type="email" class="form-control" id="email" name="email" placeholder="Email" required>

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5 mb-3">

                            <div class="d-block my-3">
                                <div class="custom-control custom-radio">
                                    <input id="credito" name="paymentMethod" type="radio" class="custom-control-input" checked required>
                                    <label class="custom-control-label" for="credito">Cartao de Credito</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input id="debito" name="paymentMethod" type="radio" class="custom-control-input" required>
                                    <label class="custom-control-label" for="debito">Cartao de Debito </label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input id="paypal" name="paymentMethod" type="radio" class="custom-control-input" required>
                                    <label class="custom-control-label" for="paypal">PayPal</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="cc-name">Nome do Cartão</label>
                                    <input type="text" class="form-control" id="cc-name" placeholder="" pattern="[A-Za-z]+" title="Por favor, insira apenas letras" required>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label for="cc-number">Número do Cartão</label>
                                    <input type="text" class="form-control" id="cc-number" placeholder="" minlength="16" maxlength="16" required>


                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3 mb-3">
                                    <label for="cc-expiration">Expiração (MM/AA)</label>
                                    <input type="text" class="form-control" id="cc-expiration" placeholder="MM/AA" maxlength="5" required pattern="^(0[1-9]|1[0-2])\/(2[4-9]|[3-9][0-9])$">
                                </div>
                                <div class="col-md-3 mb-3">
                                    <label for="cc-cvv">CVV</label>
                                    <input type="text" class="form-control" id="cc-cvv" placeholder="" maxlength="3" title="Por favor, apenas numeros" required pattern="[0-9]{3,4}">
                                </div>
                            </div>




                            <script>
                            </script>

                        </div>
                    </div>

                </div>



        </main>


        <!-- MDB -->

        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.0/mdb.umd.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    </body>
</html>
