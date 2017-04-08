<#include "../fragment/head.ftl">
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            广告版位
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="<@spring.url '/manager/index'/>"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>站点设置</li>
            <li><a href="<@spring.url '/manager/advpos/list'/>">广告版位</a></li>
            <li class="active">${page_title!"添加版位"}</li>
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
                        <button id="saveAdvPosForm" class="btn btn-success btn-sm" data-toggle="tooltip" title="保存">
                            <i class="fa fa-save"></i> 保存</button>
                        <button id="backAdvPosList" class="btn btn-default btn-sm" data-toggle="tooltip" title="返回">
                            <i class="fa fa-mail-forward"></i> 返回</button>
                    </div><!-- /. tools -->
                    <i class="fa fa-globe"></i>
                    <h3 class="box-title">${page_title!"添加版位"}</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <form id="advPosForm" action="<@spring.url '/manager/advpos/edit'/>" class="form-horizontal" role="form" method="POST">
                        <input type="hidden" value="${advpos.advPosId!""}" name="advPosId">
                        <div class="form-group">
                            <label for="dvPosName" class="col-sm-2 control-label">版位名称 <span style="color: #ff0000">*</span></label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="advPosName" id="advPosName"
                                       placeholder="版位名称" value="${advpos.advPosName!""}" datatype="*" nullmsg="版位名称不能为空！"/>
                                <span class="help-block">设置版位的名称，方便日后管理。</span>
                            </div>
                            <div class="col-sm-3 Validform_checktip"></div>
                        </div>
                        <div class="form-group">
                            <label for="describe" class="col-sm-2 control-label">版位描述</label>
                            <div class="col-sm-5">
                                <textarea class="form-control" name="advPosDes" id="advPosDes" rows="4">${advpos.advPosDes!""}</textarea>
                                <span class="help-block">设置版位描述信息。</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="advPosState" class="col-sm-2 control-label">版位状态</label>
                            <div class="col-sm-3">
                                <select class="form-control" id="advPosState" name="advPosState">
                                    <#if (advpos.advPosState!0) == 1>
                                        <option value="1" selected>启用</option>
                                        <option value="0">关闭</option>
                                    <#else>
                                        <option value="1">启用</option>
                                        <option value="0" selected>关闭</option>
                                    </#if>
                                </select>
                                <span class="help-block">版位状态是否可用。</span>
                            </div>
                        </div>
                    </form>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.row -->

    </section>
    <!-- /.content -->
</aside><!-- /.right-side -->
<#include "../fragment/footer.ftl">
<script type="text/javascript">
    $(function(){
        $("#nav_siteSetting").imitClick();
        $("#backAdvPosList").click(function(){
            location.href="<@spring.url '/manager/advpos/list'/>"
        });
        $("#advPosState").chosen({disable_search_threshold: 10});

        $("#advPosForm").Validform({
            ajaxPost:true,
            showAllError:true,
            tiptype:2,
            /*tiptype:function(msg,o,cssctl){
                if(!o.obj.is("form")){
                    if(o.type == 2){
                        layer.tips(msg, o.obj,{tips:[2, '#78BA32']});
                    }else{
                        layer.tips(msg, o.obj,{time:0});
                    }
                }else{
                    layer.closeAll('tips');
                }
            },*/
            callback:function(data){
                if(data.status === "1"){
                    layer.msg(data.message, {
                        icon: 1,
                        time:2000
                    },function(){
                        location.href="<@spring.url '/manager/advpos/list'/>";
                    });
                }else if(data.status === "0"){
                    layer.msg(data.message, {icon: 2});
                }else{
                    layer.msg("错误代码："+data.status+" 错误消息："+data.statusText, {icon: 2});
                }
            }
        });

        <#--
        $('#advPosForm').ajaxForm({
            dataType : 'json',
            success : function(data) {
                if(data.status == "1"){
                    $.v5cms.tooltip({icon:"succeed",content:data.message},function(){
                        location.href="<@spring.url '/manager/advpos/list'/>";
                    });
                }else{
                    $.v5cms.tooltip({icon:"error",content:data.message},function(){});
                }
            },
            error:function(xhr, status, error){
                $.v5cms.tooltip({icon:"error",content:"错误代码：" + status + " 错误消息：" + error},function(){});
            }
        });
        -->

        $("#saveAdvPosForm").click(function(){
            /*var result = $("#advPosName").nonEmpty({content:"版位名称不能为空！"});
            if(result) $("#advPosForm").submit();*/
            $("#advPosForm").submit();
        });
    });
</script>