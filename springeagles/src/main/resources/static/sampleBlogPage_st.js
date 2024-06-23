const searchInput = document.getElementById('searchInput');
const searchForm = document.getElementById('searchForm');
const searchImg = document.getElementById('searchImg');
const defaultImage = {value : '/images/search.svg'};
const clickImage = {value : '/images/search-go.svg'};

// 로고 이미지 클릭시 새로고침하는 스크립트
function navigateToBlogPost() {
    window.location.href = '/blogPost1';
}

// 나가기 버튼 관련 스크립트
function confirmExit() {
    return confirm('변경 사항이 저장되지 않을 수 있습니다. 그래도 나가시겠습니까?');
}

// 버튼 관련 스크립트
document.addEventListener('DOMContentLoaded', function() {

    // input에 값을 입력하고 버튼을 누를시 폼 액션이 발생하는 스크립트
    searchForm.addEventListener('submit', function(event) {
        event.preventDefault(); // 기본 동작 방지
        const query = searchInput.value.trim();
        if (query !== '') {
            console.log('검색어:', query);
            window.location.href = 'search?q=' + encodeURIComponent(query);
        }
    });

    // input에 값을 입력하고 엔터를 입력시 값이 폼 액션이 발생하는 스크립트
    searchInput.addEventListener('keypress', function(event) {
        if (event.key === 'Enter') {
            const query = searchInput.value.trim();
            if (query !== '') {
                console.log('검색어:', query);
                window.location.href = 'search' + encodeURIComponent(query);
            }
        }
    });

    // input의 트랜지션이 변경될때 값을 비우는 스크립트
    searchInput.addEventListener('transitionend', function(event) {
        if (event.propertyName === 'width' && window.getComputedStyle(searchInput).width === '50px') {
            searchInput.value = '';
        }
    });

    // 페이지를 되돌아 가거나 새로고침시 기존 input의 값을 바꾸는 스크립트
    window.addEventListener('pageshow', function(event) {
        const inputField = document.getElementById('searchInput');
        inputField.value = '';
    });

    // 아이콘을 바꾸는 스크립트
    searchInput.addEventListener('transitionend', function(event) {
        if (event.propertyName === 'width' && window.getComputedStyle(searchInput).width === '50px') {
            searchImg.src = defaultImage.value;
        } else {
            searchImg.src = clickImage.value;
        }
    });
});
