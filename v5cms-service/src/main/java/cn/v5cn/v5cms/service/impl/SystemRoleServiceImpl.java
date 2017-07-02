package cn.v5cn.v5cms.service.impl;

import cn.v5cn.v5cms.dao.SystemRoleMapper;
import cn.v5cn.v5cms.service.SystemRoleService;
import cn.v5cn.v5cms.entity.SystemRes;
import cn.v5cn.v5cms.entity.SystemRole;
import com.google.common.base.Splitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZXF-PC1 on 2015/6/26.
 */
@Service("systemRoleService")
public class SystemRoleServiceImpl implements SystemRoleService {

    @Autowired
    private SystemRoleMapper systemRoleMapper;

/*    @Override
    public Page<SystemRole> findRoleByRoleNamePageable(final SystemRole role, Integer currPage) {
        int pageSize = Integer.valueOf(PropertyUtils.getValue("page.size").or("0"));

        Page<SystemRole> roles = systemRoleDao.findAll(new Specification<SystemRole>() {
            @Override
            public Predicate toPredicate(Root<SystemRole> roleRoot, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> ps = Lists.newArrayList();
                if (StringUtils.isNotBlank(role.getName())) {
                    Path<String> roleName = roleRoot.get("name");
                    Path<String> roleDes = roleRoot.get("des");
                    ps.add(criteriaBuilder.like(roleName, "%" + role.getName() + "%"));
                    ps.add(criteriaBuilder.like(roleDes, "%" + role.getName() + "%"));
                }
                //criteriaBuilder.conjunction();  创建一个AND
                //criteriaBuilder.disjunction();  创建一个OR
                return ps.size() == 0 ? criteriaBuilder.conjunction():criteriaBuilder.or(ps.toArray(new Predicate[ps.size()]));
            }
        }, new PageRequest(currPage - 1, pageSize, new Sort("sortNum")));

        return roles;
    }*/

    @Override
    @Transactional
    public Long save(SystemRole role,String resIds) {

        if(resIds != null && resIds.length() > 0){
            List<String> resIdList = Splitter.on(",").splitToList(resIds);
            SystemRes res = null;
            for(String resId : resIdList){
                res = new SystemRes();
                res.setId(Long.valueOf(resId));
                //role.getReses().add(res);
            }
        }
        role = null;//systemRoleDao.save(role);
        return role.getId();
    }

    @Override
    public List<SystemRole> findRolesByUserName(String userName) {
        return systemRoleMapper.findRolesByUserName(userName);
    }
}
