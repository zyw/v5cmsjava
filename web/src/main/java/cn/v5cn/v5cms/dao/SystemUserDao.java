package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.SystemUser;
import org.springframework.stereotype.Repository;

/**
 * Created by ZXF-PC1 on 2015/6/18.
 */
@Repository("systemUserDao")
public interface SystemUserDao extends org.springframework.data.repository.Repository<SystemUser,Long> {
    SystemUser findByLoginname(String loginname);
}
