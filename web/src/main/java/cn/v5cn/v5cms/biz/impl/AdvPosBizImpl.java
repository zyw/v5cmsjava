package cn.v5cn.v5cms.biz.impl;

import cn.v5cn.v5cms.biz.AdvPosBiz;
import cn.v5cn.v5cms.dao.AdvPosDao;
import cn.v5cn.v5cms.entity.AdvPos;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ZYW on 2014/7/23.
 */
@Service("advPosBiz")
public class AdvPosBizImpl implements AdvPosBiz {

    @Autowired
    private AdvPosDao advPosDao;

    @Override
    @Transactional
    public AdvPos save(AdvPos advPos) {
        return advPosDao.save(advPos);
    }

    @Override
    public ImmutableList<AdvPos> finadAll() {
        return ImmutableList.<AdvPos>builder().addAll(advPosDao.findAll()).build();
    }
}
