<#include "../fragment/head.ftl">
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            栏目
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>栏目管理</li>
            <li class="active">栏目</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <!-- Small boxes (Stat box) -->
        <div class="row">
            <#--<div class="col-sm-2" style="padding-left: 0;padding-right: 0;">
                <div class="box box-info">
                    <div class="box-header">
                        <!-- tools box &ndash;&gt;
                        <i class="fa fa-sitemap"></i>
                        <h3 class="box-title">栏目树</h3>
                    </div>
                    <!-- /.box-header &ndash;&gt;
                    <div class="box-body table-responsive v5-tree-div" style="padding-top: 0;">
                        <ul id="columnTree" class="ztree"></ul>
                    </div><!-- /.box-body &ndash;&gt;
                </div><!-- /.box &ndash;&gt;
            </div>-->
            <#--<div class="col-sm-12" style="padding-right: 0;">-->
                <div class="box box-info">
                    <div class="box-header">
                        <!-- tools box -->
                        <div class="pull-right box-tools">
                            <button id="addColumn" class="btn btn-success btn-sm" data-toggle="tooltip" title="添加栏目">
                                <i class="fa fa-plus"></i> 添加栏目</button>
                            <button id="columnBatchDelete" class="btn btn-warning btn-sm" data-toggle="tooltip" title="批量删除">
                                <i class="fa fa-trash-o"></i> 批量删除</button>
                        </div><!-- /. tools -->
                        <i class="fa fa-table"></i>
                        <h3 class="box-title">栏目列表</h3>
                    </div><!-- /.box-header -->
                    <div class="box-body table-responsive">
                        <table id="column-table" class="table-striped table-advance table-hover">
                            <colgroup>
                                <col class="col-xs-2">
                                <col class="col-xs-1">
                                <col class="col-xs-1">
                                <col class="col-xs-1">
                                <col class="col-xs-2">
                            </colgroup>
                            <thead>
                            <tr>
                                <th>名称</th>
                                <th>类型</th>
                                <th>顺序</th>
                                <th>状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#if columns?size != 0>
                            <#list columns as column>
                                <tr data-tt-id="${column.colsId }" <#if column.parentId != 0>data-tt-parent-id="${column.parentId }"</#if>>
                                <td>${column.columnName!""}</td>
                                <td>${column.columnType.colTypeName!""}</td>
                                <td>${column.sortNum!0}</td>
                                <td>
                                    <#if column.columndisplay == 1>
                                        <span class="badge bg-green">可用</span>
                                    <#else>
                                        <span class="badge bg-red">禁用</span>
                                    </#if>
                                </td>
                                <td>
                                    <a href="<@spring.url '/manager/column/edit/${column.colsId}'/>" class="btn btn-success btn-xs" data-toggle="tooltip" title="添加子栏目">
                                        <i class="fa fa-plus"></i>
                                    </a>&nbsp;
                                    <a href="<@spring.url '/manager/column/${column.colsId}/update'/>" class="btn btn-primary btn-xs" data-toggle="tooltip" title="修改栏目">
                                        <i class="fa fa-edit"></i>
                                    </a>&nbsp;
                                    <a href="javascript:;" data-columnid="${column.colsId}" class="btn btn-warning btn-xs delete-column" data-toggle="tooltip" title="删除栏目">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </td>
                                </tr>
                            </#list>
                            <#else>
                            <tr>
                                <td colspan="6"><h3>还没有栏目数据！</h3></td>
                            </tr>
                            </#if>
                            </tbody>
                        </table>
                    </div><!-- /.box-body -->
                </div><!-- /.box -->
            <#--</div>--><!-- /.col-xs-9 -->
        </div><!-- /.row -->
    </section><!-- /.content -->
</aside><!-- /.right-side -->
<#include "../fragment/footer.ftl">
<script type="text/javascript">

    /*var setting = {
        view:{showLine:false},
        data: {
            simpleData: {
                enable: true
            }
        }
    };

    var zNodes =[
        { id:1, pId:0, name:"父节点1 - 展开", open:true},
        { id:11, pId:1, name:"父节点11 - 折叠"},
        { id:111, pId:11, name:"叶子节点111"},
        { id:112, pId:11, name:"叶子节点112"},
        { id:113, pId:11, name:"叶子节点113"},
        { id:114, pId:11, name:"叶子节点114"},
        { id:12, pId:1, name:"父节点12 - 折叠"},
        { id:121, pId:12, name:"叶子节点121"},
        { id:122, pId:12, name:"叶子节点122"},
        { id:123, pId:12, name:"叶子节点123"},
        { id:124, pId:12, name:"叶子节点124"},
        { id:13, pId:1, name:"父节点13 - 没有子节点", isParent:true},
        { id:2, pId:0, name:"父节点2 - 折叠"},
        { id:21, pId:2, name:"父节点21 - 展开", open:true},
        { id:211, pId:21, name:"叶子节点211"},
        { id:212, pId:21, name:"叶子节点212"},
        { id:213, pId:21, name:"叶子节点213"},
        { id:214, pId:21, name:"叶子节点214"},
        { id:22, pId:2, name:"父节点22 - 折叠"},
        { id:221, pId:22, name:"叶子节点221"},
        { id:222, pId:22, name:"叶子节点222"},
        { id:223, pId:22, name:"叶子节点223"},
        { id:224, pId:22, name:"叶子节点224"},
        { id:23, pId:2, name:"父节点23 - 折叠"},
        { id:231, pId:23, name:"叶子节点231"},
        { id:232, pId:23, name:"叶子节点232"},
        { id:233, pId:23, name:"叶子节点233"},
        { id:234, pId:23, name:"叶子节点234"},
        { id:3, pId:0, name:"父节点3 - 没有子节点", isParent:true}
    ];*/

    $(function(){
        /*$.fn.zTree.init($("#columnTree"), setting, zNodes);*/
        //$("#nav_siteSetting").imitClick();
        $("#nav_columns").imitClick();
        $("#column-table").treetable({ expandable: true,initialState:'expanded' });
        $("#addColumn").click(function(){
            location.href="<@spring.url '/manager/column/edit/0'/>";
        });

        function deleteColumn(columnId) {
            layer.confirm('您确定要删除栏目信息吗，删除后将不能恢复？', {icon: 3}, function(index){
                var url = "<@spring.url '/manager/column/delete'/>";
                $.ajax({
                    dataType:'json',
                    type:'POST',
                    url:url,
                    data:{columnId:columnId},
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
                        layer.msg("删除栏目类型信息出错，"+textStatus+"，"+errorThrown, {icon: 2});
                    }
                });
                layer.close(index);
            });
            <#--
            $.v5cms.confirm({icon:"question",content:"您确定要删除栏目信息吗，删除后将不能恢复？",width:350,ok:function(){
                var url = "<@spring.url '/manager/column/delete'/>";
                $.ajax({
                    dataType:'json',
                    type:'POST',
                    url:url,
                    data:{columnId:columnId},
                    success:function(data){
                        if(data.status == "1"){
                            $.v5cms.tooltip({icon:"succeed","content":data.message},function(){
                                location.reload();
                            });
                        }else{
                            $.v5cms.tooltip({icon:"error","content":data.message});
                        }
                    },
                    error:function(XMLHttpRequest, textStatus, errorThrown){
                        $.v5cms.tooltip({icon:"error","content":"删除栏目信息出错，"+textStatus+"，"+errorThrown});
                    }
                });
            }});
            -->
        }

        $(".delete-column").click(function(){
            var columnId = $(this).data("columnid");
            deleteColumn(columnId);
        });
    });
</script>