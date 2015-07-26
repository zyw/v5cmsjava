package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by zyw on 15/7/26.
 */
@Repository
public interface BannerDao extends JpaRepository<Banner,Long>,JpaSpecificationExecutor<Banner> {
}
