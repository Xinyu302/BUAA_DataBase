function upload() {
    // alert("fuck upload");
    // if ($("#photoFile").val() == '') {
    //     return;
    // }
    var form = document.getElementById('fileForm'),
        formData = new FormData(form);
    // var formData = new FormData();
    // formData.append('photo', document.getElementById('photoFile').files[0]);
    $.ajax({
        url:"http://localhost:8086/releaseproduct",
        type:"post",
        data: formData,
        contentType: false,
        processData: false,
        success: function(data) {
            if (data.code == 200) {
                window.location.href="/product-details";
            } else {
                alert(data.msg);
            }
        },
        error:function(data) {
            alert("上传失败");
        }
    });
    // alert("fuck u323pload");
    return false;
}