package cn.v5cn.v5cms.biz;

import cn.v5cn.v5cms.entity.ColumnType;
import cn.v5cn.v5cms.util.TwoTuple;

import java.io.File;
import java.util.List;

/**
 * Created by ZYW on 2014/11/5.
 */
public interface ColumnTypeBiz {
    ColumnType save(ColumnType columnType);
    List<TwoTuple<String,String>> templatePathAndName(File templatePath);
}
