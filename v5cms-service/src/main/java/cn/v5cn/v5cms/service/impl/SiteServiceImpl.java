package cn.v5cn.v5cms.service.impl;

import cn.v5cn.v5cms.dao.SiteMapper;
import cn.v5cn.v5cms.service.SiteService;
import cn.v5cn.v5cms.entity.Site;
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
@Service("siteService")
public class SiteServiceImpl implements SiteService {

    @Autowired
    private SiteMapper siteMapper;

    /**
     * ==============================================================
     *
     * 后端方法
     *
     * ==============================================================
     **/

    @Override
    public Site findBySiteId(Long siteId) {
        return null;//siteDao.findBySiteId(siteId);
    }

    @Override
    public ImmutableList<Site> finadAll() {
        return null;//ImmutableList.<Site>builder().addAll(siteDao.findAll()).build();
    }

    @Override
    public ImmutableList<Site> findByUserNotCloseSite(long userId) {
        return ImmutableList.<Site>builder().addAll(siteMapper.findByUserNotCloseSite(userId)).build();
    }

    @Override
    @Transactional
    public Long addSite(Site site) {
        //site.setCreateDate(DateTime.now().toDate());

        return null;//siteDao.save(site).getSiteId();
    }

    @Override
    @Transactional
    public Site updateTemplate(Site site) throws InvocationTargetException, IllegalAccessException {
        return null;//siteDao.save(site);
    }

    @Override
    @Transactional
    public void deleteSite(Long[] siteIds) {
        List<Site> sites = Lists.newArrayList();
        Site site = null;
        for(Long siteId : siteIds){
            site = new Site();
            //site.setSiteId(siteId);
            sites.add(site);
        }
//        siteDao.delete(sites);
    }

    @Override
    public long countByDomainAndSiteIdNot(String domain,Long siteId) {
        return 0L;//siteDao.countByDomainAndSiteIdNot(domain,siteId);
    }

    /**
     * ==============================================================
     *
     * 前端方法
     *
     * ==============================================================
     **/

    @Override
    public Site findByDomain(String domain) {
        return null;//siteDao.findByDomain(domain);
    }
}
