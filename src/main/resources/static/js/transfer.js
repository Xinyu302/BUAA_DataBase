$(function () {
    $("#id_user_login_submit").bind("click", function () {
        alert("fuck1");
        var loginForm = document.forms[1];
        loginForm.action = "userlogin.f";
        loginForm.method = "post";
        loginForm.submit();
    });
});

$(function () {
    $("#id_user_register_submit").bind("click", function () {
        alert("fuck2");
        var registerForm = document.forms[2];
        registerForm.action = "userregister.f";
        registerForm.method = "post";
        registerForm.submit();
    });
});

// $(function () {
//     $("#savechange").bind("click", function () {
//         alert("fuck3");
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



