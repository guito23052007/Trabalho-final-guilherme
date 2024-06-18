document.addEventListener('DOMContentLoaded', function() {
    var produtoRow = document.getElementById('produtoRow');
    var produtoContainer = document.getElementById('produtoContainer');
    var cardGroups = document.querySelectorAll('.card-group');
    
    // Calcula o número de produtos e cria grupos de cartões
    var numProdutos = produtoRow.children.length;
    var numCartoes = Math.ceil(numProdutos / 5);
    
    // Adiciona classes de agrupamento de cartões
    for (var i = 0; i < cardGroups.length; i++) {
        cardGroups[i].classList.add('card-group-' + i);
    }

    // Verifica se há mais de 5 produtos para exibir setas de navegação
    if (numProdutos >= 5) {
        // Adiciona seta de navegação para a direita
        produtoContainer.insertAdjacentHTML('beforeend', '<button class="scroll-btn next">&rarr;</button>');
        // Adiciona seta de navegação para a esquerda
        produtoContainer.insertAdjacentHTML('afterbegin', '<button class="scroll-btn prev">&larr;</button>');

        var scrollBtns = document.querySelectorAll('.scroll-btn');
        
        scrollBtns.forEach(function(btn) {
            btn.addEventListener('click', function() {
                produtoContainer.scrollBy({
                    left: this.classList.contains('next') ? 400 : -400, // Ajuste conforme necessário
                    behavior: 'smooth'
                });
            });
        });
    }
});
