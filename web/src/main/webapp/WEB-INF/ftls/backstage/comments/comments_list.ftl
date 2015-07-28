<#include "../fragment/head.ftl">
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            评论管理
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>评论管理</li>
            <li class="active">评论列表</li>
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
                        <button id="review" class="btn btn-success btn-sm" data-toggle="tooltip" title="评审">
                            <i class="fa fa-eye"></i> 评审</button>
                        <button id="unreview" class="btn btn-success btn-sm" data-toggle="tooltip" title="取消评审">
                            <i class="fa fa-eye-slash"></i> 取消评审</button>
                        <button id="commentBatchDelete" class="btn btn-warning btn-sm" data-toggle="tooltip" title="批量删除">
                            <i class="fa fa-trash-o"></i> 批量删除</button>
                    </div><!-- /. tools -->
                    <i class="fa fa-table"></i>
                    <h3 class="box-title">评论列表</h3>
                </div><!-- /.box-header -->
                <div class="box-body table-responsive">
                    <div class="container-fluid" style="margin-bottom: 8px;">
                        <form method="POST" action="<@spring.url '/manager/comment/list/1'/>">
                            <div class="col-xs-4">
                                <input type="text" class="form-control" name="commentContent"
                                       value="<#if searchComments??>${searchComments.commentContent!""}</#if>"
                                       id="commentContent" placeholder="查询">
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
                            <col class="col-xs-1">
                            <col class="col-xs-1">
                            <col class="col-xs-2">
                        </colgroup>
                        <thead>
                        <tr>
                            <th class="td-center">
                                <input type="checkbox" id="thcheckbox" value="on"/>
                            </th>
                            <th>序号</th>
                            <th>评论</th>
                            <th>所属内容</th>
                            <th>评论作者</th>
                            <th>发表时间</th>
                            <th>发表IP</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if comments?size != 0>
                            <#list comments as comment>
                            <tr>
                                <td class="td-center">
                                    <input type="checkbox" class="table-cb" value="${comment.commentsId}"/>
                                </td>
                                <td>${comment.commentsId}</td>
                                <td>${comment.commentContent}</td>
                                <td>${comment.content.cname}</td>
                                <td>${comment.commentAuthor}</td>
                                <td>${comment.commentDate}</td>
                                <td>${comment.commentIP}</td>
                                <td>
                                    <#switch comment.commentApproved>
                                        <#case 0>
                                            <small class='badge bg-red'>待审核</small>
                                            <#break>
                                        <#case 1>
                                            <small class='badge bg-green'>通过</small>
                                            <#break>
                                        <#default>
                                            <small class='badge bg-yellow'>垃圾评论</small>
                                    </#switch>
                                </td>
                                <td>
                                    <a href="<@spring.url '/manager/comment/edit/${comment.commentsId}'/>" class="btn btn-primary btn-xs" data-toggle="tooltip" title="修改链接">
                                        <i class="fa fa-edit"></i>
                                    </a>&nbsp;&nbsp;
                                    <a href="javascript:;" data-commentid="${comment.commentsId}" class="btn btn-warning btn-xs delete-comment" data-toggle="tooltip" title="删除链接">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </td>
                            </tr>
                            </#list>
                        <#else>
                            <tr>
                                <td colspan="9" class="text-center"><h3>还没有评论数据！</h3></td>
                            </tr>
                        </#if>
                        </tbody>
                    </table>
                </div><!-- /.box-body -->
                <div class="box-footer clearfix">
                <#if comments?size != 0>
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
        $("#nav_content").imitClick();

        $("#review").click(function(){
            <#--
            location.href="<@spring.url '/manager/comment/edit/0'/>";
            -->
        });

        $("#unreview").click(function(){

        });

        function deleteComments(commentIds) {
            layer.confirm('您确定要删除评论信息吗，删除后将不能恢复？', {icon: 3}, function(index){
                var url = "<@spring.url '/manager/comment/delete'/>";
                $.ajax({
                    dataType:'json',
                    type:'POST',
                    url:url,
                    data:{commentIds:commentIds},
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
                        layer.msg("删除评论出错，"+textStatus+"，"+errorThrown, {icon: 2});
                    }
                });
            });
        }

        $(".delete-comment").click(function(){
            var commentId = $(this).data("commentid");
            deleteComments(commentId);
        });

        $("#thcheckbox").on('ifChecked', function(event){
            $('.table-cb').iCheck('check');
        });
        $("#thcheckbox").on('ifUnchecked', function(event){
            $('.table-cb').iCheck('uncheck');
        });

        $("#commentBatchDelete").click(function(){
            var $chs = $(":checkbox:checked");
            if($chs.length == 0){
                layer.msg("您还没有选中要操作的数据项！", {icon: 0});
                return;
            }
            var commentIds = [];
            for(var i=0;i<$chs.length;i++){
                var v = $($chs[i]).val();
                if(v == "on") continue;
                commentIds.push(v);
            }
            deleteComments(commentIds.join());
        });
    });
</script>