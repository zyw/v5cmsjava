<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${siteKey.siteName!"没有站点"} | 后台</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>

    <#--<!-- bootstrap 3.0.2 &ndash;&gt;
    <link href="<@spring.url '/res/backstage/css/bootstrap.css'/>" rel="stylesheet" type="text/css"/>
    <!-- font Awesome &ndash;&gt;
    <link href="<@spring.url '/res/backstage/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css"/>
    <!-- Ionicons &ndash;&gt;
    <link href="<@spring.url '/res/backstage/css/ionicons.min.css'/>" rel="stylesheet" type="text/css"/>
    <!-- colorpicker &ndash;&gt;
    <link href="<@spring.url '/res/backstage/css/bootstrap-colorpicker.min.css'/>" rel="stylesheet" type="text/css"/>
    <!-- artDialog &ndash;&gt;
    <link href="<@spring.url '/res/backstage/css/ui-dialog.css'/>" rel="stylesheet" type="text/css"/>
    <!-- Theme style &ndash;&gt;
    <link href="<@spring.url '/res/backstage/css/AdminLTE.css'/>" rel="stylesheet" type="text/css"/>
    <!-- bootstrap-chosen &ndash;&gt;
    <link href="<@spring.url '/res/backstage/css/bootstrap-chosen.min.css'/>" rel="stylesheet" type="text/css"/>
    <!-- DatePicker &ndash;&gt;
    <link href="<@spring.url '/res/backstage/css/datepicker3.css'/>" rel="stylesheet" type="text/css"/>
    <!-- zTreeStyle.css &ndash;&gt;
    <link href="<@spring.url '/res/backstage/css/zTreeStyle.css'/>" rel="stylesheet" type="text/css"/>
    <!--custom CSS&ndash;&gt;
    <link href="<@spring.url '/res/backstage/css/main.css'/>" rel="stylesheet" type="text/css"/>-->
    <link href="<@spring.url '/wro/all.css'/>" rel="stylesheet" type="text/css"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body class="skin-blue">
<input type="hidden" id="v5cms_context_path" value="<@spring.url ''/>"/>
<!-- header logo: style can be found in header.less -->
<header class="header">
<a href="index" class="logo">
    <!-- Add the class icon to your logo image or logo icon to add the margining -->
    ${siteKey.siteName!"没有站点"}
</a>
<!-- Header Navbar: style can be found in header.less -->
<nav class="navbar navbar-static-top" role="navigation">
<!-- Sidebar toggle button-->
<a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
    <span class="sr-only">Toggle navigation</span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
</a>
<div class="navbar-right">

<ul class="nav navbar-nav">
<li style="line-height: 50px;">
    <select class="form-control" id="site-manager">
        <#list sitesKey as site>
            <option value="${site.siteId}" <#if siteKey == site>selected</#if>>${site.siteName}</option>
        </#list>
    </select>
</li>

<!-- Messages: style can be found in dropdown.less-->
<li class="dropdown messages-menu">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
        <i class="fa fa-envelope"></i>
        <span class="label label-success">4</span>
    </a>
    <ul class="dropdown-menu">
        <li class="header">你有4个未读消息</li>
        <li>
            <!-- inner menu: contains the actual data -->
            <ul class="menu">
                <li><!-- start message -->
                    <a href="#">
                        <div class="pull-left">
                            <img src="<@spring.url '/res/backstage/images/avatar5.png'/>" class="img-circle" alt="User Image"/>
                        </div>
                        <h4>
                            支持团队
                            <small><i class="fa fa-clock-o"></i> 5 分钟</small>
                        </h4>
                        <p>主题</p>
                    </a>
                </li>
                <!-- end message -->
                <li>
                    <a href="#">
                        <div class="pull-left">
                            <img src="<@spring.url '/res/backstage/images/avatar5.png'/>" class="img-circle" alt="user image"/>
                        </div>
                        <h4>
                            设计团队
                            <small><i class="fa fa-clock-o"></i> 2 小时</small>
                        </h4>
                        <p>团队</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="pull-left">
                            <img src="<@spring.url '/res/backstage/images/avatar5.png'/>" class="img-circle" alt="user image"/>
                        </div>
                        <h4>
                            开发
                            <small><i class="fa fa-clock-o"></i> 今天</small>
                        </h4>
                        <p>开发团队</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="pull-left">
                            <img src="<@spring.url '/res/backstage/images/avatar5.png'/>" class="img-circle" alt="user image"/>
                        </div>
                        <h4>
                            业务部门
                            <small><i class="fa fa-clock-o"></i> 昨天</small>
                        </h4>
                        <p>业务部门</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="pull-left">
                            <img src="<@spring.url '/res/backstage/images/avatar5.png'/>" class="img-circle" alt="user image"/>
                        </div>
                        <h4>
                            审核部门
                            <small><i class="fa fa-clock-o"></i> 2 天</small>
                        </h4>
                        <p>审核部门</p>
                    </a>
                </li>
            </ul>
        </li>
        <li class="footer"><a href="#">查看所有消息</a></li>
    </ul>
