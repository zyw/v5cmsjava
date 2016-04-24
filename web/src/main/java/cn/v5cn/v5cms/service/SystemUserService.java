package cn.v5cn.v5cms.service;

import cn.v5cn.v5cms.entity.SystemUser;
import org.springframework.data.domain.Page;

/**
 * Created by ZXF-PC1 on 2015/6/18.
 */
public interface SystemUserService {
    SystemUser findByLoginname(String loginname);
    Page<SystemUser> findUserByUserNamePageable(SystemUser user,Integer currPage);

    SystemUser save(SystemUser user);
    SystemUser findOne(Long id);
}
