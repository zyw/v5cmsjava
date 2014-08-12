<#include "fragment/head.ftl">
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            栏目类型
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="<@spring.url '/manager/index'/>"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>栏目管理</li>
            <li><a href="<@spring.url '/manager/coltypelist'/>">栏目类型</a></li>
            <li class="active">${page_title!"添加栏目类型"}</li>
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
                    <h3 class="box-title">${page_title!"添加栏目类型"}</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <form id="advPosForm" action="<@spring.url '/manager/advposau'/>" class="form-horizontal" role="form" method="POST">
                        <input type="hidden" value="" name="advPosId">
                        <div class="form-group">
                            <label for="dvPosName" class="col-sm-2 control-label">版位名称 <span style="color: #ff0000">*</span></label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="advPosName" id="advPosName"
                                       placeholder="版位名称" value="">
                                <span class="help-block">设置版位的名称，方便日后管理。</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="describe" class="col-sm-2 control-label">版位描述</label>
                            <div class="col-sm-5">
                                <textarea class="form-control" name="advPosDes" id="advPosDes" rows="4"></textarea>
                                <span class="help-block">设置版位描述信息。</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="advPosState" class="col-sm-2 control-label">版位状态</label>
                            <div class="col-sm-3">
                                <select class="form-control" id="advPosState" name="advPosState">
                                    <option value="1" selected>启用</option
                                    <#--<#if (advpos.advPosState!0) == 1>-->
                                        <#--<option value="1" selected>启用</option>-->
                                        <#--<option value="0">关闭</option>-->
                                    <#--<#else>-->
                                        <#--<option value="1">启用</option>-->
                                        <#--<option value="0" selected>关闭</option>-->
                                    <#--</#if>-->
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
<#include "fragment/footer.ftl">
<script type="text/javascript">
    $(function(){
        $("#nav_columns").imitClick();
        <#--$("#backAdvPosList").click(function(){-->
            <#--location.href="<@spring.url '/manager/advposlist'/>"-->
        <#--});-->
        <#--$("#advPosState").chosen({disable_search_threshold: 10});-->
        <#--$('#advPosForm').ajaxForm({-->
            <#--dataType : 'json',-->
            <#--success : function(data) {-->
                <#--if(data.status == "1"){-->
                    <#--$.v5cms.tooltip({icon:"succeed",content:data.message},function(){-->
                        <#--location.href="<@spring.url '/manager/advposlist'/>";-->
                    <#--});-->
                <#--}else{-->
                    <#--$.v5cms.tooltip({icon:"error",content:data.message},function(){});-->
                <#--}-->
            <#--}-->
        <#--});-->

        <#--$("#saveAdvPosForm").click(function(){-->
            <#--var result = $("#advPosName").nonEmpty({content:"版位名称不能为空！"});-->
            <#--if(result) $("#advPosForm").submit();-->
        <#--});-->
    });
</script>