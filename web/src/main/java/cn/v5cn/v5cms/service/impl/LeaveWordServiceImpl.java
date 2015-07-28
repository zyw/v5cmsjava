package cn.v5cn.v5cms.service.impl;

import cn.v5cn.v5cms.dao.LeaveWordDao;
import cn.v5cn.v5cms.entity.LeaveWord;
import cn.v5cn.v5cms.service.LeaveWordService;
import cn.v5cn.v5cms.util.PropertyUtils;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by ZXF-PC1 on 2015/7/28.
 */
@Service("leaveWordService")
public class LeaveWordServiceImpl implements LeaveWordService {

    @Autowired
    private LeaveWordDao leaveWordDao;

    @Override
    public Page<LeaveWord> findLeaveWordPageable(final LeaveWord leaveWord, Integer currPage) {
        int pageSize = Integer.valueOf(PropertyUtils.getValue("page.size").or("0"));

        if(currPage == null || currPage < 1) currPage = 1;

        return leaveWordDao.findAll(new Specification<LeaveWord>(){
            @Override
            public Predicate toPredicate(Root<LeaveWord> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> ps = Lists.newArrayList();
                if(leaveWord.getTitle() !=null && !"".equals(leaveWord.getTitle())){
                    Path<String> title = root.get("title");
                    Path<String> content = root.get("content");
                    Path<String> reply = root.get("reply");

                    ps.add(criteriaBuilder.like(title, "%" + leaveWord.getTitle() + "%"));
                    ps.add(criteriaBuilder.like(content, "%" + leaveWord.getTitle() + "%"));
                    ps.add(criteriaBuilder.like(reply, "%" + leaveWord.getTitle() + "%"));
                }

                //criteriaBuilder.conjunction();  创建一个AND
                //criteriaBuilder.disjunction();  创建一个OR
                return ps.size() == 0 ? criteriaBuilder.conjunction():criteriaBuilder.or(ps.toArray(new Predicate[ps.size()]));
            }
        },new PageRequest(currPage-1,pageSize,new Sort(Sort.Direction.DESC,"lwtime")));
    }
}
