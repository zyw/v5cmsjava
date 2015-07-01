package cn.v5cn.v5cms.service.impl;

import cn.v5cn.v5cms.service.ColumnBiz;
import cn.v5cn.v5cms.dao.ColumnDao;
import cn.v5cn.v5cms.entity.Column;
import cn.v5cn.v5cms.entity.wrapper.ZTreeNode;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZYW on 2014/10/31.
 */
@Service("columnBiz")
public class ColumnBizImpl implements ColumnBiz {

    @Autowired
    private ColumnDao columnDao;

    @Override
    @Transactional
    public Column save(Column column) {
        return columnDao.save(column);
    }

    @Override
    public List<Column> findAll() {

        Iterable<Column> columns = columnDao.findAll();
        return Lists.newArrayList(columns);
    }

    @Override
    public List<Column> findOrderByParentIdsAndColsId(Long siteId) {
        return columnDao.findOrderByParentIdsAndColsId(siteId);
    }

    @Override
    public Column findOne(Long columnId) {
        return columnDao.findOne(columnId);
    }

    @Override
    @Transactional
    public void delete(Long columnId) {
        columnDao.delete(columnId);
    }

    @Override
    public List<Column> findByParentId(Long parentId) {
        return columnDao.findByParentId(parentId);
    }

    @Override
    public List<ZTreeNode> buildTreeNode(Long parentId) {
        List<Column> rootNode = this.findByParentId(parentId);
        if(rootNode == null || rootNode.size() < 1) return null;

        List<ZTreeNode> treeNodes = Lists.newArrayList();
        ZTreeNode treeNode = null;
        for(Column col : rootNode){
            treeNode = new ZTreeNode();
            treeNode.setId(col.getColsId());
            treeNode.setName(col.getColumnName());
            List<ZTreeNode> treeNodes1 = this.buildTreeNode(col.getColsId());
            if(treeNodes1 != null)
                treeNode.setChildren(treeNodes1);
            treeNodes.add(treeNode);
        }
        return treeNodes;
    }
}