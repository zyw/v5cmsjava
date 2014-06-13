package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.Manager;

import java.util.List;

/**
 * Created by ZYW on 2014/6/9.
 */
public interface ManagerDao {
    List<Manager> login(String loginName);
}
