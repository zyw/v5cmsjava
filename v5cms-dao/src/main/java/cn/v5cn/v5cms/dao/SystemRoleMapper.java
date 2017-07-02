package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.SystemRole;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SystemRoleMapper extends Mapper<SystemRole> {
    List<SystemRole> findRolesByUserName(String userName);
}