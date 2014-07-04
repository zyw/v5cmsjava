package cn.v5cn.v5cms.biz.impl;

import cn.v5cn.v5cms.biz.SiteBiz;
import cn.v5cn.v5cms.dao.SiteDao;
import cn.v5cn.v5cms.entity.Site;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZYW on 2014/6/30.
 */
@Service("siteBiz")
public class SiteBizImpl implements SiteBiz {

    @Autowired
    private SiteDao siteDao;

    @Override
    public ImmutableList<Site> findSize(int siteId) {
        return siteDao.findSite(siteId);
    }

    @Override
    public ImmutableList<Site> findRunableSite(int isclosesite) {
        return siteDao.findRunableSite(isclosesite);
    }
}
