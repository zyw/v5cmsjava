package cn.v5cn.v5cms.dao.impl;

import cn.v5cn.v5cms.dao.ManagerDao;
import cn.v5cn.v5cms.entity.Manager;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZYW on 2014/6/9.
 */
@Repository("managerDao")
public class ManagerDaoImpl implements ManagerDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManagerDaoImpl.class);

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<Manager> login(String loginName) {
        List<Manager> result = sqlSession.selectList(Manager.class.getName() + ".selectLogin",loginName);
        LOGGER.debug("根据登录名称查找用户，名称为：{}，找到的数量为：{}",loginName,result.size());
        return result;
    }
}
