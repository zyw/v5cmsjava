package cn.v5cn.v5cms.service;

import cn.v5cn.v5cms.entity.Adv;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by ZYW on 2014/7/28.
 */
public interface AdvService {
    Adv save(Object advWrapper) throws JsonProcessingException;
//    Page<Adv> findAdvByAdvNamePageable(Adv adv,Integer currPage);
    Adv findOne(Long advId);
    Adv update(Object advWrapper) throws JsonProcessingException,IllegalAccessException, InvocationTargetException;

    void deleteAdvs(Long[] advIds,String realPath);
}
