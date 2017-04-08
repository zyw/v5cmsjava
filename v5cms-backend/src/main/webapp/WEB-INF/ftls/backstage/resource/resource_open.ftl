<#import "/spring.ftl" as spring/>
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
<script type="text/javascript" charset="utf-8" src="<@spring.url '/res/backstage/ace/ace.js'/>"></script>
<script type="text/javascript">
    $(function(){

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