<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Histórico de Pedidos</title>
        <!-- Incluindo Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="styles/Admin.css">


    </head>
    <body>




        <div class="sidebar">
            <div class="sidebar-header">
                <h2>Adm</h2>
            </div>
            <ul class="sidebar-menu">
                <li><a href="./cadastrar-produto"><i class="fa-solid fa-image" style="color: #ffffff ;"></i>Cadastrar Produtos</a></li>
                <li><a href="./HistoricoPedidos"><i class="fa-solid fa-credit-card" style="color: #ffffff ;"></i></i>Financeiro</a></li>

                <li><a href="./HistoricoUser"><i class="fa-solid fa-envelope" style="color: #ffffff ;"></i>Gerenciar Usuários</a></li>
                <li><a href="./index.htm"><i class="fa-solid fa-circle-xmark" style="color: #ffffff;"></i></i>Sair</a></li>

        </div>
        <div class="container">
            <h1 class="mt-4">Histórico de Pedidos</h1>

            <table class="table table-bordered mt-4">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Produto</th>
                        <th>Valor</th>
                        <th>nome</th>

                        <th>forma_pagamento</th>

                        


                        <th>Data e Hora</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${pedidos}" var="pedido">
                        <tr>
                            <td>${pedido.id_pedido}</td>
                            <td>${pedido.nome_produto}</td>
                            <td>R$ ${pedido.valor_produto}</td>
                            <td>R$ ${pedido.nome_user}</td>
                            <td>R$ ${pedido.forma_pagamento}</td>
                            <td>${pedido.datahora}</td>
                        </tr>
                    </c:forEach>
                </tbody>
                    <c:forEach items="${total}" var="total">
                <div class=""contentetotla>
                    <h2 class="text">Preço Total:</h2>
                    <p class="preco">R$ ${total.total}</p>
                </div>
            </c:forEach>
            </table>

        


        </div>

        <!-- Incluindo Bootstrap JS, opcional dependendo do uso -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/js/all.min.js" crossorigin="anonymous"></script>

    </body>
</html>
