package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.Column;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZYW on 2014/10/31.
 */
@Repository("columnDao")
public interface ColumnDao {

    /**
     * ==============================================================
     *
     * 后端方法
     *
     * ==============================================================
     **/

    //@Query("select c from Column c where c.siteId=?1 order by CONCAT(c.parentIds,c.colsId)")
    List<Column> findOrderByParentIdsAndColsId(Long siteId);

    List<Column> findByParentId(Long parentId);

    /**
     * ==============================================================
     *
     * 前端方法
     *
     * ==============================================================
     **/
//    @Query("select c from Column c where c.parentId=?1 and c.siteId=?2 and c.columndisplay=1 order by c.sortNum asc ")
//    List<Column> findByPIdAndCdObAsc();

    List<Column> findByParentIdAndSiteIdAndColumndisplay(Long parentId, Long siteId, int columndisplay/*,Sort sort*/);

//    List<Column> findByParentIdAndSiteIdAndColumndisplay(Long parentId, Long siteId, int columndisplay/*,Pageable pageable*/);
}
