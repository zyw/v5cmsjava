package cn.v5cn.v5cms.biz;

import cn.v5cn.v5cms.entity.ColumnType;
import cn.v5cn.v5cms.util.TwoTuple;
import org.springframework.data.domain.Page;

import java.io.File;
import java.util.List;

/**
 * Created by ZYW on 2014/11/5.
 */
public interface ColumnTypeBiz {
    ColumnType save(ColumnType columnType);
    List<TwoTuple<String,String>> templatePathAndName(File templatePath);
    Page<ColumnType> findColumnTypeByColTypeNamePageable(ColumnType columnType,Integer currPage);

    ColumnType findOne(Long colTypeId);

    void deleteColType(Long[] colTypeIds);

//    ColumnType update(ColumnType columnType) throws InvocationTargetException, IllegalAccessException;
}
