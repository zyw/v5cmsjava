package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.SystemUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface SystemUserMapper extends Mapper<SystemUser> {
}