package cn.v5cn.v5cms.service.impl;

import cn.v5cn.v5cms.dao.CommentsDao;
import cn.v5cn.v5cms.entity.Comments;
import cn.v5cn.v5cms.service.CommentsService;
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
@Service("commentsService")
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsDao commentsDao;

    @Override
    public Page<Comments> findCommentsPageable(final Comments comment, Integer currPage) {
        int pageSize = Integer.valueOf(PropertyUtils.getValue("page.size").or("0"));

        if(currPage == null || currPage < 1) currPage = 1;

        return commentsDao.findAll(new Specification<Comments>(){
            @Override
            public Predicate toPredicate(Root<Comments> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> ps = Lists.newArrayList();
                if(comment.getCommentContent() !=null && !"".equals(comment.getCommentContent())){
                    Path<String> commentContent = root.get("commentContent");
                    Path<String> reply = root.get("reply");

                    ps.add(criteriaBuilder.like(commentContent, "%" + comment.getCommentContent() + "%"));
                    ps.add(criteriaBuilder.like(reply, "%" + comment.getCommentContent() + "%"));
                }

                //criteriaBuilder.conjunction();  创建一个AND
                //criteriaBuilder.disjunction();  创建一个OR
                return ps.size() == 0 ? criteriaBuilder.conjunction():criteriaBuilder.or(ps.toArray(new Predicate[ps.size()]));
            }
        },new PageRequest(currPage-1,pageSize,new Sort(Sort.Direction.DESC,"commentDate")));
    }
}
