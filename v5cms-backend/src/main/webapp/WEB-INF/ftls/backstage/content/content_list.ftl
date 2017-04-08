<#include "../fragment/head.ftl">
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            内容管理
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>内容管理</li>
            <li class="active">内容列表</li>
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
                        <h3 class="box-title">栏目树</h3>
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
                            <button id="addContent" class="btn btn-success btn-sm" data-toggle="tooltip" title="添加内容">
                                <i class="fa fa-plus"></i> 添加内容</button>
                            <button id="contentBatchDelete" class="btn btn-warning btn-sm" data-toggle="tooltip" title="批量删除">
                                <i class="fa fa-trash-o"></i> 批量删除</button>
                        </div><!-- /. tools -->
                        <i class="fa fa-table"></i>
                        <h3 class="box-title">内容列表&nbsp;<small style="font-size:6px;">${colName!"全部"}</small></h3>
                    </div><!-- /.box-header -->
                    <div class="box-body table-responsive">
                        <table class="table table-hover table-bordered table-striped">
                            <colgroup>
                                <col class="col-xs-1 v5-col-xs-1">
                                <col class="col-xs-1">
                                <col class="col-xs-2">
                                <col class="col-xs-1">
                                <col class="col-xs-2">
                                <col class="col-xs-1">
                                <col class="col-xs-1">
                            </colgroup>
                            <thead>
                            <tr>
                                <th class="td-center">
                                    <input type="checkbox" id="thcheckbox" value="on"/>
                                </th>
                                <th>序号</th>
                                <th>标题</th>
                                <th>所属栏目</th>
                                <th>创建时间</th>
                                <th>状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#if contents?size != 0>
                                <#list contents as content>
                                <tr>
                                    <td class="td-center">
                                        <input type="checkbox" class="table-cb" value="${content.contentId!""}"/>
                                    </td>
                                    <td>${content.contentId!""}</td>
                                    <td>${content.cname!""}</td>
                                    <td>${content.column.columnName!""}</td>
                                    <td>${content.lastdt!""}</td>
                                    <td>
                                        <#if content.state == 0>
                                            <small class="label label-warning">草稿</small>
                                        <#elseif content.state == 1>
                                            <small class="label label-danger">待审核</small>
                                        <#else>
                                            <small class="label label-success">已发布</small>
                                        </#if>
                                    </td>
                                    <td>
                                        <a href="<@spring.url '/manager/content/edit/'/>${content.contentId!""}" class="btn btn-primary btn-xs" data-toggle="tooltip" title="修改内容">
                                            <i class="fa fa-edit"></i>
                                        </a>&nbsp;&nbsp;
                                        <a href="javascript:;" data-contentid="${content.contentId!""}" class="btn btn-warning btn-xs delete-content" data-toggle="tooltip" title="删除内容">
                                            <i class="fa fa-times"></i>
                                        </a>
                                    </td>
                                </tr>
                                </#list>
                            <#else>
                            <tr>
                                <td class="text-center" colspan="8"><h3>还没有内容数据！</h3></td>
                            </tr>
                            </#if>
                            </tbody>
                        </table>
                    </div><!-- /.box-body -->
                    <div class="box-footer clearfix">
                        ${pagination}
                    </div>
                </div><!-- /.box -->
            </div><!-- /.col-xs-9 -->
        </div><!-- /.row -->
    </section><!-- /.content -->
</aside><!-- /.right-side -->
<#include "../fragment/footer.ftl">
<script type="text/javascript">

    $(function(){
        var columnSetting = {
            view : {
                dblClickExpand : false
            },
            async : {
                enable : true,
                dataType : "json",
                url : "<@spring.url "/manager/content/tree/json"/>"
            },
            callback : {
                onAsyncSuccess : function(event, treeId, treeNode, msg) {
                    var zTree = $.fn.zTree.getZTreeObj("columnTree");
                    zTree.expandAll(true);
                },
                onClick:function(event, treeId, treeNode){
                    var columnId = treeNode.id;
                    var url = "<@spring.url '/manager/content/list'/>";
                    location.href = url +"/"+ columnId + "/1";
                }
            }
        };
        $.fn.zTree.init($("#columnTree"), columnSetting);

        $("#nav_content").imitClick();
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
            var $chs = $(":checkbox:checked");
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