</li>
<!-- Notifications: style can be found in dropdown.less -->
<li class="dropdown notifications-menu">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
        <i class="fa fa-warning"></i>
        <span class="label label-warning">10</span>
    </a>
    <ul class="dropdown-menu">
        <li class="header">你有10条未读通知</li>
        <li>
            <!-- inner menu: contains the actual data -->
            <ul class="menu">
                <li>
                    <a href="#">
                        <i class="ion ion-ios7-people info"></i> 今天有五个成员加入
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-warning danger"></i> 很长的描述这里可能不适合到页面,可能导致设计问题
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-users warning"></i> 5新成员加入
                    </a>
                </li>

                <li>
                    <a href="#">
                        <i class="ion ion-ios7-cart success"></i> 25日的销售业绩
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="ion ion-ios7-person danger"></i> 你改变了你的用户名
                    </a>
                </li>
            </ul>
        </li>
        <li class="footer"><a href="#">查看全部</a></li>
    </ul>
</li>
<!-- Tasks: style can be found in dropdown.less -->
<li class="dropdown tasks-menu">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
        <i class="fa fa-tasks"></i>
        <span class="label label-danger">9</span>
    </a>
    <ul class="dropdown-menu">
        <li class="header">你有9个任务</li>
        <li>
            <!-- inner menu: contains the actual data -->
            <ul class="menu">
                <li><!-- Task item -->
                    <a href="#">
                        <h3>
                            设计一些按钮
                            <small class="pull-right">20%</small>
                        </h3>
                        <div class="progress xs">
                            <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar"
                                 aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                <span class="sr-only">20% 完成</span>
                            </div>
                        </div>
                    </a>
                </li>
                <!-- end task item -->
                <li><!-- Task item -->
                    <a href="#">
                        <h3>
                            创建一个漂亮的主题
                            <small class="pull-right">40%</small>
                        </h3>
                        <div class="progress xs">
                            <div class="progress-bar progress-bar-green" style="width: 40%" role="progressbar"
                                 aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                <span class="sr-only">40% 完成</span>
                            </div>
                        </div>
                    </a>
                </li>
                <!-- end task item -->
                <li><!-- Task item -->
                    <a href="#">
                        <h3>
                            我需要做一些任务
                            <small class="pull-right">60%</small>
                        </h3>
                        <div class="progress xs">
                            <div class="progress-bar progress-bar-red" style="width: 60%" role="progressbar"
                                 aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                <span class="sr-only">60% 完成</span>
                            </div>
                        </div>
                    </a>
                </li>
                <!-- end task item -->
                <li><!-- Task item -->
                    <a href="#">
                        <h3>
                            让美丽的转换
                            <small class="pull-right">80%</small>
                        </h3>
                        <div class="progress xs">
                            <div class="progress-bar progress-bar-yellow" style="width: 80%" role="progressbar"
                                 aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                <span class="sr-only">80% 完成</span>
                            </div>
                        </div>
                    </a>
                </li>
                <!-- end task item -->
            </ul>
        </li>
        <li class="footer">
            <a href="#">查看所有任务</a>
        </li>
    </ul>
</li>
<!-- User Account: style can be found in dropdown.less -->
<li class="dropdown user user-menu">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
        <i class="glyphicon glyphicon-user"></i>
        <span>你好，<@shiro.principal name="full_name"/> <i class="caret"></i></span>
    </a>
    <ul class="dropdown-menu">
        <!-- User image -->
        <li class="user-header bg-light-blue">
            <img src="<@spring.url '/res/backstage/images/avatar5.png'/>" class="img-circle" alt="User Image"/>

            <p>
            <@shiro.principal name="full_name"/> - 管理员
                <small>${managerKey.email}</small>
            </p>
        </li>
       <#-- Menu Body
        <li class="user-body">
            <div class="col-xs-4 text-center">
                <a href="#">Followers</a>
            </div>
            <div class="col-xs-4 text-center">
                <a href="#">Sales</a>
            </div>
            <div class="col-xs-4 text-center">
                <a href="#">Friends</a>
            </div>
        </li>-->
        <!-- Menu Footer-->
        <li class="user-footer">
            <div class="pull-left">
                <a href="#" class="btn btn-default btn-flat">设置</a>
            </div>
            <div class="pull-right">
                <a href="<@spring.url '/manager/logout'/>" class="btn btn-default btn-flat">退出</a>
            </div>
        </li>
    </ul>
