package cn.v5cn.v5cms.biz.impl;

import cn.v5cn.v5cms.biz.ManagerBiz;
import cn.v5cn.v5cms.dao.ManagerDao;
import cn.v5cn.v5cms.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ZYW on 2014/6/10.
 */
@Component("managerBiz")
public class ManagerBizImpl implements ManagerBiz {
    @Autowired
    private ManagerDao managerDao;
    @Override
    public List<Manager> findByLoginName(String loginName) {
        return managerDao.findByLonginName(loginName);
    }
}
