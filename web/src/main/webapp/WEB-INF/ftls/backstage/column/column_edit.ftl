<#include "../fragment/head.ftl">
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            栏目
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="<@spring.url '/manager/index'/>"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>栏目管理</li>
            <li><a href="<@spring.url '/manager/column/list'/>">栏目</a></li>
            <li class="active">${page_title!"添加栏目"}</li>
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
                        <button id="saveColumnButton" class="btn btn-success btn-sm" data-toggle="tooltip" title="保存">
                            <i class="fa fa-save"></i> 保存</button>
                        <button id="backColumnList" class="btn btn-default btn-sm" data-toggle="tooltip" title="返回">
                            <i class="fa fa-mail-forward"></i> 返回</button>
                    </div><!-- /. tools -->
                    <i class="fa fa-globe"></i>
                    <h3 class="box-title">${page_title!"添加栏目"}</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <form id="columnForm" action="<@spring.url '/manager/column/edit'/>" class="form-horizontal" role="form" method="POST">
                        <input type="hidden" value="${column.colsId!""}" name="colsId">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">父栏目</label>
                            <div class="col-sm-4">
                                <input type="hidden" name="parentId" value="${column.parentId!0}">
                                <input type="hidden" name="parentIds" value="${column.parentIds!""}">
                                <input type="hidden" name="siteId" value="${column.siteId!0}">
                                <input type="text" class="form-control" value="${parentName!""}" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="columnName" class="col-sm-2 control-label">栏目名称 <span style="color: #ff0000">*</span></label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="columnName" id="columnName"
                                       placeholder="栏目名称" value="${column.columnName!""}" datatype="*" nullmsg="栏目名称不能为空！">
                                <span class="help-block">设置版位的名称，方便日后管理。</span>
                            </div>
                            <div class="col-sm-3 Validform_checktip"></div>
                        </div>
                        <div class="form-group">
                            <label for="coltpl" class="col-sm-2 control-label">栏目类型</label>
                            <div class="col-sm-4">
                                <select class="form-control" id="colTypeId" name="columnType.colTypeId">
                                <#list colTypes as colType>
                                    <option value="${colType.colTypeId!0}" <#if column?? && column.columnType?? && column.columnType.colTypeId == colType.colTypeId>selected</#if>>${colType.colTypeName!""}</option>
                                </#list>
                                </select>
                                <span class="help-block">为栏目选择类型。</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sortNum" class="col-sm-2 control-label">显示顺序</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="sortNum" id="sortNum"
                                       placeholder="显示顺序" value="${column.sortNum!0}" datatype="n" errormsg="显示顺序必须为数字！">
                                <span class="help-block">栏目的显示顺序越小越靠前。</span>
                            </div>
                            <div class="col-sm-3 Validform_checktip"></div>
                        </div>
                        <div class="form-group">
                            <label for="openWay" class="col-sm-2 control-label">打开方式</label>
                            <div class="col-sm-4">
                                <select class="form-control" id="openWay" name="openWay">
                                    <option value="_self" <#if (column.openWay!"") == "" || (column.openWay!"") == "_self">selected</#if>>当前窗口</option>
                                    <option value="_blank" <#if (column.openWay!"") == "_blank">selected</#if>>新窗口</option>
                                </select>
                                <span class="help-block">栏目的打开方式，本页打开或者新窗口打开。</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="columnpic" class="col-sm-2 control-label">栏目图标</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="columnpic" id="columnpic"
                                       placeholder="栏目图标" value="${column.columnpic!''}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="columnOutside" class="col-sm-2 control-label">外链地址</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="columnOutside" id="columnOutside"
                                       placeholder="外链地址" value="${column.columnOutside!''}" ignore="ignore" datatype="url" errormsg="外链地址格式不正确！">
                                <span class="help-block">连接到其他站点。</span>
                            </div>
                            <div class="col-sm-3 Validform_checktip"></div>
                        </div>
                        <div class="form-group">
                            <label for="isDisabled" class="col-sm-2 control-label">栏目状态</label>
                            <div class="col-sm-3">
                                <label class="checkbox-inline" style="padding-left:0;">
                                    <input type="radio" name="columndisplay" value="1" id="columndisplay1"
                                           <#if column.columndisplay==1>checked</#if>>
                                    <label for="columndisplay1">可用</label>
                                    &nbsp;&nbsp;
                                    <input type="radio" name="columndisplay" value="0" id="columndisplay0"
                                           <#if column.columndisplay==0>checked</#if>>
                                    <label for="columndisplay0">禁用</label>
                                </label>
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
        $("#nav_columns").imitClick();
        $("#backColumnList").click(function(){
            location.href="<@spring.url '/manager/column/list'/>"
        });

        $("#colTypeId").chosen({disable_search_threshold: 10,width:'100%'});
        $("#openWay").chosen({disable_search_threshold: 10,width:'100%'});

        $("#columnForm").Validform({
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
                        location.href="<@spring.url '/manager/column/list'/>";
                    });
                }else if(data.status === "0"){
                    layer.msg(data.message, {icon: 2});
                }else{
                    layer.msg("错误代码："+data.status+" 错误消息："+data.statusText, {icon: 2});
                }
            }
        });

        <#--
        $("#columnForm").ajaxForm({
            dataType : 'json',
            success : function(data) {
                if(data.status === "1"){
                    $.v5cms.tooltip({icon:"succeed",content:data.message},function(){
                        location.href="<@spring.url '/manager/column/list'/>";
                    });
                }else{
                    $.v5cms.tooltip({icon:"error",content:data.message},function(){});
                }
            },
            error:function(xhr, status, error){
                $.v5cms.tooltip({icon:"error",content:("错误代码：" + status + " 错误消息：" + error)},function(){});
            }
        });
        -->

        $("#saveColumnButton").click(function(){
            /*var result = $("#columnName").nonEmpty({content:"栏目类型名称不能为空！"});
            if(result) $("#columnForm").submit();*/
            $("#columnForm").submit();
        });
    });
</script>