</li>
</ul>
</div>
</nav>
</header>
<div class="wrapper row-offcanvas row-offcanvas-left">
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="left-side sidebar-offcanvas">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="{basePath}/resources/backstage/images/avatar5.png" class="img-circle" alt="User Image" />
                </div>
                <div class="pull-left info">
                    <p>你好, Jane</p>

                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>-->
            <!-- search form -->
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="查询..."/>
                            <span class="input-group-btn">
                                <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i
                                        class="fa fa-search"></i></button>
                            </span>
                </div>
            </form>
            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li class="active">
                    <a href="<@spring.url "/manager/index"/>">
                        <i class="fa fa-dashboard"></i> <span>仪表盘</span>
                    </a>
                </li>
                <li>
                    <a href="<@spring.url '/manager/content/edit'/>">
                        <i class="glyphicon glyphicon-send"></i> <span>内容发布</span>
                        <small class="badge pull-right bg-green">new</small>
                    </a>
                </li>
                <li class="treeview" id="nav_content">
                    <a href="javascript:;">
                        <i class="glyphicon glyphicon-list-alt"></i>
                        <span>内容管理</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="<@spring.url "/manager/content/list/0/1"/>"><i class="fa fa-angle-double-right"></i> 内容列表</a></li>
                        <li><a href="<@spring.url "/manager/content/edit"/>"><i class="fa fa-angle-double-right"></i> 添加内容</a></li>

                        <li><a href="<@spring.url "/manager/comment/list/1"/>"><i class="fa fa-angle-double-right"></i> 评论管理</a></li>
                    </ul>
                </li>
                <li class="treeview" id="nav_columns">
                    <a href="javascript:;">
                        <i class="fa fa-th-list"></i>
                        <span>栏目管理</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="<@spring.url '/manager/column/list'/>"><i class="fa fa-angle-double-right"></i> 栏目</a></li>
                        <li><a href="<@spring.url '/manager/coltype/list/1'/>"><i class="fa fa-angle-double-right"></i> 栏目类型</a></li>
                    </ul>

                </li>

                <li class="treeview" id="nav_lw">
                    <a href="javascript:;">
                        <i class="fa fa-comment"></i>
                        <span>留言管理</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="<@spring.url '/manager/lw/list/1'/>"><i class="fa fa-angle-double-right"></i> 留言</a></li>
                        <li><a href="<@spring.url '/manager/lwt/list/1'/>"><i class="fa fa-angle-double-right"></i> 留言类型</a></li>
                    </ul>

                </li>

                <li>
                    <a href="<@spring.url '/manager/tpl/list'/>">
                        <i class="fa fa-edit"></i> <span>模板管理</span>
                        <small class="badge pull-right bg-green">new</small>
                    </a>
                </li>
                <li id="resource_columns">
                    <a href="<@spring.url '/manager/resource/list'/>">
                        <i class="fa fa-paste"></i> <span>资源管理</span>
                    </a>
                </li>
                <!--
                <li class="treeview">
                    <a href="javascript:;">
                        <i class="fa fa-paste"></i> <span>资源管理</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="pages/tables/simple.html"><i class="fa fa-angle-double-right"></i> Simple
                            tables</a></li>
                        <li><a href="pages/tables/data.html"><i class="fa fa-angle-double-right"></i> Data tables</a>
                        </li>
                    </ul>
                </li>
                -->
                <li class="treeview" id="user_auth">
                    <a href="javascript:;">
                        <i class="fa fa-user"></i> <span>用户权限</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="<@spring.url '/manager/user/list/1'/>"><i class="fa fa-angle-double-right"></i> 用户管理</a></li>
                        <li><a href="<@spring.url '/manager/role/list/1'/>"><i class="fa fa-angle-double-right"></i> 角色管理</a></li>
                        <li><a href="<@spring.url '/manager/res/list'/>"><i class="fa fa-angle-double-right"></i> 资源管理</a></li>
                    </ul>
                </li>
                <li class="treeview" id="nav_siteSetting">
                    <a href="javascript:;">
                        <i class="fa fa-wrench"></i> <span>站点设置</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li>
                            <a href="<@spring.url '/manager/site/list'/>">
                                <i class="fa fa-angle-double-right"></i>
                                站点管理
                            </a>
                        </li>
                        <li><a href="<@spring.url '/manager/adv/list/1'/>"><i class="fa fa-angle-double-right"></i> 广告管理</a></li>
                        <li><a href="<@spring.url '/manager/advpos/list'/>"><i class="fa fa-angle-double-right"></i> 广告版位</a></li>
                        <li><a href="<@spring.url '/manager/link/list/1'/>"><i class="fa fa-angle-double-right"></i> 链接管理</a></li>
                        <li><a href="<@spring.url '/manager/banner/list/1'/>"><i class="fa fa-angle-double-right"></i> Banner管理</a></li>
                    </ul>
                </li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>