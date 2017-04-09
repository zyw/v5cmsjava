package cn.v5cn.v5cms.service;

import cn.v5cn.v5cms.entity.Coltype;

import java.io.File;
import java.util.List;

/**
 * Created by ZYW on 2014/11/5.
 */
public interface ColumnTypeService {
    Coltype save(Coltype columnType);
    List<String> templatePathAndName(File templatePath);
//    Page<ColumnType> findColumnTypeByColTypeNamePageable(ColumnType columnType,Integer currPage);

    Coltype findOne(Long colTypeId);

    void deleteColType(Long[] colTypeIds);

    List<Coltype> findAll();
//    ColumnType update(ColumnType columnType) throws InvocationTargetException, IllegalAccessException;
}
