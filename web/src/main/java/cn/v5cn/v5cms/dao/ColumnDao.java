package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.Column;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZYW on 2014/10/31.
 */
@Repository("columnDao")
public interface ColumnDao extends PagingAndSortingRepository<Column,Long> {
    @Query("select c from Column c where c.siteId=?1 order by CONCAT(c.parentIds,c.colsId)")
    List<Column> findOrderByParentIdsAndColsId(Long siteId);

    List<Column> findByParentId(Long parentId);
}
