<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Old Generation Games</title>
        <link rel="icon" href="assets/logomaior.png">
        <script src="https://kit.fontawesome.com/560340c572.js" crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

        <jsp:include page="header.jsp"></jsp:include>
            <link rel="stylesheet" href="./styles/carrinho.css">

        </head>

        <body>

        <main>
            <h1>Carrinho</h1>
            <div class="container">
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
        </div>
        <div class="pagamento">
            <a href="./checkout" class="botao-comprar">Comprar</a></div>
    </main>


</body>

</html>