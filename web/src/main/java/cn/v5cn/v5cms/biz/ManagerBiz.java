package cn.v5cn.v5cms.biz;

import cn.v5cn.v5cms.entity.Manager;

import java.util.List;

/**
 * Created by ZYW on 2014/6/10.
 */
public interface ManagerBiz {
    List<Manager> findByManagerLoginname(String managerLoginname);
}
