package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.Site;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SiteMapper extends Mapper<Site> {

    List<Site> findByUserNotCloseSite(long userId);
}