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
                            <a href="#" class="first-level"><span class="language-ico" style="background-image:url(<@spring.url '/res/front/${frontSite.themeName!"default"}/images/icon/zh-CN.png'/>)">简体中文</span></a>
                            <ul>
                                <li><a href="#">
                                    <span class="language-ico" style="background-image:url(<@spring.url '/res/front/${frontSite.themeName!"default"}/images/icon/zh-CN.png'/>);">简体中文</span>
                                </a></li>
                                <li><a href="#">
                                    <span class="language-ico" style="background-image:url(<@spring.url '/res/front/${frontSite.themeName!"default"}/images/icon/zh-HK.png'/>);">繁体中文</span>
                                </a></li>
                                <li><a href="#">
                                    <span class="language-ico" style="background-image:url(<@spring.url '/res/front/${frontSite.themeName!"default"}/images/icon/en-US.png'/>);">English</span>
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

    <#--
    <#list columns as column>
    ${column.columnName} ---- ${column.colsId}<br/>
    <hr>
    </#list>
    -->

    <!-- top-container -->
    <div class="top-container">
        <div class="page-width clearfix">
            <!-- S logo -->
            <div class="logo">
                <a href="index.ftl">
                    <img src="<@spring.url '/res/front/${frontSite.themeName!"default"}/images/logo.png'/>" alt="企互动" width="200" height="60" />
                </a>
            </div>
            <!-- E logo -->

            <!-- S top-container-widget -->
            <div class="top-container-widget float-right">
                <!-- S nav-area -->
                <div class="nav-area clearfix">
                    <ul class="sf-menu main-nav">
                        <li class="current">
                            <a href="<@spring.url "/"/>">网站首页</a>
                            <#--
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
                    -->
                    </li>
                    <@v5cms.column siteId=10005 maxSize=10></@v5cms.column>

                <#list columns as column>
                    <li class="">
                        <a href="<@spring.url '/nav/${column.colsId}.htm'/>">${column.columnName!""}</a>
                        <@v5cms.column parentId=(column.colsId!0) siteId=10005></@v5cms.column>
                    <#if columns?size != 0>
                        <ul>
                            <#list columns as col>
                                <li><a href="<@spring.url '/nav/${col.colsId}.htm'/>">${col.columnName!""}</a></li>
                            </#list>
                        </ul>
                    </#if>
                    </li>
                </#list>
                <#--
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
                -->
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