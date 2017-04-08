<#include "../fragment/head.ftl">
<!-- webuploader -->
<link href="<@spring.url '/res/backstage/webuploader/css/webuploader.css'/>" rel="stylesheet" type="text/css"/>
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Banner管理
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="<@spring.url '/manager/index'/>"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>站点设置</li>
            <li><a href="<@spring.url '/manager/banner/list/1'/>">Banner管理</a></li>
            <li class="active">${page_title!"添加Banner"}</li>
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
                        <button id="saveBannerForm" class="btn btn-success btn-sm" data-toggle="tooltip" title="保存">
                            <i class="fa fa-save"></i> 保存</button>
                        <button id="backBannerList" class="btn btn-default btn-sm" data-toggle="tooltip" title="返回">
                            <i class="fa fa-mail-forward"></i> 返回</button>
                    </div><!-- /. tools -->
                    <i class="fa fa-globe"></i>
                    <h3 class="box-title">${page_title!"添加Banner"}</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body" style="position: relative;">
                    <form id="bannerForm" action="<@spring.url '/manager/banner/edit'/>" class="form-horizontal" role="form" method="POST">
                        <input type="hidden" value="${banner.bannerId!""}" name="bannerId">
                        <div class="form-group">
                            <label for="linkName" class="col-sm-2 control-label">Banner名称 <span class="v5-required">*</span></label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="bannerName" id="bannerName"
                                       placeholder="Banner名称" value="${banner.bannerName!""}" datatype="*" nullmsg="Banner名称不能为空！"/>
                                <span class="help-block">设置Banner名称，用于显示Banner名称。</span>
                            </div>
                            <div class="col-sm-3 Validform_checktip"></div>
                        </div>
                        <div class="form-group">
                            <label for="dvPosName" class="col-sm-2 control-label">Banner图片 </label>
                            <div class="col-sm-4">
                                <input type="hidden" id="bannerPic" name="bannerPic" value="${banner.bannerPic!""}">
                                <div id="bannerImageUpload"><i class="fa fa-cloud-upload"></i> Banner图片上传</div>

                                <div class="banner-img-preview">
                                    <img id="bannerImg" width="100%">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="dvPosName" class="col-sm-2 control-label">Banner地址</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="bannerLink" id="bannerLink"
                                       placeholder="Banner地址，例如：http://www.expleme.com" value="${banner.bannerLink!""}" ignore="ignore" datatype="url"
                                       errormsg="Banner地址格式不正确！"/>
                                <span class="help-block">设置Banner地址，必须以http://或者https://开头。</span>
                            </div>
                            <div class="col-sm-3 Validform_checktip"></div>
                        </div>
                        <div class="form-group">
                            <label for="dvPosName" class="col-sm-2 control-label">显示顺序</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="bannerds" id="bannerds"
                                       placeholder="显示顺序" value="${banner.bannerds!""}" ignore="ignore" datatype="n" errormsg="序号必须为数字！"/>
                                <span class="help-block">设置Banner显示的顺序。</span>
                            </div>
                            <div class="col-sm-3 Validform_checktip"></div>
                        </div>
                        <div class="form-group">
                            <label for="advPosState" class="col-sm-2 control-label">是否启用</label>
                            <div class="col-sm-3">
                                <label class="checkbox-inline" style="padding-left:0;">
                                    <input type="radio" name="isstart" value="1" id="isstart1" <#if ((banner.isstart)!1)==1>checked</#if>>
                                    <label for="openType1">是</label>
                                    &nbsp;&nbsp;
                                    <input type="radio" name="isstart" value="0" id="isstart0" <#if ((banner.isstart)!1)==0>checked</#if>>
                                    <label for="openType0">否</label>
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="columnName" class="col-sm-2 control-label">显示文本</label>
                            <div class="col-sm-5">
                                <textarea class="form-control" name="bcontent" id="bcontent" placeholder="Banner显示的文本" rows="6">${banner.bcontent!""}</textarea>
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
        var bannerPic = "${banner.bannerPic!""}";
        if(bannerPic != ""){
            var contentPath = "<@spring.url '/'/>";
            $("#bannerImg").attr("src",contentPath+bannerPic);
        }
        $("#nav_siteSetting").imitClick();

        $("#backBannerList").click(function(){
            location.href="<@spring.url '/manager/banner/list/1'/>"
        });

        $("#bannerForm").Validform({
            ajaxPost:true,
            showAllError:true,
            tiptype:2,
            callback:function(data){
                if(data.status === "1"){
                    layer.msg(data.message, {
                        icon: 1,
                        time:2000
                    },function(){
                        location.href="<@spring.url '/manager/banner/list/1'/>";
                    });
                }else if(data.status === "0"){
                    layer.msg(data.message, {icon: 2});
                }else{
                    layer.msg("错误代码："+data.status+" 错误消息："+data.statusText, {icon: 2});
                }
            }
        });

        $("#saveBannerForm").click(function(){
            $("#bannerForm").submit();
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
            pick: '#bannerImageUpload',

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
            $("#bannerPic").val(response.filePath);
            $("#bannerImg").attr("src",response.contentPath + response.filePath)
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