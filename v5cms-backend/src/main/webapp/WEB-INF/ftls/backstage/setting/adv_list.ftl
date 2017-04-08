<#include "../fragment/head.ftl">
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            广告管理
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>站点设置</li>
            <li class="active">广告管理</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <!-- Small boxes (Stat box) -->
        <div class="row">
            <div class="box box-primary">
                <div class="box-header">
                    <!-- tools box -->
                    <div class="pull-right box-tools">
                        <button id="addAdv" class="btn btn-success btn-sm" data-toggle="tooltip" title="添加广告">
                            <i class="fa fa-plus"></i> 添加广告</button>
                        <button id="advBatchDelete" class="btn btn-warning btn-sm" data-toggle="tooltip" title="批量删除">
                            <i class="fa fa-trash-o"></i> 批量删除</button>
                    </div><!-- /. tools -->
                    <i class="fa fa-table"></i>
                    <h3 class="box-title">广告列表</h3>
                </div><!-- /.box-header -->
                <div class="box-body table-responsive">
                    <div class="container-fluid" style="margin-bottom: 8px;">
                        <form method="POST" action="<@spring.url '/manager/adv/list/1'/>">
                        <div class="col-xs-1 v5-text-align">
                            <label>名称</label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" name="advName"
                                   value="<#if searchAdv??>${searchAdv.advName!""}</#if>"
                                   id="advName" placeholder="名称">
                        </div>
                        <div class="col-xs-1 v5-text-align">
                            <label>版位</label>
                        </div>
                        <div class="col-xs-3">
                            <select data-placeholder="广告版位" class="form-control" id="advPosId" name="advPos.advPosId">
                            <#if aps?size != 0>
                                <option value=""></option>
                                <#list aps as ap>
                                    <option value="${ap.advPosId}"
                                    <#if searchAdv?? && searchAdv.advPos?? && (searchAdv.advPos.advPosId!0)==ap.advPosId>
                                        selected
                                    </#if>
                                            >${ap.advPosName}</option>
                                </#list>
                            <#else>
                                <option value="-1">还没有广告信息</option>
                            </#if>
                            </select>
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
                            <col class="col-xs-3">
                            <col class="col-xs-3">
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
                            <th>名称</th>
                            <th>版位</th>
                            <th>类型</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if advs.content?size != 0>
                            <#list advs.content as adv>
                            <tr>
                                <td class="td-center">
                                    <input type="checkbox" class="table-cb" value="${adv.advId}"/>
                                </td>
                                <td>${adv.advId}</td>
                                <td>${adv.advName}</td>
                                <td>${adv.advPos.advPosName}</td>
                                <td>
                                    <#switch adv.advType>
                                        <#case 1>
                                            图片
                                            <#break>
                                        <#case 2>
                                            Flash
                                            <#break>
                                        <#case 3>
                                            文字
                                            <#break>
                                        <#default>
                                            代码
                                    </#switch>
                                </td>
                                <td>
                                ${(adv.startUsing==1)?string("<small class='badge bg-green'>开启</small>",
                                "<small class='badge bg-red'>关闭</small>")}
                                </td>
                                <td>
                                    <a href="<@spring.url '/manager/adv/edit/'/>${adv.advId}" class="btn btn-primary btn-xs" data-toggle="tooltip" title="修改广告">
                                        <i class="fa fa-edit"></i>
                                    </a>&nbsp;&nbsp;
                                    <a href="javascript:;" data-advid="${adv.advId}" class="btn btn-warning btn-xs delete-adv" data-toggle="tooltip" title="删除广告">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </td>
                            </tr>
                            </#list>
                        <#else>
                        <tr>
                            <td colspan="7"><h3>还没有广告数据！</h3></td>
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
        $("#nav_siteSetting").imitClick();
        $("#advPosId").chosen({allow_single_deselect: true});
        function deleteAdvs(advIds) {
            layer.confirm('您确定要删除广告吗，删除后将不能恢复？', {icon: 3}, function(index){
                var url = "<@spring.url '/manager/adv/delete'/>";
                $.ajax({
                    dataType:'json',
                    type:'POST',
                    url:url,
                    data:{advIds:advIds},
                    success:function(data){
                        if(data.status === "1"){
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
                        layer.msg("删除广告出错，"+textStatus+"，"+errorThrown, {icon: 2});
                    }
                });
                layer.close(index);
            });
            <#--
            $.v5cms.confirm({icon:"question",content:"您确定要删除广告吗，删除后将不能恢复？",width:350,ok:function(){
                var url = "<@spring.url '/manager/adv/delete'/>";
                $.ajax({
                    dataType:'json',
                    type:'POST',
                    url:url,
                    data:{advIds:advIds},
                    success:function(data){
                        if(data.status == "1"){
                           /* $.v5cms.tooltip({icon:"succeed","content":data.message},function(){
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
                        //$.v5cms.tooltip({icon:"error","content":"删除广告出错，"+textStatus+"，"+errorThrown});
                        layer.msg("删除广告出错，"+textStatus+"，"+errorThrown, {icon: 2});
                    }
                });
            }});-->
        }

        $("#addAdv").click(function(){
            location.href="<@spring.url '/manager/adv/edit'/>";
        });

        $(".delete-adv").click(function(){
            var advId = $(this).data("advid");
            deleteAdvs(advId);
        });
        $("#thcheckbox").on('ifChecked', function(event){
            $('.table-cb').iCheck('check');
        });
        $("#thcheckbox").on('ifUnchecked', function(event){
            $('.table-cb').iCheck('uncheck');
        });

        $("#advBatchDelete").click(function(){
            var $chs = $(":checkbox:checked");
            if($chs.length == 0){
                //$.v5cms.tooltip({icon:"warning","content":"您还没有选中要操作的数据项！"},function(){});
                layer.msg("您还没有选中要操作的数据项！", {icon: 0});
                return;
            }
            var advIds = [];
            for(var i=0;i<$chs.length;i++){
                var v = $($chs[i]).val();
                if(v == "on") continue;
                advIds.push(v);
            }
            deleteAdvs(advIds.join());
        });

    });
</script>