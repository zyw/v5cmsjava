package cn.v5cn.v5cms.service.impl;

import cn.v5cn.v5cms.dao.LinkDao;
import cn.v5cn.v5cms.entity.Link;
import cn.v5cn.v5cms.service.LinkService;
import cn.v5cn.v5cms.util.PropertyUtils;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by ZXF-PC1 on 2015/7/22.
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkDao linkDao;

    @Override
    public Page<Link> findLinkPageable(final Link link, Integer currPage) {

        int pageSize = Integer.valueOf(PropertyUtils.getValue("page.size").or("0"));

        if(currPage == null || currPage < 1) currPage = 1;

        return linkDao.findAll(new Specification<Link>(){
            @Override
            public Predicate toPredicate(Root<Link> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> ps = Lists.newArrayList();
                if(link.getLinkName() !=null && !"".equals(link.getLinkName())){
                    Path<String> linkName = root.get("linkName");
                    Path<String> linkPath = root.get("link");

                    ps.add(criteriaBuilder.like(linkName, "%" + link.getLinkName() + "%"));
                    ps.add(criteriaBuilder.like(linkPath, "%" + link.getLinkName() + "%"));
                }

                //criteriaBuilder.conjunction();  创建一个AND
                //criteriaBuilder.disjunction();  创建一个OR
                return ps.size() == 0 ? criteriaBuilder.conjunction():criteriaBuilder.or(ps.toArray(new Predicate[ps.size()]));
            }
        },new PageRequest(currPage-1,pageSize,new Sort(Sort.Direction.DESC,"linkId")));
    }

    @Override
    @Transactional
    public Link save(Link link) {
        return linkDao.save(link);
    }

    @Override
    public Link findOne(Long linkId) {
        return linkDao.findOne(linkId);
    }

    @Override
    @Transactional
    public void deleteInBatch(Iterable<Link> linkIds) {
        linkDao.deleteInBatch(linkIds);
    }

    @Override
    public List<Link> findAll(Long[]  linkIds) {
        return linkDao.findAll(Lists.newArrayList(linkIds));
    }
}
