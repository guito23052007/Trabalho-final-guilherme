<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Responsive Page</title>
        <link rel="stylesheet" href="./styles/tela1.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>

        <div class="banner">


            <video autoplay muted loop>
                <source src="assets/opa.mp4" type="video/mp4">

            </video>
            <nav class="menu">
                <a class="btn btn-primary" data-bs-toggle="offcanvas" href="#offcanvasExample" role="button" aria-controls="offcanvasExample">
                    <i class="fa-solid fa-bars" style="color: #ffffff;"></i>
                </a>


                <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
                    <div class="offcanvas-header">
                        <h5 class="offcanvas-title" id="offcanvasExampleLabel">BEM VINDO</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div>
                    <div class="offcanvas-body">

                        <div class="dropdown mt-3">
                            <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown">
                                menu      
                            </button>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="./login">Login</a></li>
                                <li><a class="dropdown-item" href="./cadastrar-usuario">Cadastrar</a></li>
                                <li><a class="dropdown-item" href="./home">Home</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </nav>

            <div class="content">
                <img src="assets/logo.png" alt="Logo">
                <h1>Venha fazer parte <br> da nossa hist�ria</h1>
                <div class="u"><a href="./home"><button>Descubra mais</button></a></div>
            </div>
        </div>
        <main>
            <div class="container">
        <div class="item">
            <img src="assets/nintendo.png" alt="">
          <a href="./buscar-produtos?cat=2&busca="><button>Descubra mais</button></a>
        </div>
        <div class="item">
            <img src="assets/minecraft.png" alt="">
            <a href="./buscar-produtos?cat=1&busca="><button>Descubra mais</button></a>
        </div>
        <div class="item">
            <img src="assets/assasine.png" alt="">
             <a href="./buscar-produtos?cat=3&busca="><button>Descubra mais</button></a>
        </div>
        <div class="item">
            <img src="assets/destaques.png" alt="">
             <a href="./buscar-produtos?cat=4&busca="><button>Descubra mais</button></a>
        </div>
    </div>
        </main>
        <script src="https://kit.fontawesome.com/ffe7fbbd06.js" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    </body>
</html>