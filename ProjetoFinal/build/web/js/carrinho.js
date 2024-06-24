document.querySelectorAll('.btn-comprar').forEach(btn => {
    btn.addEventListener('click', function() {
        var idProduto = this.getAttribute('idProduto');
        var imagem = this.getAttribute('imagem');
        var nome = this.getAttribute('nome');
        var valor = this.getAttribute('valor');
        var descricao = this.getAttribute('descricao');
        var quantidade = this.getAttribute('quantidade');
        
        // Obter o ID do usuário do cookie 

        // Crie um novo objeto FormData
        var formData = new FormData();

        // Adicione os dados do produto e do usuário ao FormData
        formData.append('idProdutos', idProduto);
        formData.append('nome_carrinho', nome);
        formData.append('preco_carrinho', valor);
        formData.append('descricao_carrinho', descricao);
        formData.append('quantidade_carrinho', quantidade);
        formData.append('imagem_carrinho', imagem);

        // Se tiver o ID do usuário, adicione ao FormData

        // Envie o FormData
        fetch('carrinho', {
            method: 'POST',
            body: formData
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Ocorreu um erro ao enviar o formulário.');
            }
            return response.text();
        })
        .then(data => {
            alert('Compra feita com sucesso.');
            window.location.href = './home';
        })
        .catch(error => {
            console.error('Erro:', error);
        });
    });
});

// Função auxiliar para obter o valor de um cookie pelo nome
function getCookieValue(cookieName) {
    var name = cookieName + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var cookieArray = decodedCookie.split(';');
    for(var i = 0; i < cookieArray.length; i++) {
        var cookie = cookieArray[i];
        while (cookie.charAt(0) == ' ') {
            cookie = cookie.substring(1);
        }
        if (cookie.indexOf(name) == 0) {
            return cookie.substring(name.length, cookie.length);
        }
    }
    return "";
}
