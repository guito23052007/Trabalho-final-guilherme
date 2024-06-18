<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="./styles/login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-ZH3X48NqYidliS2L5vIC+n6LlyTo/y+0VFrJKeFmzp18uZKu6dKaAtbqhQkSFL+Zoqlu8iKfQhtYgVfG8s7YJw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Login</title>
</head>
<body>
    <h1> Venha ja fazer o seu Login</h1>
    <div class="logo"><img src="assets/logo.png" alt=""></div>
    <form action="logar" id="formulario" method="post">
        <div class="mb-3">
            <h2>Logar</h2>
            <label for="usuario" class="form-label">Usuario:</label>
            <input type="text" class="form-control" id="usuario" name="usuario" value="${abacate != null ? abacate : ''}" required>
        </div>
        <div class="mb-3">
            <label for="senha" class="form-label">Senha:</label>
            <input type="password" class="form-control" id="senha" name="senha" required>
        </div>
        <button type="submit" class="btn btn-primary btn-custom">Entrar</button>
        <a href="./Login"><h4>Ja possui seu login? clique aqui</h4></a>
    </form>
    <div class="fundo"><img src="assets/Game.png" alt=""></div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="./js/login.js"></script>
</html>
