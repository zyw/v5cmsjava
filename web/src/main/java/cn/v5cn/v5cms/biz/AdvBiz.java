package cn.v5cn.v5cms.biz;

import cn.v5cn.v5cms.entity.Adv;
import cn.v5cn.v5cms.entity.wrapper.AdvWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Created by ZYW on 2014/7/28.
 */
public interface AdvBiz {
    Adv save(AdvWrapper advWrapper) throws JsonProcessingException;
}
