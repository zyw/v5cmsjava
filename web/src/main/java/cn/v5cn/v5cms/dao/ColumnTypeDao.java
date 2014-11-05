package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.ColumnType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ZYW on 2014/11/5.
 */
@Repository("columnTypeDao")
public interface ColumnTypeDao extends CrudRepository<ColumnType,Long> {
}
