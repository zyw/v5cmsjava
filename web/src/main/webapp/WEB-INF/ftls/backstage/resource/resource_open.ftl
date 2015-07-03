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
            <li class="active">资源列表</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <!-- Small boxes (Stat box) -->
        <div class="row">
            <div class="col-sm-2" style="padding-left:0;padding-right:0;">
                <div class="box box-info">
                    <div class="box-header">
                        <!-- tools box -->
                        <i class="fa fa-sitemap"></i>
                        <h3 class="box-title">资源树</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body table-responsive v5-tree-div" style="padding-top: 0;">
                        <ul id="resourceTree" class="ztree"></ul>
                    </div><!-- /.box-body -->
                </div><!-- /.box -->
            </div>
            <div class="col-sm-10" style="padding-right: 0;">
                <div class="box box-info">
                    <div class="box-header">
                        <!-- tools box -->
                        <div class="pull-right box-tools">
                            <#if editor == "yes">
                                <button id="saveCode" class="btn btn-success btn-sm" data-toggle="tooltip" title="保存">
                                    <i class="fa fa-save"></i> 保存</button>
                            </#if>
                                <!--
                            <button id="addContent" class="btn btn-success btn-sm" data-toggle="tooltip" title="添加资源">
                                <i class="fa fa-plus"></i> 添加资源</button>
                            <button id="contentBatchDelete" class="btn btn-warning btn-sm" data-toggle="tooltip" title="批量删除">
                                <i class="fa fa-trash-o"></i> 批量删除</button>
                                -->
                        </div><!-- /. tools -->
                        <i class="fa fa-table"></i>
                        <h3 class="box-title">资源列表
                            <#if editor == "yes">
                                &nbsp;<small style="font-size:6px;">${fileName!""}</small>
                            </#if>
                        </h3>
                    </div><!-- /.box-header -->
                    <div class="box-body table-responsive">
                        <#if editor == "yes">
                            <form action="<@spring.url '/manager/resource/save/file'/>" id="fileForm" method="post">
                                <pre id="editor" style="height:750px;font-size:14px;"></pre>
                                <textarea name="resourceContent" id="resourceContent" style="display:none;" datatype="*" nullmsg="代码不能为空！">${content}</textarea>
                                <input id="fileid" name="fileid" type="hidden" value="${fileid}">
                            </form>
                        <#elseif editor == "no">
                            <div class="text-center">
                                <img src="${webPath}" style="margin-top: 10px;margin-bottom: 10px;">
                                <div>${fileName}</div>
                            </div>
                        <#else>
                            <div class="text-center" style="margin-top: 10px;margin-bottom: 10px;">
                                <h1>不能显示！</h1>
                            </div>
                        </#if>
                    </div><!-- /.box-body -->
                </div><!-- /.box -->
            </div><!-- /.col-xs-9 -->
        </div><!-- /.row -->
    </section><!-- /.content -->
    <form id="resourceForm" method="post" action="<@spring.url '/manager/resource/list'/>">
        <input type="hidden" id="pathInput" name="path">
    </form>
</aside><!-- /.right-side -->
<#include "../fragment/footer.ftl">
<script type="text/javascript" charset="utf-8" src="<@spring.url '/res/backstage/ace/ace.js'/>"></script>
<script type="text/javascript">

    $(function(){

        $("#resource_columns").imitClick();

        var resourceSetting = {
            view : {
                dblClickExpand : false
            },
            async : {
                enable : true,
                dataType : "json",
                url : "<@spring.url "/manager/resource/tree/json"/>"
            },
            callback : {
                onClick:function(event, treeId, treeNode){
                    var fileUri = treeNode.fileUri;
                    $("#pathInput").val(fileUri);
                    $("#resourceForm").submit();
                }
            }
        };
        $.fn.zTree.init($("#resourceTree"), resourceSetting);

        <#if editor == "yes">
            var codeEditor = ace.edit("editor");
            codeEditor.setTheme("ace/theme/tomorrow");
            <#if extension == "js">
                codeEditor.session.setMode("ace/mode/javascript");
            <#else>
                codeEditor.session.setMode("ace/mode/css");
            </#if>
            codeEditor.setAutoScrollEditorIntoView(true);
            codeEditor.setValue($("#resourceContent").val());
            codeEditor.getSession().on('change', function(e) {
                $("#resourceContent").val(codeEditor.getValue());
            });

            $("#fileForm").Validform({
                ajaxPost:true,
                showAllError:true,
                tiptype:function(msg,o,cssctl){
                    if(!o.obj.is("form")){
                        layer.msg(msg, {icon: 0});
                    }else{
                        layer.msg(msg, {icon: 1});
                    }
                },
                callback:function(data){
                    if(data.status === "1"){
                        layer.msg(data.message, {
                            icon: 1,
                            time:2000
                        });
                    }else if(data.status === "0"){
                        layer.msg(data.message, {icon: 2});
                    }else{
                        layer.msg("错误代码："+data.status+" 错误消息："+data.statusText, {icon: 2});
                    }
                }
            });
            $("#saveCode").click(function(){
                $("#fileForm").submit();
            });
        </#if>
    });
</script>