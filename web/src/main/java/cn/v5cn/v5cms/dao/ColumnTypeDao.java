package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.ColumnType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ZYW on 2014/11/5.
 */
@Repository("columnTypeDao")
public interface ColumnTypeDao extends JpaRepository<ColumnType,Long>,JpaSpecificationExecutor<ColumnType> {
}
