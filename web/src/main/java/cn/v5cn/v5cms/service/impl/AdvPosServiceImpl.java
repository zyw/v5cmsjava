package cn.v5cn.v5cms.service.impl;

import cn.v5cn.v5cms.service.AdvPosService;
import cn.v5cn.v5cms.dao.AdvPosDao;
import cn.v5cn.v5cms.entity.AdvPos;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZYW on 2014/7/23.
 */
@Service("advPosService")
public class AdvPosServiceImpl implements AdvPosService {

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

    @Override
    public AdvPos findOne(Long advPosId) {
        return advPosDao.findOne(advPosId);
    }

    /*@Override
    @Transactional
    public AdvPos update(AdvPos advPos) throws InvocationTargetException, IllegalAccessException {
        AdvPos dbAdvPos = findOne(advPos.getAdvPosId());
        SystemUtils.copyProperties(dbAdvPos,advPos);
        return dbAdvPos;
    }*/

    @Override
    public void deleteAdvPos(Long[] advPosIds) {
        List<AdvPos> advPoses = Lists.newArrayList();
        AdvPos advPos = null;
        for(Long advPosId : advPosIds){
            advPos = new AdvPos();
            advPos.setAdvPosId(advPosId);
            advPoses.add(advPos);
        }
        advPosDao.delete(advPoses);
    }
}
