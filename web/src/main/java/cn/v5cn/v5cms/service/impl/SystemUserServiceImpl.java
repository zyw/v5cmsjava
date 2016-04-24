package cn.v5cn.v5cms.service.impl;

import cn.v5cn.v5cms.service.SystemUserService;
import cn.v5cn.v5cms.dao.SystemUserDao;
import cn.v5cn.v5cms.entity.SystemUser;
import cn.v5cn.v5cms.util.PropertyUtils;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by ZXF-PC1 on 2015/6/18.
 */
@Service("systemUserService")
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private SystemUserDao systemUserDao;

    @Override
    public SystemUser findByLoginname(String loginname) {
        return systemUserDao.findByLoginname(loginname);
    }

    @Override
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
    }

    @Override
    public SystemUser save(SystemUser user) {
        return systemUserDao.save(user);
    }

    @Override
    public SystemUser findOne(Long id) {
        return systemUserDao.findOne(id);
    }
}
