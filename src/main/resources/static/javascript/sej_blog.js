document.addEventListener("DOMContentLoaded", function () {
    // 전체 문서에서 like-button 클래스의 요소에 클릭 이벤트를 설정합니다.
    document.body.addEventListener("click", function (event) {
        if (event.target.classList.contains("like-button")) {
            var postId = event.target.getAttribute("data-id");
            var likeCountElement = document.getElementById("likeCount-" + postId);

            axios.post(`/sej/blog/posts/detail/${postId}/like`)
                .then(response => {
                    const likeCount = response.data.likes;
                    console.log(likeCount);
                    console.log(response.data.likes);
                    if (likeCount !== undefined) {

                        likeCountElement.textContent = likeCount;


                    } else {
                        console.log(likeCountElement) // 디버깅


                        console.error("좋아요 데이터 요청 응답 실패", response.data);
                        alert("좋아요 수를 업데이트하는 데 실패했습니다.");
                    }
                })
                .catch(error => {
                    console.error("좋아요 실패", error);
                });
        }
    });
});

