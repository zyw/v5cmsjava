package cn.v5cn.v5cms.service.impl;

import cn.v5cn.v5cms.service.ColumnTypeService;
import cn.v5cn.v5cms.dao.ColumnTypeDao;
import cn.v5cn.v5cms.entity.ColumnType;
import cn.v5cn.v5cms.util.PropertyUtils;
import cn.v5cn.v5cms.util.SystemUtils;
import cn.v5cn.v5cms.util.TwoTuple;
import com.google.common.collect.Lists;
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
import java.util.List;

/**
 * Created by ZYW on 2014/11/5.
 */

@Service("columnTypeService")
public class ColumnTypeServiceImpl implements ColumnTypeService {

    @Autowired
    private ColumnTypeDao columnTypeDao;

    @Override
    @Transactional
    public ColumnType save(ColumnType columnType) {
        return columnTypeDao.save(columnType);
    }

    @Override
    public List<String> templatePathAndName(File templatePath) {
        File[] files = templatePath.listFiles();

        List<String> result = null;

        for(File file : files){

            if(file.isDirectory() && "frags".equals(file.getName())) continue;

            if(file.isDirectory()){
                List<String> temp = this.templatePathAndName(file);
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

            if(!"ftl".equalsIgnoreCase(extensionName) && !"html".equalsIgnoreCase(extensionName)) continue;

            result.add(file.getAbsolutePath());
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
        ColumnType columnType;
        for(Long colTypeId : colTypeIds){
            columnType = new ColumnType();
            columnType.setColTypeId(colTypeId);
            colTypes.add(columnType);
        }
        columnTypeDao.deleteInBatch(colTypes);
    }

    @Override
    public List<ColumnType> findAll() {
        return Lists.newArrayList(columnTypeDao.findAll());
    }
}
