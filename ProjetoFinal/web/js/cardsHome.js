document.addEventListener('DOMContentLoaded', function () {
    const scrollContainer = document.getElementById('carousel');
    const scrollLeftButton = document.getElementById('scrollLeft');
    const scrollRightButton = document.getElementById('scrollRight');

    scrollLeftButton.addEventListener('click', function () {
        scrollContainer.scrollBy({ left: -300, behavior: 'smooth' });
    });

    scrollRightButton.addEventListener('click', function () {
        scrollContainer.scrollBy({ left: 300, behavior: 'smooth' });
    });
});
