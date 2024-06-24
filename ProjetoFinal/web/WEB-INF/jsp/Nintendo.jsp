<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nintendos</title>
</head>
<body>
    <div class="nintendo">
        <h2>Produtos Nintendo</h2>
        <div class="horizontal-scroll-container" id="carousel">
            <c:forEach var="produto" items="${nintendo}">
                <div class="card card-custom">
                    <div class="card-body">
                        <div class="imagemProduto">
                            <img src="${produto.imagem}" alt="${produto.nome}">
                        </div>
                        <h5 class="card-title">${produto.nome}</h5>
                        <p class="card-text">Valor: R$ ${produto.valor}</p>
                        <a href="./ProdutoUnico?id=${produto.idProduto}" class="btn btn-primary">Comprar</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
