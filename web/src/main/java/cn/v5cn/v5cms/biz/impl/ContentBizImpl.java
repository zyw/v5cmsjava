package cn.v5cn.v5cms.biz.impl;

import cn.v5cn.v5cms.biz.ContentBiz;
import cn.v5cn.v5cms.dao.ContentDao;
import cn.v5cn.v5cms.entity.Column;
import cn.v5cn.v5cms.entity.Content;
import cn.v5cn.v5cms.util.PropertyUtils;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by ZYW on 2014/11/19.
 */
@Service("contentBiz")
public class ContentBizImpl implements ContentBiz {

    private final static Logger LOGGER = LoggerFactory.getLogger(ContentBizImpl.class);

    @Autowired
    private ContentDao contentDao;

    @Override
    public Content save(Content content) {
        return contentDao.save(content);
    }

    @Override
    public Page<Content> findContentPageable(final Content content, Integer currPage) {
        int pageSize = Integer.valueOf(PropertyUtils.getValue("page.size").or("0"));

        return contentDao.findAll(new Specification<Content>(){

            @Override
            public Predicate toPredicate(Root<Content> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<Content,Column> columns = root.join("column", JoinType.INNER);
                List<Predicate> ps = Lists.newArrayList();
                if(content.getColumn() !=null && content.getColumn().getColsId() != null){
                    Path<Long> columnId = columns.get("columnId");
                    ps.add(criteriaBuilder.equal(columnId,content.getColumn().getColsId()));
                }
                Path<Long> siteId = root.get("siteId");
                ps.add(criteriaBuilder.equal(siteId,content.getSiteId()));

                return criteriaBuilder.and(ps.toArray(new Predicate[ps.size()]));
            }
        },new PageRequest(currPage-1,pageSize,new Sort(Sort.Direction.DESC,"lastdt")));
    }
}
