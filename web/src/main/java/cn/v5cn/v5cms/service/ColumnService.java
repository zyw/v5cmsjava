package cn.v5cn.v5cms.service;

import cn.v5cn.v5cms.entity.Column;
import cn.v5cn.v5cms.entity.wrapper.ZTreeNode;

import java.util.List;

/**
 * Created by ZYW on 2014/10/31.
 */
public interface ColumnService {

    /**
     * ==============================================================
     *
     * 后端方法
     *
     * ==============================================================
     **/

    Column save(Column column);

    List<Column> findAll();
    List<Column> findOrderByParentIdsAndColsId(Long siteId);
    Column findOne(Long columnId);

    void delete(Long columnId);

    List<Column> findByParentId(Long parentId);

    List<ZTreeNode> buildTreeNode(Long parentId);

    /**
     * ==============================================================
     *
     * 前端方法
     *
     * ==============================================================
     **/

    /**
     * 根据父栏目ID，站点ID，栏目显示和SortNum排序
     * */
    List<Column> findByParentId(Long parentId,Long siteId);

}
