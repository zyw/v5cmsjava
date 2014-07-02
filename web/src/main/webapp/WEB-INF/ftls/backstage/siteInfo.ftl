<#include "fragment/head.ftl">
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            站点管理
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>站点设置</li>
            <li class="active">站点管理</li>
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
                        <button id="addSite" class="btn btn-success btn-sm" data-toggle="tooltip" title="添加站点">
                            <i class="fa fa-plus"></i> 添加站点</button>
                    </div><!-- /. tools -->
                    <i class="fa fa-table"></i>
                    <h3 class="box-title">站点信息表</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="siteInfo" class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>名称</th>
                            <th>状态</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${site.tbId}</td>
                            <td>${site.siteName}</td>
                            <td>${(site.isclosesite==1)?string("正常","关闭")}</td>
                            <td>${site.createDate?string("yyyy-MM-dd")}</td>
                            <td><a href="#">修改</a> <a href="#">删除</a></td>
                        </tr>
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
        $("#siteInfo").dataTable({
            "bPaginate": false,
            "bLengthChange": false,
            "bFilter": false,
            "bInfo": false
        });
        $("#nav_siteSetting").imitClick();
        $("#addSite").click(function(){
            location.href="<@spring.url '/manager/addsite'/>";
        })
    });
</script>