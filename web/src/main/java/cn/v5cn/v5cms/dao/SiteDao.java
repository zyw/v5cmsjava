package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.Site;
import com.google.common.collect.ImmutableList;

/**
 * Created by ZYW on 2014/6/30.
 */
public interface SiteDao {
    ImmutableList<Site> findSite(int siteId);
}
