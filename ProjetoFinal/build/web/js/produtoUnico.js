document.addEventListener('DOMContentLoaded', () => {
    const produtos = document.querySelectorAll('.produto');

    produtos.forEach(produto => {
        const mainImage = produto.querySelector('.main-image');
        const thumbnails = produto.querySelectorAll('.thumbnail');
        const videoFrame = produto.querySelector('.description iframe');

        thumbnails.forEach(thumbnail => {
            thumbnail.addEventListener('click', () => {
                mainImage.src = thumbnail.src;
            });
        });

        videoFrame.addEventListener('click', () => {
            mainImage.src = videoFrame.src;
        });
    });
});
