
// 로고 이미지 클릭시 새로고침하는 함수
function HJHBlogPost() {
    window.location.href = '/hjh/blog/posts';
}

// 좋아요 관련 로직
document.addEventListener("DOMContentLoaded", function() {
    const likeButton = document.querySelector("#like-button");

    likeButton.addEventListener("click", function() {
        const postId = likeButton.getAttribute("data-post-id");

        fetch("/hjh/blog/toggleLike", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: new URLSearchParams({ postId: postId })
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

document.addEventListener("DOMContentLoaded", function() {
    // 에러 메시지가 있으면 경고창을 띄웁니다.
    const errorMessage = document.getElementById("errorMessage").value;
    if (errorMessage) {
        console.log(errorMessage);
        alert(errorMessage);
    }
});