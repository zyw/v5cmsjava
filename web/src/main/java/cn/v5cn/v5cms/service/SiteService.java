package cn.v5cn.v5cms.service;

import cn.v5cn.v5cms.entity.Site;
import com.google.common.collect.ImmutableList;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by ZYW on 2014/6/30.
 */
public interface SiteService {
    Site findBySiteId(Long siteId);

    ImmutableList<Site> finadAll();
    /**
     * 根据运行状态值查询站点
     * */
    ImmutableList<Site> findByIsclosesite(int isclosesite);
    /**
     * 添加站点信息
     * */
    Long addSite(Site site);

    /**
     * 修改站点信息
     * */
    Site updateTemplate(Site site) throws InvocationTargetException, IllegalAccessException;

    /**
     * 删除站点信息
     * */
    void deleteSite(Long[] siteIds);

    /**
     * 根据域名查询域名的个数
     * */
    long countByDomainAndSiteIdNot(String domain,Long siteId);
}
