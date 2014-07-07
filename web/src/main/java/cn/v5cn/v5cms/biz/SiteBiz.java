package cn.v5cn.v5cms.biz;

import cn.v5cn.v5cms.entity.Site;
import com.google.common.collect.ImmutableList;

/**
 * Created by ZYW on 2014/6/30.
 */
public interface SiteBiz {
    ImmutableList<Site> findSize(int siteId);
    /**
     * 根据运行状态值查询站点
     * */
    ImmutableList<Site> findRunableSite(int isclosesite);
    /**
     * 添加站点信息
     * */
    int addSite(Site site);

    /**
     * 修改站点信息
     * */
    int updateSite(Site site);

    /**
     * 删除站点信息
     * */
    int deleteSite(int siteId);
}
