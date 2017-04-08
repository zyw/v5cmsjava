package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.SystemUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by ZXF-PC1 on 2015/6/18.
 */
@Repository("systemUserDao")
public interface SystemUserDao extends Mapper<SystemUser> {
    SystemUser findByLoginname(String loginname);
}
