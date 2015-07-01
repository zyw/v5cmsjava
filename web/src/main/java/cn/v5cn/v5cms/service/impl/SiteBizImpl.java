package cn.v5cn.v5cms.service.impl;

import cn.v5cn.v5cms.service.SiteBiz;
import cn.v5cn.v5cms.dao.SiteDao;
import cn.v5cn.v5cms.entity.Site;
import cn.v5cn.v5cms.util.SystemUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by ZYW on 2014/6/30.
 */
@Service("siteBiz")
public class SiteBizImpl implements SiteBiz {

    @Autowired
    private SiteDao siteDao;

    @Override
    public Site findBySiteId(Long siteId) {
        return siteDao.findBySiteId(siteId);
    }

    @Override
    public ImmutableList<Site> finadAll() {
        return ImmutableList.<Site>builder().addAll(siteDao.findAll()).build();
    }

    @Override
    public ImmutableList<Site> findByIsclosesite(int isclosesite) {

        return ImmutableList.<Site>builder().addAll(siteDao.findByIsclosesite(isclosesite)).build();
    }

    @Override
    @Transactional
    public Long addSite(Site site) {
        site.setCreateDate(DateTime.now().toDate());

        return siteDao.save(site).getSiteId();
    }

    @Override
    @Transactional
    public Site updateSite(Site site) throws InvocationTargetException, IllegalAccessException {
        Site s = siteDao.findOne(site.getSiteId());
        SystemUtils.copyProperties(s,site);
        return s;
    }

    @Override
    @Transactional
    public void deleteSite(Long[] siteIds) {
        List<Site> sites = Lists.newArrayList();
        Site site = null;
        for(Long siteId : siteIds){
            site = new Site();
            site.setSiteId(siteId);
            sites.add(site);
        }
        siteDao.delete(sites);
    }
}
