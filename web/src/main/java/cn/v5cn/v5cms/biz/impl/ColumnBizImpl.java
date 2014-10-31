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
//        Iterable<Column> columns = columnDao.findAll(new Sort(Sort.Direction.ASC, "parentIds","colsId"));
        Iterable<Column> columns = columnDao.findOrderByParentIdsAndColsId();
        return Lists.newArrayList(columns);
    }
}