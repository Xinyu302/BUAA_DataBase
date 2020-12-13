function submitModifyForm() {
    alert("fuck3");

    var form = document.getElementById('savechangeform'),
        formData = new FormData(form);
    $.ajax({
        url:"http://localhost:8086/modifyuser",
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