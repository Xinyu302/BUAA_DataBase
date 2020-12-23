$(function () {
    $("#id_user_login_submit").bind("click", function () {
        var loginForm = document.forms["loginForm"];
        loginForm.action = "userlogin.f";
        loginForm.method = "post";
        loginForm.submit();
    });
});

$(function () {
    $("#id_user_register_submit").bind("click", function () {
        var registerForm = document.forms["registerForm"];
        registerForm.action = "userregister.f";
        registerForm.method = "post";
        registerForm.submit();
    });
});

// $(function () {
//     $("#savechange").bind("click", function () {
//         var loginForm = document.forms["savechangeform"];
//         alert(loginForm);
//         loginForm.action = "modifyuser";
//         loginForm.method = "post";
//         loginForm.submit();
//     });
// });

$(function () {
    $("#confirmchange").bind("click", function () {
        var loginForm = document.forms["confirmchange"];
        loginForm.action = "changepassword";
        loginForm.method = "post";
        loginForm.submit();
    });
});



