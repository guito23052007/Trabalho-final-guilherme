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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP8rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/b321e58993.js" crossorigin="anonymous"></script>
        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet"/>
        <!-- MDB -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.0/mdb.min.css" rel="stylesheet"/>
        <link rel="stylesheet" href="styles/footer.css"> 
        <link rel="stylesheet" href="styles/suporte.css"> 
        <script src="sweetalert2.min.js"></script>
        <link rel="stylesheet" href="sweetalert2.min.css"> 
        <title>Checkout</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <main class="main-content">
                <div class="container">
                    <div class="row">
                        <!-- Lista de produtos do carrinho -->
                        <div class="col-md-4 order-md-2 mb-4">
                            <ul class="list-group carrinho-list">
                                <c:forEach items="${carrinho}" var="item">
                                    <div id="${item.idProdutos}" class="produto">
                                        <img src="${item.imagemCarrinho}" alt="${item.nomeCarrinho}">
                                        <h2>${item.nomeCarrinho}</h2>
                                        <p class="preco">Preço: R$ ${item.precoCarrinho}</p>
                                    </div>
                                </c:forEach>
                                <!-- Exibir o total do carrinho -->
                                <c:forEach items="${totalPreco}" var="totalPreco">
                                    <div class="content">
                                        <h2 class="text">Preço Total:</h2>
                                        <p class="preco" id="preco">R$ ${totalPreco.total}</p>
                                    </div>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="col-md-8 order-md-1">
                            <form action="checkout" method="POST" enctype="multipart/form-data">
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
                        </div>
                    </div>
                </div>
            </main>
            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.0/mdb.umd.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        </body>
</html>
