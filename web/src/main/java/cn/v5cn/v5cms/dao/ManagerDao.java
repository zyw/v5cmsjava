package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZYW on 2014/6/9.
 */
@Repository("managerDao")
public interface ManagerDao extends CrudRepository<Manager,Long> {
    List<Manager> findByLonginName(String loginName);
}
