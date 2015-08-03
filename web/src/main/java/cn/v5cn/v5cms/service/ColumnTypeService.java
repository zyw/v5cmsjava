package cn.v5cn.v5cms.service;

import cn.v5cn.v5cms.entity.ColumnType;
import org.springframework.data.domain.Page;

import java.io.File;
import java.util.List;

/**
 * Created by ZYW on 2014/11/5.
 */
public interface ColumnTypeService {
    ColumnType save(ColumnType columnType);
    List<String> templatePathAndName(File templatePath);
    Page<ColumnType> findColumnTypeByColTypeNamePageable(ColumnType columnType,Integer currPage);

    ColumnType findOne(Long colTypeId);

    void deleteColType(Long[] colTypeIds);

    List<ColumnType> findAll();
//    ColumnType update(ColumnType columnType) throws InvocationTargetException, IllegalAccessException;
}
