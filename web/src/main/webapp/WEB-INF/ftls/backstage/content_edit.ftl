<#include "fragment/head.ftl">
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            内容管理
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="<@spring.url '/manager/index'/>"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>内容管理</li>
            <li><a href="<@spring.url '/manager/content/list'/>">内容列表</a></li>
            <li class="active">${page_title!"添加内容"}</li>
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
                        <button id="backContentList" class="btn btn-default btn-sm" data-toggle="tooltip" title="返回">
                            <i class="fa fa-mail-forward"></i> 返回</button>
                    </div><!-- /. tools -->
                    <i class="fa fa-globe"></i>
                    <h3 class="box-title">${page_title!"添加内容"}</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <form id="columnForm" action="<@spring.url '/manager/column/edit'/>" class="form-horizontal" role="form" method="POST">
                        <input type="hidden" value="" name="colsId">
                        <div class="form-group">
                            <label for="columnName" class="col-sm-2 control-label">内容标题 <span style="color: #ff0000">*</span></label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="columnName" id="columnName"
                                       placeholder="内容标题" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">父栏目</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" value="" readonly>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="coltpl" class="col-sm-2 control-label">栏目类型</label>
                            <div class="col-sm-4">
                                <select class="form-control" id="colTypeId" name="columnType.colTypeId">
                                <#--<#list colTypes as colType>
                                    <option value="${colType.colTypeId!0}" <#if column?? && column.columnType?? && column.columnType.colTypeId == colType.colTypeId>selected</#if>>${colType.colTypeName!""}</option>
                                </#list>-->
                                </select>
                                <span class="help-block">为栏目选择类型。</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sortNum" class="col-sm-2 control-label">显示顺序</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="sortNum" id="sortNum"
                                       placeholder="显示顺序" value="">
                                <span class="help-block">栏目的显示顺序越小越靠前。</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="openWay" class="col-sm-2 control-label">打开方式</label>
                            <div class="col-sm-4">
                                <select class="form-control" id="openWay" name="openWay">
                                    <#--<option value="_self" <#if (column.openWay!"") == "" || (column.openWay!"") == "_self">selected</#if>>当前窗口</option>
                                    <option value="_blank" <#if (column.openWay!"") == "_blank">selected</#if>>新窗口</option>-->
                                </select>
                                <span class="help-block">栏目的打开方式，本页打开或者新窗口打开。</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="columnpic" class="col-sm-2 control-label">栏目图标</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="columnpic" id="columnpic"
                                       placeholder="栏目图标" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="columnOutside" class="col-sm-2 control-label">外链地址</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="columnOutside" id="columnOutside"
                                       placeholder="外链地址" value="">
                                <span class="help-block">连接到其他站点。</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="isDisabled" class="col-sm-2 control-label">栏目状态</label>
                            <div class="col-sm-3">
                                <label class="checkbox-inline" style="padding-left:0;">
                                    <input type="radio" name="columndisplay" value="1" id="columndisplay1"
                                           >
                                    <label for="columndisplay1">可用</label>
                                    &nbsp;&nbsp;
                                    <input type="radio" name="columndisplay" value="0" id="columndisplay0"
                                           >
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
<#include "fragment/footer.ftl">
<script type="text/javascript">
    $(function(){
        $("#nav_content").imitClick();
        $("#backContentList").click(function(){
            location.href="<@spring.url '/manager/content/list'/>"
        });

        $("#colTypeId").chosen({disable_search_threshold: 10,width:'100%'});
        $("#openWay").chosen({disable_search_threshold: 10,width:'100%'});

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

        $("#saveColumnButton").click(function(){
            var result = $("#columnName").nonEmpty({content:"栏目类型名称不能为空！"});
            if(result) $("#columnForm").submit();
        });
    });
</script>