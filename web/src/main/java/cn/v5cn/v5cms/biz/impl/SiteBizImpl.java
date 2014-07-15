package cn.v5cn.v5cms.biz.impl;

import cn.v5cn.v5cms.biz.SiteBiz;
import cn.v5cn.v5cms.dao.SiteDao;
import cn.v5cn.v5cms.entity.Site;
import com.google.common.collect.ImmutableList;
import org.joda.time.DateTime;
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
        return null;//siteDao.findSite(siteId);
    }

    @Override
    public ImmutableList<Site> findRunableSite(int isclosesite) {
        return null;//siteDao.findRunableSite(isclosesite);
    }

    @Override
    public Long addSite(Site site) {
        site.setCreateDate(DateTime.now().toDate());
        return 0L;//siteDao.addSite(site);
    }

    @Override
    public int updateSite(Site site) {
        return 0;//siteDao.updateSite(site);
    }

    @Override
    public int deleteSite(int siteId) {
        return 0;//siteDao.deleteSite(siteId);
    }
}
