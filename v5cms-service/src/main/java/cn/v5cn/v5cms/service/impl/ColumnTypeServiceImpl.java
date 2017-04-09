package cn.v5cn.v5cms.service.impl;

import cn.v5cn.v5cms.dao.ColtypeMapper;
import cn.v5cn.v5cms.service.ColumnTypeService;
import cn.v5cn.v5cms.entity.Coltype;
import com.google.common.collect.Lists;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

/**
 * Created by ZYW on 2014/11/5.
 */

@Service("columnTypeService")
public class ColumnTypeServiceImpl implements ColumnTypeService {

    @Autowired
    private ColtypeMapper coltypeMapper;

    @Override
    @Transactional
    public Coltype save(Coltype columnType) {
        return null;//columnTypeDao.save(columnType);
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

    /*@Override
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
    }*/

    @Override
    public Coltype findOne(Long colTypeId) {
        return null;//columnTypeDao.findOne(colTypeId);
    }

    @Override
    public void deleteColType(Long[] colTypeIds) {
        List<Coltype> colTypes = Lists.newArrayList();
        Coltype columnType;
        for(Long colTypeId : colTypeIds){
            columnType = new Coltype();
            //columnType.setColTypeId(colTypeId);
            colTypes.add(columnType);
        }
        //columnTypeDao.deleteInBatch(colTypes);
    }

    @Override
    public List<Coltype> findAll() {
        return null;//Lists.newArrayList(columnTypeDao.findAll());
    }
}
