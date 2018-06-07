var doLogin = function () {
    var app=this; // 调用者，即login_app
    var uname=app.username.trim();
    var upassword=app.password.trim();
    if (!uname){
        app.msg='<span class="pull-left text-danger">请填写用户名</span>';
        return;
    } else if (!upassword){
        app.msg='<span class="pull-left text-danger">请填写密码</span>';
        return;
    } else {
        app.msg='';
    }
    $.ajax({
        url: 'index_login',
        type: 'post',
        data: {
        	userId: uname,
            pwd: upassword,
        },
        success: function (data) {
        	alert(data.code);
            if (data.code==0) {
                app.msg='<span class="pull-left text-success">登录成功，正在跳转...</span>';
                window.location.href='http://localhost:8083/templates/admin/index.html';
            } else {             
                app.msg='<span class="pull-left text-danger">'+data.msg+'</span>';
            }
        }
    });
}

var login_app = new  Vue({
    el: '#login-page',
    data: {
    	username: '1',
    	password: '123',
        msg: ''//提示信息
    },
    methods: {
        login: doLogin
    }
})