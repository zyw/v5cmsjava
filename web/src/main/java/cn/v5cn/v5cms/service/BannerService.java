package cn.v5cn.v5cms.service;

import cn.v5cn.v5cms.entity.Banner;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by zyw on 15/7/26.
 */
public interface BannerService {


    /**
     * ==============================================================
     *
     * 后端方法
     *
     * ==============================================================
     **/

    Page<Banner> findBannerPageable(Banner banner,Integer currPage);
    Banner findOne(Long bannerId);

    Banner save(Banner banner);

    void deleteInBatch(Iterable<Banner> bannerIds);

    List<Banner> findAll(Long[] bannerIds);


    /**
     * ==============================================================
     *
     * 前端方法
     *
     * ==============================================================
     **/

    Page<Banner> findBannerByMaxSize(int maxSize);
}
