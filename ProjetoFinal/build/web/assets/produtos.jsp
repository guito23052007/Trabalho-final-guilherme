<%-- 
    Document   : produtos
    Created on : 04/05/2024, 10:24:15
    Author     : aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="./styles/index.css">
            

        <title>Produtos</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <main>
             <c:forEach var="produtos" items="${produtos}">
                 <div class="card" style ="width: 18rem"
                      
                    
                        <div class="card-body">
                        <img src="data:image/jpg;base64,${produto.imagemBase64}">
                            <h5 class="card-title">${produtos.nome}</h5>
                            <p class="card-text categoria-text">Categoria: ${produtos.categoria}</p>
                            <p class="card-text">Valor: R$ ${produtos.valor}</p>
                            <p class="card-text">Descrição: ${produtos.descricao}</p>
                            <a href="./ProdutoUnico?id=${produtos.idProduto}" class="btn btn-primary">Comprar</a>

 
                        </div>
                    </div>
                
            </c:forEach>
        </main>
    </body>
</html>
