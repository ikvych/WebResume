var inpFile = document.getElementById("inpFile");
var previewContainer = document.getElementById("imagePreview");
var previewImage = previewContainer.querySelector(".image-preview__image");
var originCoverPhoto = document.getElementById("originPhoto");

inpFile.addEventListener("change", function () {
    console.log("Event");
    var originPhoto = originCoverPhoto.getAttribute("value");

    var file = this.files[0];

    if (file) {
        console.log("if");
        var reader = new FileReader();
        previewImage.style.display = "block";
        reader.addEventListener("load", function () {
            console.log(this.result);
            previewImage.setAttribute("src", this.result);
        });

        reader.readAsDataURL(file);
    } else {
        previewImage.style.display = null;
        previewImage.setAttribute("src", originPhoto);
    }
});
