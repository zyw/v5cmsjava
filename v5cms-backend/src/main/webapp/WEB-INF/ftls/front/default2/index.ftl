<#import "/spring.ftl" as spring/>
<!--
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
-->
<!doctype html>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Common Skin Demo - 企互动</title>
<link rel="stylesheet" href="<@spring.url '/res/front/default/css/content.css'/>" type="text/css" />
<link rel="stylesheet" href="<@spring.url '/res/front/default/css/menu.css'/>" type="text/css" />
<link rel="stylesheet" href="<@spring.url '/res/front/default/css/jquery.fancybox-1.3.4.css'/>" type="text/css" />
<link rel="stylesheet" href="<@spring.url '/res/front/default/css/style.css'/>" type="text/css" />

<script type="text/javascript" src="<@spring.url '/res/front/default/js/jquery-1.7.2.min.js'/>"></script>
<script type="text/javascript" src="<@spring.url '/res/front/default/js/superfish.js'/>"></script>
<script type="text/javascript" src="<@spring.url '/res/front/default/js/jquery.carouFredSel.js'/>"></script>
<script type="text/javascript" src="<@spring.url '/res/front/default/js/jquery.tools.min.js'/>"></script>
<script type="text/javascript" src="<@spring.url '/res/front/default/js/jquery.fancybox-1.3.4.pack.js'/>"></script>
<script type="text/javascript" src="<@spring.url '/res/front/default/js/custom.js'/>"></script>
<!--[if IE 6]>
	<script type="text/javascript" src="<@spring.url '/res/front/default/js/ie7.js'/>"></script>
	<script type="text/javascript" src="<@spring.url '/res/front/default/js/DD_belatedPNG.js'/>"></script>
	<script type="text/javascript">
		DD_belatedPNG.fix('.logo img, .Header img');
	</script>
<![endif]-->
</head>

