function upload() {
    if ($("#photoFile").val() == '') {
        return;
    }
    var form = document.getElementById('fileForm'),
        formData = new FormData(form);

    // var formData = new FormData();
    // formData.append('photo', document.getElementById('photoFile').files[0]);
    $.ajax({
        url:"localhost:8086/uploadPhoto",
        type:"post",
        data: formData,
        contentType: false,
        processData: false,
        success: function(data) {
            if (data.code == 200) {
                $("#preview_photo").attr("src", data.filepath+data.filename);
                $("#productImg").val(data.filename);
            } else {
                alert(data.msg);
            }
        },
        error:function(data) {
            alert("上传失败")
        }
    });
}