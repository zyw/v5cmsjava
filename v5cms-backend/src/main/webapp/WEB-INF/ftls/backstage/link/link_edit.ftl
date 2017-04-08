<#include "../fragment/head.ftl">
<!-- webuploader -->
<link href="<@spring.url '/res/backstage/webuploader/css/webuploader.css'/>" rel="stylesheet" type="text/css"/>
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            链接管理
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="<@spring.url '/manager/index'/>"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>站点设置</li>
            <li><a href="<@spring.url '/manager/link/list/1'/>">链接管理</a></li>
            <li class="active">${page_title!"添加链接"}</li>
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
                        <button id="saveLinkForm" class="btn btn-success btn-sm" data-toggle="tooltip" title="保存">
                            <i class="fa fa-save"></i> 保存</button>
                        <button id="backLinkList" class="btn btn-default btn-sm" data-toggle="tooltip" title="返回">
                            <i class="fa fa-mail-forward"></i> 返回</button>
                    </div><!-- /. tools -->
                    <i class="fa fa-globe"></i>
                    <h3 class="box-title">${page_title!"添加链接"}</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body" style="position: relative;">
                    <form id="linkForm" action="<@spring.url '/manager/link/edit'/>" class="form-horizontal" role="form" method="POST">
                        <input type="hidden" value="${link.linkId!""}" name="linkId">
                        <div class="form-group">
                            <label for="linkName" class="col-sm-2 control-label">链接名称 <span style="color: #ff0000">*</span></label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="linkName" id="linkName"
                                       placeholder="链接名称" value="${link.linkName!""}" datatype="*" nullmsg="链接名称不能为空！"/>
                                <span class="help-block">设置链接名称，用于显示链接名称。</span>
                            </div>
                            <div class="col-sm-3 Validform_checktip"></div>
                        </div>
                        <div class="form-group">
                            <label for="dvPosName" class="col-sm-2 control-label">链接地址 <span style="color: #ff0000">*</span></label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="link" id="link"
                                       placeholder="链接地址" value="${link.link!"http://"}" datatype="url" nullmsg="链接地址不能为空！"
                                       errormsg="链接地址格式不正确！"/>
                                <span class="help-block">设置链接地址，必须以http://或者https://开头。</span>
                            </div>
                            <div class="col-sm-3 Validform_checktip"></div>
                        </div>
                        <div class="form-group">
                            <label for="dvPosName" class="col-sm-2 control-label">链接图片 </label>
                            <div class="col-sm-4">
                                <input type="hidden" id="linkPic" name="linkPic" value="${link.linkPic!""}">
                                <div id="linkImageUpload"><i class="fa fa-cloud-upload"></i> 链接图片上传</div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="advPosState" class="col-sm-2 control-label">打开方式</label>
                            <div class="col-sm-3">
                                <label class="checkbox-inline" style="padding-left:0;">
                                    <input type="radio" name="openType" value="_blank" id="openType1" <#if (link.openType!"_blank")=="_blank">checked</#if>>
                                    <label for="openType1">新页面</label>
                                    &nbsp;&nbsp;
                                    <input type="radio" name="openType" value="_self" id="openType0" <#if (link.openType!"_blank")=="_self">checked</#if>>
                                    <label for="openType0">当前页面</label>
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="advPosState" class="col-sm-2 control-label">链接状态</label>
                            <div class="col-sm-3">
                                <label class="checkbox-inline" style="padding-left:0;">
                                    <input type="radio" name="isstart" value="1" id="isstart1" <#if (link.isstart!1)==1>checked</#if>>
                                    <label for="isstart1">启用</label>
                                    &nbsp;&nbsp;
                                    <input type="radio" name="isstart" value="0" id="isstart0" <#if (link.isstart!1)==0>checked</#if>>
                                    <label for="isstart0">禁用</label>
                                </label>
                            </div>
                        </div>
                    </form>
                    <div class="link-img-preview">
                        <img id="linkImg" width="100%">
                    </div>
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
        var linkPic = "${link.linkPic!""}";
        if(linkPic != ""){
            var contentPath = "<@spring.url '/'/>";
            $("#linkImg").attr("src",contentPath+linkPic);
        }
        $("#nav_siteSetting").imitClick();

        $("#backLinkList").click(function(){
            location.href="<@spring.url '/manager/link/list/1'/>"
        });

        $("#linkForm").Validform({
            ajaxPost:true,
            showAllError:true,
            tiptype:2,
            callback:function(data){
                if(data.status === "1"){
                    layer.msg(data.message, {
                        icon: 1,
                        time:2000
                    },function(){
                        location.href="<@spring.url '/manager/link/list/1'/>";
                    });
                }else if(data.status === "0"){
                    layer.msg(data.message, {icon: 2});
                }else{
                    layer.msg("错误代码："+data.status+" 错误消息："+data.statusText, {icon: 2});
                }
            }
        });

        $("#saveLinkForm").click(function(){
            $("#linkForm").submit();
        });

        //上传图片
        var uploadImage = WebUploader.create({
            // swf文件路径
            swf: "<@spring.url '/res/backstage/webuploader/Uploader.swf'/>",
            auto: true,
            // 文件接收服务端。
            server: '<@spring.url '/manager/link/upload?tt='/>'+new Date().getTime(),
            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#linkImageUpload',

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
            $("#linkPic").val(response.filePath);
            $("#linkImg").attr("src",response.contentPath + response.filePath)
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