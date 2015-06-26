package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.SystemRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by ZXF-PC1 on 2015/6/26.
 */
@Repository("systemRoleDao")
public interface SystemRoleDao extends JpaRepository<SystemRole,Long>,JpaSpecificationExecutor<SystemRole> {

}
