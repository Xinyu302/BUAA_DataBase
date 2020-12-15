function upload() {
    // if ($("#photoFile").val() == '') {
    //     return;
    // }
    var form = document.getElementById('fileForm'),
        formData = new FormData(form);
    var urlPath = window.document.location.href;
    var docPath = window.document.location.pathname;
    var index = urlPath.indexOf(docPath);
    var serverPath = urlPath.substring(0, index);
    // var formData = new FormData();
    // formData.append('photo', document.getElementById('photoFile').files[0]);
    $.ajax({
        url:serverPath+"/releaseproduct",
        type:"post",
        data: formData,
        contentType: false,
        processData: false,
        success: function(res) {
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
    return false;
}