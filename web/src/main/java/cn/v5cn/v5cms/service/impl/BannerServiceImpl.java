package cn.v5cn.v5cms.service.impl;

import cn.v5cn.v5cms.dao.BannerDao;
import cn.v5cn.v5cms.entity.Banner;
import cn.v5cn.v5cms.service.BannerService;
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
 * Created by zyw on 15/7/26.
 */
@Service("bannerService")
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    /**
     * ==============================================================
     *
     * 后端方法
     *
     * ==============================================================
     **/
    @Override
    public Page<Banner> findBannerPageable(final Banner banner, Integer currPage) {

        int pageSize = Integer.valueOf(PropertyUtils.getValue("page.size").or("0"));

        if(currPage == null || currPage < 1) currPage = 1;

        return bannerDao.findAll(new Specification<Banner>(){

            @Override
            public Predicate toPredicate(Root<Banner> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> ps = Lists.newArrayList();
                if(banner.getBannerName() != null && !"".equals(banner.getBannerName())) {
                    Path<String> bannerName = root.get("bannerName");
                    Path<String> bcontent = root.get("bcontent");

                    ps.add(criteriaBuilder.like(bannerName,"%" + banner.getBannerName() + "%"));
                    ps.add(criteriaBuilder.like(bcontent,  "%" + banner.getBannerName() + "%"));
                }

                //criteriaBuilder.conjunction();  创建一个AND
                //criteriaBuilder.disjunction();  创建一个OR
                return ps.size() == 0 ? criteriaBuilder.conjunction():criteriaBuilder.or(ps.toArray(new Predicate[ps.size()]));
            }
        },new PageRequest(currPage-1,pageSize,new Sort(Sort.Direction.ASC,"bannerds")));
    }

    @Override
    public Banner findOne(Long bannerId) {
        return bannerDao.findOne(bannerId);
    }

    @Override
    public Banner save(Banner banner) {
        return bannerDao.save(banner);
    }

    @Override
    public void deleteInBatch(Iterable<Banner> banners) {
        bannerDao.deleteInBatch(banners);
    }

    @Override
    public List<Banner> findAll(Long[] bannerIds) {
        return bannerDao.findAll(Lists.newArrayList(bannerIds));
    }


    /**
     * ==============================================================
     *
     * 前端方法
     *
     * ==============================================================
     **/
    @Override
    public Page<Banner> findBannerByMaxSize(final int maxSize) {
        return bannerDao.findAll(new Specification<Banner>(){

            @Override
            public Predicate toPredicate(Root<Banner> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> ps = Lists.newArrayList();

                Path<Integer> isstart = root.get("isstart");

                ps.add(criteriaBuilder.equal(isstart,1));

                //criteriaBuilder.conjunction();  创建一个AND
                //criteriaBuilder.disjunction();  创建一个OR
                return ps.size() == 0 ? criteriaBuilder.conjunction():criteriaBuilder.or(ps.toArray(new Predicate[ps.size()]));
            }
        },new PageRequest(0,maxSize,new Sort(Sort.Direction.ASC,"bannerds")));
    }
}
