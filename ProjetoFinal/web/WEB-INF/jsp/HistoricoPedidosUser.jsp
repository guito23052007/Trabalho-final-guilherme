<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Histórico de Pedidos do Usuário</title>
</head>
<body>
    <h1>Histórico de Pedidos do Usuário</h1>

    <table border="1">
        <thead>
            <tr>
                <th>ID do Pedido</th>
                <th>Produto</th>
                <th>Valor</th>
                <th>Data e Hora</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${pedidos}" var="pedido">
                <tr>
                    <td>${pedido.id_pedido}</td>
                    <td>${pedido.nome_produto}</td>
                    <td>R$ ${pedido.valor_produto}</td>
                    <td>${pedido.datahora}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
