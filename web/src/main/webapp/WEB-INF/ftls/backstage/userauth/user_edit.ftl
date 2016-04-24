<#include "../fragment/head.ftl">
<!-- webuploader -->
<link href="<@spring.url '/res/backstage/webuploader/css/webuploader.css'/>" rel="stylesheet" type="text/css"/>
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            用户管理
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="<@spring.url '/manager/index'/>"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>用户权限</li>
            <li><a href="<@spring.url '/manager/user/list/1'/>">用户管理</a></li>
            <li class="active">${page_title!"添加用户"}</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <!-- Small boxes (Stat box) -->
        <div class="row">
            <div class="box box-success">
                <div class="box-header">
                    <!-- tools box -->
                    <div class="pull-right box-tools">
                        <button id="saveUserForm" class="btn btn-success btn-sm" data-toggle="tooltip" title="保存">
                            <i class="fa fa-save"></i> 保存</button>
                        <button id="backUserList" class="btn btn-default btn-sm" data-toggle="tooltip" title="返回">
                            <i class="fa fa-mail-forward"></i> 返回</button>
                    </div><!-- /. tools -->
                    <i class="fa fa-globe"></i>
                    <h3 class="box-title">${page_title!"添加用户"}</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body" style="position: relative;">
                    <form id="userForm" action="<@spring.url '/manager/user/edit'/>" class="form-horizontal" role="form" method="POST">
                        <input type="hidden" value="" name="id">
                        <div class="form-group">
                            <label for="loginname" class="col-sm-2 control-label">登录名称 <span class="v5-required">*</span></label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="loginname" id="loginname"
                                       placeholder="登陆名称" value="" datatype="*" nullmsg="用户登录名称不能为空！"/>
                                <span class="help-block">用户登录名称，用于登录系统使用。</span>
                            </div>
                            <div class="col-sm-3 Validform_checktip"></div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">登录密码 <span class="v5-required">*</span></label>
                            <div class="col-sm-4">
                                <input type="password" class="form-control" name="password" id="password"
                                       placeholder="登录密码" value="" datatype="s6-18" nullmsg="登录密码不能为空！" errormsg="请输入6-18位的密码！"/>
                                <span class="help-block">用户登录密码，用于登陆系统使用。</span>
                            </div>
                            <div class="col-sm-3 Validform_checktip"></div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">Email <span class="v5-required">*</span></label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="email" id="email"
                                       placeholder="Email" value="" datatype="e" nullmsg="Email不能为空！"/>
                                <span class="help-block">用户电子邮箱地址。</span>
                            </div>
                            <div class="col-sm-3 Validform_checktip"></div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">用户名 </label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="name" id="name"
                                       placeholder="用户名" value="" />
                                <span class="help-block">用户名，用于显示使用。</span>
                            </div>
                            <div class="col-sm-3 Validform_checktip"></div>
                        </div>
                        <div class="form-group" style="padding-bottom: 10px;">
                            <label for="inputPassword3" class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-8">
                                <label class="radio-inline" style="padding-left: 0px;">
                                    <input type="radio" name="sex" checked value="1"> 男
                                </label>
                                <label class="radio-inline" style="padding-left: 0px;">
                                    <input type="radio" name="sex" value="0"> 女
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="mobilephone" class="col-sm-2 control-label">手机号码 </label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="mobilephone" id="mobilephone"
                                       placeholder="手机号码" value="" ignore="ignore" datatype="m"/>
                                <span class="help-block">填写用户手机号码。</span>
                            </div>
                            <div class="col-sm-3 Validform_checktip"></div>
                        </div>
                        <div class="form-group">
                            <label for="originalPic" class="col-sm-2 control-label" style="line-height: 80px;">用户头像上传 </label>
                            <div class="col-sm-4">
                                <input type="hidden" id="originalPic" name="originalPic" value="">
                                <div id="originalPicImageUpload">
                                    <img id="originalPicImg" src="<@spring.url '/res/backstage/images/avatar5.png'/>" class="img-circle upload-img" style="width: 80px;box-shadow: 0 5px 10px #888888;" alt="用户头像上传"/>
                                </div>
                            </div>
                        </div>
                    </form>
                </div><!-- /.box-body -->
            </div><!-- /.box -->
        </div><!-- /.row -->
    </section><!-- /.content -->
</aside><!-- /.right-side -->
<#include "../fragment/footer.ftl">
<!-- webuploader -->
<script src="<@spring.url '/res/backstage/webuploader/webuploader.min.js'/>" type="text/javascript"></script>
<script type="text/javascript">
    $(function(){
        $("#nav_siteSetting").imitClick();

        $("#backUserList").click(function(){
            location.href="<@spring.url '/manager/user/list/1'/>"
        });

        $("#userForm").Validform({
            ajaxPost:true,
            showAllError:true,
            tiptype:2,
            callback:function(data){
                if(data.status === "1"){
                    layer.msg(data.message, {
                        icon: 1,
                        time:2000
                    },function(){
                        location.href="<@spring.url '/manager/user/list/1'/>";
                    });
                }else if(data.status === "0"){
                    layer.msg(data.message, {icon: 2});
                }else{
                    layer.msg("错误代码："+data.status+" 错误消息："+data.statusText, {icon: 2});
                }
            }
        });

        $("#saveUserForm").click(function(){
            $("#userForm").submit();
        });

        //上传图片
        var uploadImage = WebUploader.create({
            // swf文件路径
            swf: "<@spring.url '/res/backstage/webuploader/Uploader.swf'/>",
            auto: true,
            // 文件接收服务端。
            server: '<@spring.url '/manager/banner/upload?tt='/>'+new Date().getTime(),
            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#originalPicImageUpload',

            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });

        uploadImage.on( 'uploadSuccess', function( file,response ) {
            if(response.status == '0'){
                layer.msg(response.message, {icon: 2});
                return;
            }
            layer.msg(response.message, {icon: 1});
            $("#originalPic").val(response.filePath);
            $("#originalPicImg").attr("src",response.contentPath + response.filePath)
        });

        uploadImage.on( 'uploadError', function( file,reason  ) {
            layer.msg("上传图片出错！", {icon: 2});
        });

        uploadImage.on("beforeFileQueued",function(file){
            /*var temp = $("#adv_image_url").val();
            if(temp != null && temp != ""){
                layer.msg("您已经上传了一张图片，请先删除在上传！", {icon: 2});
                return false;
            }*/
            return true;
        });

    });
</script>