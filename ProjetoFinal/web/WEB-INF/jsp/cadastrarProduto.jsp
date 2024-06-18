<%-- 
    Document   : cadastrarProduto
    Created on : 01/05/2024, 10:49:52
    Author     : Iago
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Produto</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>Cadastro de Produto</h2>
        <form action="cadastrarProduto" method="POST" enctype="multipart/form-data">
            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" class="form-control" id="nome" name="nome" required>
            </div>
            <div class="form-group">
                <label for="categoria">Categoria:</label>
                <select class="form-control" id="categoria" name="categoria">
                    <option value="1">Xbox</option>
                    <option value="2">nintendo</option>
                    <option value="3">Play Station</option>
                    <option value="4">Rpg</option>
                    <option value="5">Outros</option>
                </select>
            </div>
            <div class="form-group">
                <label for="valor">Valor:</label>
                <input type="number" step="0.01" class="form-control" id="valor" name="valor" required>
            </div>
            <div class="form-group">
                <label for="descricao">Descrição:</label>
                <textarea class="form-control" id="descricao" name="descricao" rows="3"></textarea>
            </div>
             <div class="form-group">
                <label for="link">Link:</label>
                <textarea class="form-control" id="link" name="link" rows="3"></textarea>
            </div>
            <div class="form-group">
                <label for="imagem">Imagem home:</label>
                <input type="file" class="form-control-file" id="imagem" name="imagem">
            </div>
            
            <div class="form-group">
                <label for="imagem2">Imagem do Produto unico 1:</label>
                <input type="file" class="form-control-file" id="imagem2" name="imagem2">
            </div>
            <div class="form-group">
                <label for="imagem3">Imagem do Produto unico 2:</label>
                <input type="file" class="form-control-file" id="imagem3" name="imagem3">
            </div>
            <div class="form-group">
                <label for="imagem4">Imagem do Produto unico 3:</label>
                <input type="file" class="form-control-file" id="imagem4" name="imagem4">
            </div>
           <div class="form-group">
                <label for="imagem5">Imagem do Produto unico4 :</label>
                <input type="file" class="form-control-file" id="imagem5" name="imagem5">
            </div>
            <div class="form-group">
                <label for="imagem6">Imagem do Produto unico 5 :</label>
                <input type="file" class="form-control-file" id="imagem6" name="imagem6">
            </div>
            <div class="form-group">
                <label for="imagem7">Imagem do Produto unico logo:</label>
                <input type="file" class="form-control-file" id="imagem7" name="imagem7">
            </div>
            <div class="form-group">
                <label for="imagem8">Imagem do fundo produto unico:</label>
                <input type="file" class="form-control-file" id="imagem8" name="imagem8">
            </div>
            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

