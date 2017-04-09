package cn.v5cn.v5cms.service.impl;

import cn.v5cn.v5cms.dao.AdvposMapper;
import cn.v5cn.v5cms.service.AdvPosService;
import cn.v5cn.v5cms.entity.Advpos;
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
    private AdvposMapper advposMapper;

    @Override
    @Transactional
    public Advpos save(Advpos advPos) {
        return null;//advPosDao.save(advPos);
    }

    @Override
    public ImmutableList<Advpos> finadAll() {
        return null;//ImmutableList.<AdvPos>builder().addAll(advPosDao.findAll()).build();
    }

    @Override
    public Advpos findOne(Long advPosId) {
        return null;//advPosDao.findOne(advPosId);
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
        List<Advpos> advPoses = Lists.newArrayList();
        Advpos advPos = null;
        for(Long advPosId : advPosIds){
            advPos = new Advpos();
            //advPos.setAdvPosId(advPosId);
            advPoses.add(advPos);
        }
//        advPosDao.delete(advPoses);
    }
}
