package cn.v5cn.v5cms.biz.impl;

import cn.v5cn.v5cms.biz.ColumnTypeBiz;
import cn.v5cn.v5cms.dao.ColumnTypeDao;
import cn.v5cn.v5cms.entity.ColumnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZYW on 2014/11/5.
 */

@Service("columnTypeBiz")
public class ColumnTypeBizImpl implements ColumnTypeBiz {

    @Autowired
    private ColumnTypeDao columnTypeDao;

    @Override
    public ColumnType save(ColumnType columnType) {
        return columnTypeDao.save(columnType);
    }
}
