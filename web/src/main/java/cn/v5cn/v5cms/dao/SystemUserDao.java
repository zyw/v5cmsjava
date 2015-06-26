package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by ZXF-PC1 on 2015/6/18.
 */
@Repository("systemUserDao")
public interface SystemUserDao extends JpaRepository<SystemUser,Long>,JpaSpecificationExecutor<SystemUser> {
    SystemUser findByLoginname(String loginname);
}
