<#include "../fragment/head.ftl">
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            角色管理
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="<@spring.url '/manager/index'/>"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>用户权限</li>
            <li><a href="<@spring.url '/manager/coltype/list/1'/>">角色管理</a></li>
            <li class="active">${page_title!"添加角色"}</li>
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
                        <button id="saveRoleForm" class="btn btn-success btn-sm" data-toggle="tooltip" title="保存">
                            <i class="fa fa-save"></i> 保存</button>
                        <button id="backRoleList" class="btn btn-default btn-sm" data-toggle="tooltip" title="返回">
                            <i class="fa fa-mail-forward"></i> 返回</button>
                    </div><!-- /. tools -->
                    <i class="fa fa-globe"></i>
                    <h3 class="box-title">${page_title!"添加角色"}</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <form id="roleForm" action="<@spring.url '/manager/role/edit'/>" class="form-horizontal" role="form" method="POST">
                        <input type="hidden" value="${role.id!""}" name="id">
                        <div class="form-group">
                            <label for="colTypeName" class="col-sm-2 control-label">名称 <span style="color: #ff0000">*</span></label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="name" id="roleName"
                                       placeholder="角色名称" value="${role.name!""}" datatype="*" nullmsg="请输入角色名称！">
                                <span class="help-block">设置版位的名称，方便日后管理。</span>
                            </div>
                            <div class="col-sm-3 Validform_checktip"></div>
                        </div>
                        <div class="form-group">
                            <label for="coltpl" class="col-sm-2 control-label">序号</label>
                            <div class="col-sm-4">
                                <input type="text" name="sortNum" id="sortNum" class="form-control" placeholder="序号" value="0" datatype="n" errormsg="序号必须为数字！">
                                <span class="help-block">对角色进行排序，越小越靠前。</span>
                            </div>
                            <div class="col-sm-3 Validform_checktip"></div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">状态</label>
                            <div class="col-sm-4">
                                <label class="radio-inline" style="padding-left: 0px;">
                                    <input type="radio" name="available" checked value="1"> 可用
                                </label>
                                <label class="radio-inline" style="padding-left: 0px;">
                                    <input type="radio" name="available" value="0"> 禁用
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="coltpl" class="col-sm-2 control-label">授权</label>
                            <div class="col-sm-4">
                                <input id="resIds" name="resIds" type="hidden">
                                <div class="v5-div-scroll">
                                    <ul id="resTree" class="ztree"></ul>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="contenttpl" class="col-sm-2 control-label">描述</label>
                            <div class="col-sm-4">
                                <textarea name="des" id="des" class="form-control">${role.des!""}</textarea>
                            </div>
                        </div>
                    </form>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.row -->
        <input type="hidden" id="update_resIds" value="${resIds!""}">
    </section>
    <!-- /.content -->
</aside><!-- /.right-side -->
<#include "../fragment/footer.ftl">
<script type="text/javascript">
    $(function(){
        $("#user_auth").imitClick();
        $("#backRoleList").click(function(){
            location.href="<@spring.url '/manager/role/list/1'/>"
        });

        function onCheck(event, treeId, treeNode){
            var zTree = $.fn.zTree.getZTreeObj("resTree"),
                    nodes = zTree.getCheckedNodes(true),
                    id = [];
            nodes.sort(function compare(a,b){return a.id-b.id;});
            for (var i=0, l=nodes.length; i < l; i++) {
                id.push(nodes[i].id);
            }
            if (id.length > 0 )
                $("#resIds").val(id.join(','));
            else
                $("#resIds").val("");
        }
        var setting = {
            check: {
                enable: true,
                chkStyle: "checkbox",
                chkboxType: { "Y": "ps", "N": "ps" }
            },
            view: {
                dblClickExpand: false
            },
            async:{
                enable: true,
                dataType: "text",
                url:'<@spring.url "/manager/res/tree/json"/>'
            },
            callback:{
                onCheck:onCheck,
                onAsyncSuccess:function(event, treeId, treeNode, msg){
                    var zTree = $.fn.zTree.getZTreeObj("resTree");
                    zTree.expandAll(true);
                    var resIds = $("#update_resIds").val();
                    if(resIds !== null && resIds.length > 0){
                        var resIdArr = resIds.split(",");
                        var nodes = zTree.transformToArray(zTree.getNodes());
                        for (var i=0, l=nodes.length; i < l; i++) {
                            if($.inArray(nodes[i].id+"",resIdArr) === -1) continue;
                            zTree.checkNode(nodes[i], true, false,true);
                        }
                    }
                }
            }
        };

        $.fn.zTree.init($("#resTree"), setting);

        $("#roleForm").Validform({
            ajaxPost:true,
            showAllError:true,
            tiptype:2,
            callback:function(data){
                if(data.status === "1"){
                    layer.msg(data.message, {
                        icon: 1,
                        time:2000
                    },function(){
                        location.href="<@spring.url '/manager/role/list/1'/>";
                    });
                }else if(data.status === "0"){
                    layer.msg(data.message, {icon: 2});
                }else{
                    layer.msg("错误代码："+data.status+" 错误消息："+data.statusText, {icon: 2});
                }
            }
        });

        $("#saveRoleForm").click(function(){
            $("#roleForm").submit();
        });
    });
</script>