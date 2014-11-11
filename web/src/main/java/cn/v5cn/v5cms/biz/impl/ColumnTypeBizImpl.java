package cn.v5cn.v5cms.biz.impl;

import cn.v5cn.v5cms.biz.ColumnTypeBiz;
import cn.v5cn.v5cms.dao.ColumnTypeDao;
import cn.v5cn.v5cms.entity.Adv;
import cn.v5cn.v5cms.entity.ColumnType;
import cn.v5cn.v5cms.entity.Site;
import cn.v5cn.v5cms.util.PropertyUtils;
import cn.v5cn.v5cms.util.SystemUtils;
import cn.v5cn.v5cms.util.TwoTuple;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Created by ZYW on 2014/11/5.
 */

@Service("columnTypeBiz")
public class ColumnTypeBizImpl implements ColumnTypeBiz {

    @Autowired
    private ColumnTypeDao columnTypeDao;

    @Override
    @Transactional
    public ColumnType save(ColumnType columnType) {
        return columnTypeDao.save(columnType);
    }

    @Override
    public List<TwoTuple<String,String>> templatePathAndName(File templatePath) {
        File[] files = templatePath.listFiles();

        List<TwoTuple<String,String>> result = null;

        for(File file : files){
//            if(file.isDirectory() && "assets".equalsIgnoreCase(file.getName())) continue;

            if(file.isDirectory()){
                List<TwoTuple<String,String>> temp = this.templatePathAndName(file);
                if(result == null){
                    result = temp;
                }else{
                    result.addAll(temp);
                }
                continue;
            }

            if(result == null){
                result = Lists.newArrayList();
            }

            String fileName = file.getName();
            String extensionName = FilenameUtils.getExtension(fileName);
            if(!"ftl".equalsIgnoreCase(extensionName)) continue;

            /*Map<String,String> fileNameAndUri = Maps.newHashMap();

            fileNameAndUri.put(fileName, file.getAbsolutePath());*/

            result.add(new TwoTuple<String,String>(fileName,file.getAbsolutePath()));
        }
        return result;
    }

    @Override
    public Page<ColumnType> findColumnTypeByColTypeNamePageable(final ColumnType columnType, Integer currPage) {
        int pageSize = Integer.valueOf(PropertyUtils.getValue("page.size").or("0"));
        return columnTypeDao.findAll(new Specification<ColumnType>(){

            @Override
            public Predicate toPredicate(Root<ColumnType> columnTypeRoot, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<javax.persistence.criteria.Predicate> ps = Lists.newArrayList();
                Path<Long> siteId = columnTypeRoot.get("siteId");
                ps.add(criteriaBuilder.equal(siteId,columnType.getSiteId()));
                if(StringUtils.isNotBlank(columnType.getColTypeName())){
                    Path<String> advName = columnTypeRoot.get("colTypeName");
                    ps.add(criteriaBuilder.like(advName, "%" + columnType.getColTypeName() + "%"));
                }
                return criteriaBuilder.and(ps.toArray(new javax.persistence.criteria.Predicate[0]));
            }
        },new PageRequest(currPage-1,pageSize));
    }

    @Override
    public ColumnType findOne(Long colTypeId) {
        return columnTypeDao.findOne(colTypeId);
    }

    @Override
    public void deleteColType(Long[] colTypeIds) {
        List<ColumnType> colTypes = Lists.newArrayList();
        ColumnType columnType = null;
        for(Long colTypeId : colTypeIds){
            columnType = new ColumnType();
            columnType.setColTypeId(colTypeId);
            colTypes.add(columnType);
        }
        columnTypeDao.delete(colTypes);
    }

//    @Override
//    @Transactional
//    public ColumnType update(ColumnType columnType) throws InvocationTargetException, IllegalAccessException {
//        ColumnType dbct = findOne(columnType.getColTypeId());
//        SystemUtils.copyProperties(dbct,columnType);
//        return dbct;
//    }
}