<body>
<div id="wrapper">
	
    <!-- ==================== S Top ==================== -->
    <div class="Top">
		<!-- S top-toolbar -->
        <div class="top-toolbar">
	        <div class="page-width clearfix">
				<!-- S top-area -->
                <div class="top-area">
                	<!-- S language-select -->
					<div class="language-select float-right">	                	
						<ul class="sf-menu">
							<li>
								<a href="#" class="first-level"><span class="language-ico" style="background-image:url(<@spring.url '/r/default/images/icon/zh-CN.png'/>)">简体中文</span></a>
								<ul>
									<li><a href="#">
                                        <span class="language-ico" style="background-image:url(<@spring.url '/r/default/images/icon/zh-CN.png'/>);">简体中文</span>
                                    </a></li>
									<li><a href="#">
                                        <span class="language-ico" style="background-image:url(<@spring.url '/r/default/images/icon/zh-HK.png'/>);">繁体中文</span>
                                    </a></li>
									<li><a href="#">
                                        <span class="language-ico" style="background-image:url(<@spring.url '/r/default/images/icon/en-US.png'/>);">English</span>
                                    </a></li>
								</ul>
							</li>					
						</ul>
					</div>
					<!-- E language-select -->
                </div>
                <!-- E top-area -->
			</div>
        </div>
        <!-- S top-toolbar -->
        
		<!-- top-container -->
        <div class="top-container">
			<div class="page-width clearfix">
				<!-- S logo -->
				<div class="logo">
					<a href="index.ftl">
                    	<img src="<@spring.url '/res/front/default/images/logo.png'/>" alt="企互动" width="200" height="60" />
                    </a>
				</div>
				<!-- E logo -->
				
				<!-- S top-container-widget -->
				<div class="top-container-widget float-right">
	            	<!-- S nav-area -->
					<div class="nav-area clearfix">
                        <ul class="sf-menu main-nav">                                                                             
                            <li class="current">
                                <a href="index.ftl">网站首页</a>
                                <ul>
									<li>
                                    	<a href="index.ftl">二级菜单 11</a>
                                    	<ul>
											<li><a href="index.ftl">三级菜单 11</a></li>
											<li><a href="index.ftl">三级菜单 22</a></li>
                                            <li><a href="index.ftl">三级菜单 11</a></li>
											<li><a href="index.ftl">三级菜单 22</a></li>
                                            <li><a href="index.ftl">三级菜单 11</a></li>
											<li class="isLast">
                                              	<a href="index.ftl">三级菜单 22</a>
		                                    	<ul>
													<li><a href="index.ftl">四级菜单 11</a></li>
													<li class="isLast"><a href="index.ftl">四级菜单 22</a></li>
												</ul>
                                            </li>
										</ul>
                                    </li>
									<li class="isLast"><a href="index.ftl">二级菜单 22</a></li>
								</ul>
                            </li>
                            <li class="">
                                <a href="about.ftl">关于我们</a>
                                <ul>
									<li><a href="about.ftl">公司简介</a></li>
									<li><a href="about.ftl">公司荣誉</a></li>
                                    <li><a href="about.ftl">发展历程</a></li>
                                    <li><a href="about.ftl">团队介绍</a></li>
								</ul>					
                            </li>
                            <li class="">
                                <a href="products.ftl">产品展示</a>
                            </li>
                            <li class="">
                                <a href="showcase.ftl">工程案例 </a>
                            </li>
                            <li class="">
                                <a href="news.ftl">资讯中心</a>
                                <ul>
									<li><a href="news.ftl">公司新闻</a></li>
									<li><a href="news2.ftl">行业动态</a></li>
								</ul>
                            </li>
                            <li class="">
                                <a href="contact.ftl">联系我们</a>
                                <ul>
									<li><a href="contact.ftl">联系方式</a></li>
									<li><a href="message.ftl">在线留言</a></li>
								</ul>				
                            </li>
                        </ul>
					</div>
					<!-- E nav-area -->             
				</div>
				<!-- E top-container-widget -->
				
				<div class="clear"></div>
			</div>
        </div>
        <!-- top-container -->
		
	</div>
    <!-- ==================== E Top ==================== -->
    
    
    
    
    <!-- ==================== S Header ==================== -->
    <div class="Header">
		<!-- S module-default -->
		<div class="module-default">
        	<div class="mod-inner">
            	<div class="mod-content">
                	<!-- S banner -->
                    
                    <div class="banner banner-bg banner-padding">
                    	<div class="full-page">                        	
			                <div class="slideshow carousel clearfix">
			                    <div id="slideshow-01">
			                        <div class="carousel-item">
			                            <a class="carousel-img" href="javascript:;" style="background:url(<@spring.url '/r/default/assets/images/upload/banner-01.jpg'/>) no-repeat top center;"></a>
                                        <div class="carousel-info">
                                        	<div class="carousel-info-inner">
	                                        	<h4><a href="#">小米手机3 TD</a></h4>
	                                            <p>迄今为止最快的小米手机，顶级双平台全球首发</p>
                                            </div>
                                        </div>
			                        </div>		
			                        <div class="carousel-item">
			                            <a class="carousel-img" href="javascript:;" style="background:url(<@spring.url '/r/default/assets/images/upload/banner-01.jpg'/>) no-repeat top center;"></a>
                                        <div class="carousel-info">
                                        	<div class="carousel-info-inner">
	                                        	<h4><a href="#">小米手机3 TD</a></h4>
	                                            <p>迄今为止最快的小米手机，顶级双平台全球首发</p>
                                            </div>
                                        </div>
			                        </div>
			                    </div>
			                    <div class="carousel-btn" id="banner-page-01"></div>
                                <div class="carousel-direction">
	                            	<a class="carousel-prev" id="carousel-prev-02" href="#"><span> &lt; </span></a>
	                                <a class="carousel-next" id="carousel-next-02" href="#"><span> &gt; </span></a>
	                            </div>
			                    <script type="text/javascript">
			                       $(function(){
			                            $("#slideshow-01").carouFredSel({
			                                responsive: true,									
			                                items: { visible: 1 },
			                                pagination: "#banner-page-01",
											prev: {button:"#carousel-prev-02",key:"left"},
							  				next: {button:"#carousel-next-02",key:"right"}
			                            });
			                        });
			                    </script>
			                </div>			               
                        </div>
                    </div>
                    
                    <!-- 
                    <div class="banner">
                    	<div class="full-screen">                        	
			                <div class="slideshow carousel clearfix">
			                    <div id="slideshow-01">							
			                        <div class="carousel-item">
			                            <a class="carousel-img" href="javascript:;" style="background:url(images/upload/screen-banner-01.jpg) no-repeat top center;"></a>
			                        </div>						
			                        <div class="carousel-item">
			                            <a class="carousel-img" href="javascript:;" style="background:url(images/upload/screen-banner-01.jpg) no-repeat top center;"></a>
			                        </div>
			                    </div>
			                    <div class="carousel-btn carousel-fixed-btn" id="banner-page-01"></div>
			                    <script type="text/javascript">
			                        $(function() {
			                            $("#slideshow-01").carouFredSel({
			                                responsive: true,									
			                                items: { visible: 1 },
			                                pagination: "#banner-page-01"
			                            });
			                        });
			                    </script>
			                </div>			               
                        </div>
                    </div>
                    -->
                    
                    <!-- E banner -->                    
                </div>
            </div> <!-- end of mod-inner -->
		</div>
		<!-- E module-default -->
        
        
       <!-- S　module-bc -->
        <div class="module module-bc module-border-b">
        	<div class="mod-inner">
            	<div class="mod-content">
                	<div class="page-width">
                    	<!-- S qhd-content-->
                    	<div class="qhd-content">
                        	<div class="column">
								<div class="col-4-1">
									<div class="typo">
										<a href="#"><img class="typo_img" src="<@spring.url '/res/front/default/images/upload/ico-01.png'/>" style="width:40px; height:40px;" /></a>
										<div class="typo_text">
											<h5>CLEAN THEME</h5>
										</div>
									</div>
									<p>Ut nec lorem id orci convallis porta. Donec pharetra neque eu velit dictum molestie. Duis porta gravida augue sed viverra. Quisque at nulla leo, non aliquet mi.</p>
									<ul class="iconlist iconlist-dot">
										<li><a href="#">Read More</a></li>
                                    </ul>
								</div>
								<div class="col-4-1">
									<div class="typo">
										<a href="#"><img class="typo_img" src="<@spring.url '/res/front/default/images/upload/ico-02.png'/>" style="width:40px; height:40px;" /></a>
										<div class="typo_text">
											<h5>CLEAN THEME</h5>
										</div>
									</div>
									<p>Ut nec lorem id orci convallis porta. Donec pharetra neque eu velit dictum molestie. Duis porta gravida augue sed viverra. Quisque at nulla leo, non aliquet mi.</p>
									<ul class="iconlist iconlist-dot">
										<li><a href="#">Read More</a></li>
                                    </ul>
								</div>
								<div class="col-4-1">
									<div class="typo">
										<a href="#"><img class="typo_img" src="<@spring.url '/res/front/default/images/upload/ico-03.png'/>" style="width:40px; height:40px;" /></a>
										<div class="typo_text">
											<h5>CLEAN THEME</h5>
										</div>
									</div>
									<p>Ut nec lorem id orci convallis porta. Donec pharetra neque eu velit dictum molestie. Duis porta gravida augue sed viverra. Quisque at nulla leo, non aliquet mi.</p>
									<ul class="iconlist iconlist-dot">
										<li><a href="#">Read More</a></li>
                                    </ul>
								</div>
								<div class="col-4-1 last">
									<div class="typo">
										<a href="#"><img class="typo_img" src="<@spring.url '/res/front/default/images/upload/ico-04.png'/>" style="width:40px; height:40px;" /></a>
										<div class="typo_text">
											<h5>CLEAN THEME</h5>
										</div>
									</div>
									<p>Ut nec lorem id orci convallis porta. Donec pharetra neque eu velit dictum molestie. Duis porta gravida augue sed viverra. Quisque at nulla leo, non aliquet mi.</p>
									<ul class="iconlist iconlist-dot">
										<li><a href="#">Read More</a></li>
                                    </ul>
								</div>
							</div>							
                        </div>
                        <!-- E qhd-content-->                        
                    </div>
                </div>
            </div>
        </div>
        <!-- E module-bc -->
    </div>
    <!-- ==================== E Header ==================== -->
    
    
    
    
    <!-- ==================== S ContentArea ==================== -->
    <div class="ContentArea">    	
    	<div class="page-width clearfix">
        
        	<!-- S module -->
            <div class="module module-tit-border-b">
            	<div class="mod-inner">
                	<div class="mod-tit clearfix">
                    	<div class="mod-tit-group">
                        	<h3 class="mod-tit-icon" style="background-image:url(<@spring.url '/r/default/images/upload/tit-ico-01.png'/>);">最新产品</h3>
                        </div>                    	
                        <a href="#" class="float-right mod-more"><span>更多</span></a>
                    </div>                    
                    <div class="mod-content">
                        <!-- S scrollable -->                                                
                        <div class="scrollable carousel clearfix">
                            <ul id="scrollable-01" class="clearfix">
                                <li>
                                    <p><a href="products-detail.ftl"><img src="<@spring.url '/res/front/default/images/upload/latest_work01.jpg'/>" alt="" width="230" height="167" /></a></p>
                                    <h4><a href="products-detail.ftl">商业照明节电系统</a></h4>
                                </li>
                                <li>
                                    <p><a href="products-detail.ftl"><img src="<@spring.url '/res/front/default/images/upload/latest_work02.jpg'/>" alt="" width="230" height="167" /></a></p>
                                    <h4><a href="products-detail.ftl">空气源热泵</a></h4>
                                </li>
                                <li>
                                    <p><a href="products-detail.ftl"><img src="<@spring.url '/res/front/default/images/upload/latest_work03.jpg'/>" alt="" width="230" height="167" /></a></p>
                                    <h4><a href="products-detail.ftl">空气源热泵</a></h4>
                                </li>
                                <li>
                                    <p><a href="products-detail.ftl"><img src="<@spring.url '/res/front/default/images/upload/latest_work04.jpg'/>" alt="" width="230" height="167" /></a></p>
                                    <h4><a href="products-detail.ftl">商业照明节电系统</a></h4>
                                </li>
                                <li>
                                    <p><a href="products-detail.ftl"><img src="<@spring.url '/res/front/default/images/upload/latest_work01.jpg'/>" alt="" width="230" height="167" /></a></p>
                                    <h4><a href="products-detail.ftl">商业照明节电系统</a></h4>
                                </li>
                                <li>
                                    <p><a href="products-detail.ftl"><img src="<@spring.url '/res/front/default/images/upload/latest_work02.jpg'/>" alt="" width="230" height="167" /></a></p>
                                    <h4><a href="products-detail.ftl">空气源热泵</a></h4>
                                </li>
                                <li>
                                    <p><a href="products-detail.ftl"><img src="<@spring.url '/res/front/default/images/upload/latest_work03.jpg'/>" alt="" width="230" height="167" /></a></p>
                                    <h4><a href="products-detail.ftl">空气源热泵</a></h4>
                                </li>
                                <li>
                                    <p><a href="products-detail.ftl"><img src="<@spring.url '/res/front/default/images/upload/latest_work04.jpg'/>" alt="" width="230" height="167" /></a></p>
                                    <h4><a href="products-detail.ftl">商业照明节电系统</a></h4>
                                </li>
                            </ul>
                            <div class="carousel-direction">
                            	<a class="carousel-prev" id="carousel-prev-01" href="#"><span> &lt; </span></a>
                                <a class="carousel-next" id="carousel-next-01" href="#"><span> &gt; </span></a>
                            </div>
                        </div>
                        <script type="text/javascript">
                        	$(function() {
                            	$("#scrollable-01").carouFredSel({
                              		infinite: false,
                              		auto 	: false,
							  		prev: {button:"#carousel-prev-01",key:"left"},
							  		next: {button:"#carousel-next-01",key:"right"}
                            	});
                        	});
                        </script>
                        <!-- E scrollable-->                        
                    </div>                    
                    <div class="mod-dividing"></div>
                </div>
            </div>
        	<!-- E module -->
        
			<!-- S module-default -->
			<div class="module-default">
            	<div class="mod-inner">
                	<div class="mod-content">
                    	<!-- S qhd-module -->
						<div class="qhd-module">
							<div class="column">
								<div class="col-3-2">
									<!-- S module -->
									<div class="module">
										<div class="mod-inner">
											<div class="mod-tit clearfix">
												<div class="mod-tit-group">
		                                            <h3 class="mod-tit-icon" style="background-image:url(<@spring.url '/r/default/images/upload/tit-ico-02.png'/>);">最新资讯</h3>
												</div>
												<a href="news.ftl" class="mod-more mod-more-img"><span>更多</span></a>
											</div>
											<div class="mod-content">
                                                <ul class="article-list-row">
                                                    <!-- S article-list-item -->
                                                    <li class="article-list-headlines">
                                                        <div class="typo">
                                                            <a href="news-detail.ftl"><img src="<@spring.url '/res/front/default/images/upload/article-list-img.jpg'/>" width="150" alt="" class="typo-img" /></a>
                                                            <div class="typo-text">
                                                                <div class="article-title"><h3><a href="news-detail.ftl">互联网的扁平化设计之争</a></h3></div>
                                                                <div class="article-summary">
                                                                    <div class="qhd-content">
                                                                        <p>不可否认，扁平设计目前是设计界的宠儿 它无处不在。不仅仅是扁平设计，现在也包括类扁平设计 关于这种风格的有效性与用途的争论如火如荼。这种极度时髦的设计风格在激发着每个人的观念...</p>
                                                                    </div>
                                                                </div>
                                                                <div class="article-info">
                                                                    <span class="article-time">发表日期：2012-11-26</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <!-- E article-list-item -->  	
                                                    <li><span class="article-time float-right">2012-11-26</span><a href="news-detail.ftl">你的眼睛喜欢看什么？ </a></li>
                                                    <li><span class="article-time float-right">2012-11-26</span><a href="news-detail.ftl">是否应该将iOS7设计风格融入你的应用？ </a></li>
                                                </ul>
											</div>                                      
										</div>
									</div>
									<!-- S module -->
								</div>
								<div class="col-3-1 last">
									<!-- S module -->
									<div class="module">
										<div class="mod-inner">
											<div class="mod-tit clearfix">
												<div class="mod-tit-group">
													<h3 class="mod-tit-icon" style="background-image:url(<@spring.url '/r/default/images/upload/tit-ico-03.png'/>);">最新案例</h3>
												</div>
												<a href="products.ftl" class="mod-more"><span>更多</span></a>
											</div>
											<div class="mod-content">
												<!-- S responsive-carousel -->
                                                <div class="responsive-carousel carousel clearfix">
													<div id="responsive-01">
														<div class="carousel-item">
															<div class="carousel-img"><a href="#"><img src="<@spring.url '/res/front/default/images/upload/case-img-01.jpg'/>" alt="" width="313" /></a></div>
															<div class="carousel-info">
                                                            	<div class="carousel-info-inner">
																	<h4>小米手机</h4>
                                                                </div>
															</div>
														</div>
														<div class="carousel-item">
															<div class="carousel-img"><a href="#"><img src="<@spring.url '/res/front/default/images/upload/case-img-02.jpg'/>" alt="" width="313" /></a></div>
															<div class="carousel-info">
                                                            	<div class="carousel-info-inner">
																	<h4>小米电视</h4>
                                                                </div>
															</div>
														</div>														
													</div>
                                                    <div class="carousel-direction">
						                            	<a class="carousel-prev" id="carousel-prev-03" href="#"><span> &lt; </span></a>
						                                <a class="carousel-next" id="carousel-next-03" href="#"><span> &gt; </span></a>
						                            </div>
												</div>
												<script type="text/javascript">
                                                	$(window).load(function(){
														$("#responsive-01").carouFredSel({
															responsive	: true,
															prev 		: { button:"#carousel-prev-03",key:"left" },
													  		next 		: { button:"#carousel-next-03",key:"right" },
															scroll 		: {	fx : "crossfade" },
															items		: { visible	: 1 }
														});	
													});
                                                </script>								
												<!-- E responsive-carousel -->
											</div>
										</div>
									</div>
									<!-- S module -->
								</div>
							</div>
						</div>
						<!-- E qhd-module -->
                        
                        
                    </div>
                </div><!-- end of mod-inner-->                				
			</div>
			<!-- E module-default -->
			
		
			
			
        </div>
    </div>
    <!-- ==================== E ContentArea ==================== -->
    
    
    
    
    <!-- ==================== S Footer ==================== -->
    <div class="Footer">
		<div class="page-width clearfix">
        	<div class="module-default">
            	<div class="mod-inner">
                	<div class="mod-content">
                  		<!-- S qhd-module -->
			        	<div class="qhd-module">
			            	<div class="column">
			                	<div class="col-3-1">
			                    	<!-- S module-->
			                    	<div class="module">
			                        	<div class="mod-inner">
			                            	<div class="mod-tit clearfix">
			                                	<div class="mod-tit-group"><h3>友情链接</h3></div>
			                                    <a class="mod-more" href="friend-link.ftl"><span>更多</span></a>
			                                </div>
			                                <div class="mod-content">
			                                	<div class="link-line clearfix">
			                                    	<ul class="clearfix">
			                                      		<li><a href="#" target="_blank">广州企互动科技有限公司</a></li>
			                                          	<li><a href="#" target="_blank">企互动</a></li>
			                                          	<li><a href="#" target="_blank">企互动</a></li>
			                                          	<li><a href="#" target="_blank">广州企互动科技有限公司</a></li>
			                                         	<li><a href="#" target="_blank">企互动</a></li>
			                                          	<li><a href="#" target="_blank">广州企互动科技有限公司</a></li>
			                                          	<li><a href="#" target="_blank">企互动</a></li>
			                                          	<li><a href="#" target="_blank">广州企互动科技有限公司</a></li>
			                                          	<li><a href="#" target="_blank">广州企互动科技有限公司</a></li>
			                                          	<li><a href="#" target="_blank">企互动</a></li>
			                                    	</ul>
			                                    </div>
			                                </div>
			                            </div>
			                        </div>
			                        <!-- E module-->
			                    </div>
			                    
			                    <div class="col-3-1">
			                    	<!-- S module-no-margin-->
			                    	<div class="module module-no-margin">
			                        	<div class="mod-inner">
			                            	<div class="mod-tit clearfix">
			                                	<div class="mod-tit-group"><h3>联系我们</h3></div>
			                                </div>
			                                <div class="mod-content">
			                                	<div class="qhd-content">
			                                    	<p>电话：020-1234567</p>
			                                        <p>邮箱：admin@qihudong.com</p>
			                                        <p>QQ：123456789</p>
			                                        <p>地址：广东省广州市越秀区广卫路</p>
			                                    </div>
			                                </div>
			                            </div>
			                        </div>
			                        <!-- E module-no-margin-->
			                    </div>
			                    
			                    <div class="col-3-1 last">
			                    	<!-- S module-->
			                    	<div class="module">
			                        	<div class="mod-inner">
			                            	<div class="mod-tit clearfix">
			                                	<div class="mod-tit-group"><h3>关注我们</h3></div>                                    
			                                </div>
			                                <div class="mod-content">
			                                	<!-- S qhd-content-->
			                                    <div class="qhd-content">
			                                    	<p>
				                                    	<a href="#" target="_blank"><img src="<@spring.url '/res/front/default/images/upload/ico-sina.gif'/>" alt="新浪微博" title="点击关注新浪微博" /></a>&nbsp;&nbsp;
				                                    	<a href="#" target="_blank"><img src="<@spring.url '/res/front/default/images/upload/ico-tx.gif'/>" alt="腾讯微博" title="点击关注腾讯微博" /></a>&nbsp;&nbsp;
				                                        <a href="#" target="_blank"><img src="<@spring.url '/res/front/default/images/upload/ico-douban.gif'/>" alt="豆瓣" title="点击关注豆瓣"  /></a>&nbsp;&nbsp;
				                                    </p>
			                                    </div>
			                                    <!-- E qhd-content-->               
			                                </div>
			                            </div>
			                        </div>
			                        <!-- E module-->
			                    </div>
			                </div>
			            </div>
			            <!-- E qhd-module -->  	
                    </div>
                </div>
            </div>        	
		</div>
	</div>
    <!-- ==================== E Footer ==================== -->
    
    
    
    <!-- ==================== S Bottom ==================== -->
    <div class="Bottom">
		<div class="page-width">
			<div class="module-default">
            	<div class="mod-inner">
                	<div class="mod-content">
                    	<div class="qhd-module">
							<div class="column">
								<div class="col-3-1">
									<!-- S module-no-margin -->
									<div class="module-no-margin">
		                            	<div class="mod-inner">
											<div class="mod-content">
		                                    	<!-- S link-line-->
												<div class="link-line">
													<ul class="clearfix">
														<li><a href="video.ftl">视频中心</a><span>-</span></li>
														<li><a href="jobs.html">人才招聘</a><span>-</span></li>
														<li><a href="#">在线留言 </a></li>											
													</ul>
												</div>
												<!-- E link-line-->
											</div>
		                                </div>
									</div>
									<!-- E module-no-margin -->
								</div>
								<div class="col-3-2 last">
									<!-- S module-no-margin -->
									<div class="module-no-margin">
										<div class="mod-inner">
		                                	<div class="mod-content">
		                                    	<!-- S qhd-content -->
												<div class="qhd-content">
													<p style="text-align:right">Copyright 2008-2013 广州企互动科技有限公司，All Right Serviced 粤ICP备01022235号-62</p>
												</div>
												<!-- E qhd-content -->
		                                    </div>
		                                </div>	
									</div>
									<!-- E module-no-margin -->
								</div>
							</div>
						</div>
                    </div>
                </div>				
			</div>
		</div>
    </div>
    <!-- ==================== E Bottom ==================== -->
    
	
	
    
</div>
</body>
</html>