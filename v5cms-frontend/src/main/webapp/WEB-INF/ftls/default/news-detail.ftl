<#import "/spring.ftl" as spring/>
<!doctype html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="${(content.contentKey)!""}" />
    <meta name="description" content="${(content.contentDes)!""}" />
    <title>${(frontSite.siteName)!""} - ${(content.cname)!""}</title>
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
									<div class="article-detail">
										<div class="article-title"><h1>${(content.cname)!""}</h1></div>
										<div class="article-info">
											<span>所属分类：<a href="#">${(content.column.columnName)!""}</a></span>
											<span>发布时间：<strong>${(content.lastdt)!""}</strong></span>
										</div>
										<div class="article-cont">
											<div class="qhd-content">
	                                        	<p style="text-align:center;"><img src="<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/article-detail-img.jpg'/>" alt="" /></p>
												<!--
												<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 用户体验，用户体验，用户体验，啥是用户体验?这貌似又是最近几年烂大街的一个词了。有些人说用户体验就是我上网的时候登陆输入邮箱那一刻，我输入完后面提供给我邮箱后缀;有些人说用户体验是我看一个老长老长老长，特喵的比旧社会妇女的裹脚布还长的页面，左下角那个回到顶部的按钮;有人说…得!打住，要我说，你别说了!啥是用户体验?用户体验就是让用户在使用过程中切实的感觉到方便、可行、简单，在对你的产品使用过程中，充分感觉到愉悦、舒服、顺利达到目的的心理感受!简而言之通俗点的说就是让用户在使用产品的过程中感觉到"爽"。或者说让用户说出来"次奥，碉堡了!"。呃，当然，前提是一点，我说的是好的用户体验，当然不好的就不煞风景了。 </p>
												<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 但是这么多人天天的说这些，愈发的让人感觉到似乎他们只有在他们对一些产品品头论足的时候说什么用户体验。或者总是说要提高用户体验之类的。但是有没有想过，其实用户体验就在我们身边，在我们的生活中有美好的用户体验吗?答案是肯定的，必须的必么，那我们接下来简单抓几个聊聊! </p>
												<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 大家平时洗澡的时候都用到什么?起码两样必须把，一个是洗发液还有一个是浴液。但是在前些年的时候更多的是大家用的香皂吧!提起舒肤佳相信没几个人不知道吧。早期的香皂就是一个圆筒形或者一个方块形。暂且不说效果怎么样好用不好用，起码有一点，就是在洗澡的时候或者洗脸的时候竟然容易从手里滑出去，抓不住，于是舒肤佳粗线了，他们将香皂设计成了腰身形状，注意，是美铝的那种弧线形的小蛮腰，不是老肥这种水桶腰(尼玛，我这是挖坑埋自己吗?)这样一来，最直接的提升了用户体验，洗澡使用的时候就可以很方便的抓住了，而且还方便，减掉的一部分还能节约一点成本，肿么样? </p>
												<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 不服气?再说几个，大家回家看看家里的管道线，尤其是北方的孩纸，那些管道线是不是有一些同学家里用绿色的枝叶、树木的蔓藤一样的塑料仿真给裹起来了?相对于普通的白色管子，你喜欢哪个?这样做的好处是什么?安全、美观同时还很别致。</p>
	                                            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 大家很多人喝过速溶咖啡吧，就是雀巢的那种，其实很多速溶咖啡的包装袋设计成了什么样子?条状!这样做的好处是什么?因为在这之前人们把这种包装袋的两边从平的设计成了锯齿状，这样便于撕开，可是如果是很宽的话往往撕开的时候容易开口很大，这样倾倒就不方便，可是设计成条状的话，方便携带同时又不容易在倾倒的时候撒出来。还有立顿茶的袋子，他用的袋子什么材质具体的我不懂，我只是知道那是一种可以冲泡的纸张，同时不会污染水，对人体造成影响，同时外流出的拉环，是立顿的标识，这样的好处是清晰的让人看到立顿的标识，同时卫生、不影响用户引用反而更加方便了。</p>
												<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 等等说不清有多少了，其实写这个的原因就在于想跟大家说用户体验无处不在，只要我们能够发现、能够去总结，那么不会找不到好的用户体验的。这对于我们提高功能技能和产品设计及优化等都是有很大帮助的。不是说么，艺术来源于生活，工作来源于生活，啥玩意都来源于生活!发现好的的用户体验，更重要的是发现生活美!</p>
	                                            <p>
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  1、报到时间：2013年3月15日下午2:00-4:00点 <br />
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  2、报到地点：云南省昆明市老民航路499号峨山温泉大酒店 <br />
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  3、培训时间：2013年3月15日—4月30日45天 <br />
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  4、作息时间：早6:00—晚21:30，听课、分享、习劳。 <br />
											   </p>
												-->
												${(content.cbody)!""}
											</div>
										</div>								
									</div>
									
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
                                <li class=""><a href="news.ftl">行业动态</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- E sidebar-menu -->
                
                <!-- S module-sidebar -->
                <div class="module module-sidebar">
                    <div class="mod-inner">                       
                        <div class="mod-content">                            
                        </div>
                    </div>
                </div>
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