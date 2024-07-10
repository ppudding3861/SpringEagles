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
