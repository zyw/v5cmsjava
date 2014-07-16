package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZYW on 2014/6/30.
 */
@Repository("siteDao")
public interface SiteDao extends JpaRepository<Site,Long> {
//    Site save(Site site);
//    Iterable<Site> findAll();
//    void delete(Long id);
    /**
     * 根据站点ID查询站点。
     * */
    Site findBySiteId(Long siteId);
    /**
     * 根据运行状态值查询站点
     * */
    List<Site> findByIsclosesite(int isclosesite);
//    /**
//     * 修改站点信息
//     * */
//    @Transactional
//    int update(Site site);
}
