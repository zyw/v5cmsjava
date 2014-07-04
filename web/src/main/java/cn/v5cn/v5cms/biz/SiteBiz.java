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
}
