<#include "../fragment/head.ftl">
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            资源管理
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li class="active">资源列表</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <!-- Small boxes (Stat box) -->
        <div class="row">
            <div class="col-sm-2" style="padding-left: 0;padding-right: 0;">
                <div class="box box-info">
                    <div class="box-header">
                        <!-- tools box -->
                        <i class="fa fa-sitemap"></i>
                        <h3 class="box-title">资源树</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body table-responsive v5-tree-div" style="padding-top: 0;">
                        <ul id="resourceTree" class="ztree"></ul>
                    </div><!-- /.box-body -->
                </div><!-- /.box -->
            </div>
            <div class="col-sm-10" style="padding-right: 0;">
                <div class="box box-info">
                    <div class="box-header">
                        <!-- tools box -->
                        <div class="pull-right box-tools">
                            <button id="createFolder" class="btn btn-success btn-sm" data-toggle="tooltip" title="新建文件夹">
                                <i class="fa fa-folder-open"></i> 新建文件夹</button>
                            <button id="addResource" class="btn btn-success btn-sm" data-toggle="tooltip" title="添加资源">
                                <i class="fa fa-plus"></i> 添加资源</button>
                            <button id="fileBatchDelete" class="btn btn-warning btn-sm" data-toggle="tooltip" title="批量删除">
                                <i class="fa fa-trash-o"></i> 批量删除</button>
                        </div><!-- /. tools -->
                        <i class="fa fa-table"></i>
                        <h3 class="box-title">资源列表&nbsp;
                            <small style="font-size:6px;">
                                <#if fileName == "front">
                                    资源根目录
                                <#else>
                                    ${fileName!"资源根目录"}
                                </#if>
                            </small>
                        </h3>
                    </div><!-- /.box-header -->
                    <div class="box-body table-responsive">
                        <table class="table table-hover table-bordered table-striped">
                            <colgroup>
                                <col class="col-xs-1 v5-col-xs-1">
                                <col class="col-xs-2">
                                <col class="col-xs-1">
                                <col class="col-xs-1">
                                <col class="col-xs-2">
                                <col class="col-xs-2">
                            </colgroup>
                            <thead>
                            <tr>
                                <th class="td-center">
                                    <input type="checkbox" id="thcheckbox" value="on"/>
                                </th>
                                <th>名称</th>
                                <th>类型</th>
                                <th>大小</th>
                                <th>最后修改</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#if files?size != 0>
                                <#list files as file>
                                <tr>
                                    <td class="td-center">
                                        <input type="checkbox" class="table-cb" value="${file.id!""}"/>
                                    </td>
                                    <td>${file.name!""}</td>
                                    <td>
                                        <#if file.type == "文件">
                                            <small class="badge bg-light-blue">${file.type!""}</small>
                                        <#else>
                                            <small class="badge bg-info">${file.type!""}</small>
                                        </#if>
                                    </td>
                                    <td>${file.size!""}</td>
                                    <td>${file.modifyDate!""}</td>
                                    <td>
                                        <#if file.type == "文件夹">
                                            <a href="javascript:;" data-resourceid="${file.id!""}" class="btn btn-success btn-xs create-folder" data-toggle="tooltip" title="创建文件夹">
                                                <i class="fa fa-folder-open"></i>
                                            </a>&nbsp;&nbsp;
                                            <#--<a href="javascript:;" class="btn btn-success btn-xs" data-toggle="tooltip" title="添加资源">-->
                                                <#--<i class="fa fa-plus"></i>-->
                                            <#--</a>&nbsp;&nbsp;-->
                                        <#else>
                                            <a href="javascript:;" data-resourceid="${file.id!""}" class="btn btn-success btn-xs edit-resource" data-toggle="tooltip" title="编辑内容">
                                                <i class="fa fa-edit"></i>
                                            </a>&nbsp;&nbsp;
                                        </#if>
                                        <a href="javascript:;" data-resourceid="${file.id!""}" data-oldname="${file.name!""}" class="btn btn-primary btn-xs rename-resource" data-toggle="tooltip" title="重命名">
                                            <i class="fa fa-magic"></i>
                                        </a>&nbsp;&nbsp;

                                        <a href="javascript:;" data-resourceid="${file.id!""}" class="btn btn-warning btn-xs delete-resource" data-toggle="tooltip" title="删除资源">
                                            <i class="fa fa-times"></i>
                                        </a>
                                    </td>
                                </tr>
                                </#list>
                            <#else>
                            <tr>
                                <td class="text-center" colspan="8"><h3>还没有资源数据！</h3></td>
                            </tr>
                            </#if>
                            </tbody>
                        </table>
                    </div><!-- /.box-body -->
                </div><!-- /.box -->
            </div><!-- /.col-xs-9 -->
        </div><!-- /.row -->
    </section><!-- /.content -->
    <form id="resourceForm" method="post" action="<@spring.url '/manager/resource/list'/>">
        <input type="hidden" id="pathInput" name="path">
    </form>
    <input type="hidden" id="pathUri" value="${path!"/"}">
