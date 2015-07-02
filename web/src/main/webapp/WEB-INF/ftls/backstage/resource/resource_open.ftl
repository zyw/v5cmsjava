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
                        <ul id="columnTree" class="ztree"></ul>
                    </div><!-- /.box-body -->
                </div><!-- /.box -->
            </div>
            <div class="col-sm-10" style="padding-right: 0;">
                <div class="box box-info">
                    <div class="box-header">
                        <!-- tools box -->
                        <div class="pull-right box-tools">
                            <button id="addContent" class="btn btn-success btn-sm" data-toggle="tooltip" title="添加资源">
                                <i class="fa fa-plus"></i> 添加资源</button>
                            <button id="contentBatchDelete" class="btn btn-warning btn-sm" data-toggle="tooltip" title="批量删除">
                                <i class="fa fa-trash-o"></i> 批量删除</button>
                        </div><!-- /. tools -->
                        <i class="fa fa-table"></i>
                        <h3 class="box-title">资源列表&nbsp;<small style="font-size:6px;">${colName!"全部"}</small></h3>
                    </div><!-- /.box-header -->
                    <div class="box-body table-responsive">
                        <#if editor == "yes">
                            <pre id="editor" style="height:750px;font-size:14px;"></pre>
                            <textarea name="resourceContent" id="resourceContent" style="display:none;">${content}</textarea>
                        <#else>
                            <div class="text-center">
                                <img src="${webPath}" style="margin-top: 10px;margin-bottom: 10px;">
                                <div>${fileName}</div>
                            </div>
                        </#if>
                    </div><!-- /.box-body -->
                    <div class="box-footer clearfix">
                        <#--${pagination}-->
                    </div>
                </div><!-- /.box -->
            </div><!-- /.col-xs-9 -->
        </div><!-- /.row -->
    </section><!-- /.content -->
    <form id="resourceForm" method="post" action="<@spring.url '/manager/resource/list'/>">
        <input type="hidden" id="pathInput" name="path">
    </form>
</aside><!-- /.right-side -->
<#include "../fragment/footer.ftl">
<script type="text/javascript" charset="utf-8" src="<@spring.url '/res/backstage/ace/ace.js'/>"></script>
<script type="text/javascript">

    $(function(){
        var columnSetting = {
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
        $.fn.zTree.init($("#columnTree"), columnSetting);

        <#if editor == "yes">
            var editor = ace.edit("editor");
            editor.setTheme("ace/theme/tomorrow");
            <#if extension == "js">
                editor.session.setMode("ace/mode/javascript");
            <#else>
                editor.session.setMode("ace/mode/css");
            </#if>
            editor.setAutoScrollEditorIntoView(true);
            editor.setValue($("#resourceContent").val());
            editor.getSession().on('change', function(e) {
                $("#resourceContent").val(editor.getValue());
            });
        </#if>


        $("#resource_columns").imitClick();
        $("#addContent").click(function(){
            location.href="<@spring.url '/manager/content/edit'/>";
        });

        function deleteContent(contentId) {
            layer.confirm('您确定要删除内容信息吗，删除后将不能恢复？', {icon: 3}, function(index){
                var url = "<@spring.url '/manager/content/delete'/>";
                $.ajax({
                    dataType:'json',
                    type:'POST',
                    url:url,
                    data:{contentId:contentId},
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
                layer.close(index);
            });
        }

        $(".delete-content").click(function(){
            var contentId = $(this).data("contentid");
            deleteContent(contentId);
        });

        $("#thcheckbox").on('ifChecked', function(event){
            $('.table-cb').iCheck('check');
        });
        $("#thcheckbox").on('ifUnchecked', function(event){
            $('.table-cb').iCheck('uncheck');
        });

        $("#contentBatchDelete").click(function(){
            var $chs = $(":checkbox[checked=checked]");
            if($chs.length == 0){
                layer.msg("您还没有选中要操作的数据项！", {icon: 0});
                return;
            }
            var contentIds = [];
            for(var i=0;i<$chs.length;i++){
                var v = $($chs[i]).val();
                if(v == "on") continue;
                contentIds.push(v);
            }
            deleteContent(contentIds.join());
        });
    });
</script>