document.getElementById('scrollLeft').addEventListener('click', function() {
    document.getElementById('carousel').scrollBy({
        left: -220, // Ajuste o valor de acordo com a largura dos cartões e o espaço entre eles
        behavior: 'smooth'
    });
});

document.getElementById('scrollRight').addEventListener('click', function() {
    document.getElementById('carousel').scrollBy({
        left: 720, // Ajuste o valor de acordo com a largura dos cartões e o espaço entre eles
        behavior: 'smooth'
    });
});
