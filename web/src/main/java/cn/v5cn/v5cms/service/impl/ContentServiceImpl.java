package cn.v5cn.v5cms.service.impl;

import cn.v5cn.v5cms.service.ContentService;
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
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by ZYW on 2014/11/19.
 */
@Service("contentService")
public class ContentServiceImpl implements ContentService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ContentServiceImpl.class);

    @Autowired
    private ContentDao contentDao;

    /**
     * ==============================================================
     *
     * 后端方法
     *
     * ==============================================================
     **/
    @Override
    @Transactional
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
                    Path<Long> columnId = columns.get("colsId");
                    ps.add(criteriaBuilder.equal(columnId,content.getColumn().getColsId()));
                }
                Path<Long> siteId = root.get("siteId");
                ps.add(criteriaBuilder.equal(siteId,content.getSiteId()));

                return criteriaBuilder.and(ps.toArray(new Predicate[ps.size()]));
            }
        },new PageRequest(currPage-1,pageSize,new Sort(Sort.Direction.DESC,"lastdt")));
    }

    @Override
    public Content findOne(Long contentId) {
        return contentDao.findOne(contentId);
    }


    /**
     * ==============================================================
     *
     * 前端方法
     *
     * ==============================================================
     **/
    @Override
    public Page<Content> findContentPageable(final Long colId, Integer currPage, Integer maxSize) {

        Page<Content> contentPage = contentDao.findAll(new Specification<Content>() {

            @Override
            public Predicate toPredicate(Root<Content> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<Content, Column> columns = root.join("column", JoinType.INNER);
                List<Predicate> ps = Lists.newArrayList();
                if (colId != null && colId != 0) {
                    Path<Long> columnId = columns.get("colsId");
                    ps.add(criteriaBuilder.equal(columnId, colId));
                }
                Path<Integer> state = root.get("state");
                ps.add(criteriaBuilder.equal(state, 2));

                return criteriaBuilder.and(ps.toArray(new Predicate[ps.size()]));
            }
        }, new PageRequest(currPage - 1, maxSize,
                new Sort(Sort.Direction.DESC,"stickNum","lastdt")));
        //new Sort(new Sort.Order(Sort.Direction.ASC,"stickNum"),new Sort.Order(Sort.Direction.DESC, "lastdt"))
        return contentPage;
    }

    @Override
    public List<Content> findStickContents(final Long colId) {
        return contentDao.findAll(new Specification<Content>() {
            @Override
            public Predicate toPredicate(Root<Content> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<Content, Column> columns = root.join("column", JoinType.INNER);
                List<Predicate> ps = Lists.newArrayList();
                if (colId != null && colId != 0) {
                    Path<Long> columnId = columns.get("colsId");
                    ps.add(criteriaBuilder.equal(columnId, colId));
                }
                Path<Integer> state = root.get("state");
                ps.add(criteriaBuilder.equal(state, 2));
                Path<Integer> stick = root.get("stick");
                ps.add(criteriaBuilder.equal(stick, 1));

                return criteriaBuilder.and(ps.toArray(new Predicate[ps.size()]));
            }
        }, new Sort(Sort.Direction.ASC, "stickNum"));
    }
}
