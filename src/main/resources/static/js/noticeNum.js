function noticeNum(){
    var userId = document.getElementById("userId").value;
        if (userId == null) return;
        var urlPath = window.document.location.href;
        var docPath = window.document.location.pathname;
        var index = urlPath.indexOf(docPath);
        var serverPath = urlPath.substring(0, index);
        var formData = new FormData();
        formData.append("userid", Number(userId));
        $.ajax({
            url: serverPath + "/get-notice-num",
            type: "post",
            data: formData,
            contentType: false,
            processData: false,
            success: function (res) {
                if (res.code === 200) {
                    // sellerInfo = res.data;
                    document.getElementById("noticenum").innerHTML = res.data
                } else {
                    alert(res.msg);
                }
            },
            error: function (data) {
                alert("getseller failed");
            }
        });
        return false;
}