package cn.v5cn.v5cms.biz.impl;

import cn.v5cn.v5cms.biz.SiteBiz;
import cn.v5cn.v5cms.dao.SiteDao;
import cn.v5cn.v5cms.entity.Site;
import com.google.common.base.Optional;
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
    public Optional<Site> findSize() {
        return siteDao.findSite();
    }
}
