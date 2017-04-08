<#include "../fragment/head.ftl">
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            站点管理
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="<@spring.url '/manager/index'/>"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li>站点设置</li>
            <li><a href="<@spring.url '/manager/site/list'/>">站点管理</a></li>
            <li class="active">${page_title!"添加站点"}</li>
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
                        <button id="saveSiteForm" class="btn btn-success btn-sm" data-toggle="tooltip" title="保存">
                            <i class="fa fa-save"></i> 保存</button>
                        <button id="backSiteList" class="btn btn-default btn-sm" data-toggle="tooltip" title="返回">
                            <i class="fa fa-mail-forward"></i> 返回</button>
                    </div><!-- /. tools -->
                    <i class="fa fa-globe"></i>
                    <h3 class="box-title">${page_title!"添加站点"}</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
                    <form id="siteForm" action="<@spring.url '/manager/site/edit'/>" class="form-horizontal" role="form" method="POST">
                        <input type="hidden" value="${site.siteId!""}" name="siteId">
                        <input type="hidden" value="${site.themeName!""}" name="themeName"/>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">站点名称 <span style="color: #ff0000">*</span></label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" name="siteName" id="siteName"
                                       placeholder="站点名称" value="${site.siteName!""}" datatype="*" nullmsg="站点名称不能为空！">
                                <span class="help-block">设置站点的标题，显示到title标签中。</span>
                            </div>
                            <div class="col-sm-3 Validform_checktip"></div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">域名 <span style="color: #ff0000">*</span></label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" name="domain" id="domain"
                                       placeholder="域名" value="${site.domain!""}" datatype="*"
                                       nullmsg="站点域名不能为空！" ajaxurl="<@spring.url '/manager/site/domain/count'/><#if (site.siteId!0) != 0>?siteId=${site.siteId!0}</#if>">
                                <span class="help-block">设置站点域名，例如：www.explame.com，域名必须唯一。</span>
                            </div>
                            <div class="col-sm-3 Validform_checktip"></div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">访问协议 <span style="color: #ff0000">*</span></label>
                            <div class="col-sm-5">
                                <select class="form-control" id="protocol" name="protocol">
                                    <option value="http://" <#if (site.protocol!"http://")=="http://">selected</#if>>http://</option>
                                    <option value="https://" <#if (site.protocol!"http://")=="https://">selected</#if>>https://</option>
                                </select>
                                <span class="help-block">站点访问的协议，http://或者https://</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">副标题</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" name="siteDeputyTitle" id="siteDeputyTitle"
                                       placeholder="副标题" value="${site.siteDeputyTitle!""}">
                                <span class="help-block">设置站点的副标题，可以显示成title | 副标题的形式。</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">关键字</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" name="siteKey" id="siteKey"
                                       placeholder="关键字" value="${site.siteKey!""}">
                                <span class="help-block">设置站点的关键字，出现在首页的meta中，可提高网站的SEO。</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">站点描述</label>
                            <div class="col-sm-5">
                                <textarea class="form-control" name="siteDescribed" id="siteDescribed" rows="3">${site.siteDescribed!""}</textarea>
                                <span class="help-block">设置站点的描述，出现在首页的meta中，可提高网站的SEO。</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">ICP备案号</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" name="siteicp" id="siteicp"
                                       placeholder="ICP备案号" value="${site.siteicp!""}">
                                <span class="help-block">保存网站的备案信息。</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">统计代码</label>
                            <div class="col-sm-5">
                                <textarea class="form-control" name="siteStatisticCode" id="siteStatisticCode" rows="3">${site.siteStatisticCode!""}</textarea>
                                <span class="help-block">设置网站的统计代码，如百度统计或者是腾讯统计。</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">底部信息</label>
                            <div class="col-sm-5">
                                <textarea class="form-control" name="siteFooterInfo" id="siteFooterInfo" rows="3">${site.siteFooterInfo!""}</textarea>
                                <span class="help-block">用于保存网站的底部信息，支持HTML。</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">运行状态</label>
                            <div class="col-sm-5">
                                <select class="form-control" id="isclosesite" name="isclosesite">
                                    <#if (site.isclosesite!0) == 1>
                                        <option value="1" selected>运行</option>
                                        <option value="0">停止</option>
                                    <#else>
                                        <option value="1">运行</option>
                                        <option value="0" selected>停止</option>
                                    </#if>
                                </select>
                                <span class="help-block">用于设置网站的运行状态，运行或者停止。</span>
                            </div>
                        </div>
                    </form>
                </div><!-- /.box-body -->
            </div><!-- /.box -->
        </div><!-- /.row -->

    </section><!-- /.content -->
</aside><!-- /.right-side -->
<#include "../fragment/footer.ftl">
<script type="text/javascript">
    $(function(){
        $("#nav_siteSetting").imitClick();
        $("#backSiteList").click(function(){
            location.href="<@spring.url '/manager/site/list'/>"
        });

        $("#isclosesite").chosen({disable_search_threshold: 10,width:'100%'});
        $("#protocol").chosen({disable_search_threshold: 10,width:'100%'});

        $("#siteForm").Validform({
            ajaxPost:true,
            showAllError:true,
            tiptype:2,
            callback:function(data){
                if(data.status === "1"){
                    layer.msg(data.message, {
                        icon: 1,
                        time:2000
                    },function(){
                        location.href="<@spring.url '/manager/site/list'/>";
                    });
                }else if(data.status === "0"){
                    layer.msg(data.message, {icon: 2});
                }else{
                    layer.msg("错误代码："+data.status+" 错误消息："+data.statusText, {icon: 2});
                }
            }
        });

        $("#saveSiteForm").click(function(){
            $("#siteForm").submit();
        });
    });
</script>