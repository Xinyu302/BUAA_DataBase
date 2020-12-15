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
        success: function(res) {
            alert("fuck");
            if (res.code == 200) {
                alert(res.data);
                window.location.href="/product-details/" + res.data;
            } else {
                alert(res.msg);
            }
        },
        error:function(data) {
            alert("上传失败");
        }
    });
    // alert("fuck u323pload");
    return false;
}