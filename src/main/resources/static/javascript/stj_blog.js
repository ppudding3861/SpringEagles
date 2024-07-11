// 로고 이미지 클릭시 새로고침하는 함수
function navigateToBlogPost() {
    saveScrollPosition();
    window.location.href = '/stj/blog/posts';
}

// 나가기 버튼 확인 함수
function confirmExit() {
    return confirm('변경 사항이 저장되지 않을 수 있습니다. 그래도 나가시겠습니까?');
}

// 페이지 로드 시 실행할 함수들
document.addEventListener('DOMContentLoaded', function () {

    // 네비게이션 버튼 클릭 이벤트 설정
    const postListButton = document.getElementById('postListButton');
    const introduceButton = document.getElementById('introduceButton');
    const postList = document.getElementById('postList');
    const introduce = document.getElementById('introduce');

    function handleNavButtonClick(activeButton, inactiveButton, activeSection, inactiveSection) {
        activeSection.classList.add('active');
        inactiveSection.classList.remove('active');
        activeButton.classList.add('active');
        inactiveButton.classList.remove('active');
    }

    postList.classList.add('active');
    postListButton.classList.add('active');

    postListButton.addEventListener('click', function () {
        handleNavButtonClick(postListButton, introduceButton, postList, introduce);
    });

    introduceButton.addEventListener('click', function () {
        handleNavButtonClick(introduceButton, postListButton, introduce, postList);
    });

    // 소개글 수정 버튼 클릭 이벤트 설정
    const introduceContent = document.getElementById('introduceContent');
    const introduceTextarea = document.getElementById('introduceTextarea');
    const modifyButton = document.getElementById('modifyButton');

    modifyButton.addEventListener('click', function () {
        if (modifyButton.innerText === '수정') {
            introduceTextarea.value = introduceContent.innerText.trim();
            introduceTextarea.style.display = 'block';
            introduceContent.style.display = 'none';
            modifyButton.innerText = '완료';
        } else if (modifyButton.innerText === '완료') {
            const introContent = introduceTextarea.value.trim();
            fetch('/stj/blog/updateIntro', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({introContent: introContent})
            })
                .then(response => {
                    if (response.ok) {
                        return response.json(); // JSON 응답으로 변경
                    }
                    throw new Error('게시물 작성 중 오류가 발생했습니다.');
                })
                .then(data => {
                    if (data.message) {
                        alert(data.message); // 성공 메시지 표시
                    }
                    introduceContent.innerText = introContent; // 화면에 수정된 내용 표시
                    introduceContent.style.display = 'block';
                    introduceTextarea.style.display = 'none';
                    modifyButton.innerText = '수정';
                })
                .catch(error => {
                    alert(error.message); // 오류 발생 시 메시지 표시
                });
        }
    });
});

// 삭제 확인 함수
function confirmDelete() {
    return confirm("삭제하시겠습니까?");
}

// 댓글 수정 폼 보이기 함수
function showEditForm(button) {
    const commentUpper = button.closest('.comment-upper');
    const commentBottom = commentUpper.nextElementSibling;

    // 숨겨진 폼 보이기
    commentBottom.style.display = 'block';

    // 기존의 수정 폼들 숨기기
    const allCommentBottoms = document.querySelectorAll('.comment-bottom');
    allCommentBottoms.forEach(function (elem) {
        if (elem !== commentBottom) {
            elem.style.display = 'none';
        }
    });
}

// 좋아요 관련 로직
document.addEventListener("DOMContentLoaded", function () {
    const likeButton = document.querySelector("#like-button");

    likeButton.addEventListener("click", function () {
        const postId = likeButton.getAttribute("data-post-id");

        fetch("/stj/blog/toggleLike", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: new URLSearchParams({postId: postId})
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                console.log(data); // 응답 객체를 콘솔에 출력하여 디버깅
                if (data.status === "success") {
                    // 서버 응답에 따라 버튼의 상태와 UI를 업데이트
                    if (data.newState === "liked") {
                        likeButton.textContent = "좋아요 취소";
                        likeButton.classList.add("liked");
                    } else {
                        likeButton.textContent = "좋아요";
                        likeButton.classList.remove("liked");
                    }
                } else {
                    alert("An error occurred: " + data.message);
                }
            })
            .catch(error => {
                console.error("Error:", error);
                alert("An error occurred: " + error.message);
            });
    });
});

document.addEventListener("DOMContentLoaded", function () {
    // 에러 메시지가 있으면 경고창을 띄웁니다.
    const errorMessage = document.getElementById("errorMessage").value;
    if (errorMessage) {
        console.log(errorMessage);
        alert(errorMessage);
    }
});