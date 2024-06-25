// 로고 이미지 클릭시 새로고침하는 스크립트
function navigateToBlogPost() {
    window.location.href = '/blogPost1';
}

// 나가기 버튼 관련 스크립트
function confirmExit() {
    return confirm('변경 사항이 저장되지 않을 수 있습니다. 그래도 나가시겠습니까?');
}

// 네비버튼을 누르면 보이는 페이지를 조정하는 스크립트
document.addEventListener('DOMContentLoaded', function() {
    const postListButton = document.getElementById('postListButton');
    const introduceButton = document.getElementById('introduceButton');
    const postList = document.getElementById('postList');
    const introduce = document.getElementById('introduce');

    postList.classList.add('active');
    postListButton.classList.add('active');

    postListButton.addEventListener('click', function() {
        postList.classList.add('active');
        introduce.classList.remove('active');
        postListButton.classList.add('active');
        introduceButton.classList.remove('active');
    });

    introduceButton.addEventListener('click', function() {
        introduce.classList.add('active');
        postList.classList.remove('active');
        introduceButton.classList.add('active');
        postListButton.classList.remove('active');
    });
});

// 소개 페이지 수정관련 스크립트
document.addEventListener('DOMContentLoaded', function() {
    const modifyButton = document.getElementById('modifyButton');
    const introduceContent = document.getElementById('introduceContent');
    const introduceTextarea = document.getElementById('introduceTextarea');

    modifyButton.addEventListener('click', function() {
        if (modifyButton.innerText === '수정') {
            introduceTextarea.value = introduceContent.innerText.trim();
            introduceTextarea.style.display = 'block';
            introduceContent.style.display = 'none';
            modifyButton.innerText = '완료';
        } else if (modifyButton.innerText === '완료') {
            introduceContent.innerText = introduceTextarea.value.trim();
            introduceContent.style.display = 'block';
            introduceTextarea.style.display = 'none';
            modifyButton.innerText = '수정';
            alert('저장되었습니다.');
        }
    });
});