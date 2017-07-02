package cn.v5cn.v5cms.service;

import cn.v5cn.v5cms.entity.SystemUser;

import java.util.Set;

/**
 * Created by ZXF-PC1 on 2015/6/18.
 */
public interface SystemUserService {
    /**
     * 根据用户名查询用户信息
     * @param loginName 用户名
     * @return 返回一条用户信息
     */
    SystemUser findByLoginName(String loginName);
//    Page<SystemUser> findUserByUserNamePageable(SystemUser user,Integer currPage);

//    SystemUser save(SystemUser user);
//    SystemUser findOne(Long id);

    void deleteUsers(Long[] userIds);



    //MyBatis Shiro
    Set<String> findRoles(String userName);
    Set<String> findPermissions(String userName);
}
