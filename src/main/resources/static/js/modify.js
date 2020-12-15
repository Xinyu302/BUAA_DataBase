function submitModifyForm() {

    var form = document.getElementById('savechangeform'),
        formData = new FormData(form);
    var urlPath = window.document.location.href;
    var docPath = window.document.location.pathname;
    var index = urlPath.indexOf(docPath);
    var serverPath = urlPath.substring(0, index);
    $.ajax({
        url:serverPath+"/modifyuser",
        type:"post",
        data:formData,
        processData:false,
        contentType:false,
        done: function (res) {
            uxAlert('finish:' + res);
        },
        success:function(res){
            location.reload();
            if(res){
                uxAlert("上传成功！");
            }
            console.log(res);
        },
        error:function(err){
            uxAlert("网络连接失败,稍后重试",err);
        }
    });
    return false;
}