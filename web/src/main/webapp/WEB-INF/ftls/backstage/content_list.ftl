<#include "fragment/head.ftl">
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
                            <button id="addColumn" class="btn btn-success btn-sm" data-toggle="tooltip" title="添加内容">
                                <i class="fa fa-plus"></i> 添加内容</button>
                            <button id="columnBatchDelete" class="btn btn-warning btn-sm" data-toggle="tooltip" title="批量删除">
                                <i class="fa fa-trash-o"></i> 批量删除</button>
                        </div><!-- /. tools -->
                        <i class="fa fa-table"></i>
                        <h3 class="box-title">内容列表</h3>
                    </div><!-- /.box-header -->
                    <div class="box-body table-responsive">
                        <table class="table table-hover table-bordered table-striped">
                            <colgroup>
                                <col class="col-xs-1 v5-col-xs-1">
                                <col class="col-xs-1">
                                <col class="col-xs-2">
                                <col class="col-xs-2">
                                <col class="col-xs-2">
                                <col class="col-xs-1">
                                <col class="col-xs-1">
                                <col class="col-xs-2">
                            </colgroup>
                            <thead>
                            <tr>
                                <th class="td-center">
                                    <input type="checkbox" id="thcheckbox"/>
                                </th>
                                <th>序号</th>
                                <th>类型名称</th>
                                <th>列表模板</th>
                                <th>内容模板</th>
                                <th>单页</th>
                                <th>禁用</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#--<#if cts?size != 0>
                                <#list cts as ct>
                                <tr>
                                    <td class="td-center">
                                        <input type="checkbox" class="table-cb" value="${ct.colTypeId}"/>
                                    </td>
                                    <td>${ct.colTypeId}</td>
                                    <td>${ct.colTypeName}</td>
                                    <td>${ct.coltpl}</td>
                                    <td>${ct.contenttpl}</td>
                                    <td>
                                    ${(ct.hasContent==1)?string("<small class='badge bg-green'>是</small>",
                                    "<small class='badge bg-red'>否</small>")}
                                    </td>
                                    <td>
                                    ${(ct.isDisabled==1)?string("<small class='badge bg-green'>启用</small>",
                                    "<small class='badge bg-red'>禁用</small>")}
                                    </td>
                                    <td>
                                        <a href="<@spring.url '/manager/coltype/edit/'/>${ct.colTypeId}">修改</a>&nbsp;&nbsp;
                                        <a href="javascript:;" class="deleteColType" data-ctid="${ct.colTypeId}">删除</a>
                                    </td>
                                </tr>
                                </#list>
                            <#else>
                            <tr>
                                <td colspan="8"><h3>还没有栏目类型数据！</h3></td>
                            </tr>
                            </#if>
                            </tbody>-->
                        </table>
                    </div><!-- /.box-body -->
                </div><!-- /.box -->
            <#--</div>--><!-- /.col-xs-9 -->
        </div><!-- /.row -->
    </section><!-- /.content -->
</aside><!-- /.right-side -->
<#include "fragment/footer.ftl">
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
        $("#nav_content").imitClick();
        $("#column-table").treetable({ expandable: true,initialState:'expanded' });
        $("#addColumn").click(function(){
            location.href="<@spring.url '/manager/column/edit/0'/>";
        });

        function deleteColumn(columnId) {
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
        }

        $(".delete-column").click(function(){
            var columnId = $(this).data("columnid");
            deleteColumn(columnId);
        });

//        $("#thcheckbox").on('ifChecked', function(event){
//            $('.table-cb').iCheck('check');
//        });
//        $("#thcheckbox").on('ifUnchecked', function(event){
//            $('.table-cb').iCheck('uncheck');
//        });
//
//        $("#siteBatchDelete").click(function(){
//            var $chs = $(":checkbox[checked=checked]");
//            if($chs.length == 0){
//                $.v5cms.modalDialog({icon:'warning',content:"您还没有选中要操作的数据项！",width:250});
//                return;
//            }
//            var siteIds = [];
//            for(var i=0;i<$chs.length;i++){
//                var v = $($chs[i]).val();
//                if(v == "on") continue;
//                siteIds.push(v);
//            }
//            deleteSites(siteIds.join());
//        });
    });
</script>