package cn.v5cn.v5cms.biz.impl;

import cn.v5cn.v5cms.biz.ColumnBiz;
import cn.v5cn.v5cms.dao.ColumnDao;
import cn.v5cn.v5cms.entity.Column;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZYW on 2014/10/31.
 */
@Service("columnBiz")
public class ColumnBizImpl implements ColumnBiz {

    @Autowired
    private ColumnDao columnDao;

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
}