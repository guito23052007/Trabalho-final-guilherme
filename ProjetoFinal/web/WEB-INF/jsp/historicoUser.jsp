<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Histórico de Usuários</title>
    <!-- Adicione o link para o Bootstrap CSS -->

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
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

            </ul>
        </div>

   <div class="container">
            <h1>Lista de Usuários</h1>

            <table class="table table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Usuário</th>
                        <th>cpf</th>
                        <th>Numero</th>


                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${usuarios}" var="usuario">
                        <tr>
                            <td>${usuario.id_usuario}</td>
                            <td>${usuario.nome}</td>

                            <td>${usuario.usuario}</td>

                            <td>${usuario.cpf}</td>
                            <td>${usuario.telefone}</td>


                            <td>
                                <form action="deletar-usuario" method="post" onsubmit="return confirm('Tem certeza que deseja deletar este usuário?');">
                                    <input type="hidden" name="id" value="${usuario.id_usuario}" />
                                    <button type="submit" class="btn btn-danger">Deletar</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>


    <!-- Adicione o link para o jQuery e Bootstrap JS no final do body -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js" integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl7+wpNuEH6d3Ao+1gfiB/x+2L4yMhIbxZ5Y+td/eB" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
