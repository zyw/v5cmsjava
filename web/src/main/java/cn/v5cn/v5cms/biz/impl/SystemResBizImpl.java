package cn.v5cn.v5cms.biz.impl;

import cn.v5cn.v5cms.biz.SystemResBiz;
import cn.v5cn.v5cms.dao.SystemResDao;
import cn.v5cn.v5cms.entity.SystemRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZXF-PC1 on 2015/6/23.
 */
@Service("systemResBiz")
public class SystemResBizImpl implements SystemResBiz {

    @Autowired
    private SystemResDao systemResDao;

    @Override
    public List<SystemRes> findOrderByPidsAndId() {
        return systemResDao.findOrderByPidsAndId();
    }
}
