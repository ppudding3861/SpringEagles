document.addEventListener("DOMContentLoaded", function() {
    var likeButton = document.getElementById("likeButton");
    var likeCountElement = document.getElementById("likeCount");

    if (likeButton && likeCountElement) {
        likeButton.addEventListener("click", function() {
            var blogId = likeButton.getAttribute("data-id");

            if (!blogId) {
                console.error("Blog ID is missing.");
                return;
            }

            fetch("/khs/blog/" + blogId + "/like", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                }
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error("Failed to like the blog.");
                    }
                    console.log("Blog liked successfully.");
                    var currentLikeCount = parseInt(likeCountElement.textContent);
                    likeCountElement.textContent = currentLikeCount + 1;
                })
                .catch(error => {
                    console.error("Failed to like the blog.", error);
                });
        });
    } else {
        console.error("Like button or like count element not found.");
    }
});


// 코멘트 작성

document.addEventListener("DOMContentLoaded", function () {
    const commentForms = document.querySelectorAll(".comment-form form");

    commentForms.forEach(form => {
        form.addEventListener("submit", function (event) {
            event.preventDefault();

            const postId = this.getAttribute("data-post-id");
            const contents = this.querySelector('textarea[name="contents"]').value;

            axios.post(`/khs/blog/postreader/${postId}/comment`, { contents })
                .then(response => {
                    const commentSection = this.closest('.read-container').querySelector('.comment-list');
                    const newComment = document.createElement('div');
                    newComment.classList.add('comment');
                    newComment.innerHTML = `<p>${response.data.contents}</p>`;
                    commentSection.appendChild(newComment);
                    this.querySelector('textarea[name="contents"]').value = '';
                })
                .catch(error => {
                    console.error('There was an error!', error);
                });
        });
    });
});