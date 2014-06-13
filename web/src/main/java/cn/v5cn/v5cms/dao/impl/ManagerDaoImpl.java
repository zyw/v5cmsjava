package cn.v5cn.v5cms.dao.impl;

import cn.v5cn.v5cms.dao.ManagerDao;
import cn.v5cn.v5cms.entity.Manager;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZYW on 2014/6/9.
 */
@Repository("managerDao")
public class ManagerDaoImpl implements ManagerDao {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<Manager> login(String loginName) {
        List<Manager> result = sqlSession.selectList(Manager.class.getName() + ".selectLogin",loginName);
        return result;
    }
}
