package cn.v5cn.v5cms.service;

import cn.v5cn.v5cms.entity.Banner;
import org.springframework.data.domain.Page;

/**
 * Created by zyw on 15/7/26.
 */
public interface BannerService {

    Page<Banner> findBannerPageable(Banner banner,Integer currPage);

}
