$(function () {
    if (window != top){
        top.location.href = location.href;
        return;
    }
    // 表单提交
    function formCommit(username, password) {
        $.ajax({
            type : "post",
            url : "/pc/login/loginIn",
            data : {"loginName":username,"password":password},
            success : function(result) {
                if(result.status == 200 ) {
                    window.location.href = "/pc/index";
                } else {
                    $("#errorMsg").text(result.message);
                }
            },
            error : function() {
                alert("/pc/login/loginIn ajax error");
            }
        });
    }

    // 获取实际按键
    $('body').bind('keypress',getKeyCode);
    function getKeyCode(e) {
        var evt = e || window.event;
        var keyCode = evt.keyCode || evt.which || evt.charCode;
        //console.log("触发了toLogin.js里面的获取实际按键的function，实际按键码：",keyCode);
        return keyCode;
    }

    // 登录处理
    function loginIn() {
        var user = new Object();
        user.loginName = $("#user_input").val();
        user.password = $("#pwd_input").val();
        if(user.loginName.trim() == "" || user.password.trim() == "") {
            user.msg = "用户名或密码为空";
        } else {
            user.password = $.md5(user.password);
            $("#pwd_input_hidden").val(user.password);
            user.msg = "success";
        }
        return user;
    }

    // 给body绑定“Enter按键抬起之后”的事件
    $('body').keyup(function(e){
        var eCode = getKeyCode(e);
        //console.log(eCode,"--------");
        if (eCode == 13){
            var user = loginIn();
            if(user.msg === "success") {
                formCommit(user.loginName, user.password);
            } else {
                alert(user.msg);
            }
        }
    });

    // 给登录按钮绑定事件
    $("#submitBtn").on("click",function () {
        var user = loginIn();
        if(user.msg === "success") {
            formCommit(user.loginName, user.password);
        } else {
            alert(user.msg);
        }
    });
});