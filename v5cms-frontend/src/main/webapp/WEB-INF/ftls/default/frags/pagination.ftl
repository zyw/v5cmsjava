<!-- S pagination -->
<#if pageContent?? && pageContent.totalPages gt 0>
<div class="pagination pagination-default">
    <#if pageContent.isFirst()>
        <span title="首页" class="page_first disabled">首页</span>
        <span title="上一页" class="page_prev disabled">上一页</span>
    <#else>
        <a title="首页" href="#?page=2" class="page_next">首页</a>
        <a title="上一页" href="#?page=200" class="page_last">上一页</a>
    </#if>

    <#assign currentPage=(pageContent.number + 1)/>
    <#assign totalPage=(pageContent.totalPages)/>

    <#if (currentPage - 2) gt 0>
        <#assign page_start = (currentPage-2) />
    <#else>
        <#assign page_start = 1/>
    </#if>

    <#if (page_start + 4) gte totalPage >
        <#assign page_end = totalPage/>
    <#else>
        <#assign page_end = page_start + 4/>
    </#if>

    <#if page_start gt 1>
        ...
    </#if>

    <#list page_start..page_end as groupId>
        <#assign pageIndex = groupId/>
        <#if groupId == currentPage>
            <span class="current">${groupId}</span>
        <#else>
            <a href="#?page=${groupId}">${groupId}</a>
        </#if>
    </#list>

    <#if page_end lt totalPage>
        ...
    </#if>

    <#if currentPage == totalPage>
        <span title="下一页" class="page_first disabled">下一页</span>
        <span title="末页" class="page_prev disabled">末页</span>
    <#else>
        <a title="下一页" href="#?page=2" class="page_next">下一页</a>
        <a title="末页" href="#?page=200" class="page_last">末页</a>
    </#if>

</div>
</#if>
<!-- E pagination -->