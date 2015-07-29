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

    /**
     * ==============================================================
     *
     * 后端方法
     *
     * ==============================================================
     **/

    /**
     * 根据站点ID查询站点。
     * */
    Site findBySiteId(Long siteId);
    /**
     * 根据运行状态值查询站点
     * */
    List<Site> findByIsclosesite(int isclosesite);

    /**
     * 根据域名查询域名的个数
     * */
    long countByDomainAndSiteIdNot(String domain,Long siteId);

    /**
     * ==============================================================
     *
     * 前端方法
     *
     * ==============================================================
     **/

    /**
     * 根据域名查询站点信息。
     * @param domain 域名，例如：wwww.explatem.com
     * */
    Site findByDomain(String domain);
}
