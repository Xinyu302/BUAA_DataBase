function uploadAndSubmit() {
    var form = document.forms["fileForm"];
    if (form["productPic"].files.length > 0) { // 寻找表单域中的 <input type="file" ... /> 标签
        var file = form["productPic"].files[0]; // try sending

        //alert(file.content());
        var reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function () {
            this.result
            var re = this.result;
            alert(file.name);    //'文件'file.name  '大小'file.size  '修改'file.lastModifiedDate
            document.getElementById("myImg").src = file.target.result;  //赋值img
        }


        reader.onloadstart = function() { // 这个事件在读取开始时触发
            // alert("onloadstart");
            document.getElementsByName("productPic").textContent = file.size;
        }
        reader.onprogress = function(p) { // 这个事件在读取进行中定时触发
            // alert("onprogress");
            document.getElementsByName("productPic").textContent = p.loaded;
        }

        reader.onloadend = function() { // 这个事件在读取结束后，无论成功或者失败都会触发
            if (reader.error) {
                console.log(reader.error);
            } else {
                document.getElementById("bytesRead").textContent = file.size; // 构造 XMLHttpRequest 对象，发送文件 Binary 数据
                var equest = new XMLHttpRequest();
                request.open(/* method */ "POST",
                    /* target url */ "upload.jsp?fileName=" + file.name
                    /*, async, default to true */);
                request.overrideMimeType("application/octet-stream");
                request.sendAsBinary(reader.result);
                request.onreadystatechange = function() {
                    if (request.readyState == 4) {
                        if (request.status == 200) {
                            console.log("upload complete");
                            console.log("response: " + request.responseText);
                        }
                    }
                }
            }
        }

        reader.readAsText(file);
    } else {
        alert ("Please choose a file.");
    }
}