package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.SystemRes;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SystemResMapper extends Mapper<SystemRes> {
    List<SystemRes> findPermissionsByUserName(String userName);

    List<SystemRes> findOrderByPidsAndId();
}