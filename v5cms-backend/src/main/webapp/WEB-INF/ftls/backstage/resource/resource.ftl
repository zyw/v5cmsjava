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
            <div class="col-sm-10" id="resource-wapper" style="padding-right: 0;">

            </div><!-- /.col-xs-9 -->
        </div><!-- /.row -->
    </section><!-- /.content -->
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
                    loadingResource(fileUri);
                }
            }
        };
        $.fn.zTree.init($("#resourceTree"), resourceSetting);

        $("#resource_columns").imitClick();
        
        function loadingResource(fileUri) {
            $.ajax({
                dataType:'html',
                type:'POST',
                url:"<@spring.url '/manager/resource/list'/>",
                data:{path:fileUri},
                success:function(data){
                    $("#resource-wapper").html(data);
                },
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    layer.msg("获取资源信息出错，"+textStatus+"，"+errorThrown, {icon: 2});
                }
            });
        }

        loadingResource("");
    });
</script>