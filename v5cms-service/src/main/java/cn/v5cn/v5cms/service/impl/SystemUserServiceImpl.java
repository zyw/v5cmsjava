package cn.v5cn.v5cms.service.impl;

import cn.v5cn.v5cms.dao.SystemUserMapper;
import cn.v5cn.v5cms.entity.SystemRes;
import cn.v5cn.v5cms.entity.SystemRole;
import cn.v5cn.v5cms.service.SystemResService;
import cn.v5cn.v5cms.service.SystemRoleService;
import cn.v5cn.v5cms.service.SystemUserService;
import cn.v5cn.v5cms.entity.SystemUser;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by ZXF-PC1 on 2015/6/18.
 */
@Service("systemUserService")
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Autowired
    private SystemRoleService systemRoleService;
    @Autowired
    private SystemResService systemResService;

    @Override
    public SystemUser findByLoginName(String loginName) {
        SystemUser systemUser = new SystemUser();
        systemUser.setLoginname(loginName);
        return systemUserMapper.selectOne(systemUser);
    }

    /*@Override
    public Page<SystemUser> findUserByUserNamePageable(final SystemUser user, Integer currPage) {
        int pageSize = Integer.valueOf(PropertyUtils.getValue("page.size").or("0"));

        Page<SystemUser> users = systemUserDao.findAll(new Specification<SystemUser>() {

            @Override
            public Predicate toPredicate(Root<SystemUser> userRoot, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> ps = Lists.newArrayList();
                if (StringUtils.isNotBlank(user.getName())) {
                    Path<String> userName = userRoot.get("name");
                    Path<String> email = userRoot.get("email");
                    ps.add(criteriaBuilder.like(userName,"%" + user.getName() + "%"));
                    ps.add(criteriaBuilder.like(email,"%" + user.getName() + "%"));
                }
                //return criteriaBuilder.or(ps.toArray(new Predicate[0]));
                return ps.size() == 0 ? criteriaBuilder.conjunction():criteriaBuilder.or(ps.toArray(new Predicate[ps.size()]));
            }
        }, new PageRequest((currPage - 1), pageSize, new Sort(Sort.Direction.DESC,"id")));

        return users;
    }*/

//    @Override
//    public SystemUser save(SystemUser user) {
//        return systemUserDao.save(user);
//    }
//
//    @Override
//    public SystemUser findOne(Long id) {
//        return systemUserDao.findOne(id);
//    }

    @Override
    public void deleteUsers(Long[] userIds) {
        List<SystemUser> systemUsers = Lists.newArrayList();
        SystemUser systemUser = null;
        for(Long userId : userIds){
            systemUser = new SystemUser();
            systemUser.setId(userId);
            systemUsers.add(systemUser);
        }
//        systemUserDao.delete(systemUsers);
    }

    @Override
    public Set<String> findRoles(String userName) {
        Set<String> result = Sets.newHashSet();
        List<SystemRole> roles = systemRoleService.findRolesByUserName(userName);
        roles.stream().forEach(role -> result.add(role.getName()));
        return result;
    }

    @Override
    public Set<String> findPermissions(String userName) {
        Set<String> result = Sets.newHashSet();

        List<SystemRes> permissions = systemResService.findPermissionsByUserName(userName);

        permissions.stream().forEach(res -> result.add(res.getPermission()));

        return result;
    }
}
