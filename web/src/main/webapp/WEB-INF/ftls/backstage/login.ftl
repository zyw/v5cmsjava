<#import "/spring.ftl" as spring/>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <title>用户登录</title>
    <link rel="stylesheet" href="<@spring.url '/res/backstage/css/bootstrap.css'/>">
    <link rel="stylesheet" href="<@spring.url '/res/backstage/css/bootstrap-theme.css'/>">
    <link rel="stylesheet" href="<@spring.url '/res/backstage/css/main.css'/>">

    <script src="<@spring.url '/res/backstage/js/jquery-1.8.3.min.js'/>" type="text/javascript"></script>
    <script src="<@spring.url '/res/backstage/js/bootstrap.min.js'/>" type="text/javascript"></script>
</head>
<body>
<div class="panel panel-primary login-panel">
    <div class="panel-heading">
        <h3 class="panel-title">用户登录</h3>
    </div>
    <div class="panel-body">
        <form class="form-horizontal" action="<@spring.url '/manager/login'/>" method="post" role="form">
            <div class="form-group">
                <label for="managerName" class="col-lg-3 control-label">用户名</label>
                <div class="col-lg-9">
                    <input type="text" class="form-control" name="loginName" id="loginName" placeholder="用户名" value="zhangsan">
                </div>
            </div>
            <div class="form-group" style="display: block">
                <label for="managerPwd" class="col-lg-3 control-label">密码</label>
                <div class="col-lg-9">
                    <input type="password" class="form-control" name="loginPwd" id="loginPwd" placeholder="密码" value="000000">
                </div>
            </div>

            <div class="form-group">
                <label for="managerVcode" class="col-lg-3 control-label">验证码</label>
                <div class="col-lg-5" style="padding-right: 10px;">
                    <input type="text" class="form-control" name="captcha" id="captcha" placeholder="验证码">
                </div>
            <img id="vcode_img" src="<@spring.url '/manager/login/captcha'/>" title="点击更换验证码"
                 style="cursor: pointer;width: 80px;height: 35px;"/>
            </div>

            <div class="form-group">
                <div class="col-lg-offset-3 col-lg-9">
                    <button type="submit" class="btn btn-primary col-lg-9">
                        <span class="glyphicon glyphicon-log-in"></span>&nbsp;
                        登&nbsp;&nbsp;录
                    </button>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-3 col-lg-9">
                    <label style="color: #ff0000">${errorMessage!""}</label>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    /*seajs.use('jquery',function($){
        $("#vcode_img").on('click',function(){
            var url = $(this).attr('src').replace(/&r=[\w]*//*g,'');
            $(this).attr('src',url+'?r='+new Date().getTime());
        });
    });*/
    $(function(){
        $("#vcode_img").click(function(){
            var url = $(this).attr('src').replace(/&r=[\w]*/g,'');
            $(this).attr('src',url+'?r='+new Date().getTime());
        });
    })
</script>
</body>
</html>