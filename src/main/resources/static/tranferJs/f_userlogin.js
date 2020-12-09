$(function () {
    $("#id_user_login_submit").bind("click", function () {
        alert("fuck");
        var loginForm = document.forms[0];
        loginForm.action = "userlogin.f";
        loginForm.method = "post";
        loginForm.submit();
    });
});