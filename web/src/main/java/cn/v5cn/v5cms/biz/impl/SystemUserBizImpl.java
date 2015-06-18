package cn.v5cn.v5cms.biz.impl;

import cn.v5cn.v5cms.biz.SystemUserBiz;
import cn.v5cn.v5cms.dao.SystemUserDao;
import cn.v5cn.v5cms.entity.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZXF-PC1 on 2015/6/18.
 */
@Service("systemUserBiz")
public class SystemUserBizImpl implements SystemUserBiz {

    @Autowired
    private SystemUserDao systemUserDao;

    @Override
    public SystemUser findByLoginname(String loginname) {
        return systemUserDao.findByLoginname(loginname);
    }
}
