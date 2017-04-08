<#include "../fragment/head.ftl">
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            留言管理
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>留言管理</li>
            <li class="active">留言类型</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <!-- Small boxes (Stat box) -->
        <div class="row">
            <div class="box box-danger">
                <div class="box-header">
                    <!-- tools box -->
                    <div class="pull-right box-tools">
                        <button id="addLwt" class="btn btn-success btn-sm" data-toggle="tooltip" title="添加留言类型">
                            <i class="fa fa-plus"></i> 添加留言类型</button>
                        <button id="lwtBatchDelete" class="btn btn-warning btn-sm" data-toggle="tooltip" title="批量删除">
                            <i class="fa fa-trash-o"></i> 批量删除</button>
                    </div><!-- /. tools -->
                    <i class="fa fa-table"></i>
                    <h3 class="box-title">留言类型列表</h3>
                </div><!-- /.box-header -->
                <div class="box-body table-responsive">
                    <div class="container-fluid" style="margin-bottom: 8px;">
                        <form method="POST" action="<@spring.url '/manager/lwt/list/1'/>">
                            <div class="col-xs-4">
                                <input type="text" class="form-control" name="name"
                                       value="<#if searchLwt??>${searchLwt.name!""}</#if>"
                                       id="name" placeholder="查询">
                            </div>
                            <div class="col-xs-2">
                                <button type="submit" class="btn btn-success">
                                    <i class="fa fa-search"></i>
                                    查询
                                </button>
                            </div>
                        </form>
                    </div>
                    <table class="table table-hover table-bordered table-striped">
                        <colgroup>
                            <col class="col-xs-1 v5-col-xs-1">
                            <col class="col-xs-1">
                            <col class="col-xs-2">
                            <col class="col-xs-1">
                            <col class="col-xs-2">
                        </colgroup>
                        <thead>
                        <tr>
                            <th class="td-center">
                                <input type="checkbox" id="thcheckbox" value="on"/>
                            </th>
                            <th>序号</th>
                            <th>名称</th>
                            <th>排序</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if lwts?size != 0>
                            <#list lwts as lwt>
                            <tr>
                                <td class="td-center">
                                    <input type="checkbox" class="table-cb" value="${lwt.id}"/>
                                </td>
                                <td>${lwt.id}</td>
                                <td>${lwt.name}</td>
                                <td>${lwt.sortNum}</td>
                                <td>
                                    <a href="<@spring.url '/manager/lwt/edit/${lwt.id}'/>" class="btn btn-primary btn-xs" data-toggle="tooltip" title="修改链接">
                                        <i class="fa fa-edit"></i>
                                    </a>&nbsp;&nbsp;
                                    <a href="javascript:;" data-lwtid="${lwt.id}" class="btn btn-warning btn-xs delete-lwt" data-toggle="tooltip" title="删除链接">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </td>
                            </tr>
                            </#list>
                        <#else>
                            <tr>
                                <td colspan="5" class="text-center"><h3>还没有留言类型数据！</h3></td>
                            </tr>
                        </#if>
                        </tbody>
                    </table>
                </div><!-- /.box-body -->
                <div class="box-footer clearfix">
                <#if lwts?size != 0>
                    ${pagination}
                </#if>
                </div>
            </div><!-- /.box -->
        </div><!-- /.row -->
    </section><!-- /.content -->
</aside><!-- /.right-side -->
<#include "../fragment/footer.ftl">
<script type="text/javascript">
    $(function(){
        $("#nav_lw").imitClick();

        $("#addLwt").click(function(){
            location.href="<@spring.url '/manager/lwt/edit/0'/>";
        });

        function deleteLwts(lwtIds) {
            layer.confirm('您确定要删除留言类型信息吗，删除后将不能恢复？', {icon: 3}, function(index){
                var url = "<@spring.url '/manager/link/delete'/>";
                $.ajax({
                    dataType:'json',
                    type:'POST',
                    url:url,
                    data:{lwtIds:lwtIds},
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
                        layer.msg("删除留言类型出错，"+textStatus+"，"+errorThrown, {icon: 2});
                    }
                });
            });
        }

        $(".delete-lwt").click(function(){
            var lwtId = $(this).data("lwtid");
            deleteLwts(lwtId);
        });

        $("#thcheckbox").on('ifChecked', function(event){
            $('.table-cb').iCheck('check');
        });
        $("#thcheckbox").on('ifUnchecked', function(event){
            $('.table-cb').iCheck('uncheck');
        });

        $("#lwtBatchDelete").click(function(){
            var $chs = $(":checkbox:checked");
            if($chs.length == 0){
                layer.msg("您还没有选中要操作的数据项！", {icon: 0});
                return;
            }
            var lwtIds = [];
            for(var i=0;i<$chs.length;i++){
                var v = $($chs[i]).val();
                if(v == "on") continue;
                lwtIds.push(v);
            }
            deleteLwts(lwtIds.join());
        });
    });
</script>