<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Histórico de Usuários</title>
</head>
<body>
    <h1>Histórico de Usuários</h1>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Usuário</th>
                <th>Nome</th>
                <th>CPF</th>
                <th>Telefone</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${usuarios}" var="usuario">
                <tr>
                    <td>${usuario.id_usuario}</td>
                    <td>${usuario.usuario}</td>
                    <td>${usuario.nome}</td>
                    <td>${usuario.cpf}</td>
                    <td>${usuario.telefone}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