</aside><!-- /.right-side -->
<#include "../fragment/footer.ftl">
<!-- webuploader -->
<script src="<@spring.url '/res/backstage/webuploader/webuploader.min.js'/>" type="text/javascript"></script>
<script type="text/javascript">

    $(function(){
        var resourceSetting = {
            view : {
                dblClickExpand : false
            },
            async : {
                enable : true,
                dataType : "json",
                url : "<@spring.url "/manager/resource/tree/json"/>"
            },
            callback : {
                onClick:function(event, treeId, treeNode){
                    var fileUri = treeNode.fileUri;
                    $("#pathInput").val(fileUri);
                    $("#resourceForm").submit();
                }
            }
        };
        $.fn.zTree.init($("#resourceTree"), resourceSetting);

        $("#resource_columns").imitClick();

        //上传资源
        var uploadResource = WebUploader.create({
            // swf文件路径
            swf: "<@spring.url '/res/backstage/webuploader/Uploader.swf'/>",
            auto: true,
            // 文件接收服务端。
            server: '<@spring.url '/manager/resource/res/upload?tt='/>'+new Date().getTime(),
            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: {
                id:'#addResource',
                multiple:true
            },

            accept: {
                title: 'Images js css',
                extensions: 'gif,jpg,jpeg,bmp,png,js,css',
                mimeTypes: 'image/*,application/javascript,text/css'
            }
        });

        uploadResource.on( 'uploadBeforeSend', function( object,data,headers ) {
            data.uploadUri = $("#pathUri").val();
        });

        uploadResource.on( 'uploadSuccess', function( file,response ) {
            if(response.status == '0'){
                layer.msg(response.message, {icon: 2});
                return;
            }
            layer.msg(response.message, {icon: 1},function(){
                location.reload();
            });
        });

        uploadResource.on( 'uploadError', function( file,reason  ) {
            layer.msg("上传资源出错！", {icon: 2});
        });

        function createFolder(pathUri){
            layer.open({
                btn: ['确定','取消'],
                content: '<div>文件夹名：<input type="text" id="folderName" name="folderName"></div>',
                yes:function(index, layero){
                    var folderName = $("#folderName").val();
                    if(folderName == ""){
                        layer.msg("文件名称不能为空！",{icon:2});
                        return;
                    }
                    $.ajax({
                        dataType:'json',
                        type:'POST',
                        url:"<@spring.url '/manager/resource/create/folder'/>",
                        data:{pathUri:pathUri,folderName:folderName},
                        success:function(data){
                            if(data.status == "1"){
                                layer.msg(data.message, {
                                    icon: 1,
                                    time:2000
                                },function(){
                                    location.reload();
                                });
                            }else{
                                layer.msg(data.message, {icon: 2});
                            }
                        },
                        error:function(XMLHttpRequest, textStatus, errorThrown){
                            layer.msg("删除内容信息出错，"+textStatus+"，"+errorThrown, {icon: 2});
                        }
                    });
                }
            });
        }

        function deleteResource(resourceIds) {
            layer.confirm('您确定要删除资源文件吗，删除后将不能恢复？', {icon: 3}, function(index){
                var url = "<@spring.url '/manager/resource/delete/file'/>";
                $.ajax({
                    dataType:'json',
                    type:'POST',
                    url:url,
                    data:{pathUris:resourceIds},
                    success:function(data){
                        if(data.status == "1"){
                            layer.msg(data.message, {
                                icon: 1,
                                time:2000
                            },function(){
                                location.reload();
                            });
                        }else{
                            layer.msg(data.message, {icon: 2});
                        }
                    },
                    error:function(XMLHttpRequest, textStatus, errorThrown){
                        layer.msg("删除文件信息出错，"+textStatus+"，"+errorThrown, {icon: 2});
                    }
                });
                layer.close(index);
            });
        }

        $(".create-folder").click(function(){
            var resourceId = $(this).data("resourceid");
            createFolder(resourceId);
        });

        $(".rename-resource").click(function(){
            var resourceId = $(this).data("resourceid");
            var oldName = $(this).data("oldname");
            var content = '<div>新文件夹名：<input type="text" id="folderName" name="folderName" value="'+oldName+'"></div>';
            layer.open({
                btn: ['确定','取消'],
                content: content,
                yes:function(index, layero){
                    var folderName = $("#folderName").val();
                    if(folderName == ""){
                        layer.msg("文件名称不能为空！",{icon:2});
                        return;
                    }
                    $.ajax({
                        dataType:'json',
                        type:'POST',
                        url:"<@spring.url '/manager/resource/rename/file'/>",
                        data:{pathUri:resourceId,folderName:folderName},
                        success:function(data){
                            if(data.status == "1"){
                                layer.msg(data.message, {
                                    icon: 1,
                                    time:2000
                                },function(){
                                    location.reload();
                                });
                            }else{
                                layer.msg(data.message, {icon: 2});
                            }
                        },
                        error:function(XMLHttpRequest, textStatus, errorThrown){
                            layer.msg("重命名文件名出错，"+textStatus+"，"+errorThrown, {icon: 2});
                        }
                    });
                }
            });
        });

        $(".edit-resource").click(function(){
            var resourceId = $(this).data("resourceid");
            $("#pathInput").val(resourceId);
            $("#resourceForm").submit();
        });

        $(".delete-resource").click(function(){
            var resourceId = $(this).data("resourceid");
            deleteResource(resourceId);
        });

        $("#thcheckbox").on('ifChecked', function(event){
            $('.table-cb').iCheck('check');
        });
        $("#thcheckbox").on('ifUnchecked', function(event){
            $('.table-cb').iCheck('uncheck');
        });

        $("#fileBatchDelete").click(function(){
            var $chs = $(":checkbox:checked");
            if($chs.length == 0){
                layer.msg("您还没有选中要操作的数据项！", {icon: 0});
                return;
            }
            var resourceIds = [];
            for(var i=0;i<$chs.length;i++){
                var v = $($chs[i]).val();
                if(v == "on") continue;
                resourceIds.push(v);
            }
            deleteResource(resourceIds.join());
        });

        $("#createFolder").click(function(){
            var pathUri = $("#pathUri").val();
            createFolder(pathUri);
        });
    });
</script>