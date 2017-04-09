package cn.v5cn.v5cms.service;

import cn.v5cn.v5cms.entity.Cols;

import java.util.List;

/**
 * Created by ZYW on 2014/10/31.
 */
public interface ColumnService {

    /**
     * ==============================================================
     *
     * 通用方法
     *
     * ==============================================================
     **/
    Cols findOne(Long columnId);
    /**
     * ==============================================================
     *
     * 后端方法
     *
     * ==============================================================
     **/

    Cols save(Cols column);

    List<Cols> findAll();
    List<Cols> findOrderByParentIdsAndColsId(Long siteId);

    void delete(Long columnId);

    List<Cols> findByParentId(Long parentId);
    //ZTreeNode
    List<Object> buildTreeNode(Long parentId);

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
    List<Cols> findByParentId(Long parentId,Long siteId);

    /**
     * 根据父栏目ID，站点ID，栏目显示，
     * SortNum排序和最多显示的行数
     * */
    List<Cols> findByParentId(Long parentId,Long siteId,int maxSize);
}
