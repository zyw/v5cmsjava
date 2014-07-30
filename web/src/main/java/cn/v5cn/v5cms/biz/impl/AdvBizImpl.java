package cn.v5cn.v5cms.biz.impl;

import cn.v5cn.v5cms.biz.AdvBiz;
import cn.v5cn.v5cms.dao.AdvDao;
import cn.v5cn.v5cms.entity.Adv;
import cn.v5cn.v5cms.entity.wrapper.AdvWrapper;
import cn.v5cn.v5cms.util.PropertyUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by ZYW on 2014/7/28.
 */
@Service("advBiz")
public class AdvBizImpl implements AdvBiz {

    @Autowired
    private AdvDao advDao;

    @Override
    @Transactional
    public Adv save(AdvWrapper advWrapper) throws JsonProcessingException {
        Adv adv = advWrapper.getAdv();
        Map<String,Object> reqMap = advWrapper.getAti();
        Map<String,Object> filterAfterMap = null;
        if(adv.getAdvType() == 1){
            filterAfterMap = filterMapKeys(reqMap,"adv_image_");
        }else if(adv.getAdvType() == 2){
            filterAfterMap = filterMapKeys(reqMap,"adv_flash_");
        }else if(adv.getAdvType() == 3){
            filterAfterMap = filterMapKeys(reqMap,"adv_text_");
        }

        ObjectMapper mapper = new ObjectMapper();
        String advTypeJson = mapper.writeValueAsString(filterAfterMap);

        adv.setAdvTypeInfo(advTypeJson);
        adv.setCreateDate(DateTime.now().toDate());
        return advDao.save(adv);
    }

    @Override
    public Page<Adv> findAdvByAdvNamePageable(final Adv adv, Integer currPage) {
        int pageSize = Integer.valueOf(PropertyUtils.getValue("page.size").or("0"));
        adv.setAdvName("广");
        adv.setAdvPosId(1L);
        return advDao.findAll(new Specification<Adv>() {

            @Override
            public javax.persistence.criteria.Predicate toPredicate(Root<Adv> advRoot, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                advRoot = criteriaQuery.from(Adv.class);
                //advRoot.join("advPos",JoinType.INNER);
                List<javax.persistence.criteria.Predicate> ps = Lists.newArrayList();
                if(StringUtils.isNotBlank(adv.getAdvName())){
                    Path<String> advName = advRoot.get("advName");
                    ps.add(criteriaBuilder.like(advName, "%" + adv.getAdvName() + "%"));
                }
                if(adv.getAdvPosId() != null){
                    Path<Integer> advPosId = advRoot.get("advPosId");
                    ps.add(criteriaBuilder.equal(advPosId, adv.getAdvPosId()));
                }
                return criteriaBuilder.and();
            }
        }, new PageRequest(currPage,pageSize,new Sort(Sort.Direction.DESC,new String[]{"createDate"})));
    }

    private Map<String,Object> filterMapKeys(Map<String, Object> reqMap,final String key) {
        Map<String, Object> filterAfterMap = Maps.filterKeys(reqMap, new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return StringUtils.contains(input,key);
            }
        });
        return filterAfterMap;
    }
}
