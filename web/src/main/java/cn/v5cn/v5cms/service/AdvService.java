package cn.v5cn.v5cms.service;

import cn.v5cn.v5cms.entity.Adv;
import cn.v5cn.v5cms.entity.wrapper.AdvWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by ZYW on 2014/7/28.
 */
public interface AdvService {
    Adv save(AdvWrapper advWrapper) throws JsonProcessingException;
    Page<Adv> findAdvByAdvNamePageable(Adv adv,Integer currPage);
    Adv findOne(Long advId);
    Adv update(AdvWrapper advWrapper) throws JsonProcessingException,IllegalAccessException, InvocationTargetException;

    void deleteAdvs(Long[] advIds,HttpServletRequest request);
}
