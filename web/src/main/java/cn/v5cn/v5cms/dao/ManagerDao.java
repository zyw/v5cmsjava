package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.Manager;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZYW on 2014/6/9.
 */
@Repository("managerDao")
public interface ManagerDao extends org.springframework.data.repository.Repository<Manager,Long> {
    List<Manager> findByManagerLoginname(String managerLoginname);
}
