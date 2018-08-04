$(function () {
    //check username
    $("#username").blur(function () {
        var username = $("#username").val().trim();
        if (username.length < 3 || username.length > 20) {
            toastr.error('账号格式不正确', '错误提示');
            $("#username").focus();
            return false;
        }

        // 获取 CSRF Token
        var csrfToken = $("meta[name='_csrf']").attr("content");
        var csrfHeader = $("meta[name='_csrf_header']").attr("content");
        $.ajax({
            type: "POST",
            async: false,
            beforeSend: function(request) {
                request.setRequestHeader(csrfHeader, csrfToken); // 添加  CSRF Token
            },
            url: "/user/checkUsername",
            data: {"username":username},
            success: function(msg){
                if (msg.status != 200){
                    toastr.error(msg.message, '错误提示');
                    $("#username").focus();
                }
            }
        });
    });

    //注册提交按钮
    $("#submit").click(function () {
        var username = $("#username").val().trim();
        if (username.length < 3 || username.length > 20) {
            toastr.error('账号格式不正确', '错误提示');
            $("#username").focus();
            return false;
        }
        var email = $("#email").val().trim();
        var reg = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
        if (!reg.test(email)) {
            toastr.error('邮箱格式不正确', '错误提示');
            $("#email").focus();
            return false;
        }
        var realname = $("#realname").val().trim();
        if (realname.length < 2 || realname.length > 20) {
            toastr.error('姓名格式不正确', '错误提示');
            $("#realname").focus();
            return false;
        }
        var password = $("#password").val().trim();
        var pwdReg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
        if (password.length < 6 || password.length > 20) {
            toastr.error('密码长度至少6位,不超过20位', '错误提示');
            $("#password").focus();
            return false;
        }
        if (!pwdReg.test(password)){
            toastr.error('密码格式不正确', '错误提示');
            $("#password").focus();
            return false;
        }
    });


});
