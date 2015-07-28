package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.LeaveWordType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by ZXF-PC1 on 2015/7/28.
 */
@Repository
public interface LeaveWordTypeDao extends JpaRepository<LeaveWordType,Long>,JpaSpecificationExecutor<LeaveWordType> {
}
