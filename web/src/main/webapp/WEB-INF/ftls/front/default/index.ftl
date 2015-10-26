<#import "/spring.ftl" as spring/>
<!doctype html>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="${(frontSite.siteKey)!""}" />
    <meta name="description" content="${(frontSite.siteDescribed)!""}" />
<title>${(frontSite.siteName)!""}</title>
<#include "frags/header.ftl"/>
</head>

<body>
<div id="wrapper">
	
	<#include "frags/top.ftl"/>

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
									<@v5cms.banner maxSize=3></@v5cms.banner>
									<#list banners as banner>
										<div class="carousel-item">
											<a class="carousel-img" href="javascript:;" style="background:url(<@spring.url '/${banner.bannerPic}'/>) no-repeat top center;">
												<img width="1000" height="440" alt="" src="<@spring.url '/${banner.bannerPic}'/>">
											</a>
											<div class="carousel-info">
												<div class="carousel-info-inner">
													<h4><a href="#">小米手机3 TD--------${banner.bannerName}</a></h4>
													<p>迄今为止最快的小米手机，顶级双平台全球首发</p>
												</div>
											</div>
										</div>
									</#list>

			                        <div class="carousel-item">
			                            <a class="carousel-img" href="javascript:;" style="background:url(<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/banner-01.jpg'/>) no-repeat top center;">
                                            <img width="1000" height="440" alt="" src="<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/banner-01.jpg'/>">
										</a>
                                        <div class="carousel-info">
                                        	<div class="carousel-info-inner">
	                                        	<h4><a href="#">小米手机3 TD</a></h4>
	                                            <p>迄今为止最快的小米手机，顶级双平台全球首发</p>
                                            </div>
                                        </div>
			                        </div>		
			                        <div class="carousel-item">
			                            <a class="carousel-img" href="javascript:;" style="background:url(<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/banner-01.jpg'/>) no-repeat top center;">
                                            <img width="1000" height="440" alt="" src="<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/banner-01.jpg'/>">
										</a>
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
										<a href="#"><img class="typo_img" src="<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/ico-01.png'/>" style="width:40px; height:40px;" /></a>
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
										<a href="#"><img class="typo_img" src="<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/ico-02.png'/>" style="width:40px; height:40px;" /></a>
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
										<a href="#"><img class="typo_img" src="<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/ico-03.png'/>" style="width:40px; height:40px;" /></a>
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
										<a href="#"><img class="typo_img" src="<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/ico-04.png'/>" style="width:40px; height:40px;" /></a>
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
                        	<h3 class="mod-tit-icon" style="background-image:url(<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/tit-ico-01.png'/>);">最新产品</h3>
                        </div>                    	
                        <a href="#" class="float-right mod-more"><span>更多</span></a>
                    </div>                    
                    <div class="mod-content">
                        <!-- S scrollable -->                                                
                        <div class="scrollable carousel clearfix">
                            <ul id="scrollable-01" class="clearfix">
                                <li>
                                    <p><a href="products-detail.ftl"><img src="<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/latest_work01.jpg'/>" alt="" width="230" height="167" /></a></p>
                                    <h4><a href="products-detail.ftl">商业照明节电系统</a></h4>
                                </li>
                                <li>
                                    <p><a href="products-detail.ftl"><img src="<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/latest_work02.jpg'/>" alt="" width="230" height="167" /></a></p>
                                    <h4><a href="products-detail.ftl">空气源热泵</a></h4>
                                </li>
                                <li>
                                    <p><a href="products-detail.ftl"><img src="<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/latest_work03.jpg'/>" alt="" width="230" height="167" /></a></p>
                                    <h4><a href="products-detail.ftl">空气源热泵</a></h4>
                                </li>
                                <li>
                                    <p><a href="products-detail.ftl"><img src="<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/latest_work04.jpg'/>" alt="" width="230" height="167" /></a></p>
                                    <h4><a href="products-detail.ftl">商业照明节电系统</a></h4>
                                </li>
                                <li>
                                    <p><a href="products-detail.ftl"><img src="<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/latest_work01.jpg'/>" alt="" width="230" height="167" /></a></p>
                                    <h4><a href="products-detail.ftl">商业照明节电系统</a></h4>
                                </li>
                                <li>
                                    <p><a href="products-detail.ftl"><img src="<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/latest_work02.jpg'/>" alt="" width="230" height="167" /></a></p>
                                    <h4><a href="products-detail.ftl">空气源热泵</a></h4>
                                </li>
                                <li>
                                    <p><a href="products-detail.ftl"><img src="<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/latest_work03.jpg'/>" alt="" width="230" height="167" /></a></p>
                                    <h4><a href="products-detail.ftl">空气源热泵</a></h4>
                                </li>
                                <li>
                                    <p><a href="products-detail.ftl"><img src="<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/latest_work04.jpg'/>" alt="" width="230" height="167" /></a></p>
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
		                                            <h3 class="mod-tit-icon" style="background-image:url(<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/tit-ico-02.png'/>);">最新资讯</h3>
												</div>
												<a href="news.ftl" class="mod-more mod-more-img"><span>更多</span></a>
											</div>
											<div class="mod-content">
                                                <ul class="article-list-row">
                                                    <!-- S article-list-item -->
                                                    <li class="article-list-headlines">
                                                        <div class="typo">
                                                            <a href="news-detail.ftl"><img src="<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/article-list-img.jpg'/>" width="150" alt="" class="typo-img" /></a>
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
													<h3 class="mod-tit-icon" style="background-image:url(<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/tit-ico-03.png'/>);">最新案例</h3>
												</div>
												<a href="products.ftl" class="mod-more"><span>更多</span></a>
											</div>
											<div class="mod-content">
												<!-- S responsive-carousel -->
                                                <div class="responsive-carousel carousel clearfix">
													<div id="responsive-01">
														<div class="carousel-item">
															<div class="carousel-img"><a href="#"><img src="<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/case-img-01.jpg'/>" alt="" width="313" /></a></div>
															<div class="carousel-info">
                                                            	<div class="carousel-info-inner">
																	<h4>小米手机</h4>
                                                                </div>
															</div>
														</div>
														<div class="carousel-item">
															<div class="carousel-img"><a href="#"><img src="<@spring.url '/res/front/${frontSite.themeName!"default"}/images/upload/case-img-02.jpg'/>" alt="" width="313" /></a></div>
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
    
	<#include 'frags/footer.ftl'/>
    
</div>
</body>
</html>