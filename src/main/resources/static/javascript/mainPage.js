function navigateToBlogPost() {
    window.location.href = '/';
}

document.addEventListener('DOMContentLoaded', function() {
    const searchInput = document.getElementById('searchInput');
    const searchForm = document.getElementById('searchForm');
    const searchImg = document.getElementById('searchImg');
    const defaultImage = { value: '/images/public_buttonSearch_img.svg' };
    const clickImage = { value: '/images/public_buttonSearch2_img.svg' };

    if (searchForm && searchInput && searchImg) {
        // input에 값을 입력하고 버튼을 누를 시 폼 액션이 발생하는 스크립트
        searchForm.addEventListener('submit', function(event) {
            event.preventDefault(); // 기본 동작 방지
            const query = searchInput.value.trim();
            if (query !== '') {
                console.log('검색어:', query);
                window.location.href = 'search?q=' + encodeURIComponent(query);
            }
        });

        // input에 값을 입력하고 엔터를 입력 시 값이 폼 액션이 발생하는 스크립트
        searchInput.addEventListener('keypress', function(event) {
            if (event.key === 'Enter') {
                const query = searchInput.value.trim();
                if (query !== '') {
                    console.log('검색어:', query);
                    window.location.href = 'search?q=' + encodeURIComponent(query);
                }
            }
        });

        // input의 트랜지션이 변경될 때 값을 비우는 스크립트
        searchInput.addEventListener('transitionend', function(event) {
            if (event.propertyName === 'width' && window.getComputedStyle(searchInput).width === '50px') {
                searchInput.value = '';
            }
        });

        // 페이지를 되돌아가거나 새로고침 시 기존 input의 값을 바꾸는 스크립트
        window.addEventListener('pageshow', function(event) {
            searchInput.value = '';
        });

        // 아이콘을 바꾸는 스크립트
        searchInput.addEventListener('transitionend', function(event) {
            if (event.propertyName === 'width' && window.getComputedStyle(searchInput).width === '50px') {
                searchImg.src = defaultImage.value;
            } else {
                searchImg.src = clickImage.value;
            }
        });
    }
});