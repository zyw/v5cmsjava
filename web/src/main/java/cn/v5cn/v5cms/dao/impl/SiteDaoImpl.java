package cn.v5cn.v5cms.dao.impl;

import cn.v5cn.v5cms.dao.SiteDao;
import cn.v5cn.v5cms.entity.Site;
import com.google.common.collect.ImmutableList;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZYW on 2014/6/30.
 */
@Repository("siteDao")
public class SiteDaoImpl implements SiteDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(SiteDaoImpl.class);

    @Autowired
    private SqlSession sqlSession;

    @Override
    public ImmutableList<Site> findSite(int siteId) {
        List<Site> temp = sqlSession.selectList(Site.class.getName()+".selectSite",siteId);
        ImmutableList<Site> result = ImmutableList.<Site>builder().addAll(temp).build();
        LOGGER.debug("查询Site ID为：{}的信息，找到的数量为：",siteId,result.size());
        return result;
    }

    @Override
    public ImmutableList<Site> findRunableSite(int isclosesite) {
        List<Site> temp = sqlSession.selectList(Site.class.getName()+".selectRunableSite",isclosesite);
        ImmutableList<Site> result = ImmutableList.<Site>builder().addAll(temp).build();
        LOGGER.debug("根据站点状态查找站点信息，状态为：{}，找到的数量为：{}",isclosesite,result.size());
        return result;
    }

    @Override
    public Long addSite(Site site) {
        int result =  sqlSession.insert(Site.class.getName() + ".addSite",site);
        LOGGER.debug("添加站点信息："+site);
        if(result > 0){
            LOGGER.debug("添加站点信息，创建的新数据库ID为：{}",site.getSiteId());
            return site.getSiteId();
        }
        LOGGER.error("添加站点信息失败：" + site);
        return 0L;
    }

    @Override
    public int updateSite(Site site) {
        LOGGER.debug("修改站点信息："+site);
        return sqlSession.update(Site.class.getName() + ".updateSite",site);
    }

    @Override
    public int deleteSite(int siteId) {
        LOGGER.debug("删除站点信息："+siteId);
        return sqlSession.update(Site.class.getName() + ".deleteSite",siteId);
    }
}
