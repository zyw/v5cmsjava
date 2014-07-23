<#include "fragment/head.ftl">
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            广告版位
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>站点设置</li>
            <li class="active">广告版位</li>
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
                        <button id="addAdvPos" class="btn btn-success btn-sm" data-toggle="tooltip" title="添加版位">
                            <i class="fa fa-plus"></i> 添加版位</button>
                        <button id="siteBatchDelete" class="btn btn-warning btn-sm" data-toggle="tooltip" title="批量删除">
                            <i class="fa fa-plus"></i> 批量删除</button>
                    </div><!-- /. tools -->
                    <i class="fa fa-table"></i>
                    <h3 class="box-title">广告版位表</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table class="table table-hover table-bordered table-striped">
                        <colgroup>
                            <col class="col-xs-1">
                            <col class="col-xs-2">
                            <col class="col-xs-3">
                            <col class="col-xs-2">
                            <col class="col-xs-2">
                        </colgroup>
                        <thead>
                        <tr>
                            <th class="td-center">
                                <input type="checkbox" id="thcheckbox"/>
                            </th>
                            <th>序号</th>
                            <th>名称</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if advposs?size != 0>
                            <#list advposs as advpos>
                            <tr>
                                <td class="td-center">
                                    <input type="checkbox" class="table-cb" value="${advpos.advPosId}"/>
                                </td>
                                <td>${advpos.advPosId}</td>
                                <td>${advpos.advPosName}</td>
                                <td>
                                ${(advpos.advPosState==1)?string("<small class='badge bg-green'>开启</small>",
                                "<small class='badge bg-red'>关闭</small>")}
                                </td>
                                <td>
                                    <a href="<@spring.url '/manager/updatesite/${advpos.advPosId}'/>">修改</a>&nbsp;&nbsp;
                                    <a href="javascript:;" class="deletesite" data-siteid="${advpos.advPosId}">删除</a>
                                </td>
                            </tr>
                            </#list>
                        <#else>
                        <tr>
                            <td colspan="4"><h3>还没有站点数据！</h3></td>
                        </tr>
                        </#if>
                        </tbody>
                    </table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.row -->

    </section>
    <!-- /.content -->
</aside><!-- /.right-side -->
<#include "fragment/footer.ftl">
<script type="text/javascript">
    $(function(){
        $("#nav_siteSetting").imitClick();

        $("#addAdvPos").click(function(){
            location.href="<@spring.url '/manager/advposaup'/>";
        });
    });
</script>