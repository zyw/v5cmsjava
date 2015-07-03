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
            <li>用户权限</li>
            <li class="active">资源管理</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <!-- Small boxes (Stat box) -->
        <div class="row">
            <div class="box box-info">
                <div class="box-header">
                    <!-- tools box -->
                    <div class="pull-right box-tools">
                        <button id="addRes" class="btn btn-success btn-sm" data-toggle="tooltip" title="添加资源">
                            <i class="fa fa-plus"></i> 添加资源</button>
                        <#--<button id="columnBatchDelete" class="btn btn-warning btn-sm" data-toggle="tooltip" title="批量删除">
                            <i class="fa fa-trash-o"></i> 批量删除</button>-->
                    </div><!-- /. tools -->
                    <i class="fa fa-table"></i>
                    <h3 class="box-title">资源列表</h3>
                </div><!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="res-table" class="table-striped table-advance table-hover">
                        <colgroup>
                            <col class="col-xs-2">
                            <col class="col-xs-1">
                            <col class="col-xs-1">
                            <col class="col-xs-1">
                            <col class="col-xs-1">
                            <col class="col-xs-1">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>名称</th>
                            <th>类型</th>
                            <th>URL</th>
                            <th>权限字符串</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if reses?size != 0>
                        <#list reses as res>
                            <tr data-tt-id="${res.id }" <#if res.pid != 0>data-tt-parent-id="${res.pid }"</#if>>
                            <td>${res.name!""}</td>
                            <td>${res.type!0}</td>
                            <td>${res.url!""}</td>
                            <td>${res.permission!""}</td>
                            <td>
                                <#if res.available == 1>
                                    <span class="badge bg-green">可用</span>
                                <#else>
                                    <span class="badge bg-red">不可用</span>
                                </#if>
                            </td>
                            <td>
                                <#if res.type == 1>
                                    <a href="<@spring.url '/manager/res/edit/${res.id}'/>" class="btn btn-success btn-xs" data-toggle="tooltip" title="添加资源">
                                        <i class="fa fa-plus"></i>
                                    </a>&nbsp;
                                </#if>
                                <a href="<@spring.url '/manager/res/${res.id}/update'/>" class="btn btn-primary btn-xs" data-toggle="tooltip" title="修改资源">
                                    <i class="fa fa-edit"></i>
                                </a>&nbsp;
                                <a href="javascript:;" data-resid="${res.id}" class="btn btn-warning btn-xs delete-res" data-toggle="tooltip" title="删除资源">
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
        </div><!-- /.row -->
    </section><!-- /.content -->
</aside><!-- /.right-side -->
<#include "../fragment/footer.ftl">
<script type="text/javascript">
    $(function(){
        $("#user_auth").imitClick();
        $("#res-table").treetable({ expandable: true,initialState:'expanded' });
        $("#addRes").click(function(){
            location.href="<@spring.url '/manager/column/edit/0'/>";
        });

        function deleteRes(resid) {
            $.v5cms.confirm({icon:"question",content:"您确定要删除资源信息吗，删除后将不能恢复？",width:350,ok:function(){
                var url = "<@spring.url '/manager/column/delete'/>";
                $.ajax({
                    dataType:'json',
                    type:'POST',
                    url:url,
                    data:{columnId:resid},
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
                        $.v5cms.tooltip({icon:"error","content":"删除资源信息出错，"+textStatus+"，"+errorThrown});
                    }
                });
            }});
        }

        $(".delete-res").click(function(){
            var resid = $(this).data("resid");
            deleteRes(resid);
        });
    });
</script>