package cn.v5cn.v5cms.service;

import cn.v5cn.v5cms.entity.AdvPos;
import com.google.common.collect.ImmutableList;

/**
 * Created by ZYW on 2014/7/23.
 */
public interface AdvPosService {
    AdvPos save(AdvPos advPos);

    ImmutableList<AdvPos> finadAll();

    AdvPos findOne(Long advPosId);

//    AdvPos update(AdvPos advPos) throws InvocationTargetException, IllegalAccessException;

    void deleteAdvPos(Long[] advPosIds);
}
