package cn.v5cn.v5cms.service.impl;

import cn.v5cn.v5cms.service.ManagerService;
import cn.v5cn.v5cms.dao.ManagerDao;
import cn.v5cn.v5cms.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZYW on 2014/6/10.
 */
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;
    @Override
    public List<Manager> findByManagerLoginname(String managerLoginname) {
        return managerDao.findByManagerLoginname(managerLoginname);
    }
}
