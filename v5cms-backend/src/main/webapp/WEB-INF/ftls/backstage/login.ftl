<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en" style="background:url(<@spring.url '/res/backstage/images/1.png'/>);no-repeat; background-size: cover;">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <link rel="shortcut icon" th:href="@{/admin/images/favicon.png}"/>
    <title>V5CMS - 用户登录</title>
    <link href="<@spring.url '/res/backstage/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="<@spring.url '/res/backstage/css/bootstrap.css'/>">
    <link rel="stylesheet" href="<@spring.url '/res/backstage/css/login/login.css'/>">
    <link rel="stylesheet" href="<@spring.url '/res/backstage/css/login/sweetalert2.min.css'/>">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
        .panel-shadow {
            -moz-box-shadow: 0px 0px 10px 0px rgba(39, 49, 65, 0.1);
            -webkit-box-shadow: 0px 0px 10px 0px rgba(39, 49, 65, 0.1);
            box-shadow: 0px 0px 10px 0px rgba(39, 49, 65, 0.1);
        }
        .bg-overlay {
            -moz-border-radius: 6px 6px 0 0;
            -webkit-border-radius: 6px 6px 0 0;
            background-color: rgba(47, 51, 62, 0.3);
            border-radius: 6px 6px 0 0;
            height: 100%;
            left: 0;
            position: absolute;
            top: 0;
            width: 100%;
        }
        .input-border {
            font-size: 14px;
            width: 100%;
            height: 40px;
            border-radius: 0;
            border: none;
            border-bottom: 1px solid #dadada;
        }

        .bg-img > h3 {
            text-shadow: 0px 2px 3px #555;
            color: #cac9c8;
        }
    </style>

</head>
<body style="background:url(<@spring.url '/res/backstage/images/1.png'/>);no-repeat; background-size: cover;" >
<div style="margin: 0 auto; padding-bottom: 0%; padding-top: 7.5%; width: 380px;">
    <div class="panel panel-color panel-danger panel-pages panel-shadow">
        <div class="panel-heading bg-img">
            <div class="bg-overlay"></div>
            <h3 class="text-center m-t-10"> 登录V5CMS </h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal m-t-20" method="post" id="loginForm" action="<@spring.url '/manager/login'/>">
                <div class="form-group">
                    <div class="col-xs-12">
                        <input class="input-lg input-border" name="loginname" type="text" required=""
                               placeholder="账号:"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-12">
                        <input class="input-lg input-border" name="password" type="password" required=""
                               placeholder="密码:"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-5" style="padding-right: 10px;">
                        <input type="text" class="input-lg input-border" name="jcaptchaCode" id="captcha" placeholder="验证码">
                    </div>
                    <img id="vcode_img" src="<@spring.url '/manager/login/captcha'/>" title="点击更换验证码"
                         style="cursor: pointer;width: 115px;height: 35px;"/>
                </div>
                <div class="form-group">
                    <div class="col-xs-12">
                        <div class="checkbox checkbox-danger">
                            <input id="checkbox-signup" name="rememberMe" type="checkbox"/>
                            <label for="checkbox-signup">记住我</label>
                        </div>
                    </div>
                </div>
                <div class="form-group text-center m-t-40">
                    <div class="col-xs-12">
                        <button class="btn btn-danger btn-lg btn-rounded btn-block w-lg waves-effect waves-light" style="box-shadow: 0px 0px 4px #868282;" type="submit">登&nbsp;录
                        </button>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-offset-3 col-xs-9">
                        <label style="color: #ff0000">${error!""}</label>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Main  -->
<script src="<@spring.url '/res/backstage/js/jquery-1.10.1.min.js'/>" type="text/javascript"></script>
<script src="<@spring.url '/res/backstage/js/bootstrap.min.js'/>" type="text/javascript"></script>
<script src="<@spring.url '/res/backstage/js/sweetalert2.min.js'/>" type="text/javascript"></script>
<script src="<@spring.url '/res/backstage/js/login.js'/>" type="text/javascript"></script>
<script type="text/javascript">
    /*<![CDATA[*/
    var tale = new $.tale();
    function checkForm() {
        tale.post({
            url: '/manager/login',
            data: $("#loginForm").serialize(),
            success: function (result) {
                if (result && result.success) {
                    window.location.href = '/manager/index';
                } else {
                    tale.alertError(result.msg || '登录失败');
                }
            }
        });
        return false;
    }
    /*]]>*/
</script>
</body>
</html>