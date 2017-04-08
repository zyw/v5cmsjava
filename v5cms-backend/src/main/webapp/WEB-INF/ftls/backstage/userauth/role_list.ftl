<#include "../fragment/head.ftl">
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            角色管理
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>用户权限</li>
            <li class="active">角色管理</li>
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
                        <button id="addRole" class="btn btn-success btn-sm" data-toggle="tooltip" title="添加角色">
                            <i class="fa fa-plus"></i> 添加角色</button>
                        <button id="roleBatchDelete" class="btn btn-warning btn-sm" data-toggle="tooltip" title="批量删除">
                            <i class="fa fa-trash-o"></i> 批量删除</button>
                    </div><!-- /. tools -->
                    <i class="fa fa-table"></i>
                    <h3 class="box-title">角色列表</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <div class="container-fluid" style="margin-bottom: 8px;">
                        <form method="POST" action="<@spring.url '/manager/role/list/1'/>">
                            <div class="col-xs-4">
                                <input type="text" class="form-control" name="name"
                                       value="<#if searchRole??>${searchRole.name!""}</#if>"
                                       id="roleName" placeholder="查询">
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
                            <col class="col-xs-2">
                            <col class="col-xs-1">
                            <col class="col-xs-1">
                            <col class="col-xs-2">
                        </colgroup>
                        <thead>
                        <tr>
                            <th class="td-center">
                                <input type="checkbox" id="thcheckbox" value="on"/>
                            </th>
                            <th><i class="fa fa-list-ol"></i> 序号</th>
                            <th><i class="fa fa-bullhorn"></i> 名称</th>
                            <th><i class="fa fa-question-circle"></i> 描述</th>
                            <th><i class="fa fa-bookmark"></i> 排序</th>
                            <th><i class="fa fa-edit"></i> 状态</th>
                            <th><i class="fa fa-gear"></i> 操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if roles.content?size != 0>
                            <#list roles.content as role>
                            <tr>
                                <td class="td-center">
                                    <input type="checkbox" class="table-cb" value="${role.id}"/>
                                </td>
                                <td>${role.id}</td>
                                <td>${role.name}</td>
                                <td>${role.des!""}</td>
                                <td>${role.sortNum!"0"}</td>
                                <td>
                                ${(role.available==1)?string("<small class='badge bg-green'>启用</small>",
                                "<small class='badge bg-red'>禁用</small>")}
                                </td>
                                <td>
                                    <a href="<@spring.url '/manager/role/edit/'/>${role.id}" class="btn btn-primary btn-xs" data-toggle="tooltip" title="修改角色">
                                        <i class="fa fa-edit"></i>
                                    </a>&nbsp;&nbsp;
                                    <a href="javascript:;" data-roleid="${role.id}" class="btn btn-warning btn-xs deleteRole" data-toggle="tooltip" title="删除角色">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </td>
                            </tr>
                            </#list>
                        <#else>
                        <tr>
                            <td colspan="8" class="text-center"><h3>还没有角色数据！</h3></td>
                        </tr>
                        </#if>
                        </tbody>
                    </table>
                </div><!-- /.box-body -->
                <div class="box-footer clearfix">
                    ${pagination}
                </div>
            </div><!-- /.box -->
        </div><!-- /.row -->
    </section><!-- /.content -->
</aside><!-- /.right-side -->
<#include "../fragment/footer.ftl">
<script type="text/javascript">
    $(function(){
        $("#user_auth").imitClick();
        $("#addRole").click(function(){
            location.href="<@spring.url '/manager/role/edit'/>";
        });
        $("#thcheckbox").on('ifChecked', function(event){
            $('.table-cb').iCheck('check');
        });
        $("#thcheckbox").on('ifUnchecked', function(event){
            $('.table-cb').iCheck('uncheck');
        });
        function deleteRole(roleIds) {
            layer.confirm('您确定要删除角色信息吗，删除后将不能恢复？', {icon: 3}, function(index){
                var url = "<@spring.url '/manager/coltype/delete'/>";
                $.ajax({
                 dataType:'json',
                 type:'POST',
                 url:url,
                 data:{roleIds:roleIds},
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
                     layer.msg("删除角色出错，"+textStatus+"，"+errorThrown, {icon: 2});
                 }
                });
            });
        }

        $(".deleteRole").click(function(){
            var roleId = $(this).data("roleid");
            deleteRole(roleId);
        });

        $("#roleBatchDelete").click(function(){
            var $chs = $(":checkbox:checked");
            if($chs.length == 0){
                layer.msg("您还没有选中要操作的数据项！", {icon: 0});
                return;
            }
            var roleIds = [];
            for(var i=0;i<$chs.length;i++){
                var v = $($chs[i]).val();
                if(v == "on") continue;
                roleIds.push(v);
            }
            deleteRole(roleIds.join());
        });
    });
</script>