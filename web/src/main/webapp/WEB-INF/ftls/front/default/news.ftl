<#import "/spring.ftl" as spring/>
<!doctype html>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="${frontSite.siteKey!""}" />
    <meta name="description" content="${frontSite.siteDescribed!""}" />
<title>${(frontSite.siteName)!""} - ${(column.columnName)}</title>
<#include "frags/header.ftl"/>
</head>

<body>
<div id="wrapper">

	<#include "frags/top.ftl"/>
    <!-- ==================== S Header ==================== -->
    <div class="Header">		
    </div>
    <!-- ==================== E Header ==================== -->

    <!-- ==================== S ContentArea ==================== -->
    <div class="ContentArea">    	
    	<!-- S page-title -->
        <div class="page-title clearfix">
			<div class="page-width clearfix">
                <h2>公司新闻</h2>
                <!-- S breadcrumbs  -->
                <div class="breadcrumbs">
                    您现在的位置：<a class="breadcrumbs-home" href="/">首页</a><i>&gt;</i>
                    <a href="javascript:;">资讯中心</a><i>&gt;</i>
                    <strong>公司新闻</strong>
                </div>
                <!-- E breadcrumbs -->
			</div>
        </div>
        <!-- E page-title --> 
        
        <div class="page-width clearfix">
            <!-- S Main -->
            <div class="Main float-left"> 
            	<!-- S main-cont -->
                <div class="main-cont">
                    <!-- module-default -->
                    <div class="module-default">
                        <div class="mod-inner">
                        	<div class="mod-content">
	                        	<!-- S article -->
	                            <div class="article">
	                            	<ul class="article-list-row">
										<@v5cms.content colId=(column.colsId) currentPage=1 maxSize=10/>
											<#list pageContent.content as content>
	                                    <li>
	                                    	<span class="float-right">${(content.lastdt)?string("yyyy-MM-dd")}</span>
	                                    	<a href="<@spring.url '/content/${content.contentId}.htm'/>">${content.cname}</a>
	                                    </li>
											</#list>
	                                    <li><span class="float-right">2013-08-06</span><a href="news-detail.ftl">移动互联网向左，社区向右</a></li>
	                                    <li><span class="float-right">2013-08-06</span><a href="news-detail.ftl">社交产品的真正使命是消灭"朋友"</a></li>
	                                    <li><span class="float-right">2013-08-06</span><a href="news-detail.ftl">在注册之前，能让我先试用一下产品吗？</a></li>
	                                    <li><span class="float-right">2013-08-06</span><a href="news-detail.ftl">用互联网思维做产品的7个要素</a></li>
	                                    <li><span class="float-right">2013-08-06</span><a href="news-detail.ftl">用户体验无处不在—-发现生活中的用户体验美</a></li>
	                                    <li><span class="float-right">2013-08-06</span><a href="news-detail.ftl">移动互联网向左，社区向右</a></li>
	                                    <li><span class="float-right">2013-08-06</span><a href="news-detail.ftl">社交产品的真正使命是消灭"朋友"</a></li>
	                                    <li><span class="float-right">2013-08-06</span><a href="news-detail.ftl">在注册之前，能让我先试用一下产品吗？</a></li>
	                                    <li><span class="float-right">2013-08-06</span><a href="news-detail.ftl">用互联网思维做产品的7个要素</a></li>
	                                    <li><span class="float-right">2013-08-06</span><a href="news-detail.ftl">用户体验无处不在—-发现生活中的用户体验美</a></li>
	                                    <li><span class="float-right">2013-08-06</span><a href="news-detail.ftl">移动互联网向左，社区向右</a></li>
	                                    <li><span class="float-right">2013-08-06</span><a href="news-detail.ftl">社交产品的真正使命是消灭"朋友"</a></li>
	                                    <li><span class="float-right">2013-08-06</span><a href="news-detail.ftl">在注册之前，能让我先试用一下产品吗？</a></li>
	                                    <li><span class="float-right">2013-08-06</span><a href="news-detail.ftl">用互联网思维做产品的7个要素</a></li>
	                                    <li><span class="float-right">2013-08-06</span><a href="news-detail.ftl">用户体验无处不在—-发现生活中的用户体验美</a></li>
	                                </ul>
	                                
	                                <#include "frags/pagination.ftl"/>
	                                
	                            </div>
	                            <!-- E article -->
                            </div>
                        </div>
                    </div>
                    <!-- -->
                </div>
                <!-- E main-cont -->                
                
            </div>
            <!-- E Main -->
        
            <!-- S Sidebar -->
            <div class="Sidebar float-right">
                <!-- S sidebar-menu -->
                <div class="sidebar-menu">
                    <div class="sidebar-menu-inner">
                        <div class="sidebar-menu-tit">
                            <h2>资讯中心</h2>
                        </div>
                        <div class="sidebar-menu-cont">
                            <ul>
                                <li class="current"><a href="news.ftl">公司新闻</a></li>
                                <li class=""><a href="news2.ftl">行业动态</a></li>
                                <li class=""><a href="news3.ftl">促销活动</a></li>
                                <li class=""><a href="news4.ftl">文章分类</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- E sidebar-menu -->
                
                <!-- S module-sidebar -->                
                <!-- E module-sidebar -->                
                
            </div>
            <!-- E Sidebar -->
        </div>
    </div>
    <!-- ==================== E ContentArea ==================== -->

	<#include 'frags/footer.ftl'/>
    
</div>
</body>
</html>