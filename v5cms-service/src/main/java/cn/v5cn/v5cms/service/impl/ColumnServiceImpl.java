package cn.v5cn.v5cms.service.impl;

import cn.v5cn.v5cms.dao.ColsMapper;
import cn.v5cn.v5cms.service.ColumnService;
import cn.v5cn.v5cms.entity.Cols;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZYW on 2014/10/31.
 */
@Service("columnService")
public class ColumnServiceImpl implements ColumnService {

    @Autowired
    private ColsMapper colsMapper;

    /**
     * ==============================================================
     *
     * 通用方法
     *
     * ==============================================================
     **/
    @Override
    public Cols findOne(Long columnId) {
        return null;//columnDao.findOne(columnId);
    }
    /**
     * ==============================================================
     *
     * 后端方法
     *
     * ==============================================================
     **/

    @Override
    @Transactional
    public Cols save(Cols column) {
        return null;//columnDao.save(column);
    }

    @Override
    public List<Cols> findAll() {

        Iterable<Cols> columns = null;//columnDao.findAll();
        return Lists.newArrayList(columns);
    }

    @Override
    public List<Cols> findOrderByParentIdsAndColsId(Long siteId) {
        return null;//columnDao.findOrderByParentIdsAndColsId(siteId);
    }

    @Override
    @Transactional
    public void delete(Long columnId) {
//        columnDao.delete(columnId);
    }

    @Override
    public List<Cols> findByParentId(Long parentId) {
        return null;//columnDao.findByParentId(parentId);
    }

    @Override//ZTreeNode
    public List<Object> buildTreeNode(Long parentId) {
        List<Cols> rootNode = this.findByParentId(parentId);
        if(rootNode == null || rootNode.size() < 1) return null;

//        List<ZTreeNode> treeNodes = Lists.newArrayList();
//        ZTreeNode treeNode = null;
//        for(Column col : rootNode){
//            treeNode = new ZTreeNode();
//            treeNode.setId(col.getColsId());
//            treeNode.setName(col.getColumnName());
//            List<ZTreeNode> treeNodes1 = this.buildTreeNode(col.getColsId());
//            if(treeNodes1 != null)
//                treeNode.setChildren(treeNodes1);
//            treeNodes.add(treeNode);
//        }
        return null;//treeNodes;
    }


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
    @Override
    public List<Cols> findByParentId(Long parentId,Long siteId) {

        return null;//columnDao.findByParentIdAndSiteIdAndColumndisplay(parentId, siteId, 1, new Sort(Sort.Direction.ASC, "sortNum"));
    }

    /**
     * 根据父栏目ID，站点ID，栏目显示，
     * SortNum排序和最多显示的行数
     * */
    @Override
    public List<Cols> findByParentId(Long parentId,Long siteId,int maxSize) {

        if (maxSize == 0) return null;//findByParentId(parentId,siteId);

//        return columnDao.findByParentIdAndSiteIdAndColumndisplay(parentId, siteId, 1,
//                new PageRequest(0,maxSize,new Sort(Sort.Direction.ASC,"sortNum")));
        return null;
    }
}