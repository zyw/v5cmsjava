<#include "../fragment/head.ftl">
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            栏目类型
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>栏目管理</li>
            <li class="active">栏目类型</li>
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
                        <button id="addColType" class="btn btn-success btn-sm" data-toggle="tooltip" title="添加栏目类型">
                            <i class="fa fa-plus"></i> 添加栏目类型</button>
                        <button id="colTypeBatchDelete" class="btn btn-warning btn-sm" data-toggle="tooltip" title="批量删除">
                            <i class="fa fa-trash-o"></i> 批量删除</button>
                    </div><!-- /. tools -->
                    <i class="fa fa-table"></i>
                    <h3 class="box-title">栏目类型列表</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <div class="container-fluid" style="margin-bottom: 8px;">
                        <form method="POST" action="<@spring.url '/manager/adv/list/1'/>">
                            <div class="col-xs-1 v5-text-align">
                                <label>类型名称</label>
                            </div>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" name="colTypeName"
                                       value="<#if searchAdv??>${searchAdv.advName!""}</#if>"
                                       id="colTypeName" placeholder="类型名称">
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
                            <col class="col-xs-2">
                            <col class="col-xs-2">
                            <col class="col-xs-2">
                            <col class="col-xs-1">
                            <col class="col-xs-1">
                            <col class="col-xs-1">
                        </colgroup>
                        <thead>
                        <tr>
                            <th class="td-center">
                                <input type="checkbox" id="thcheckbox" value="on"/>
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
                        <#if cts?size != 0>
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
                                    <a href="<@spring.url '/manager/coltype/edit/'/>${ct.colTypeId}" class="btn btn-primary btn-xs" data-toggle="tooltip" title="修改栏目类型">
                                        <i class="fa fa-edit"></i>
                                    </a>&nbsp;&nbsp;
                                    <a href="javascript:;" data-ctid="${ct.colTypeId}" class="btn btn-warning btn-xs delete-coltype" data-toggle="tooltip" title="删除栏目类型">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </td>
                            </tr>
                            </#list>
                        <#else>
                        <tr>
                            <td colspan="8"><h3>还没有栏目类型数据！</h3></td>
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
        $("#nav_columns").imitClick();
        $("#addColType").click(function(){
            location.href="<@spring.url '/manager/coltype/edit/0'/>";
        });
        $("#thcheckbox").on('ifChecked', function(event){
            $('.table-cb').iCheck('check');
        });
        $("#thcheckbox").on('ifUnchecked', function(event){
            $('.table-cb').iCheck('uncheck');
        });
       function deleteColType(ctIds) {
           layer.confirm('您确定要删除栏目类型吗，删除后将不能恢复？', {icon: 3}, function(index){
               var url = "<@spring.url '/manager/coltype/delete'/>";
               $.ajax({
                   dataType:'json',
                   type:'POST',
                   url:url,
                   data:{colTypeIds:ctIds},
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
         $.v5cms.confirm({icon:"question",content:"您确定要删除栏目类型吗，删除后将不能恢复？",width:350,ok:function(){
             var url = "<@spring.url '/manager/coltype/delete'/>";
             $.ajax({
                 dataType:'json',
                 type:'POST',
                 url:url,
                 data:{colTypeIds:ctIds},
                 success:function(data){
                     if(data.status == "1"){
                         /*$.v5cms.tooltip({icon:"succeed","content":data.message},function(){
                             location.reload();
                         });*/
                         layer.msg(data.message, {
                             icon: 1,
                             time:2000
                         },function(){
                             location.reload();
                         });
                     }else{
                         //$.v5cms.tooltip({icon:"error","content":data.message},function(){});
                         layer.msg(data.message, {icon: 2});
                     }
                 },
                 error:function(XMLHttpRequest, textStatus, errorThrown){
                     //$.v5cms.tooltip({icon:"error","content":"删除栏目类型信息出错，"+textStatus+"，"+errorThrown});
                     layer.msg("删除栏目类型信息出错，"+textStatus+"，"+errorThrown, {icon: 2});
                 }
             });
            }});
            -->
        }

        $(".delete-coltype").click(function(){
            var colTypeId = $(this).data("ctid");
            deleteColType(colTypeId);
        });

        $("#colTypeBatchDelete").click(function(){
            var $chs = $(":checkbox:checked");
            if($chs.length == 0){
                //$.v5cms.tooltip({icon:"warning","content":"您还没有选中要操作的数据项！"},function(){});
                layer.msg("您还没有选中要操作的数据项！", {icon: 0});
                return;
            }
            var colTypeIds = [];
            for(var i=0;i<$chs.length;i++){
                var v = $($chs[i]).val();
                if(v == "on") continue;
                colTypeIds.push(v);
            }
            deleteColType(colTypeIds.join());
        });
    });
</script>