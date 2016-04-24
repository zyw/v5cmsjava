<#include "../fragment/head.ftl">
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            用户管理
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>用户权限</li>
            <li class="active">用户管理</li>
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
                        <button id="addUser" class="btn btn-success btn-sm" data-toggle="tooltip" title="添加用户">
                            <i class="fa fa-plus"></i> 添加用户</button>
                        <button id="userBatchDelete" class="btn btn-warning btn-sm" data-toggle="tooltip" title="批量删除">
                            <i class="fa fa-trash-o"></i> 批量删除</button>
                    </div><!-- /. tools -->
                    <i class="fa fa-table"></i>
                    <h3 class="box-title">用户列表</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <div class="container-fluid" style="margin-bottom: 8px;">
                        <form method="POST" action="<@spring.url '/manager/user/list/1'/>">
                            <#--<div class="col-xs-1 v5-text-align">-->
                                <#--<label>用户名称</label>-->
                            <#--</div>-->
                            <div class="col-xs-4">
                                <input type="text" class="form-control" name="name"
                                       value="<#if searchUser??>${searchUser.name!""}</#if>"
                                       id="userName" placeholder="查询">
                            </div>
                            <div class="col-xs-4">
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
                            <col class="col-xs-1">
                            <col class="col-xs-1">
                            <col class="col-xs-1">
                            <col class="col-xs-1">
                            <col class="col-xs-1">
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
                            <th><i class="fa fa-list-ol"></i> 序号</th>
                            <th><i class="fa fa-bullhorn"></i> 名称</th>
                            <th><i class="fa fa-rocket"></i> 登录名</th>
                            <th><i class="fa fa-envelope"></i> 邮箱</th>
                            <th><i class="fa fa-female"></i> 性别</th>
                            <th><i class="fa fa-mobile-phone"></i> 电话</th>
                            <th><i class="fa fa-bookmark"></i> 登录次数</th>
                            <th><i class="fa fa-calendar"></i> 登录时间</th>
                            <th><i class="fa fa-edit"></i> 状态</th>
                            <th><i class="fa fa-gear"></i> 操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if users.content?size != 0>
                            <#list users.content as user>
                            <tr>
                                <td class="td-center">
                                    <input type="checkbox" class="table-cb" value="${user.id}"/>
                                </td>
                                <td>${user.id}</td>
                                <td>${user.name}</td>
                                <td>${user.loginname}</td>
                                <td>${user.email}</td>
                                <td>
                                    ${(user.sex == 1)?string("<i class='fa fa-male v5-man'></i>","<i class='fa fa-female v5-woman'></i>")}
                                </td>
                                <td>${user.mobilephone}</td>
                                <td>${user.loginCount}</td>
                                <td>${user.lastLoginTime}</td>
                                <td>
                                ${(user.available==1)?string("<small class='badge bg-green'>启用</small>",
                                "<small class='badge bg-red'>禁用</small>")}
                                </td>
                                <td>
                                    <a href="<@spring.url '/manager/user/edit/'/>${user.id}" class="btn btn-primary btn-xs" data-toggle="tooltip" title="修改用户">
                                        <i class="fa fa-edit"></i>
                                    </a>&nbsp;&nbsp;
                                    <a href="javascript:;" data-userid="${user.id}" class="btn btn-warning btn-xs deleteUser" data-toggle="tooltip" title="删除用户">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </td>
                            </tr>
                            </#list>
                        <#else>
                        <tr>
                            <td colspan="11" class="text-center"><h3>还没有用户数据！</h3></td>
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
        $("#addUser").click(function(){
            location.href="<@spring.url '/manager/user/edit/0'/>";
        });
        $("#thcheckbox").on('ifChecked', function(event){
            $('.table-cb').iCheck('check');
        });
        $("#thcheckbox").on('ifUnchecked', function(event){
            $('.table-cb').iCheck('uncheck');
        });
       function deleteUser(userIds) {
             $.v5cms.confirm({icon:"question",content:"您确定要删除用户吗，删除后将不能恢复？",width:350,ok:function(){
                 var url = "<@spring.url '/manager/coltype/delete'/>";
                 $.ajax({
                     dataType:'json',
                     type:'POST',
                     url:url,
                     data:{userIds:userIds},
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
                         layer.msg("删除用户信息出错，"+textStatus+"，"+errorThrown, {icon: 2});
                     }
                 });
            }});
        }

        $(".deleteUser").click(function(){
            var userId = $(this).data("userid");
            deleteUser(userId);
        });

        $("#userBatchDelete").click(function(){
            var $chs = $(":checkbox:checked");
            if($chs.length == 0){
                layer.msg("您还没有选中要操作的数据项！", {icon: 0});
                return;
            }
            var userIds = [];
            for(var i=0;i<$chs.length;i++){
                var v = $($chs[i]).val();
                if(v == "on") continue;
                userIds.push(v);
            }
            deleteUser(userIds.join());
        });
    });
</script>