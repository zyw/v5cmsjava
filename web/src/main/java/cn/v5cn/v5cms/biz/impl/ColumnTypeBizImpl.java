package cn.v5cn.v5cms.biz.impl;

import cn.v5cn.v5cms.biz.ColumnTypeBiz;
import cn.v5cn.v5cms.dao.ColumnTypeDao;
import cn.v5cn.v5cms.entity.ColumnType;
import cn.v5cn.v5cms.util.TwoTuple;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
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
    public ColumnType save(ColumnType columnType) {
        return columnTypeDao.save(columnType);
    }

    @Override
    public List<TwoTuple<String,String>> templatePathAndName(File templatePath) {
        File[] files = templatePath.listFiles();

        List<TwoTuple<String,String>> result = null;

        for(File file : files){
            if(file.isDirectory() && "assets".equalsIgnoreCase(file.getName())) continue;

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
}
