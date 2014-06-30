package cn.v5cn.v5cms.dao.impl;

import cn.v5cn.v5cms.dao.SiteDao;
import cn.v5cn.v5cms.entity.Site;
import com.google.common.base.Optional;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ZYW on 2014/6/30.
 */
@Repository("siteDao")
public class SiteDaoImpl implements SiteDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public Optional<Site> findSite() {
        Site result = sqlSession.selectOne(Site.class.getName()+".selectSite");
        if(result != null) return Optional.of(result);
        return Optional.absent();
    }
}
