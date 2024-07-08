// 로고 이미지 클릭시 새로고침하는 스크립트
function navigateToBlogPost() {
    window.location.href = '/hjh/blog/posts';
}

// 나가기 버튼 관련 스크립트
function confirmExit() {
    return confirm('변경 사항이 저장되지 않을 수 있습니다. 그래도 나가시겠습니까?');
}

// 네비버튼을 누르면 보이는 페이지를 조정하는 스크립트
document.addEventListener('DOMContentLoaded', function() {
    const introduceButton = document.getElementById('introduceButton');
    const introduce = document.getElementById('introduce');

    introduceButton.addEventListener('click', function() {
        introduce.classList.add('active');
        postList.classList.remove('active');
        introduceButton.classList.add('active');
        postListButton.classList.remove('active');
    });
});

document.addEventListener("DOMContentLoaded", function() {
    // 에러 메시지가 있으면 경고창을 띄웁니다.
    const errorMessage = document.getElementById("errorMessage").value;
    if (errorMessage) {
        alert(errorMessage);
    }
});
