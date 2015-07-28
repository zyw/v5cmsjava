package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.LeaveWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by ZXF-PC1 on 2015/7/28.
 */
@Repository
public interface LeaveWordDao extends JpaRepository<LeaveWord,Long>,JpaSpecificationExecutor<LeaveWord> {
}
