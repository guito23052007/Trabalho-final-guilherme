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
                <div class="col-md-4 order-md-2 mb-4">
                    <ul class="list-group carrinho-list">
                      <c:forEach items="${carrinho}" var="carrinho">
                <div id="${carrinho.idProdutos}" class="produto">
                    <img src="${carrinho.imagemCarrinho}" alt="${nomeCarrinho}">
                    <h2>${carrinho.nomeCarrinho}</h2>
                    <p id="p1" class="preco">Preço : R$ ${carrinho.precoCarrinho}</p>
                    
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
                <div class="col-md-8 order-md-1">
                    <form id="form-checkout" action="enviarFor" method="post" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="firstName">Nome</label>
                                <input required type="text" class="form-control" id="firstName" name="nome" placeholder="">
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="lastName">Sobrenome</label>
                                <input required type="text" class="form-control" id="lastName" name="sobrenome" placeholder="">
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="username">Email</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">@</span>
                                </div>
                                <input type="email" class="form-control" id="email" name="email" placeholder="Email" required>
                            </div>
                        </div>
                        <div class="d-block my-3">
                            <div class="custom-control custom-radio">
                                <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked required>
                                <label class="custom-control-label" for="credit">Cartão de Crédito</label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input id="debit" name="paymentMethod" type="radio" class="custom-control-input" required>
                                <label class="custom-control-label" for="debit">Cartão de Débito</label>
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
                                <input type="text" class="form-control" id="cc-cvv" placeholder="" maxlength="3" title="Por favor, apenas números" required pattern="[0-9]{3,4}">
                            </div>
                        </div>
                        <button class="btn btn-primary btn-lg btn-block" id="btn_finalizar" type="submit" style="background-color: blue">Finalizar Compra</button>
                    </form>
                </div>
            </div>
        </div>
    </main>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.0/mdb.umd.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
</html>
