<#include "../fragment/head.ftl">
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Banner管理
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>站点设置</li>
            <li class="active">Banner管理</li>
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
                        <button id="addBanner" class="btn btn-success btn-sm" data-toggle="tooltip" title="添加Banner">
                            <i class="fa fa-plus"></i> 添加Banner</button>
                        <button id="bannerBatchDelete" class="btn btn-warning btn-sm" data-toggle="tooltip" title="批量删除">
                            <i class="fa fa-trash-o"></i> 批量删除</button>
                    </div><!-- /. tools -->
                    <i class="fa fa-table"></i>
                    <h3 class="box-title">Banner列表</h3>
                </div><!-- /.box-header -->
                <div class="box-body table-responsive">
                    <div class="container-fluid" style="margin-bottom: 8px;">
                        <form method="POST" action="<@spring.url '/manager/banner/list/1'/>">
                            <div class="col-xs-4">
                                <input type="text" class="form-control" name="bannerName"
                                       value="<#if searchBanner??>${searchBanner.bannerName!""}</#if>"
                                       id="bannerName" placeholder="查询">
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
                            <th>序号</th>
                            <th>Banner名称</th>
                            <th>Banner图片</th>
                            <th>Banner内容</th>
                            <th>排序</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if banners?size != 0>
                            <#list banners as banner>
                            <tr>
                                <td class="td-center">
                                    <input type="checkbox" class="table-cb" value="${banner.bannerId}"/>
                                </td>
                                <td>${banner.bannerId}</td>
                                <td>${banner.bannerName}</td>
                                <td>${banner.bannerPic}</td>
                                <td>
                                    <#if (banner.bcontent?html?length) gt 60>
                                        ${banner.bcontent?html?substring(0,60)}...
                                    <#else>
                                        ${banner.bcontent?html}
                                    </#if>
                                </td>
                                <td>${banner.bannerds}</td>
                                <td>
                                    ${(banner.isstart==1)?string("<small class='badge bg-green'>启用</small>",
                                    "<small class='badge bg-red'>禁用</small>")}
                                </td>
                                <td>
                                    <a href="<@spring.url '/manager/banner/edit/${banner.bannerId}'/>" class="btn btn-primary btn-xs" data-toggle="tooltip" title="修改Banner">
                                        <i class="fa fa-edit"></i>
                                    </a>&nbsp;&nbsp;
                                    <a href="javascript:;" data-bannerid="${banner.bannerId}" class="btn btn-warning btn-xs delete-banner" data-toggle="tooltip" title="删除Banner">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </td>
                            </tr>
                            </#list>
                        <#else>
                            <tr>
                                <td colspan="8" class="text-center"><h3>还没有Banner数据！</h3></td>
                            </tr>
                        </#if>
                        </tbody>
                    </table>
                </div><!-- /.box-body -->
                <div class="box-footer clearfix">
                <#if banners?size != 0>
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
        $("#nav_siteSetting").imitClick();
        $("#addBanner").click(function(){
            location.href="<@spring.url '/manager/banner/edit/0'/>";
        });

        function deleteBanners(bannerIds) {
            layer.confirm('您确定要删除Banner信息吗，删除后将不能恢复？', {icon: 3}, function(index){
                var url = "<@spring.url '/manager/banner/delete'/>";
                $.ajax({
                    dataType:'json',
                    type:'POST',
                    url:url,
                    data:{bannerIds:bannerIds},
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
                        layer.msg("删除Banner出错，"+textStatus+"，"+errorThrown, {icon: 2});
                    }
                });
            });
        }

        $(".delete-banner").click(function(){
            var bannerId = $(this).data("bannerid");
            deleteBanners(bannerId);
        });

        $("#thcheckbox").on('ifChecked', function(event){
            $('.table-cb').iCheck('check');
        });
        $("#thcheckbox").on('ifUnchecked', function(event){
            $('.table-cb').iCheck('uncheck');
        });

        $("#bannerBatchDelete").click(function(){
            var $chs = $(":checkbox:checked");
            if($chs.length == 0){
                layer.msg("您还没有选中要操作的数据项！", {icon: 0});
                return;
            }
            var bannerIds = [];
            for(var i=0;i<$chs.length;i++){
                var v = $($chs[i]).val();
                if(v == "on") continue;
                bannerIds.push(v);
            }
            deleteBanners(bannerIds.join());
        });
    });
</script>