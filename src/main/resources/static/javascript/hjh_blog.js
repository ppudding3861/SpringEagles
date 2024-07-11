

// 스크롤 위치 저장 함수
function saveScrollPosition() {
    localStorage.setItem('scrollPosition', window.scrollY);
}

// 스크롤 위치 복원 함수
function restoreScrollPosition() {
    const savedScrollPosition = localStorage.getItem('scrollPosition');
    if (savedScrollPosition !== null) {
        window.scrollTo(0, parseInt(savedScrollPosition));
        localStorage.removeItem('scrollPosition');
    }
}

// 좋아요 관련 로직

document.addEventListener('DOMContentLoaded', function() {
    const likeButton = document.getElementById('like-button');
    const unlikeButton = document.getElementById('unlike-button');

    function handleResponse(response) {
        if (response.ok) {
            return response.json(); // JSON 형식으로 변환
        } else {
            throw new Error('Network response was not ok.');
        }
    }

    function handleData(data) {
        if (data.status === 'success') {
            window.location.href = data.redirectUrl; // 리다이렉트 수행
        } else {
            throw new Error(data.message);
        }
    }

    function handleError(error) {
        console.error('Error:', error);
    }

    if (likeButton) {
        likeButton.addEventListener('click', function(event) {
            event.preventDefault();
            saveScrollPosition();
            const postId = this.getAttribute('data-post-id');
            fetch('/hjh/blog/likes', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: new URLSearchParams({ postId: postId })
            })
                .then(handleResponse)
                .then(handleData)
                .catch(handleError);
        });
    }

    if (unlikeButton) {
        unlikeButton.addEventListener('click', function(event) {
            event.preventDefault();
            saveScrollPosition();
            const postId = this.getAttribute('data-post-id');
            fetch('/hjh/blog/unlikes', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: new URLSearchParams({ postId: postId })
            })
                .then(handleResponse)
                .then(handleData)
                .catch(handleError);
        });
    }
});

document.addEventListener("DOMContentLoaded", function() {
    // 에러 메시지가 있으면 경고창을 띄웁니다.
    const errorMessage = document.getElementById("errorMessage").value;
    if (errorMessage) {
        console.log(errorMessage);
        alert(errorMessage);
    }
});