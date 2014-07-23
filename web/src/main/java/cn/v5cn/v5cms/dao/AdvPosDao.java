package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.AdvPos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ZYW on 2014/7/23.
 */
@Repository("advPosDao")
public interface AdvPosDao extends CrudRepository<AdvPos,Long> {
}
